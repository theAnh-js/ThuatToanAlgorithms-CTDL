package Tree;

public class PathSum {
    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public boolean duyet(TreeNode curNode, int curSum, int targetSum) {
        // b1: dieu kien dung/bai toan cs
        if (curNode == null)
            return false;

        curSum += curNode.val;
        if (isLeaf(curNode)) {
            return curSum == targetSum;
        }

        // b2: duyet sang 2 cay con de kiem tra
        boolean kqBenTrai = duyet(curNode.left, curSum, targetSum);
        boolean kqBenPhai = duyet(curNode.right, curSum, targetSum);

        return kqBenTrai || kqBenPhai;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return duyet(root, 0, targetSum);
    }
}
