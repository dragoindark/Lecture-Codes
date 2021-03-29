
public class arrayLength {

	public static void main(String[] args) {
		int[] intArray=new int[10];
		int[] stringArray=new int[15];
		System.out.println("The size of int array is "+arrayLengthFinder(intArray));
		System.out.println("The size of int array is "+arrayLengthFinder(stringArray));
		
	}

	public static int arrayLengthFinder(int[] arr) {
		boolean end=false;
		int count=0;
		while(!end) {
			try {
				System.out.println(arr[count]);
				count++;
			}catch(ArrayIndexOutOfBoundsException e) {
				end=true;
			}
		}
		return count;
	}
	
	public static int[] returnStackDynamicArray(int n) {
		return new int[n];
	}
	public static int[] returnFixedStackDynamicArray() {
		return new int[10];
	}
}
