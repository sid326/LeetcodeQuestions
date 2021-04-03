/**
 * @author Siddhant Sharma
 * @date 03-Apr-2021 @time 1:49:58 pm
 */

/*
 * 
You are given an array of binary strings ```strs``` and two integers ```m``` and ```n```.

Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.

A set x is a subset of a set y if all elements of x are also elements of y.

Constraints:

1 <= strs.length <= 600
1 <= strs[i].length <= 100
strs[i] consists only of digits '0' and '1'.
1 <= m, n <= 100
 */
public class OneAndZeroSolution1 {

	public static void main(String[] args) {
		OneAndZeroSolution1 obj = new OneAndZeroSolution1();
		int m = 5, n=3;
		String[] strs = {"10","0001","111001","1","0"};
		
		System.out.println(obj.findMaxForm(strs, m, n));
	}
	
	public int findMaxForm(String[] strs, int m, int n) {
		int[][] frequency = new int[strs.length][2];// as have only 0 and 1 as values 
		
		// calculate the frequency by index
		for(int i=0;i< strs.length;i++) {
			frequency[i] = calculateFrequency(strs[i]);
		}
		return helperFindMax(strs, m, n, 0, frequency);
	}
	
	public int helperFindMax(String[] strs, int maxZeros, int maxOnes, int index, int[][] frequency) {
		/*
		 * Corner Condition
		 * Two conditions:
		 * 1. if array is fully iterated
		 * 2. sum of maxZero and maxOne becomes 0
		 */
		
		if(index>= strs.length || (maxOnes + maxZeros) <= 0) {
			return 0;
		}
		
		int isConsidered = 0;
		int isNotConsidered = 0;
		int zeroFrequency = frequency[index][0];
		int oneFrequency = frequency[index][1];
		
		if( maxZeros >= zeroFrequency && maxOnes >= oneFrequency) {
			isConsidered = 1 + helperFindMax(strs, maxZeros - zeroFrequency , maxOnes - oneFrequency, index + 1, frequency);
		}
		isNotConsidered = helperFindMax(strs, maxZeros, maxOnes, index + 1, frequency);
		
		return Math.max(isConsidered, isNotConsidered);
	}
	
	public int[] calculateFrequency(String strs) {
		char[] charArray = strs.toCharArray();
		
		// 2 index 0 to store the zero frequency and 1 to store the 1 frequency
		int frequency[] = new int[2];
		for(char ch : charArray) {
			if(ch == '0') {
				frequency[0]++;
			} 
            if(ch == '1') {
				frequency[1]++;
			}
		}
		return frequency;
	}
}
