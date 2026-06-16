class DCLLNode{
    int data;
    DCLLNode prev, next;

    DCLLNode(int data){
        this.data = data;
        prev = next = null;
    }
}


public class DCLL {
    static DCLLNode head = null, tail = null;
    static void createHeadNode(int data){
        DCLLNode nn = new DCLLNode(data);
        head = tail = nn;
        head.next = head.prev = head;
        tail.next = tail.prev = tail;
    }

    static void insert(int data){
        if(head==null && tail==null){
            createHeadNode(data);
            return;
        }

        DCLLNode nn = new DCLLNode(data);
        tail.next = nn;
        nn.prev = tail;
        nn.next = head;
        head.prev = nn;
        tail = nn;
    }

    static void delete(){
        if(head==null && tail==null){
            System.out.println("Empty LL");
            return;
        }

        DCLLNode ptr = tail.prev;
        tail.next = tail.prev = null;
        ptr.next = head;
        head.prev = ptr;
        tail = ptr;
    }

    static void display(){
        if(head==null && tail==null){
            System.out.println("Empty LL");
            return;
        }
        System.out.println("Display:");
        DCLLNode ptr = head;
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
        delete();
        display();
    }
}