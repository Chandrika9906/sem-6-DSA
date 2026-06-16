class HashMapNode{
    int key, value;
    HashMapNode next;

    HashMapNode(int key, int value){
        this.key = key;
        this.value = value;
        next = null;
    }
}

public class MyHashMap {
    static int size = 10;
    static HashMapNode map[];

    MyHashMap(){
        map = new HashMapNode[size];
    }

    static int findHashCode(int key){
        return key%size;
    }

    void put(int key, int value){
        int hashCode = findHashCode(key);
        HashMapNode nn = new HashMapNode(key, value);
        if(map[hashCode]==null){
            map[hashCode] = nn;
            return;
        }

        HashMapNode ptr = map[hashCode];
        while (ptr!=null) {
            if(ptr.key==key){
                ptr.value = value;
                return;
            }
            ptr = ptr.next;
        }

        nn.next = map[hashCode];
        map[hashCode] = nn;
    }

    int get(int key){
        int hashCode = findHashCode(key);
        HashMapNode ptr = map[hashCode];
        while(ptr!=null){
            if(ptr.key==key)
                return ptr.value;
            ptr = ptr.next;
        }
        return -1;
    }

    boolean remove(int key){
        int hashCode = findHashCode(key);
        HashMapNode ptr = map[hashCode], pptr = null;
        if(ptr==null)
            return false;

        while(ptr!=null){
            if(ptr.key==key){
                if(pptr==null){
                    map[hashCode] = map[hashCode].next;
                    ptr.next = null;
                    return true;
                }
                else{
                    pptr.next = ptr.next;
                    ptr.next = null;
                    return true;
                }
            }
            pptr = ptr;
            ptr = ptr.next;
        }
        return false;
    }

    void display(){
        for(int i=0; i<size; i++){
            HashMapNode ptr = map[i];
            System.out.print(i);
            if(ptr==null){
                System.out.println(" -> Empty");
                continue;
            }
            while (ptr!=null) {
                System.out.print(" -> ("+ptr.key+", "+ptr.value+")");
                ptr = ptr.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MyHashMap mp = new MyHashMap();
        mp.put(10, 5);
        mp.put(20, 6); //adding 20->6
        mp.put(20, 7); //updating 20->7
        mp.put(53, 13);
        mp.display();
        System.out.println(mp.remove(73)?"Element Deleted":"No element in this key");
        mp.display();
        System.out.println(mp.get(40));
    }
}
