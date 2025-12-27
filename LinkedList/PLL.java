public class PLL {
    Node1 head;
    class Node1{
        int data;
        Node1 next;
        Node1(int data){
            this.data=data;
            this.next=null;
        }

    }
    public void addL(int data){
        Node1 newN=new Node1(data);
        if(head==null){
            head=newN;
            return;
        }
        Node1 curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=newN;

    }
    public void reverseI(){
        Node1 prev=head;
        Node1 cur=head.next;
        while(cur!=null){
            Node1 next=cur.next;
            cur.next=prev;


            prev=cur;
            cur=next;
        }
        head.next=null;
        head=prev;
    }

    public void print(){

        if(head==null){
            System.out.println("List is EMPTY!");
        }
        Node1 curr=head;
        while(curr!=null){
            System.out.print(curr.data+" -> ");
            curr=curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        PLL list=new PLL();
        list.addL(1);
        list.addL(2);
        list.addL(3);
        list.addL(4);
        list.print();
        list.reverseI();
        list.print();
    }
}

