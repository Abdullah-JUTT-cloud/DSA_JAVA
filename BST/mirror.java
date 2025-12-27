public class mirror {
    static class Node2{
        int data;
        Node2 left;
        Node2 right;
         Node2(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static Node2 Mirror(Node2 root){
        if(root == null) return null;
       Node2 leftM= Mirror(root.left);
       Node2 rightM= Mirror(root.right);
       root.left=rightM;
       root.right=leftM;
       return root;

    }
    public static void preOrder(Node2 root){
        if(root == null) return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) {
        Node2 root = new Node2(8);
        root.left = new Node2(5);
        root.right = new Node2(10);
        root.left.left = new Node2(3);
        root.left.right = new Node2(6);
//        root.right.left = new Node2(5);
        root.right.right = new Node2(11);


        Mirror(root);
        preOrder(root);
    }
}
