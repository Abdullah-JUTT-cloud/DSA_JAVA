public class LargestBSTInBT {
    static class Node4 {
        int data;
        Node4 left;
        Node4 right;

        Node4(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static int maxBST=0;
    public static Info largestBST(Node4 root){
        if(root==null){
            return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        Info leftInfo=largestBST(root.left);
        Info rightInfo=largestBST(root.right);
        int size= leftInfo.size+rightInfo.size+1;
        int max=Math.max(root.data,Math.max(leftInfo.max,rightInfo.max));
        int min=Math.min(root.data,Math.min(leftInfo.min,rightInfo.min));

        if(root.data<=leftInfo.max||root.data>=rightInfo.min){
            return new Info(false,size,min,max);
        }
        if(leftInfo.isBST&&rightInfo.isBST){
            maxBST=Math.max(maxBST,size);
            return new Info(true,size,min,max);
        }
        return new Info(false,size,min,max);
    }
    static class Info{
        boolean isBST;
        int size;
        int min;
        int max;
        Info( boolean isBST,int size,int min,int max){
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
    public static void main(String[] args) {
        Node4 root = new Node4(50);

        root.left = new Node4(30);
        root.left.left = new Node4(5);
        root.left.right = new Node4(20);

        root.right = new Node4(60);
        root.right.left = new Node4(45);
        root.right.right = new Node4(70);
        root.right.right.left = new Node4(65);
        root.right.right.right = new Node4(80);
        Info info = largestBST(root);
        System.out.println(maxBST);
    }
}
