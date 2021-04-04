import java.util.Stack;

/**
 * 
 */

/**
 * @author Siddhant Sharma
 * @date 03-Apr-2021 @time 11:43:14 pm
 */
public class LongestValidParenthesesStack {

	public static void main(String[] args) {
		String str = "()(()";
		LongestValidParenthesesStack obj = new LongestValidParenthesesStack();
		System.out.println(obj.longestValidParentheses(str));
	}
	 public int longestValidParentheses(String s) {
		 int count = 0;
		 int maxCount =0;
		 Stack<Character> stack = new Stack<>();
		 char[] charArray = s.toCharArray();
		 for(char ch : charArray) {
			 if(stack.isEmpty() && ch == '(') {
				 stack.push(ch);
			 }else {
			 if(stack.peek()==')' && ch ==')') {
				 maxCount = Math.max(count, maxCount);
				 count = 0;
				 continue;
			 }
			 else if(!stack.isEmpty() && stack.peek()=='(' && ch == ')') {
				 count = count + 2;
				 stack.push(ch);
			 }else if(!stack.isEmpty() && stack.peek()=='(' && ch == '(') {
				 maxCount = Math.max(count, maxCount);
				 count = 0;
				 stack.push(ch);
			 }
			 else {
				 stack.push(ch);
			 }
			 }
		 }
		 return count;
	    }
}
