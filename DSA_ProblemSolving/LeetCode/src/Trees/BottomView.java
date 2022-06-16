package Trees;

import java.util.*;

public class BottomView {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static  class Pair{
        int hd;
        Node node;

        public Pair(int hd,Node node){
            this.node=node;
            this.hd=hd;
        }
    }

    static class BT {
        static int idx = -1;

        public static Node buildTree(int[] nodes) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

    static ArrayList<Integer> topView(Node root){
        Queue<Pair> q=new LinkedList<>();
        Map<Integer,Integer>map=new TreeMap<>();
        q.add(new Pair(0,root));
        while (!q.isEmpty()){
          Pair curr=q.poll();
              map.put(curr.hd, curr.node.data);
          if(curr.node.left!=null){
              q.add(new Pair(curr.hd-1, curr.node.left));
          }
            if(curr.node.right!=null){
                q.add(new Pair(curr.hd+1, curr.node.right));
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }

    public static void main(String args[]) {
            int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
            BT tree = new BT();
            Node root = BT.buildTree(nodes);
            ArrayList ar= topView(root);
            System.out.println(ar);

        }
    }

