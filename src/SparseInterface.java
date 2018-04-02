public interface SparseInterface {

    //STUDENTS:  DO NOT ALTER.  THIS WILL BE USED TO TEST YOUR CODE

    /*
        Should clear the matrix of all entries (make all entries 0)
     */
    public void clear();


    /*
        Sets  size of the matrix.  Number of rows, number of columns. 
     */

    public void setSize(int numRows, int numCols);

    
    public int getNumRows();
 
    public int getNumCols();

    /*
        Adds an element to the row and column passed as arguments (overwrites if element is already present at that position).
        Throws an error if row/column combination is out of bounds.
        Checks to see if element has a value of zero before creating
     */
    public void addElement(int row, int col, int data);


    /*
        Remove (make 0) the element at the specified row and column.
        Throws an error if row/column combination is out of bounds.
     */
    public void removeElement(int row, int col);


    /*
        Return the element at the specified row and column
        Throws an error if row/column combination is out of bounds.
     */
    public int getElement(int row, int col);

    /*
    Should return the nonzero elements of your sparse matrix as a string.
    The String should be k lines, where k is the number of nonzero elements.
    Each line should be in the format "row column data" where row and column are the "coordinate" of the data and all are separated by spaces.
    An empty matrix should return an empty string.
    The print should be from left to right and from top to bottom (like reading a book) i.e. the matrix

                                                     3 0 1
                                                     0 2 0
                                                     0 0 4

                                                 Should print as:
                                                     0 0 3
                                                     0 2 1
                                                     1 1 2
                                                     2 2 4

     */
    public String toString();

    
    /*takes another matrix as input and returns the sum of the two matrices*/
    /*return NULL if sizes incompatible*/
    public SparseInterface addMatrices(SparseInterface matrixToAdd);
    
    /*takes another matrix as input and returns the product of the two matrices*/
    /*return NULL if sizes incompatible*/
    public SparseInterface multiplyMatrices(SparseInterface matrixToMultiply);
}
