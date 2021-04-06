/**
 * @author Siddhant Sharma
 * @date 06-Apr-2021 @time 5:37:48 pm
 */
public class MaximumDepthBTSolution {

	/*
	 * Solution with recursive approach 
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		MaximumDepthBTSolution obj = new MaximumDepthBTSolution();
		int minimumDepth = obj.minDepth(root);
		System.out.println("Minimum Depth : "+ minimumDepth);
		
	}
	public int minDepth(TreeNode root) {
		if(root == null) return 0;
		else return helper(root);
	}
	public int helper(TreeNode root){
		if(root == null){
			return Integer.MIN_VALUE;
		}
		if(root.left == null && root.right ==null){
			return 1;
		}
		return 1+ Math.max(helper(root.left), helper(root.right));
	}
}

//Definition for a binary tree node.
class TreeNode {
int val;
TreeNode left;
TreeNode right;
TreeNode() {}
TreeNode(int val) { this.val = val; }
TreeNode(int val, TreeNode left, TreeNode right) {
	this.val = val;
	this.left = left;
	this.right = right;
}
}
