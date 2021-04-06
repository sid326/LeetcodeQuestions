import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Siddhant Sharma
 * @date 03-Apr-2021 @time 4:49:57 pm
 */

public class MinimumDepthOfBTSolution2 {

	/*
	 * Solution with Queue approach 
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		MinimumDepthOfBTSolution2 obj = new MinimumDepthOfBTSolution2();
		int minimumDepth = obj.minDepth(root);
		System.out.println("Minimum Depth : "+ minimumDepth);

	}
	public int minDepth(TreeNode root) {
        int level = 0;
        if(root==null) return level;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            for(int i=0;i<size;i++){
                TreeNode n = q.poll();
                if(n.left!=null) q.add(n.left);
                if(n.right!=null) q.add(n.right);
                if(n.left==null && n.right==null) return level;
            }
        }
        return -1;
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
