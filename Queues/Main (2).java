public class Main {
    static class Node{
        Node next;
        int data;
        Node(int data){
            this.data=data;
            this.next=null;
        }

    }
    public static class QueueLL{
        static Node head;
        static Node tail;
        public static boolean isEmpty(){
            return head==null && tail==null;
        }
        public static void Enqueue(int data){
            Node newNode=new Node(data);
            if(head==null){
                head=tail=newNode;
            }
            tail.next=newNode;
            tail=newNode;

        }
        public static int Dequeue(){
            if(isEmpty()){
                System.out.println("empty");
                return 01 ;
            }
            int top=head.data;
            if(head==tail){
                head=tail=null;
            }else {
                head=head.next;
            }

            return top;
        }
        public static int poll(){
            if(isEmpty()){
                System.out.println("emp");
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String[] args) {
        QueueLL q=new QueueLL();
        q.Enqueue(1);
        q.Enqueue(2);
        while(!q.isEmpty()){
            System.out.println(q.poll());
            q.Dequeue();
        }

    }
}