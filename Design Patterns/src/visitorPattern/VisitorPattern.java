package visitorPattern;

import java.util.ArrayList;

//Element  (Element)
//defines an Accept operation that takes a visitor a
//as an argument.

interface Element {
	public void Accept(Visitor visitor);
}

//"Visitor" declares a Visit operation for each class of ConcreteElement in the
//object structure. The operation's name and signature identifies the
//class that sends the Visit request to the visitor. That lets the
//visitor determine the concrete class of the element being visited.
//Then the visitor can access the elements directly through its particular
//interface
//
//"Visitor"
interface Visitor {
	public void Visit(Clerk element);
	public void Visit(Director element);
	public void Visit(President element);
}

//ConcreteElement  (Employee)
//implements an Accept operation that
//takes a visitor as an argument

abstract class Employee implements Element {
	private String name;
	private double income;
	private int vacationDays;
	// Constructor
	public Employee(String name, double income, int vacationDays) {
		this.name = name;
		this.income = income;
		this.vacationDays = vacationDays;
	}
		
	public String getName() {return name;};
	public void setname(String value) {name = value;};
	public double getIncome() {return income;};
	public void setIncome(double value) {income = value;};
	public int getVacationDays() {return vacationDays;};
	public void setVacationDays(int value) {vacationDays = value;};
}

class Clerk extends Employee {
	public Clerk(String name, int salary, int vacation) {
		super (name, salary, vacation);
	}
	public void Accept(Visitor visitor) {visitor.Visit(this);}
}

class Director extends Employee {
	public Director(String name,int salary, int vacation) {
		super (name, salary, vacation);
	}
	public void Accept(Visitor visitor) {visitor.Visit(this);}

}

class President extends Employee {
	public President(String name,int salary, int vacation) {
		super (name, salary, vacation);
	}
	public void Accept(Visitor visitor) {visitor.Visit(this);}
}


//ObjectStructure can enumerate its elements  may provide a
//high-level interface to allow the visitor to visit its elements
//may either be a Composite (pattern) or a collection such as a
//list or a set
//
//ObjectStructure  (Employees)
class Employees {
	public void Add(Employee employee){ employees.add(employee);};
	public void Remove(Employee employee) {
		for (int i = 0; i< employees.size(); i++) {
			if (employees.get(i).getName() == employee.getName()) {
				employees.remove(i);
				return;
			}
		}
	}
	public void Accept(Visitor visitor) {
		// set argument to something that helps
		// tell the Observers what happened
		for (int i = 0; i < employees.size(); i++) {
			employees.get(i).Accept(visitor);		}
	}
	private ArrayList<Employee> employees = new ArrayList<Employee>();
};

//ConcreteVisitors (IncomeVisitor, VacationVisitor)
//implements each operation declared by Visitor. Each operation implements
//a fragment of the algorithm defined for the corresponding class or object
//in the structure. ConcreteVisitor provides the context for the algorithm
//and stores its local state. This state often accumulates results during
//the traversal of the structure.
//
//"ConcreteVisitor 1"
class IncomeVisitor implements  Visitor {
	public void Visit(Clerk element){
		element.setIncome(element.getIncome() * 1.10);
		System.out.print(element.getName() + "'s new income:");
		System.out.printf("%6.2f\n", element.getIncome());
	}
	public void Visit(Director element){
		element.setIncome(element.getIncome() * 1.50);
		System.out.print(element.getName() + "'s new income:");
		System.out.println(element.getIncome());
	}
	public void Visit(President element){
		element.setIncome(element.getIncome() * 2.0);
		System.out.print(element.getName() + "'s new income:");
		System.out.printf("%6.2f\n",element.getIncome());
	}
}
//"ConcreteVisitor 2"

class VacationVisitor implements Visitor {
	public void Visit(Clerk element){
		// Provide 3 extra vacation days
		element.setVacationDays(element.getVacationDays() + 3);
		System.out.print(element.getName() + "'s new vacation days:");
		System.out.println(element.getVacationDays());
	}
	public void Visit(Director element){
		// Provide 5 extra vacation days
		element.setVacationDays(element.getVacationDays() + 5);
		System.out.print(element.getName() + "'s new vacation days:");
		System.out.println(element.getVacationDays());
	}
	public void Visit(President element){
		// Provide 7 extra vacation days
		element.setVacationDays(element.getVacationDays() + 7);
		System.out.print(element.getName() + "'s new vacation days:");
		System.out.println(element.getVacationDays());
	}
}

public class VisitorPattern {
	public static void main(String[] args) {
		// Setup employee collection
		Employees e = new Employees();
		e.Add(new Clerk("Şenol Güneş",200000,10));
		e.Add(new Director("Umut Güner",300000,20));
		e.Add(new President("Fikret Orman",400000,30));

		// Employees are 'visited'
		e.Accept(new IncomeVisitor());
		e.Accept(new VacationVisitor());
	}
}
