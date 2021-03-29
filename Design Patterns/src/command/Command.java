package command;

import java.util.ArrayList;

//
//The classes and/or objects participating in this pattern are:
//
//1. Command  (Command)
//		- declares an interface for executing an operation.
//2. ConcreteCommand  (CalculatorCommand)
//		- defines a binding between a Receiver object and an action.
//		- implements Execute by invoking the corresponding operation(s) on Receiver
//3. Client  (Calculator Application)
//		- creates a ConcreteCommand object and sets its receiver.
//4. Invoker  (User)
//		- asks the command to carry out the request
//5. Receiver  (Calculator)
//		- knows how to perform the operations associated with carrying out
//		  a request. Any class may serve as a Receiver.
//
//

//"Command"
//
interface Command {
	public void Execute();
	public void UnExecute();
}
//"ConcreteCommand"
//
class CalculatorCommand implements Command {
	// Constructor
	public CalculatorCommand(Calculator calculator, char op, int operand) { 
		_calculator = calculator;
		_operator = op;
		_operand = operand;
	}
	public void Execute() {
		_calculator.Action(_operator, _operand);
	}
	public void UnExecute() {
		_calculator.Action(Undo(_operator), _operand);
	}

	// Private helper function. Needed to get the inverse operation.
	private char Undo(char _operator) {
		switch (_operator) {
		case '+': return '-';
		case '-': return '+';
		case '*': return '/';
		case '/': return '*';
		default:  return ' ';
		}
	}
	private Calculator _calculator;
	private char _operator;
	private int _operand;
}
// "Receiver"
//
class Calculator {
	public Calculator() { 
		current_value = 0; 
	}
	public void Action(char _operator, int operand) {
		switch (_operator) {
		case '+': current_value += operand; break;
		case '-': current_value -= operand; break;
		case '*': current_value *= operand; break;
		case '/': current_value /= operand; break;
		}
		System.out.println("Current value " + current_value + " (following "
				+ _operator + " " + operand + ")");
	}
	private int current_value;
}

// "Invoker"
class User {
	public User() {	current = 0; }
	public void Redo(int levels) {
		System.out.println("\n---- Redo " + levels + " levels ");
		// Perform redo operations
		for (int i = 0; i < levels; i++) {
			if (current < _commands.size()) {
				Command command = _commands.get(current++);
				command.Execute();
			}
		}
	}

	void Undo(int levels) {
		System.out.println("\n---- Undo " + levels + " levels ");
		// Perform undo operations
		for (int i = 0; i < levels; i++) {
			if (current > 0) {
				Command command = _commands.get(--current);
				command.UnExecute();
			}
		}
	}
	void Compute(Command command) {
		command.Execute();
		// Add command to undo list
		_commands.add(command);
		current++;
	}

	// Initializers.
	private int current;
	private ArrayList<Command> _commands = new ArrayList<Command>();
}
