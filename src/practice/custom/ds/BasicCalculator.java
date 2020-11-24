package practice.custom.ds;

import java.util.Stack;

public class BasicCalculator {
	public int calculate(String s) {
		char[] tokens = s.toCharArray();
		Stack<Integer> operands = new Stack<Integer>();
		Stack<Character> operators = new Stack<Character>();
		for (int i = 0; i < tokens.length; i++) {
			char ch = tokens[i];
			int operand = 0;
			if (ch == ' ')
				continue;
			if (ch >= '0' && ch <= '9') {
				while (ch >= '0' && ch <= '9') {
					operand = operand * 10 + Integer.parseInt(ch + "");
					i++;
					if (i == tokens.length)
						break;

					ch = tokens[i];
				}
				operands.push(operand);
				i--;
			} else if (ch == '(')
				operators.push(ch);
			else if (ch == ')') {
				while (operators.peek() != '(') {
					operands.push(eval(operands.pop(), operands.pop(), operators.pop()));
				}
				operators.pop();
			} else {
				while (!operators.isEmpty() && hasPrecedence(ch, operators.peek())) {
					operands.push(eval(operands.pop(), operands.pop(), operators.pop()));
				}
				operators.push(ch);
			}
		}

		while (!operators.isEmpty()) {

			operands.push(eval(operands.pop(), operands.pop(), operators.pop()));
		}

		return operands.pop();

	}

	boolean hasPrecedence(char operator1, char operator2) {
		if (operator2 == '(' || operator2 == ')')
			return false;
		else if ((operator1 == '*' || operator1 == '/') && (operator2 == '+' || operator2 == '-'))
			return false;
		else
			return true;

	}

	int eval(int operand2, int operand1, char operator) {
		if (operator == '+')
			return operand1 + operand2;
		else if (operator == '-')
			return operand1 - operand2;
		else if (operator == '*')
			return operand1 * operand2;
		else
			return operand1 / operand2;
	}

}
