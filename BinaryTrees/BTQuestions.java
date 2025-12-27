import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class heightOfBTree {
    static class Node2{
        Node2 left;
        Node2 right;
        int data;
        Node2(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }

    }
    public static int height(Node2 root){
        if(root ==null){
            return 0;
        }
        int lh=height(root.left);
        int rh=height(root.right);
        return Math.max(lh,rh)+1;
    }
    public static int count(Node2 root){
        if(root==null){
            return 0;
        }
        int lc=count(root.left);
        int rc=count(root.right);
        return lc+rc+1;
    }
    public static int Sum(Node2 root){
        if(root==null){
            return 0;
        }
        int ls=Sum(root.left);
        int rs=Sum(root.right);
        return ls+rs+root.data;
    }
    public static int Diam(Node2 root){
        if(root ==null){
            return 0;
        }
        int ld=Diam(root.left);
        int lh=height(root.left);
        int rd=Diam(root.right);
        int rh=height(root.right);
        int selfDiam=lh+rh+1;
        return Math.max(selfDiam,Math.max(rd,ld));
    }
    static class TreeInfo{
        int ht;
        int diam;
        TreeInfo(int ht,int diam){
            this.ht=ht;
            this.diam=diam;
        }
    }
    public static TreeInfo Diam2(Node2 root){
        if(root ==null ){
            return new TreeInfo(0,0);
        }
        TreeInfo left=Diam2(root.left);
        TreeInfo right=Diam2(root.right);
        int myHeight=Math.max(left.ht,right.ht)+1;
        int ld=left.diam;
        int rd=right.diam;
        int Diam= left.ht+ right.ht+1;
        int selfDiam=Math.max(Diam,Math.max(ld,rd));
        TreeInfo info=new TreeInfo(myHeight,Diam);
        return info;


    }
    public static boolean isIdentical(Node2 node,Node2 subRoot){
        if(node==null && subRoot==null){
            return true;
        }else if(node ==null || subRoot==null || node.data!= subRoot.data){
            return false;
        }
        if(!isIdentical(subRoot.left,subRoot.left)){
            return false;
        }
        if(!isIdentical(subRoot.right,subRoot.right)){
            return false;
        }
        return true;
    }
    public static boolean isSubtree(Node2 root,Node2 subRoot){
        if(root==null){
            return false;
        }
        if(root.data==subRoot.data){
            if(isIdentical(root,subRoot)){
                return true;
            }
        }
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
    static class info{
        Node2 node;
        int hd;
        info(Node2 node,int hd){
            this.node=node;
            this.hd=hd;
        }

    }
    public static void topView(Node2 root){
        Queue<info> q=new LinkedList<>();
        HashMap<Integer, Node2> map=new HashMap<>();
        int min=0,max=0;
        q.add(new info(root,0));
        q.add(null);
        while (!q.isEmpty()){
            info curr=q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else {
                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd, curr.node);
                }
                if(curr.node.left!=null){
                    q.add(new info(curr.node.left, curr.hd-1));
                    min=Math.min(curr.hd-1, min);
                }
                if(curr.node.right!=null){
                    q.add(new info(curr.node.right, curr.hd+1));
                    max=Math.max(curr.hd+1, max);
                }
            }


        }
        for (int i=min;i<=max;i++){
            System.out.print(map.get(i).data+" ");
        }
        System.out.println();
    }
    public static void Klevel(Node2 root,int l,int k){
        if(root==null){
            return;
        }
        if(l==k){
            System.out.print(root.data+" ");
        }
        Klevel(root.left,l+1,k);
        Klevel(root.right,l+1,k);
    }
    public static boolean getPath(Node2 root,int n,ArrayList<Node2> path){
        if(root==null){
            return false;
        }
        path.add(root);
        if(root.data==n){
            return true;
        }
        boolean leftP=getPath(root.left,n,path);
        boolean rightP=getPath(root.right,n,path);
            if(leftP || rightP){
                return true;
            }
            path.remove(path.size()-1);
            return false;
    }
    public static Node2 lca(Node2 root,int n1,int n2){
        ArrayList<Node2> path1=new ArrayList<>();
        ArrayList<Node2> path2=new ArrayList<>();
        getPath(root,n1,path1);
        getPath(root,n2,path2);
        int i=0;
        for(;i<path1.size()&&i<path2.size();i++){
            if(path1.get(i)!=path2.get(i)){
                break;
            }


        }
        Node2 lca=path1.get(i-1);
        return lca;
    }
    public static Node2 lca2(Node2 root,int n1,int n2){
        if(root==null||root.data==n1||root.data==n2){
            return root;
        }
        Node2 Llca=lca2(root.left,n1,n2);
        Node2 Rlca=lca2(root.right,n1,n2);
        if(Rlca==null){
            return Llca;
        }
        if(Llca==null){
            return Rlca;
        }
        return root;
    }
    public static int lcaDis(Node2 root,int n){
        if(root==null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }
        int leftDis=lcaDis(root.left,n);
        int rightDis=lcaDis(root.right,n);
        if(leftDis==-1&&rightDis==-1){
            return -1;
        } else if (leftDis==-1) {
            return rightDis+1;
        }else {
            return leftDis+1;
        }
    }
    public static int minDist(Node2 root ,int n1,int n2){
       Node2 lca= lca2(root,n1,n2);
       int dist1=lcaDis(root,n1);
       int dist2=lcaDis(root,n2);
       return dist1+dist2;

    }
    public static int KAncestor(Node2 root,int n,int k){
        if(root==null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }
        int LD=KAncestor(root.left,n,k);
        int RD=KAncestor(root.right,n,k);
        if(LD==-1&&RD==-1){
            return -1;
        }
        int max=Math.max(LD,RD);
        if(max+1==k){
            System.out.println(root.data);
        }
        return max+1;
    }

    public static int transformToSum(Node2 root){
        if(root==null){
            return 0;
        }
        int Lchild=transformToSum(root.left);
        int Rchild=transformToSum(root.right);
        int data=root.data;
        int newL= root.left==null?0:root.left.data;
        int newR=root.right==null?0:root.right.data;
        root.data=Lchild+newL+Rchild+newR;
        return data;

    }
    public static void preOrder(Node2 root){
        if(root==null){
            return;

        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void levelOrder(Node2 root){
        Queue<Node2> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node2 currNode=q.remove();
            if(currNode==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(currNode.data+" ");
                if(currNode.left!=null){
                    q.add(currNode.left);
                }
                if(currNode.right!=null) {
                    q.add(currNode.right);
                }
            }
        }
    }
    public static void main(String[] args) {
        Node2 root=new Node2(1);
        root.left=new Node2(2);
        root.right=new Node2(3);
        root.left.left=new Node2(4);
        root.left.right=new Node2(5);
        root.right.left=new Node2(6);
        root.right.right=new Node2(7);

//        System.out.println(height(root));
//        System.out.println(count(root));
//        System.out.println(Sum(root));
//        System.out.println(Diam(root));
//        System.out.println(Diam2(root).diam);
//        System.out.println(Diam2(root).ht);
//
//
//        Node2 subRoot=new Node2(2);
//        subRoot.left=new Node2(4);
//        subRoot.right=new Node2(5);
//
//        System.out.println(isSubtree(root,subRoot));
//        topView(root);

//        Klevel(root,1,3);


//        System.out.println(lca2(root,6,7).data);
//        System.out.println(minDist(root,4,6));
//        KAncestor(root,5,2);
        transformToSum(root);
        preOrder(root);
        System.out.println();
        levelOrder(root);
    }
}

