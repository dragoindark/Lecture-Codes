package task8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class uncheckedEmployee {
	private ArrayList E = new ArrayList();
	private double max = -500;

	public ArrayList getList() {
		return E;
	}

	public void addList(String Name, String Surname, double Salary) {
		Employee myEmp = new Employee(Name, Surname, Salary);
		if (Salary > max) {
			max = Salary;
		}
		E.add(myEmp);
	}

	public double getMaxSalary() {
		return max;
	}

	public void sortSalariesAsc(ArrayList empList) {
		Collections.sort(empList);
	}

	public void sortSalariesDesc(ArrayList empList,salDesc salDescComp) {
		Comparator<Employee> salDescCompurator = Collections.reverseOrder(salDescComp);
		Collections.sort(empList,salDescCompurator);
	}

}
