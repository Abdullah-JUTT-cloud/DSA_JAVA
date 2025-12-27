import java.util.ArrayList;

public class MergeBSTs {
    static class Node5{
        Node5 left;
        Node5 right;
        int data;
        public Node5(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static void getInorder(Node5 root, ArrayList<Integer> inorder){
        if(root==null) return ;
        getInorder(root.left,inorder);
        inorder.add(root.data);
        getInorder(root.right,inorder);
    }
    public static Node5 buildBST(ArrayList<Integer> inorder, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        Node5 node = new Node5(inorder.get(mid));
        node.left = buildBST(inorder, start, mid - 1);
        node.right = buildBST(inorder, mid + 1, end);
        return node;
    }

    public static Node5 mergeBSTs(Node5 root1,Node5 root2){
        ArrayList<Integer> inorder1=new ArrayList();
        getInorder(root1,inorder1);
        ArrayList<Integer> inorder2=new ArrayList();
        getInorder(root2,inorder2);
        ArrayList<Integer> finalinorder=new ArrayList();
        int i=0,j=0;
        while(i<inorder1.size()&&j<inorder2.size()){
            if(inorder1.get(i)<=inorder2.get(j)){
                finalinorder.add(inorder1.get(i++));
            }else{
                finalinorder.add(inorder2.get(j++));
            }
        }
        while(i<inorder1.size()){
            finalinorder.add(inorder1.get(i++));
        }
        while(j<inorder2.size()){
            finalinorder.add(inorder2.get(j++));
        }

        return  buildBST(finalinorder,0,finalinorder.size()-1);
    }
    public static void getPreorder(Node5 root) {
        if (root == null) return;
        System.out.print(root.data+" ");
        getPreorder(root.left);
        getPreorder(root.right);
    }
    public static void main(String[] args) {
        Node5 root1=new Node5(2);
        root1.left=new Node5(1);
        root1.right=new Node5(4);


        Node5 root2=new Node5(9);
        root2.left=new Node5(3);
        root2.right=new Node5(12);

        Node5 root=mergeBSTs(root1,root2);
        getPreorder(root);
    }
}
