package lab10;

import java.util.HashMap;

public class test {

	public static void main(String[] args) {
		Object[] street= {new Human(),new Bus(),new Auto(),new Vehicle(),new Auto(),new Human(),4," "};
		
		check1(street);
		check2(street);
		check3(street);

	}
	public static void check2(Object [] obj) {
		int V=0,H=0,B=0,A=0,U=0;
        if(obj.length>0){
    		
    	}else {
    		return;
    	}
	for(int i=0;i<obj.length;i++) {
		if(Human.class.isInstance(obj[i])) {
			H++;
		}else if(Bus.class.isInstance(obj[i])) {
			B++;
		}else if(Auto.class.isInstance(obj[i])) {
			A++;
		}else if(Vehicle.class.isInstance(obj[i])) {
			V++;
		}else {
			U++;
		}
	}
	System.out.println("Vehicle "+V+" Human "+H+" Bus "+B+" Auto "+A+" Unknown "+U);
	}
    public static void check1(Object [] obj) {
    	int V=0,H=0,B=0,A=0,U=0;
    	if(obj.length>0){
    		
    	}else {
    		return;
    	}
    	for(int i=0;i<obj.length;i++) {
    		if(obj[i] instanceof Human) {
    			H++;
    		}else if(obj[i] instanceof Bus) {
    			B++;
    		}else if(obj[i] instanceof Auto) {
    			A++;
    		}else if(obj[i] instanceof Vehicle) {
    			V++;
    		}else {
    			U++;
    		}
    	}
    	System.out.println("Vehicle "+V+" Human "+H+" Bus "+B+" Auto "+A+" Unknown "+U);
	}
    public static void check3(Object [] obj) {
	HashMap<String,Integer> result=new HashMap<String,Integer>();
	int V=0,H=0,B=0,A=0;
	if(obj.length>0){
		
	}else {
		return;
	}
	for(int i=0;i<obj.length;i++) {
		if(result.containsKey(obj[i].getClass().getSimpleName())) {
			int count=result.get(obj[i].getClass().getSimpleName())+1;
			result.put(obj[i].getClass().getSimpleName(),count);
		}else {
			result.put(obj[i].getClass().getSimpleName(),1);
		}
	}
	System.out.println(result);
    }

}
