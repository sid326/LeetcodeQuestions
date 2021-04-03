/**
 * @author Siddhant Sharma
 * @date 03-Apr-2021 @time 1:51:09 pm
 */
public class OneAndZeroSolution2 {

	/*
	 * Solution with 3 dimensional dp memorization approach 
	 */
	int dp[][][] = null;
	public int findMaxForm(String[] strs, int m, int n) {
		dp = new int[m+1][n+1][strs.length];
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
		if(index >= strs.length || maxZeros + maxOnes <= 0) {
			return 0;
		}
		if(dp[maxZeros][maxOnes][index]>0) {
			return dp[maxZeros][maxOnes][index];
		}
		int isConsidered = 0;
		int isNotConsidered = 0;
		int zeroFreq = frequency[index][0];
		int oneFreq = frequency[index][1];

		if(maxZeros >= zeroFreq && maxOnes >= oneFreq) {
			isConsidered = 1 + helperFindMax(strs, maxZeros-zeroFreq, maxOnes-oneFreq, index +1, frequency);
		}
		isNotConsidered = helperFindMax(strs, maxZeros, maxOnes, index +1, frequency);
		dp[maxZeros][maxOnes][index] = Math.max(isNotConsidered, isConsidered);
		return dp[maxZeros][maxOnes][index];
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
