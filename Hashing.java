class HashNode{
    int key;
    HashNode next;

    HashNode(int key){
        this.key = key;
        next = null;
    }
}

public class Hashing {
    static int size = 5;
    static HashNode hashTable[];

    Hashing(){
        hashTable = new HashNode[size];
    }

    static int findHashCode(int key){
        return key%size;
    }

    void put(int key){
        int hashCode = findHashCode(key);
        HashNode nn = new HashNode(key);
        if(hashTable[hashCode]==null){
            hashTable[hashCode] = nn;
            return;
        }
        nn.next = hashTable[hashCode];
        hashTable[hashCode] = nn;
    }

    boolean search(int key){
        int hashCode = findHashCode(key);
        HashNode ptr = hashTable[hashCode];
        while (ptr!=null) {
            if(ptr.key == key)
                return true;
            ptr = ptr.next;
        }
        return false;
    }

    boolean remove(int key){
        int hashCode = findHashCode(key);
        HashNode ptr = hashTable[hashCode];
        HashNode pptr = null;
        if(ptr==null)
            return false;
        
        while(ptr.next!=null){
            if(ptr.key==key){
                pptr.next = ptr.next;
                ptr.next = null;
                return true;
            }
            pptr = ptr;
            ptr = ptr.next;
        }
        return false;
    }

    void display(){
        for(int i=0; i<size; i++){
            HashNode ptr = hashTable[i];
            System.out.print(i);
            if(ptr==null){
                System.out.println(" -> Empty");
                continue;
            }
            while(ptr!=null){
                System.out.print(" -> "+ptr.key);
                ptr = ptr.next;
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Hashing hs = new Hashing();
        hs.put(10);
        hs.put(20);
        hs.put(29);
        hs.put(24);
        hs.put(14);
        hs.display();
        System.out.println(hs.search(39)?"Element found":"Element not found");
        System.out.println(hs.remove(24)?"Element deleted":"Element not found");
        hs.display();
    }
}