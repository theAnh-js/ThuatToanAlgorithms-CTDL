package Tree;

import java.util.ArrayList;
import java.util.List;

public class MyBST {

    public TreeNode mRoot;

    public TreeNode insert(TreeNode root, int value) {

        TreeNode newNode = new TreeNode(value);

        // TH1: root = null;
        if (root == null) {
            root = newNode;
            return root;
        } else {
            TreeNode temp = root;
            while (true) {
                if (value > temp.val) {
                    if (temp.right == null) {
                        temp.right = newNode;
                        break;
                    } else {
                        temp = temp.right;
                    }
                } else { // value < temp.val
                    if (temp.left == null) {
                        temp.left = newNode;
                        break;
                    } else {
                        temp = temp.left;
                    }
                }
            }
            return root;
        }
    }

    public TreeNode insertIntoBST(TreeNode rootNode, int value) {
        if (rootNode == null) {
            return new TreeNode(value);
        }

        if (value < rootNode.val) {
            if (rootNode.left == null) {
                rootNode.left = new TreeNode(value);
            } else {
                insertIntoBST(rootNode.left, value);
            }
        } else {
            if (rootNode.right == null) {
                rootNode.right = new TreeNode(value);
            } else {
                insertIntoBST(rootNode.right, value);

            }
        }

        return rootNode;
    }

    // Tìm node con trái cùng của root.
    public TreeNode findLeftMostNode(TreeNode root) {

        if (root == null) {
            return null;
        }
        TreeNode leftMostNode = root;
        while (leftMostNode.left != null) {
            leftMostNode = leftMostNode.left;
        }
        return leftMostNode;
    }

    // xoa node key trong cay root
    // return: cay moi da dk xoa node key
    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null)
            return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else { // root.val = key -> xoa root luon
            // TH1: root la node lá:
            if (root.left == null && root.right == null) {
                return null;
            }
            // TH2: Chỉ có 1 con bên trái
            if (root.right == null && root.left != null) {
                return root.left;
            }
            // TH3: Chỉ có 1 con bên phải
            if (root.right != null && root.left == null) {
                return root.right;
            }
            // TH4: Tồn tại 2 con
            // Tìm node trái cùng của cây con bên phải
            TreeNode leftMostNode = findLeftMostNode(root.right);
            root.val = leftMostNode.val;
            root.right = deleteNode(root.right, leftMostNode.val);
        }
        return root;
    }

    public TreeNode searchBST(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            return searchBST(root.left, key);
        } else if (key > root.val) {
            return searchBST(root.right, key);
        } else { // root.val = key
            return root;
        }
    }

    // Node - L - R
    public static void PreOder(TreeNode currentNode) {
        if (currentNode == null) {
            return;
        }

        System.out.println(currentNode.val + " ");
        PreOder(currentNode.left);
        PreOder(currentNode.right);

    }

    // L - Node - R
    public static void InOder(TreeNode currentNode) {
        if (currentNode == null) {
            return;
        }

        InOder(currentNode.left);

        System.out.println(currentNode + " ");

        InOder(currentNode.right);

    }

    // L - R - Node
    public static void PostOrder(TreeNode currentNode) {
        if (currentNode == null) {
            return;
        }

        PostOrder(currentNode.left);

        PostOrder(currentNode.right);

        System.out.println(currentNode + " ");
    }

    List<Integer> duyetOrder = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {

        if (root == null) {
            return duyetOrder;
        }
        duyetOrder.add(root.val);

        preorderTraversal(root.left);
        preorderTraversal(root.right);

        return duyetOrder;
    }
}
