import java.util.HashMap;

public class dataTypeLab {

	public static void main(String[] args) {
		Roman romanOne=new Roman("IV");
		Roman romanTwo=new Roman("V");
		romanOne.increment();
		System.out.println(romanOne.toString());
		System.out.println(romanTwo.toString());
		System.out.println(romanOne.add(romanTwo.getRomanNumber()));

	}

}

class Roman{
	private HashMap<Integer,String> romanNumbers=new HashMap<Integer,String>();
	private String romanNumber;
	private int romanValue;
	public Roman(String romanNumber) {
		this.initiateRomanNumbers();
		if(this.romanNumbers.containsValue(romanNumber)) {
			this.romanNumber=romanNumber;
			this.romanValue=this.calculateRomanValue();	
		}else {
			System.out.println("Wrong roman number ");
		}
	}
	public String getRomanNumber() {
		return this.romanNumber;
	}
	public void setRomanNumber(String romanNumber) {
		this.romanNumber=romanNumber;
	}
	public void setRomanValue(int romanValue) {
		this.romanValue=romanValue;
	}
	public int getRomanValue() {
		return this.romanValue;
	}
	public int calculateRomanValue() {
		int returnValue=-1;
		for(int i=1;i<=romanNumbers.size();i++) {
			if(romanNumbers.get(i).equalsIgnoreCase(this.romanNumber)) {
				returnValue=i;
			}
		}
		return returnValue;
	}
	private void initiateRomanNumbers(){
		romanNumbers.put(1,"I");
		romanNumbers.put(2,"II");
		romanNumbers.put(3,"III");
		romanNumbers.put(4,"IV");
		romanNumbers.put(5,"V");
		romanNumbers.put(6,"VI");
		romanNumbers.put(7,"VII");
		romanNumbers.put(8,"VIII");
		romanNumbers.put(9,"IX");
		romanNumbers.put(10,"X");
	}
	private int modulo(int value) {
		int returnValue=-1;
		if(value==10) {
			returnValue=10;
		}else if(value==0){
			returnValue=1;
		}else{
			returnValue=value%10;
		}
		return returnValue;
	}
	public String toString() {
		return this.getRomanNumber();
	}
	public String add(String roman) {
		String returnValue="";
		if(romanNumbers.containsValue(roman)) {
			for(int i=1;i<=romanNumbers.size();i++) {
				if(romanNumbers.get(i).equalsIgnoreCase(roman)) {
					int sum=this.modulo(this.getRomanValue()+i);
					returnValue=romanNumbers.get(sum);
				}	
			}			
		}else {
			System.out.println("Illegal roman number");
			returnValue="";
		}
		return returnValue;
	}
	public void increment() {
		String roman=this.getRomanNumber();
		if(romanNumbers.containsValue(roman)) {
			for(int i=1;i<=romanNumbers.size();i++) {
				if(romanNumbers.get(i).equalsIgnoreCase(roman)) {
					this.setRomanValue(i+1);
					this.setRomanNumber(romanNumbers.get(this.modulo(i+1)));
				}
			}
		}else {
			System.out.println("Illegal roman number");
		}
	}
	public void decrement() {
		String roman=this.getRomanNumber();
		if(romanNumbers.containsValue(roman)) {
			if(roman.equals("I")) {
				System.out.println("Cannot decrement I");
			}else {
				for(int i=1;i<=romanNumbers.size();i++) {
					if(romanNumbers.get(i).equalsIgnoreCase(roman)) {
						this.setRomanValue(i-1);
						this.setRomanNumber(romanNumbers.get(this.modulo(i-1)));
					}
				}	
			}			
		}else {
			System.out.println("Illegal roman number");
		}
		
	}
}
