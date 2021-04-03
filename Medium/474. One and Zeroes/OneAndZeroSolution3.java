/**
 * @author Siddhant Sharma
 *
 */
public class OneAndZeroSolution3 {


	/*
	 * Solution with 2 dimensional dp memorization approach 
	 */
	int dp[][] = null;
	public int findMaxForm(String[] strs, int m, int n) {
		dp = new int[m+1][n+1];
		int[][] frequency = new int[strs.length][2];// as have only 0 and 1 as values 
		
		// calculate the frequency by index
		for(int i=0;i< strs.length;i++) {
			frequency[i] = calculateFrequency(strs[i]);
		}
		
		for(int i=0;i<strs.length;i++)
		{
			int oneFreq = frequency[i][1];
			int zeroFreq = frequency[i][0];
			for(int j=m;j>=zeroFreq;j--) {
				for(int k=n;k>=oneFreq;k--) {
					dp[j][k] = Math.max(dp[j][k], dp[j - zeroFreq][k - oneFreq] + 1);
				}
			}
		}
		
		return dp[m][n];
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
