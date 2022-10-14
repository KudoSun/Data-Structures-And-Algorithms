import java.util.Scanner;

class singlyLinkedlist{
    Node head;

    static class Node{
        int data;
        Node next;
        Node(int d)
        {
            this.data=d;
            next=null;
        }
    }

    public void printList(){
        Node n= head;
        while(n!=null){
            System.out.print(n.data+" ");
            n=n.next;
        }
    }
    public void insertBegining(int d)
    {
        Node new_node = new Node(d);
        new_node.next=head;
        head = new_node;
    }
    public void insertEnd(int d)
    {
        Node new_node = new Node(d);
        Node temp = head;
        if (head == null)
        {
            head=new_node;
            return;
        }
   
        while(temp.next != null)
        {
            temp = temp.next;
        }
        temp.next=new_node;
        return;
    }

    public void insertBefore(int place,int d)
    {
        Node new_node = new Node(d);
        Node temp = head;
        Node temp2 = head;

        if (head == null)
        {
            head=new_node;
            return;
        }
        else if(head.data == place)
        {
            new_node.next = head;
            head = new_node;
        }
        else{
            while(temp2.data != place)
            {
                temp = temp2;
                temp2 = temp2.next;
            }
            temp.next=new_node;
            new_node.next = temp2;
        }
    }

    public void insertAfter(int place,int d)
    {
        Node new_node = new Node(d);
        Node temp = head;
        Node temp2 = temp.next;
        if(head == null)
        {
            head=new_node;
        }
        else if(head.data==place)
        {
            head.next = new_node;
            new_node.next =temp2;
        }
        else{
            while(temp2.data != place)
            {
                temp2 = temp2.next;
                temp = temp2.next;
            }
            temp2.next = new_node;
            new_node.next = temp;
        }
       
    }

    public void deleteHead()
    {
        head = head.next;
    }

    public void deleteNode(int d)
    {
        Node temp=head, prev =head;
        if(temp.data == d)
        {
            head=temp.next;
        }
        while(temp.data!=d){
            prev = temp;
            temp = temp.next;
        }
        prev.next=temp.next;
    }
    public static void main(String[] args) {
        singlyLinkedlist llist = new singlyLinkedlist();
        Scanner sc = new Scanner(System.in);
        System.out.print("Insert:");
        int d = sc.nextInt();

        llist.head=new Node(1);
        Node second=new Node(2);
        Node third = new Node(3);

        llist.head.next= second;
        second.next=third;

        llist.printList();


        llist.insertBegining(d);
        System.out.println();
        llist.printList();


        llist.insertEnd(6);
        System.out.println();
        llist.printList();


        llist.insertBefore(4,7);
        System.out.println();
        llist.printList();
        sc.close();

        llist.insertAfter(7,20);
        System.out.println();
        llist.printList();



        llist.deleteHead();
        System.out.println();
        llist.printList();


        llist.deleteNode(20);
        System.out.println();
        llist.printList();
        sc.close();
    }
}
