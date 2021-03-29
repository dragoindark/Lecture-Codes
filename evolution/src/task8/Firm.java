package task8;

import java.util.ArrayList;

class Firm {
	private String Name;
	private ArrayList E = new ArrayList();

	public Firm(String Name) {
		this.Name = Name;
	}

	public void add(ArrayList empList) {
		this.E.addAll(empList);
	}
	public ArrayList getList() {
		return E;
	}

	@Override
	public String toString() {
		
		 String S = "Firm: " + Name + ". Amount of employees: " + E.size() + ".\n";
		 for (int i = 0; i < E.size(); i++) { S += (i + 1) + ". " + E.get(i) + "\n"; }
		 return S;		 
	}

}
