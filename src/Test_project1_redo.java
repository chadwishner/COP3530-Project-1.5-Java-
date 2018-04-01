public class Test {

   

    public static void main(String[] args){
        SparseInterface myTest = new SparseMatrix();

	myTest.setSize(3, 3);

        System.out.println("Num Rows is 3: " + (myTest.getNumRows() == 3));
 	System.out.println("Num Cols is 3: " + (myTest.getNumCols() == 3));

        myTest.addElement(0, 0, 16);

        myTest.addElement(0, 1, 4);

        myTest.removeElement(0,1);

        String correctString = "0 0 16\n";

        System.out.println("toString is correct: " + correctString.equals(myTest.toString()));

	myTest.removeElement(0,0);
        

        myTest.addElement(2,2,4);

        myTest.addElement(1,0,-3);

        correctString = "1 0 -3\n2 2 4\n";

        System.out.println("toString is correct: " + correctString.equals(myTest.toString()));
         

	myTest.removeElement(2, 2);

	myTest.removeElement(1, 0);

        myTest.addElement(0, 0, 0);

        correctString = "";

        //Because we are not storing 0 values in the matrix the toString should reflect an "empty" (all 0) matrix.
        System.out.println("toString is correct: " + correctString.equals(myTest.toString()));

        myTest.addElement(0, 1, 3);

        myTest.addElement(0, 1, 0);

        correctString = "";

        //Note that adding 0 to the matrix overwrites the data at that position to 0 as defined in the interface description
        //Because we are not storing 0 values, we can remove the element at that position.
        System.out.println("toString is correct: " + correctString.equals(myTest.toString()));

        myTest.addElement(0, 0, 16);
        myTest.addElement(0, 1, 4);
        myTest.addElement(1, 1, 9);
        myTest.addElement(2, 2, 7);
        
        SparseInterface addTest1 = new SparseMatrix();
	addTest1.setSize(3, 3);
        addTest1.addElement(0, 0, 1);
        addTest1.addElement(1, 1, 2);
        addTest1.addElement(2, 2, 3);
        
        SparseInterface addTest2 = new SparseMatrix();
	addTest2.setSize(3, 3);
        addTest2.addElement(0, 0, 3);
        addTest2.addElement(0, 0, 2);
        addTest2.addElement(0, 0, 1);
        
        SparseInterface addTest3 = addTest1.addMatrices(addTest2);
        
        System.out.println("added matrix: "+addTest3.toString());
        
        SparseInterface multiplyTest1 = new SparseMatrix();
        multiplyTest1.setSize(3, 3);
        multiplyTest1.addElement(0, 0, 1);
        multiplyTest1.addElement(0, 1, 1);
        multiplyTest1.addElement(0, 2, 1);

        SparseInterface multiplyTest2 = new SparseMatrix();
        multiplyTest2.setSize(3, 3);
        multiplyTest2.addElement(0, 0, 1);
        multiplyTest2.addElement(1, 0, 1);
        multiplyTest2.addElement(2, 0, 1);
        
        multiplyTest2.addElement(0, 1, 2);
        multiplyTest2.addElement(1, 1, 1);
        multiplyTest2.addElement(2, 1, 1);
        
        multiplyTest2.addElement(0, 2, 3);
        multiplyTest2.addElement(1, 2, 1);
        multiplyTest2.addElement(2, 2, 1);

        SparseInterface multiplyTest3 = multiplyTest1.multiplyMatrices(multiplyTest2);
        
        System.out.println("multiplied matrix: "+multiplyTest3.toString());

	SparseInterface test1 = new SparseMatrix();
        test1.setSize(3, 4);
	SparseInterface test2 = new SparseMatrix();
        Test2.setSize(4, 5)

	SparseInterface test3 = test1.add(test2);  //should return null
	SparseInterface test4 = test1.multiply(test2); //should work
	SparseInterface test5 = test2.multiply(test1); //should return null

        
    }
}
