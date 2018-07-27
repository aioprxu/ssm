package com.aiopr.binarytree;



import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Administrator on 2018/4/14.
 */

public class Norecursive {
//    //前序遍历
//    void preorderTraversalNew(TreeNode root, ArrayList<Integer> path)
//    {
//        Stack<Pair<TreeNode , Boolean>> s = new Stack<>();
//        Pair<TreeNode , Boolean> pair = new Pair<>(root, false);
//        s.push(pair);
//        boolean visited;
//        while(!s.empty())
//        {
//            root = s.peek().getKey();
//            visited = s.peek().getValue();
//            s.pop();
//            if(root == null)
//                continue;
//            if(visited)
//            {
//                path.add(root.val);
//            }
//            else
//            {
//                s.push(new Pair<>(root.right, false));
//                s.push(new Pair<>(root.left, false));
//                s.push(new Pair<>(root, true));
//            }
//        }
//    }
//    //更简单的非递归中序遍历
//    void inorderTraversalNew(TreeNode root, ArrayList<Integer> path)
//    {
//        Stack< Pair<TreeNode , Boolean> > s = new Stack<>();
//        s.push(new Pair<>(root, false));
//        boolean visited;
//        while(!s.empty())
//        {
//            root = s.peek().getKey();
//            visited = s.peek().getValue();
//            s.pop();
//            if(root == null)
//                continue;
//            if(visited)
//            {
//                path.add(root.val);
//            }
//            else
//            {
//                s.push(new Pair<>(root.right, false));
//                s.push(new Pair<>(root, true));
//                s.push(new Pair<>(root.left, false));
//            }
//        }
//    }
//    //更简单的非递归后序遍历
//    void postorderTraversalNew(TreeNode root, ArrayList<Integer> path)
//    {
//        Stack< Pair<TreeNode , Boolean> > s = new Stack<>();
//        s.push(new Pair<>(root, false));
//        boolean visited;
//        while(!s.empty())
//        {
//            root = s.peek().getKey();
//            visited = s.peek().getValue();
//            s.pop();
//            if(root == null)
//                continue;
//            if(visited)
//            {
//                path.add(root.val);
//            }
//            else
//            {
//                s.push(new Pair<>(root, true));
//                s.push(new Pair<>(root.right, false));
//                s.push(new Pair<>(root.left, false));
//            }
//        }
//    }
}
