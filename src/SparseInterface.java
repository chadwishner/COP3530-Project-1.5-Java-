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

    
    public String toString();


    
    /*takes another matrix as input and returns the sum of the two matrices*/
    /*return NULL if sizes incompatible*/
    public SparseInterface addMatrices(SparseInterface matrixToAdd);
    
    /*takes another matrix as input and returns the product of the two matrices*/
    /*return NULL if sizes incompatible*/
    public SparseInterface multiplyMatrices(SparseInterface matrixToMultiply);
}
