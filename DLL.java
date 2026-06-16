class DllNode{
    int data;
    DllNode prev, next;

    DllNode(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DLL{
    static DllNode head = null, tail = null;
    static void createHeadDllNode(int data){
        DllNode nn = new DllNode(data);
        head = tail = nn;
    }

    static void insertBeg(int data){
        if(head==null && tail==null){
            createHeadDllNode(data);
            return;
        }

        DllNode nn = new DllNode(data);
        nn.next = head;
        head.prev = nn;
        head = head.prev;
    }

    static void insertEnd(int data){
        if(head==null && tail==null){
            createHeadDllNode(data);
            return;
        }

        DllNode nn = new DllNode(data);
        tail.next = nn;
        nn.prev = tail;
        tail = tail.next;
    }

    static void insAftPos(int pos, int data){
        if(head==null && tail==null){
            createHeadDllNode(data);
            return;
        }

        DllNode nn = new DllNode(data);
        DllNode ptr = head;
        for(int i=1; i<pos; i++){
            ptr = ptr.next;
        }

        DllNode nptr = ptr.next;
        ptr.next = nn;
        nn.prev = ptr;
        nn.next = nptr;
        nptr.prev = nn;
    }

    static void insBefPos(int pos, int data){
        if(head==null && tail==null){
            createHeadDllNode(data);
            return;
        }

        DllNode nn = new DllNode(data);
        DllNode ptr = head;
        for(int i=1; i<pos; i++){
            ptr = ptr.next;
        }
        DllNode pptr = ptr.prev;
        pptr.next = nn;
        nn.prev = pptr;
        nn.next = ptr;
        ptr.prev = nn;
    }

    static void deleteBeg(){
        if(head==null){
            System.out.println("No element in LL");
            return;
        }
        DllNode ptr = head.next;
        head.next = null;
        ptr.prev = null;
        head = ptr;
    }

    static void deleteEnd(){
        if(head==null){
            System.out.println("No element in LL");
            return;
        }
        DllNode ptr = tail.prev;
        tail.prev = null;
        ptr.next = null;
        tail = ptr;
    }

    static void display(){
        DllNode ptr = head;
        System.out.println("Display:");
        while (ptr!=null) {
            System.out.print("->"+ptr.data);
            ptr = ptr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        createHeadDllNode(10);
        insertBeg(5);
        insertBeg(3);
        display();
        insertEnd(20);
        insertEnd(30);
        display();
        deleteBeg();
        display(); 
        deleteEnd();
        display(); 
        insBefPos(3, 8); 
        display();
    }
}
