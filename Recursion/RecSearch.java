import java.util.LinkedList;

public class RecSearch {
    static class Node{
        Node next;
        int data;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static void addL(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
        }else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public static int helper(Node head,int key){
        if(head==null){
            return -1;
        }
        if(head.data==key){
            return 0;
        }
        int i=helper(head.next,key);
        if(i==-1){
            return -1;
        }
        return i+1;
    }
        public static int searchRec(int key){
            return helper( head, key);
        }

    public static void main(String[] args) {
//        LinkedList ll=new LinkedList();
        addL(1);
        addL(2);
        addL(3);
        System.out.println( searchRec(3));

    }
}
