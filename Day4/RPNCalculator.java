package ssa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class RPNCalculator {

	public static void main(String[] args) {
		//variables to hold the current operation
		Integer num1, num2, answer;
		String curPos;
		
		//ArrayList will hold the entire equation 
		//**THIS IS THE INPUT***
		
		//test for single digit
		//ArrayList<String> equation = new ArrayList<String>(Arrays.asList("2", "9","*", "3", "/", "7", "+"));
		
		//testing for different order of operands
		//ArrayList<String> equation = new ArrayList<String>(Arrays.asList("1", "2","3", "+", "*"));
		
		//test for double digit
		//ArrayList<String> equation = new 
		//		ArrayList<String>(Arrays.asList("20", "90","*", "30", "/", "70", "+"));
		
		//test for longer equation
		ArrayList<String> equation = new 
		ArrayList<String>(Arrays.asList("100","20", "90","40", "30", "/", "-", "+","*"));
		
		//Stack will hold all numbers but not operators
		Stack<String> operation = new Stack<String>();
		
		//will go through each item in the arraylist and do operation
		// as appropriate: for numbers, will push onto stack, for operators,
		//will pop 2 numbers and perform operation
		for(String temp: equation)
		{
			curPos = temp;
			if(isOperator(curPos))
			{	
				num2 = Integer.valueOf(operation.pop());
				num1 = Integer.valueOf(operation.pop());
				
				System.out.printf("Calculating %d,%d,%s ",num1,num2,curPos);
				answer = calculate(num1, num2, curPos);
				System.out.printf("Answer is %d.\n",answer);
				operation.push(answer.toString());
			}
			else
			{	operation.push(curPos);		}
		}
		
	}
	
	//method to determine operator or operand
	private static boolean isOperator(String op)
	{
		switch(op)
		{
			case "+": return true;
			case "-": return true;
			case "*": return true;
			case "/": return true;
			default:  return false;
		}
	}
	
	//method to determine the operand and perform appropriate operation
	private static Integer calculate(Integer n1, Integer n2, String op)
	{
		switch(op)
		{
			case "+": return n1 + n2;
			case "-": return n1 - n2;
			case "*": return n1 * n2;
			case "/": return n1 / n2;
			default: System.out.println("Invalid operand");
					 return 0;
		
		}
	}

}
