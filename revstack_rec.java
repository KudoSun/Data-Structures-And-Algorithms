import java.util.*;

public class revstack_rec {
    static Stack<Integer> s = new Stack<>();

    public static void addBottom(int a) {
        if (s.isEmpty()) {
            s.push(a);
        } else {
            int q = s.peek();
            s.pop();
            addBottom(a);

            s.push(q);
        }
    }

    public static void revstack() {
        if (s.size() > 0) {
            int a = s.peek();
            s.pop();
            revstack();
            addBottom(a);
        }
    }

    public static void display() {
        while(!s.empty())
        {
            int a = s.peek();
            System.out.println(a);
            s.pop();
        }
    }

    public static void main(String[] args) {
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        revstack();
        System.out.println();
        display();
    }
}
