// Java program to evaluate value of a postfix expression
package SummerCPSC3200Assignment2McGaha;
import java.util.Stack;
public class evaluatePostfix {
	
	// Method to evaluate value of a postfix expression
	static int evaluatePostfix(String exp)
	{
		// Create a String
		String num = "";
		
		// Create a stack
		Stack<Integer> stack = new Stack<>();

		// Scan all characters one by one
		for (int i = 0; i < exp.length(); i++) {
			char c = exp.charAt(i);

			// If the scanned character is an operand
			// (number here), add it to the num string.
			if (Character.isDigit(c)) {
				num += c;
			}
			// if scanned character is a space, push num into the stack if not empty
			else if (c == ' ') {
				if (num != "")
					stack.push(Integer.parseInt(num));
					num = "";
			}
			// If the scanned character is an operator, pop
			// two elements from stack apply the operator
			else {
				int val1 = stack.pop();
				int val2 = stack.pop();

				switch (c) {
				case '+':
					stack.push(val2 + val1);
					break;
				case '-':
					stack.push(val2 - val1);
					break;
				case '/':
					stack.push(val2 / val1);
					break;
				case '*':
					stack.push(val2 * val1);
					break;
				case '^':
					stack.push((int) Math.pow(val2, val1));
					break;	
				}
			}
		}
		return stack.pop();
	}

	// Driver code
	public static void main(String[] args)
	{
		String exp = "3 25 15 - ^";
		String exp2 = "3 25 15 - *";
	
		// Function call
		System.out.println("postfix evaluation: "
						+ evaluatePostfix(exp));
		
		System.out.println("postfix evaluation 2: "
				+ evaluatePostfix(exp2));
	}
}

