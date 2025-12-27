import java.util.ArrayList;

public class Main {
    static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static Node BuildTree(Node root,int val){
        if(root==null){
            root=new Node(val);
            return root;
        }
        if(root.data>val){
            root.left=BuildTree(root.left,val);
        }else{
           root.right= BuildTree(root.right,val);
        }
        return root;
    }
    public static void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public static boolean search(Node root,int val){
        if(root==null){
            return false;
        }
        if(root.data==val){
            return true;
        }
        if(root.data>val){
            return search(root.left,val);
        }else{
            return search(root.right,val);
        }
    }
    public static Node delete(Node root,int val){
        if(root.data>val){
            root.left=delete(root.left,val);
        }else if(root.data<val){
            root.right=delete(root.right,val);
        }
        else{
            if(root.left==null&&root.right==null){
                root=null;
            }
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            Node IS=inorderSucessor(root.right);
            root.data=IS.data;
            root.right=delete(root.right,IS.data);
        }
        return root;
    }
    public static Node inorderSucessor(Node root){
        while(root.left!=null){
            root=root.left;
        }
            return root;
    }
//    public static void printInRange(Node root,int k1,int k2){
//        if(root==null){
//            return;
//        }
//        if(root.data>=k1&&root.data<=k2){
//            printInRange(root.left,k1,k2);
//            System.out.print(root.data+" ");
//            printInRange(root.right,k2,k2);
//        } else if (root.data<k1) {
//            printInRange(root.left,k1,k2);
//        }else{
//            printInRange(root.right,k2,k2);
//        }
//    }
public static void printInRange(Node root, int k1, int k2){
    if(root == null) return;

    if(root.data > k1){
        printInRange(root.left, k1, k2);
    }

    if(root.data >= k1 && root.data <= k2){
        System.out.print(root.data + " ");
    }
    if(root.data < k2){
        printInRange(root.right, k1, k2);
    }

}
public static void printPath(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+"->");
        }
    System.out.println("null");
}
public static void root2Leaf(Node root,ArrayList<Integer> path){
        if(root==null){
            return;
        }
        path.add(root.data);
        if(root.left==null&&root.right==null){
            printPath(path);
        }
        root2Leaf(root.left,path);
        root2Leaf(root.right,path);
        path.remove(path.size()-1);
}
    public static boolean Validate(Node root,Node min,Node max){
        if(root==null){
            return true;
        }
        if(min != null && root.data<=min.data){
            return false;
        }else if(max != null && root.data>=max.data){
            return false;
        }
        return Validate(root.left,min,root)&&Validate(root.right,root,max);
    }
    public static void main(String[] args) {
        int[] values = {4, 8, 1, 3, 5, 9, 2, 7, 10, 0};
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = BuildTree(root, values[i]);
        }
        inOrder(root);
        System.out.println();
//        if(search(root,4)){
//            System.out.println("true");
//        }else System.out.println("false");

//        delete(root,9);
//        inOrder(root);
//        System.out.println();
//        delete(root,5);
//        inOrder(root);

//        printInRange(root,0,6);
        root2Leaf(root,new ArrayList<>());
        if(Validate(root,null,null)){
            System.out.println("valid");
        }else System.out.println("invalid");
    }
}
