
public class Swap {
	public void swap(int x,int y) {
		int z;
		z=x;
		x=y;
		y=z;
	}
	public static void main(String[]args) {
		int x=5;
		int y=10;
		System.out.println("Variables before changing 1st var==>"+x+" 2nd var==>"+y);
		Swap deneme=new Swap();
		deneme.swap(x, y);
		System.out.println("Variables after chaging 1st var==>"+x+" 2nd var==>"+y);		
	}
	public static void brand(Car c) {
		c.setName("Fiat");
		c=new Car("Audi");
	}
	
class Car{
	String name;
	public void setName(String name) {
		this.name=name;
	}
	public Car(String name) {
		this.name=name;
	}
}
}

