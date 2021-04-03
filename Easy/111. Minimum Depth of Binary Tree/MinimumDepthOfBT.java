/**
 * @author Siddhant Sharma
 * @date 03-Apr-2021 @time 4:15:08 pm
 */
public class MinimumDepthOfBT {

	/*
	 * Solution with recursive approach 
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		MinimumDepthOfBT obj = new MinimumDepthOfBT();
		int minimumDepth = obj.minDepth(root);
		System.out.println("Minimum Depth : "+ minimumDepth);
		
	}
	public int minDepth(TreeNode root) {
		if(root == null) return 0;
		else return helper(root);
	}
	public int helper(TreeNode root){
		if(root == null){
			return Integer.MAX_VALUE;
		}
		if(root.left == null && root.right ==null){
			return 1;
		}
		return 1+ Math.min(helper(root.left), helper(root.right));
	}
}

//  Definition for a binary tree node.
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

