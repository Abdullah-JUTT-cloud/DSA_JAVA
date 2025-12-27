import java.util.ArrayList;

public class ComplexProblems {
    static class  Node3{
        int data;
        Node3 right;
        Node3 left;
        Node3(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static void preOrder(Node3 root){
        if(root == null) return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static Node3 createBST(int[] arr,int s,int e){
        if(s>e){
            return null;
        }
        int mid=(s+e)/2;
        Node3 root = new Node3(arr[mid]);
         root.left=createBST(arr,s,mid-1);
         root.right=createBST(arr,mid+1,e);
         return root;
    }
    public static void getInorder(Node3 root,ArrayList<Integer> inorder){
        if(root==null) return ;
        getInorder(root.left,inorder);
        inorder.add(root.data);
        getInorder(root.right,inorder);
    }
    public static Node3 generateBST(ArrayList<Integer> inorder,int s,int e){
        if(s>e) return null;
        int mid=(s+e)/2;
        Node3 root=new Node3(inorder.get(mid));
        root.left=generateBST(inorder,s,mid-1);
        root.right=generateBST(inorder,mid+1,e);
        return root;
    }
    public static Node3 balancedBST(Node3 root){
        ArrayList<Integer> inorder=new ArrayList<>();
        getInorder(root,inorder);
        root=generateBST(inorder,0,inorder.size()-1);
        return root;
    }
    public static void main(String[] args) {
//        int[] arr={3,5,6,8,10,11,12};
//       Node3 root= createBST(arr,0,arr.length-1);
//       preOrder(root);
        Node3 root=new Node3(8);
        root.left=new Node3(6);
        root.left.left=new Node3(5);
        root.left.left.left=new Node3(3);
        root.right=new Node3(10);
        root.right.right=new Node3(11);
        root.right.right.right=new Node3(12);
        root=balancedBST(root);
        preOrder(root);
    }
}
