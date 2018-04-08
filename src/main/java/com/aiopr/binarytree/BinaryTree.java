package com.aiopr.binarytree;

/**
 * Created by Administrator on 2018/1/29.
 */
//104. Maximum Depth of Binary Tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class BinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int maxleft = maxDepth(root.left);
        int maxright = maxDepth(root.right);
        return max(maxleft,maxright)+1;
    }
    public int max(int a,int b){
        if(a>b) return a;
        else return b;
    }
}
class Solution {
    int sum=0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;
        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);
        if(root.left.left==null&&root.left.right==null) return root.left.val;
        return 0;
    }
}
