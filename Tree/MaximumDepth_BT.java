package Tree;

public class MaximumDepth_BT {
    public int maxDepth(TreeNode root) {

        // B1: dieu kien dung/bai toan co so
        if (root == null)
            return 0;

        // B2: cong thuc de quy:
        int chieuCaoCayBenTrai = maxDepth(root.left);
        int chieuCaoCayBenPhai = maxDepth(root.right);

        int result = Math.max(chieuCaoCayBenTrai, chieuCaoCayBenPhai) + 1;
        return result;
    }

    public static void main(String[] args) {

    }
}
