package task11;

public class test {
	
	public static void main(String[] args) {
		int[][] matrix = new int[][]{
			  { 10, 19, 3, 8, 2},
			  { 5, 2, 0, 6, 7},
			  { 4, 5, 17, 22, 13},
			  { 2, 9, 3, 13, 12},
			  { 3, 7, 0, 6, 4},
			  { 29, 13, 5, 8, 2}
			};
	    oddThread myOdd=new oddThread(matrix,1,"Odd Thread",1,0);
		evenThread myEven=new evenThread(matrix,0,"Even Thread",1,0);
		myOdd.start();
	    try {
			myOdd.getThread().join();
			myEven.getThread().join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		myEven.printSum();
		myOdd.printSum();
		System.out.println("Total sum is "+(myEven.getSum()+myOdd.getSum()));
	}

}
