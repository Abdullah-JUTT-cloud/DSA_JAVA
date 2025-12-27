import java.util.*;

public class SP {

    public static boolean Valid(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {
                if (s.isEmpty()) {
                    return false;
                }
                if ((s.peek() == '(' && ch == ')') ||
                        (s.peek() == '{' && ch == '}') ||
                        (s.peek() == '[' && ch == ']')) {
                    s.pop();
                } else {
                    return false;
                }
            }
        }
        if (s.isEmpty()) {
            return true;
        } else return false;
    }
    public static boolean dup(String str){
//        Stack<Character> s=new Stack<>();
//        for(int i=0;i<str.length();i++){
//            char ch=str.charAt(i);
//            if(ch==')'){
//                int count=0;
//                while(s.peek()!='('){
//                    s.pop();
//                    count++;
//                }
//                if(count<1){
//                    return true;
//                }
//                s.pop();
//            }else s.push(ch);
//        }
//        return false;
        Stack<Character> s=new Stack<>();
        for (int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if (ch==')'){
                int c=0;
                while (s.peek()!='('){
                    s.pop();
                    c++;
                }
                if(c<1){
                    return true;
                }
                s.pop();

            }else s.push(ch);
        }
        return false;
    }


    public static void main(String[] args) {
//        System.out.println(Valid("(([]))"));
//        System.out.println(dup("(((a+b)+(c)))"));
        int arr[]={1,4,3,6,2};
        Stack<Integer> s1=new Stack<>();
        int nextarr[]=new int[arr.length];
        for (int i= arr.length-1;i>=0;i--){
            while (!s1.isEmpty()&& arr[s1.peek()]<=arr[i]){
                s1.pop();
            }
            if(s1.isEmpty()){
                nextarr[i]=-1;
            }else {
                nextarr[i]=arr[s1.peek()];
            }
            s1.push(i);
        }
        for (int i=0;i< arr.length;i++){
            System.out.print(nextarr[i]+" ");
        }
        System.out.println();
    }
}
