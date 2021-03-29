import java.util.Random;

public class performanceChecker {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		staticArrays staticMemory=new staticArrays();
		int[][] staticMatrix=staticMemory.staticArray();
		long end = System.currentTimeMillis();
		long timeElapsed = end - start;
		long startStack = System.currentTimeMillis();
		dynamicArrays dynamicMemory = new dynamicArrays();
		int[][] dynamicMatrix=dynamicMemory.dynamicArray(1000, 1000);
		long endStack = System.currentTimeMillis();
		long timeElapsedStack = endStack - startStack;
		System.out.println("The amount of rows in static array is "+staticMatrix.length+" amount of colums are "+staticMatrix[0].length);
		System.out.println("The amount of time elapsed for static array is " + timeElapsed);
		System.out.println("The amount of rows in dynamic array is "+dynamicMatrix.length+" amount of colums are "+dynamicMatrix[0].length);
		System.out.println("The amount of time elapsed for stack array is " + timeElapsedStack);

	}

}
class staticArrays{
	private static int[][] firstMatrix=new int[1000][1000];
	private static int[][] secondMatrix=new int[1000][1000];
	private static int[][] thirdMatrix=new int[1000][1000];
	public int[][] staticArray() {
		Random numGenerator = new Random();
		for (int row = 0; row < firstMatrix.length; row++) {
			for (int col = 0; col < firstMatrix[row].length; col++) {
				firstMatrix[row][col] = numGenerator.nextInt(10);
				secondMatrix[row][col] = numGenerator.nextInt(10);
			}
		}
		for (int row = 0; row < firstMatrix.length; row++) {
			for (int col = 0; col < firstMatrix[row].length; col++) {
				thirdMatrix[row][col] = firstMatrix[row][col] * secondMatrix[row][col];
			}
		}
		return thirdMatrix;
	}
}

class dynamicArrays {
	public int[][] dynamicArray(int rowNum, int colNum) {
		int[][] firstMatrix = new int[rowNum][colNum];
		int[][] secondMatrix = new int[rowNum][colNum];
		int[][] thirdMatrix = new int[rowNum][colNum];
		Random numGenerator = new Random();
		for (int row = 0; row < firstMatrix.length; row++) {
			for (int col = 0; col < firstMatrix[row].length; col++) {
				firstMatrix[row][col] = numGenerator.nextInt(10);
				secondMatrix[row][col] = numGenerator.nextInt(10);
			}
		}
		for (int row = 0; row < firstMatrix.length; row++) {
			for (int col = 0; col < firstMatrix[row].length; col++) {
				thirdMatrix[row][col] = firstMatrix[row][col] * secondMatrix[row][col];
			}
		}
		return thirdMatrix;

	}
}
