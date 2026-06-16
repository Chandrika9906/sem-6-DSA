import java.util.Scanner;

class Node{
    int data; //instance
    Node next; //instance

    Node(int data){ //local
        this.data = data;
        this.next = null;
    }
}

public class SLL {
    static Node head = null;
    static void createHeadNode(int data){
        Node nn = new Node(data);
        head = nn;
    }

    static void insertBeg(int data){
        if(head==null){
            createHeadNode(data);
            return;
        }
        Node nn = new Node(data);
        nn.next = head;
        head = nn;
    }

    static void insertEnd(int data){
        if(head==null){
            createHeadNode(data);
            return;
        }
        Node nn = new Node(data);
        Node ptr = head;
        while(ptr.next!=null){
            ptr = ptr.next;
        }
        ptr.next = nn;
    }

    static void deleteBeg(){
        if(head==null){
            System.out.println("No elements in the linked list");
            return;
        }
        Node ptr = head.next;
        head.next = null;
        head = ptr;
    }

    static void deleteEnd(){
        if(head==null){
            System.out.println("No elements in the linked list");
            return;
        }
        if(head.next==null){
            deleteBeg();
            return;
        }
        Node ptr = head;
        while(ptr.next.next!=null){
            ptr = ptr.next;
        }
        ptr.next = null;
    }

    static void deleteMid(){
        if(head==null){
            System.out.println("No elements in the linked list");
            return;
        }
        if(head.next==null){
            deleteBeg();
            return;
        }
        Node ptr = null, slow, fast;
        slow = fast = head;
        while(fast!=null && fast.next!=null){
            ptr = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        ptr.next = slow.next;
        slow.next = null;
    }

    static void display(){
        Node ptr = head;
        System.out.println("Display: ");
        while(ptr!=null){
            System.out.print("->"+ptr.data);
            ptr = ptr.next;
        }
        System.out.println();
    }

    static void insertMid(int data){
        if(head==null){
            createHeadNode(data);
            return;
        }
        Node nn = new Node(data);
        Node ptr = null, slow, fast;
        slow = fast = head;
        while(fast!=null && fast.next!=null){
            ptr = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        ptr.next = nn;
        nn.next = slow;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        createHeadNode(3);
        insertBeg(2);
        insertBeg(1);
        display();
        insertEnd(4);
        insertEnd(5);
        display();
        insertMid(6);
        display();
        insertMid(7);
        display();
    }
}