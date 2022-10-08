import java.util.*;

public class reverseQueue {
    // static Queue<Integer> q;

    // static void print(){
    // while(!q.isEmpty())
    // {
    // System.out.println(q.peek());
    // q.remove();
    // }
    // }

    // static void reverse()
    // {
    // Stack<Integer> s = new Stack<>();
    // while(!q.isEmpty())
    // {
    // s.push(q.peek());
    // q.remove();
    // }
    // while(!s.isEmpty())
    // {
    // q.add(s.peek());
    // s.pop();
    // }

    // }

    static Queue<Integer> q;

    static void print(){
            while(!q.isEmpty())
            {
                System.out.println(q.peek());
                q.remove();
            }
        }

    static Queue<Integer> revQueue(Queue<Integer> que)
    {
        if(que.isEmpty())
        return que;

        int data= que.peek();
        que.remove();

        que=revQueue(que);
        que.add(data);

        return que;

    }

    public static void main(String[] args) {
        q = new LinkedList<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        q=revQueue(q);
        print();

    }
}
