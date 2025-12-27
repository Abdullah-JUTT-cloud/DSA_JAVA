import java.util.*;

public class LL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        System.out.print("Enter number of elements to test: ");
        int n = sc.nextInt();

        long start, end;

        start = System.nanoTime();
        for (int i = 0; i < n; i++)
            arrayList.add(i);
        end = System.nanoTime();
        System.out.println("ArrayList insertion time: " + (end - start) + " ns");

        start = System.nanoTime();
        for (int i = 0; i < n; i++)
            linkedList.add(i);
        end = System.nanoTime();
        System.out.println("LinkedList insertion time: " + (end - start) + " ns");

        int mid = n / 2;

        start = System.nanoTime();
        arrayList.contains(mid);
        end = System.nanoTime();
        System.out.println("ArrayList search time: " + (end - start) + " ns");

        start = System.nanoTime();
        linkedList.contains(mid);
        end = System.nanoTime();
        System.out.println("LinkedList search time: " + (end - start) + " ns");

        start = System.nanoTime();
        arrayList.remove(mid);
        end = System.nanoTime();
        System.out.println("ArrayList deletion time: " + (end - start) + " ns");

        start = System.nanoTime();
        linkedList.remove((Integer) mid);
        end = System.nanoTime();
        System.out.println("LinkedList deletion time: " + (end - start) + " ns");

        System.out.println("\nSummary:");
        System.out.println("ArrayList -> Better for search, random access.");
        System.out.println("LinkedList -> Better for frequent insertions/deletions at ends.");
    }
}
