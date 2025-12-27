public class doubleLL {
    class Node3{
        Node3 next;
        int data;
        Node3 prev;
        Node3(int data){
            this.data=data;
            this.next=null;
            this.next=null;
        }
    }
    public static Node3 head;
    public static Node3 tail;
    public static int sz;

    public void aF(int data){
        Node3 newNode=new Node3(data);
        sz++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
    }
    public void aL(int data){
        Node3 newNode=new Node3(data);
        sz++;
        if(head==null){
            head=tail=newNode;
        }
        tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;

    }
    public void p(){
        Node3 temp=head;
        while(temp!=null){
            System.out.print(temp.data+"<->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public int rF(){
        if(head==null){
            System.out.println("DLL is empty......");
            return Integer.MAX_VALUE;
        }
        if(sz==1){
            int val=head.data;
            head=tail=null;
            sz--;
            return val;
        }
        int val= head.data;
        head=head.next;
        head.prev=null;
        sz--;
        return val;
    }
    public int rL(){
        if(head==null){
            System.out.println("DLL empty!!");
            return Integer.MAX_VALUE;
        }
        if(sz==1){
            int v=head.data;
            head=tail=null;
            sz--;
            return v;
        }
        int v=tail.data;
        tail.prev.next=null;
        tail=tail.prev;
        sz--;
        return v;

    }
   

    public static void main(String[] args) {
        doubleLL dll=new doubleLL();
        dll.aF(3);
        dll.aF(2); dll.aF(1);
        dll.aL(4);
        dll.aL(5);
        dll.p();
//        System.out.println(dll.sz);
//        System.out.println(dll.rF());
//        dll.p();
//        System.out.println(dll.sz);
//        dll.aL(4);
//        dll.p();
//        System.out.println(dll.sz);
//        System.out.println(dll.rL());
//        dll.p();
//        System.out.println(dll.sz);
    }
}
