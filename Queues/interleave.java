import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class interleave {
    public static void Inter(Queue<Integer> q){
        Queue<Integer> FH=new LinkedList<>();
        int s=q.size();
        for(int i=0;i<s/2;i++){
            FH.add(q.remove());
        }
        while(!FH.isEmpty()){
            q.add(FH.remove());
            q.add(q.remove());
        }

    }
    public static void main(String[] args) {
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        ArrayDeque<Integer> s=new ArrayDeque<>();
        while(!q.isEmpty()){
            s.push(q.remove());

        }
        while (!s.isEmpty()){
            q.add(s.pop());
        }
        while(!q.isEmpty()){
            System.out.println(q.remove());

        }
    }
}
