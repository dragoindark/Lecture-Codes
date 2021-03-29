package command;

public class CommandPattern {
	public static void main(String[] args) {

		// Create user and let her compute
		Command command = null;
		User user = new User();
		Calculator calculator = new Calculator();

		command = new CalculatorCommand(calculator, '+', 100);
		user.Compute(command);
		command = new CalculatorCommand(calculator, '-', 50);
		user.Compute(command);
		command = new CalculatorCommand(calculator, '*', 10);
		user.Compute(command);
		command = new CalculatorCommand(calculator, '/', 2);
		user.Compute(command);

		// Undo 4 commands
		user.Undo(4);
		// Redo 2 commands
		user.Redo(2);
	}
}
