import java.util.Stack;

public class StackLL {
    static class Node{
        Node next;
        int data;
        Node(int data){
            this.data=data;
            this.next=next;
        }
    }

    static class Stack1 {
        static Node head=null;
        public static boolean isEmp(){
            return head==null;
        }
        public static void push(int data){
            Node newNode=new Node(data);
            if(isEmp()){
                head=newNode;
                return;
            }
            newNode.next=head;
            head=newNode;
        }
        public static int pop(){
            if(isEmp()){
                return -1;
            }
            int top=head.data;
            head=head.next;
            return top;
        }
        public static int peek(){
            if(isEmp()){
                return -1;
            }
            return head.data;

        }
    }
    public static void main(String[] args) {
        Stack1 s=new Stack1();
        s.push(1);
        s.push(2);
        while(!s.isEmp()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
