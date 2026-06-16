class SCLLNode{
    int data;
    SCLLNode next;

    SCLLNode(int data){
        this.data = data;
        this.next = null;
    }
}

public class SCLL {
    static SCLLNode head = null;

    static void createHeadNode(int data){
        SCLLNode nn = new SCLLNode(data);
        head = nn;
        head.next = head;
    }

    static void insert(int data){
        if(head==null){
            createHeadNode(data);
            return;
        }
        SCLLNode ptr = head, nn = new SCLLNode(data);
        while(ptr.next!=head){
            ptr = ptr.next;
        }
        ptr.next = nn;
        nn.next = head;
    }

    static void delete(){
        if(head==null){
            System.out.println("Empty LL");
            return;
        }
        SCLLNode ptr = head;
        while(ptr.next.next!=head){
            ptr = ptr.next;
        }
        ptr.next.next = null;
        ptr.next = head;
    }

    static void display(){
        if(head==null){
            System.out.println("LL is empty");
            return;
        }
        System.out.println("Display:");
        SCLLNode ptr = head;
        do{
            System.out.print("->"+ptr.data);
            ptr = ptr.next;
        }while(ptr!=head);
        System.out.println();
    }

    public static void main(String[] args) {
        createHeadNode(10);
        insert(20);
        insert(30);
        insert(40);
        insert(50);
        display();
        delete();
        display();
    }
}