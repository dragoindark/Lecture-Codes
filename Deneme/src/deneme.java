
public class deneme {
	
	public void fixedStackDynamic() {
	}

	public static void main(String[] args) {
		int a=5;
		int b=10;
		System.out.println("The value of a outside the block is "+a);
		System.out.println("The value of b outside the block is "+b);
		if(true) {
			a=20;
			b=40;
			System.out.println("The value of a inside the block is "+a);
			System.out.println("The value of b inside the block is "+b);
			if(true) {
				a=80;
				b=160;
				System.out.println("The value of a inside the inner block is "+a);
				System.out.println("The value of b inside the inner block is "+b);
			}
		}
		System.out.println("The value of a after exiting block is "+a);
		System.out.println("The value of b after exiting block is "+b);
		
		
		int[] arr= {1,2,3,4,5};
		
		int fixedStackDynamic[]=new int[7];
	}

}
