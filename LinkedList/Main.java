import java.util.LinkedList;

public class Main{
public static class Node2 {
    int data;
    Node2 next;

    public Node2(int data) {
        this.data = data;
        this.next = null;
    }
}


        public static Node2 head;
        public static Node2 tail;
        public static int s;

        public void addFirst(int data) {
            Node2 newNode = new Node2(data);
            s++;
            if (head == null) {
                head = tail = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        public void addLast(int data) {
            Node2 newNode = new Node2(data);
            s++;
            if (head == null) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }
        public void add(int id,int data){

            if(id==0){
               addFirst(data);
               return;
            }
            Node2 newNode=new Node2(data);
            s++;
            Node2 temp=head;
            int i=0;
            while(i<id){
                temp=temp.next;
                i++;
            }
            newNode.next=temp.next;
            temp.next=newNode;
        }
        public int removeF(){
            if(head==null){
                System.out.println("list is empty");
                return -1;
            }
            int val=head.data;
            head=head.next;
            s--;
            System.out.println(val);
            return val;

        }
        public int removeL(){
            if(s==0){
                System.out.println("EMpty");
                return Integer.MAX_VALUE;
            } else if (s==1) {
                int val= head.data;
                head=tail=null;
                s=0;
                return val;
            }
            Node2 temp=head;
           for(int i=0;i<s-2;i++){
               temp=temp.next;
           }
           int val= temp.next.data;
           temp.next=null;
           tail=temp;
           return val;
        }
        public int search(int key){
            Node2 temp=head;
            int i=0;
            while(temp!=null){
                if(temp.data==key){
                    return i;
                }
                temp=temp.next;
                i++;
            }
            return -1;
        }
        public void print1() {
            if (head == null) {
                System.out.println("LL EMPTY!!!");
                return;
            }
            Node2 temp = head;
            while (temp != null) {
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
            System.out.println("null");
        }

        public void reverse(){
            Node2 prev=null;
            Node2 curr=tail=head;
            Node2 next;
            while(curr!=null){
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            head=prev;
        }
        public void deleteN(int n){
            int sx=0;
            Node2 temp=head;
            while(temp.next!=null){
                temp=temp.next;
                sx++;
            }
            if(sx==n){
                head=head.next;
            }
            Node2 prev=head;
            int i=0;
            while(i<(sx-n)){
                prev=prev.next;
                i++;
            }
            prev.next=prev.next.next;
            System.out.println(sx-1);
            return;
        }
        public Node2 mid(Node2 head){
            Node2 slow=head;
            Node2 fast=head;
            while(fast!=null&&fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            return slow;
        }
        public boolean pali(){
            if(head==null|| head.next==null){
                return true;
            }
            Node2 mid=mid(head);
            Node2 prev=null;
            Node2 curr=mid;
            Node2 next;
            while(curr!=null){
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            Node2 right=prev;
            Node2 left=head;
            while(right!=null){
                if(left.data!=right.data){
                    return false;
                }
                left=left.next;
                right=right.next;
            }
            return true;

        }
        public static boolean cycle(){
            Node2 slow=head;
            Node2 fast=head;
            while(fast!=null&fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
                if(slow==fast){
                    return true;

                }
            }
            return false;
        }
        public static void removecycle(){
            Node2 slow=head;
            Node2 fast=head;
            boolean cycle=false;
            while(fast!=null&&fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
                if(slow==fast){
                    cycle=true;
                    break;
                }
            }
            if(cycle==false){
                return;
            }
            slow=head;
            Node2 prev=null;


            if(cycle==true){
                while (slow!=fast){
                    prev=fast;
                    slow=slow.next;
                    fast=fast.next;
                }

                prev.next=null;
                System.out.println("Cycle removed ");

            }
        }
        public void zigzag(){
            Node2 slow=head;
            Node2 fast=head;
            while (fast!=null&& fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            Node2 mid=slow;
            Node2 curr=mid.next;
            mid.next=null;
            Node2 prev=null;
            Node2 next;
            while(curr!=null){
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            Node2 left=head;
            Node2 right=prev;
            Node2 nextL,nextR;
            while (left!=null&&right!=null){
                nextL=left.next;
                left.next=right;
                nextR=right.next;
                right.next=nextL;
                left=nextL;
                right=nextR;
            }
        }
        public static Node2 getMid(Node2 head){
            Node2 slow=head;
            Node2 fast=head.next;
            while(fast!=null && fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            return slow;
        }
        public static Node2 merge(Node2 headL,Node2 headR){
            Node2 mergeLL=new Node2(-1);
            Node2 temp=mergeLL;
            while(headL !=null && headR !=null){
                if(headL.data<=headR.data){
                    temp.next=headL;
                    headL=headL.next;
                    temp=temp.next;
                }else{
                    temp.next=headR;
                    headR=headR.next;
                    temp=temp.next;
                }
            }
            while(headL!=null){
                temp.next=headL;
                headL=headL.next;
                temp=temp.next;
            }
            while(headR!=null){
                temp.next=headR;
                headR=headR.next;
                temp=temp.next;
            }
            return mergeLL.next;

        }
        public static Node2 mergeSort(Node2 head){
            if(head ==null || head.next==null){
                return head;
            }
            Node2 mid=getMid(head);
            Node2 rightHead=mid.next;
            mid.next=null;
            Node2 newLeft=mergeSort(head);
            Node2 newRight=mergeSort(rightHead);
            return merge(newLeft,newRight);
        }


    public static void main(String[] args) {
        Main ll=new Main();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(88);
        ll.addLast(4);
        ll.addLast(5);
//        ll.addLast(6);
        ll.print1();
//        ll.deleteN(3);
//        ll.zigzag();
//        System.out.println( ll.pali());
        ll.head=ll.mergeSort(head);
        ll.print1();
//        head=new Node2(1);
//        Node2 temp=new Node2(2);
//        head.next=temp;
//        head.next.next=new Node2(3);
//        head.next.next.next=temp;
//        System.out.println(cycle());
//        removecycle();
//        System.out.println(cycle());
//        ll.addFirst(2);
//        ll.addFirst(1);
//        ll.addLast(1);
//        ll.addLast(1);
//        ll.add(2,3);
//        ll.print1();
//        System.out.println( ll.pali());
//        ll.deleteN(3);
//        ll.print1();
//        ll.reverse();
//        ll.print1();
//      ll.print1();
//      ll.removeF();
//      ll.removeL();
//        System.out.println(ll.search(44));
//      ll.print1();
//        System.out.println(Main.s);

    }
}