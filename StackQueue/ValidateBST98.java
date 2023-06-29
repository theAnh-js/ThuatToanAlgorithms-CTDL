package StackQueue;

import java.util.Stack;

import Tree.TreeNode;

public class ValidateBST98 {
    private Stack<TreeNode> stack = new Stack<>();
    private Stack<TreeNode> minStack = new Stack<>();
    private Stack<TreeNode> maxStack = new Stack<>();

    private void addToStacks(TreeNode node, TreeNode minNode, TreeNode maxNode) {
        stack.push(node);
        minStack.push(minNode);
        maxStack.push(maxNode);
    }

    private boolean checkNode(TreeNode curNode, TreeNode minNode, TreeNode maxNode) {
        if (curNode == null) {
            return true;
        }
        if (minNode != null && curNode.val <= minNode.val) {
            return false;
        }

        if (maxNode != null && curNode.val >= maxNode.val) {
            return false;
        }

        return true;
    }

    public boolean isValidBST(TreeNode root) {
        stack.push(root);
        minStack.push(null);
        maxStack.push(null);
        while (stack.isEmpty() == false) {
            TreeNode curNode = stack.pop();
            TreeNode minNode = minStack.pop();
            TreeNode maxNode = maxStack.pop();

            if (curNode == null)
                continue;

            if (checkNode(curNode, minNode, maxNode) == true) {
                addToStacks(curNode.right, curNode, maxNode);
                addToStacks(curNode.left, minNode, curNode);
            } else {
                return false;
            }

        }
        return true;
    }
}
