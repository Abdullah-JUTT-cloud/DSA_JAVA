public class queueLL {
    static class Node{
        Node next;
        int data;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static class LLqueue{
        static Node head=null;
        static Node tail=null;

        public static boolean isEmp(){
            return head==null && tail==null;
        }
        public void addLL(int data){
            Node newNode=new Node(data);
            if(head==null){
                head=tail=newNode;
                return;
            }
            tail.next=newNode;
            tail=newNode;
        }
        public int remLL(){
            if(isEmp()){
                System.out.println("Empty!");
                return Integer.MAX_VALUE;
            }
            int front=head.data;
            if(head==tail){
                head=tail=null;

            }else {
                head=head.next;
            }
            return front;
        }
        public int peek(){
            if(isEmp()){
                System.out.println("Empty!");
                return Integer.MAX_VALUE;
            }
            return head.data;

        }

    }
    public static void main(String[] args) {
        LLqueue qll=new LLqueue();
        qll.addLL(1);
        qll.addLL(2);
        qll.addLL(3);
        while(!qll.isEmp()){
            System.out.println(qll.peek());
            qll.remLL();
        }
    }
}
