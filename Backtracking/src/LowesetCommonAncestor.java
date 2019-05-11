public class LowesetCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {



        return null;

    }

    TreeNode  lca(TreeNode root, TreeNode p, TreeNode q) {

        if(root != null){
            int parent = root.val;
            int pValue = p.val;
            int rValue = q.val;


            if (pValue > parent && rValue > parent){
              return   lca(root.right, p,q);
            } else if(pValue <parent && rValue <parent) {
              return  lca(root.left, p,q);
            } else {
                return root;
            }
        }
        return root;
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }