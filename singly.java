import java.util.Scanner;

class Node{
    int data; //instance
    Node next; //instance

    Node(int data){ //local
        this.data = data;
        this.next = null;
    }
}

public class singly{
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

    static void display(){
        Node ptr = head;
        System.out.println("Display: ");
        while(ptr!=null){
            System.out.print("->"+ptr.data);
            ptr = ptr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        createHeadNode(5);
        insertBeg(4);
        insertBeg(2);
        display();
        insertEnd(10);
        insertEnd(20);
        display();
        deleteBeg();
        display();
        deleteEnd();
        display();
        deleteEnd();
        display();
        deleteEnd();
        display();
        deleteEnd();
        display();
        // boolean flg = true;
        // while(flg==true){
        //     System.out.println("Linked List Operations");
        //     System.out.println("1. Create head node");
        //     System.out.println("2. Insert Begining");
        //     System.out.println("3. Insert end");
        //     System.out.println("4. Display");
        //     System.out.println("5. Delete Begining");
        //     System.out.println("10. Exit");
        //     System.out.println("Select your choice");
        //     int ch = in.nextInt();
        //     switch (ch) {
        //         case 1:
        //             System.out.print("Enter the data: ");
        //             int data = in.nextInt();
        //             createHeadNode(data);
        //             break;
        //         case 2:
        //             System.out.print("Enter the data: ");
        //             data = in.nextInt();
        //             insertBeg(data);
        //             break;
        //         case 3:
        //             System.out.print("Enter the data: ");
        //             data = in.nextInt();
        //             insertEnd(data);
        //             break;
        //         case 4:
        //             display();
        //             break;
        //         case 5:
        //             deleteBeg();
        //             break;
        //         case 10:
        //             flg = false;
        //             break;
        //         default:
        //             break;
        //     }
        // }
    }
}