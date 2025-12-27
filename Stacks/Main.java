import java.util.Stack;

public class Main {
    static class stack{
        static Stack<Integer> list=new Stack<>();
        public static boolean isEmpty(){
            return list.size()==0;
        }
        public static void push(int data){
            list.add(data);
        }
        public static int pop(){
            if(isEmpty()){
                System.out.println(isEmpty());
                return -1;
            }
            int top=list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }
        public static int peek(){
            if(isEmpty()){
                System.out.println(isEmpty());
                return -1;
            }
            return list.get(list.size()-1);
        }
        public static String revstr(String str ){
            Stack<Character> s =new Stack<>();
            int i=0;
            while(i<str.length()){
                s.push(str.charAt(i));
                i++;
            }
            StringBuilder res=new StringBuilder("");
            while (!s.isEmpty()){
                char cur=s.pop();
                res.append(cur);
            }
            return res.toString() ;

        }

    }
    public static void main(String[] args) {
//            Stack s=new Stack();
        Stack<Integer> sa=new Stack<>();
//            sa.push(1);
//            sa.push(2);
//            sa.push(3);
        String res=stack.revstr("abdullah");
        System.out.println(res);
//            while(!sa.isEmpty()){
//                System.out.println(sa.peek());
//                sa.pop();
//            }
        }
    }
