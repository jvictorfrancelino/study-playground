package estruturasDeDados;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        this.val = val;
    }

}

public class TreesLowestCommonAncestor {
    public TreeNode lowestCommonAncestor(
        TreeNode root,
        TreeNode p,
        TreeNode q
        ){

        if (root == null) {
            return null;
        }

        // Se encontrou um dos nós, retorna ele
        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // Se achou um em cada lado, este é o LCA
        if (left != null && right != null) {
            return root;
        }

        // Caso contrário, propaga o não-nulo
        return left != null ? left : right;
    }
}
