public class circular {
    public static class Queue{
        static int[] arr;
        static int size;
        static int front;
        static int rear;
        Queue(int n){
           this.arr=new int[n];
           this.size=n;
           this.front=-1;
           this.rear=-1;
        }
        public static boolean isEmpty(){
            return rear==-1 && front==-1;
        }
        public static boolean isFull(){
            return (rear+1)%size==front;
        }
        public static void add(int data){
            if(isFull()){
                System.out.println("full");
                return;
            }
            if(front==-1){
                front=0;
            }
                rear=(rear+1)%size;
                arr[rear]=data;
        }
        public static int remove(){
            if(isEmpty()){
                System.out.println("Notrhing");
                return -1;
            }
            int top=arr[front];
            if(front==rear){
                front=rear=-1;
            }else {
                front=(front+1)%size;
            }
            return top;
        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("Notrhing");
                return -1;
            }
            return arr[front];
        }
    }
    public static void main(String[] args) {
        Queue q=new Queue(3);
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println( q.remove());
        q.add(4);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
