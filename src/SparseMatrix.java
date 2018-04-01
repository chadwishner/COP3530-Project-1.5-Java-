/** @author Chad Wishner
 * 	COP3530 Section: 1079 Data Structures and Algorithms
 */
public class SparseMatrix implements SparseInterface {	
	Node head;
		
	int numRows;
	int numCols;
	
	/**	default constructor Sparse Matrix
	 * 	default size to 5	
	 * 	includes Node head and int size
	 */
	public SparseMatrix(){
		head = null;

//WHAT IS THE DEFAULT SIZE
		//default size 5
		numRows = 5;
		numCols = 5;
	}
	
	/** Node class:
	 * 	includes int row, int col, int data, Node next
	 * 	default constructor
	 * 	specified value constructor
	 */
	public class Node {
		//node data
		int data;
		int row;
		int col;
		Node next;
		
		//constructor for specified values
		public Node(int da, int r, int c){
			data = da;
			row = r;
			col = c;		
		}
		
		//default constructor
		public Node(){
			data = 0;
			row = 0;
			col = 0;
		}
	}

	/** Clear the matrix of all entries (make all entries 0)
	 * 	O(1)
     */
	@Override
    public void clear(){
    	//setting head to null clears reference to the rest of the nodes, garbage collector will collect
    	this.head = null;
    }

    /** Sets maximum size of the matrix.  Number of rows. It should also clear the matrix (make all elements 0)
     * 	@param int size
     * 	O(1)
     */
    @Override
    public void setSize(int numRows, int numCols){
    	//set size to specified value
    	this.numRows = numRows;
    	this.numCols = numCols;
    	
 //SHOULD WE ALSO CLEAR THE MATRIX
    	//clears matrix
    	this.clear();
    }
    
    /** Returns the size of the rows
     * @return int size rows
     * O(1)
     */
    public int getNumRows(){
    	return this.numRows;
    }
    
    /** Returns the size of the columns
     * @return int size columns
     * O(1)
     */
    public int getNumCols(){
    	return this.numCols;
    }

    /** Adds an element to the row and column passed as arguments (overwrites if element is already present at that position). Throws an error if row/column 
     * 	combination is out of bounds. Adds values in order of row then column (ie. row 0 col 0, row 0 col 1, row 0 col 2, row 1 col 0, row 1 col 1, row 1 col 2...) 
     * 	@param int row, int col, int data
     * 	O(n^2) where n is the size of the matrix
     */
    @Override
    public void addElement(int row, int col, int data){
    	//add in order
    	
    	//check if out of bound combination
    	if (row > numRows || col > numCols){
    		System.err.println("Out of Bound row/col combination");
    	} else {
    		
    		//if data is 0, remove the element at row/col and return
    		if (data == 0){
    			this.removeElement(row, col);
    			return;
    		}
    		
    		//create new node to add
    		Node add = new Node(data, row, col);
    		
    		//if head is empty, make the head the new node
    		if (head == null){
    			head = add;
    		} else {
    			
    			//create pointer nodes to increment through
    			Node cur = head;
    			Node prev = null;
    			
    			//find the correct row
    			while (cur != null && cur.row < row){
        			prev = cur;
            		cur = cur.next;
        		}
    			
    			//special if row doesn't exist yet, and it is after the rows that do exist, place it at the end
    			if (cur == null){
    				prev.next = add;
    				return;
    			}
  
    			
    			//special case if row doesn't exist and it is between 2 rows, place it between the 2 rows
    			if (cur.row > row && prev != null){
    				prev.next = add;
    				add.next = cur;
    				return;
    			}
    				
    			//find the correct col
    			while (cur != null && cur.row == row && cur.col < col){
    				prev = cur;
                	cur = cur.next;
        		} 
    				       			
    			//special case if the 1st row doesn't exist, thus the prev pointer node has not been changed, and the new node needs to be placed at head
        		if (prev == null && (cur.row != row || cur.col != col)){
        			head = add;
        			add.next = cur;
        			return;
        		}
        			
    			//if final col isn't there, and it is at the end of the list, place the node at the tail
    			if (cur == null){
        			prev.next = add;
        			return;
        		}
    				
    			//if the node already exists, overwrite that node
    			if (cur.row == row && cur.col == col){
        			cur.data = data;
        			return;
        				
        		//normal case of simply adding the new node in the correct space
        		} else {
        			prev.next = add;
        			add.next = cur;
        		}
    		}
    	}
    }

    
    /** Remove (make 0) the element at the specified row and column. Throws an error if row/column combination is out of bounds.
     * 	@param int row, int col (of the desired element)
     * 	O(n^2) where n is the size of the matrix
     */
    @Override
    public void removeElement(int row, int col){
    	
    	//check if out of bound combination
    	if (row > numRows || col > numCols){
    		System.err.println("Out of Bound row/col combination");
    	} else {
    		
    		//create cur and prev node pointers
    		Node cur = head;
    		Node prev = new Node();
    		
    		//find the right row/col combination
    		while (cur != null && (cur.row != row || cur.col != col)){
    			prev = cur;
    			cur = cur.next;
    		}
    		
    		if (cur == null){
    			return;
    		}
    		
    		//skip over cur
    		prev.next = cur.next;
    		
    		//special case if cur is head, set the head pointer
    		if (cur == head){
    			head = head.next;
    		}
    		
    		//delete cur
    		cur = null;
    	}
    
    }

    /** Returns the element at the specified row and column. Throws an error if row/column combination is out of bounds.
     * 	@return int data
     * 	@param int row, int col (of the desired element)
     * 	O(n^2) where n is the size of the matrix
     */
    @Override
    public int getElement(int row, int col){
    	
    	//check if out of bound combination
    	if (row > numRows || col > numCols){
    		System.err.println("Out of Bound row/col combination");
    	} else {
    		
    		//create cur node pointer
    		Node cur = head;
    		
    		//find the right row/col combination
    		while (cur != null && (cur.row != row || cur.col != col)){
    			cur = cur.next;
    		}

    		if (cur == null){
    			return 0;
    		}
    		
    		//return data
    		return cur.data;
    	}
    	
    	//if you don't find it, return 0 (the index is 0 in the matrix)
    	return 0;
    }

    /** Return the nonzero elements of your sparse matrix as a string. The String is k lines, where k is the number of nonzero elements. 
     * 	Each line should be in the format "row column data" where row and column are the "coordinate" of the data and all are separated by spaces. An empty matrix should 
     * 	return an empty string. The print is be from left to right and from top to bottom (like reading a book) i.e. the matrix
     * 	@return String
     * 	O(n^2) where n is the size of the matrix
     */
    @Override
    public String toString(){
    	
    	//create empty string and cur node
    	String matrix = "";
		Node cur = head;

		//increment and add the correct information to the string
    	while (cur != null){
    		matrix += cur.row + " " + cur.col + " " + cur.data + "\n";
    		cur = cur.next;
    	}
    	
    	//return string
    	return matrix;
    }
    
    public SparseInterface addMatrices (SparseInterface matrixToAdd){
    	
    }
    
    public SparseInterface multiplyMatrices(SparseInterface matrixToMultiply){
    	
    }
}