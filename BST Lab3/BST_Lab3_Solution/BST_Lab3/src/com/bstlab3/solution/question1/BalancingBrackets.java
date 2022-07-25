package com.bstlab3.solution.question1;

import java.util.Stack;

public class BalancingBrackets {
	
	static boolean checkBalancedBrackets(String bracket) {
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<bracket.length(); i++) {
			char c = bracket.charAt(i);
			if(c == '(' || c == '[' || c == '{') {
				stack.push(c);
				continue;
			}
			if(stack.isEmpty()) {
				return false;
			}
			
			char s;
			switch(c) {
			case ')':	
				s=stack.pop();
				if(s=='{' || s=='[')
					return false;
				break;
				
			case ']':
				s=stack.pop();
				if(s=='(' || s=='{')
					return false;
				break;
				
			case '}':
				s=stack.pop();
				if(s=='(' || s=='[')
					return false;
				break;
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String bracketExpression ="([[{}]])";
		Boolean result;
		
		result= checkBalancedBrackets(bracketExpression);
		if(result)	
			System.out.println("The entered String has Balanced Brackets");
		else
			System.out.println("The entered Strings do not contain Balanced Brackets");
	}

}
