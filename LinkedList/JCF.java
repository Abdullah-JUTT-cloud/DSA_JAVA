import java.util.Scanner;

class Node {
    int data;
    Node next;
}

class Stack {
    Node top;


    void push(int value) {
        Node newNode = new Node();
        newNode.data = value;
        newNode.next = top;
        top = newNode;
    }

    int pop() {
        if (top == null) {
            System.out.println(" Underflow!");
            return Integer.MAX_VALUE;
        }
        int value = top.data;
        top = top.next;
        return value;
    }


    boolean isEmpty() {
        return top == null;
    }
}

public class JCF {


    static int reverseNumber(int number) {
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();


        if (number == 0) {
            stack1.push(0);
        } else {

            while (number > 0) {
                int digit = number % 10;
                stack1.push(digit);
                number /= 10;
            }
        }

        while (!stack1.isEmpty()) {
            int val = stack1.pop();
            stack2.push(val);
        }


        int reversed = 0;
        while (!stack2.isEmpty()) {
            int digit = stack2.pop();
            reversed = reversed * 10 + digit;
        }

        return reversed;
    }


    static void Display(int reversedNum) {
        System.out.println("Output is: " + reversedNum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int reversed = reverseNumber(number);
        Display(reversed);

        sc.close();
    }
}