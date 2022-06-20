package Trees;
// A java program to find all duplicate subtrees
// in a binary tree.

import java.util.*;

public class DuplicateSubtreesLeetcode {

    /* A binary tree node has data, pointer to
    left child and a pointer to right child */
    static HashMap<String, Integer> m;
static LinkedList<Integer> l=new LinkedList<>();

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

   static public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Set<TreeNode> result = new HashSet<>();
        Map<String,TreeNode> map = new HashMap<>();

        getDuplicate(result,root,map,false,false);

        return new ArrayList<>(result);
    }

   static public String getDuplicate( Set<TreeNode> result,TreeNode root,Map<String,TreeNode> map,boolean left,boolean right){

        //to get the unique value for null on the left and right
        if(root==null && left)
            return "lnull";
        if(root==null && right)
            return "rnull";
        if(root==null)
            return "null";

        int val = root.data;

        String leftstr =  getDuplicate(result,root.left,map,true,false);
        String rightstr =  getDuplicate(result,root.right,map,false,true);

        String combined = leftstr+val+rightstr;

        if(map.containsKey(combined)){
            result.add(map.get(combined));
        }
        else{
            map.put(combined, root);
        }

        return combined;

    }
    // Driver code
    public static void main(String args[]) {
        TreeNode root = null;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(4);
        root.right.right = new TreeNode(4);
        List<TreeNode>tl=findDuplicateSubtrees(root);
       for(int i=0;i<tl.size();i++){
           System.out.print(tl.get(i).data+" ");
       }
    }
}