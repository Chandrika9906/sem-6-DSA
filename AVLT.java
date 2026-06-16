class ATNode{
    int data, height;
    ATNode left, right;

    ATNode(int data){
        this.data = data;
        height = 1;
        left = right = null;
    }
}

public class AVLT {
    static ATNode root = null;
    static int findHeight(ATNode root){
        return root==null?0:root.height;
    }

    static int findHeiBal(ATNode root){
        return findHeight(root.left)-findHeight(root.right);
    }

    static ATNode leftRotation(ATNode x){
        ATNode y = x.right;
        ATNode z = y.left;

        y.left = x;
        x.right = z;
        x.height = 1+Math.max(findHeight(x.left), findHeight(x.right));
        y.height = 1+Math.max(findHeight(y.left), findHeight(y.right));
        return y;
    }

    static ATNode rightRotation(ATNode x){
        ATNode y = x.left;
        ATNode z = y.right;

        y.right = x;
        x.left = z;
        x.height = 1+Math.max(findHeight(x.left), findHeight(x.right));
        y.height = 1+Math.max(findHeight(y.left), findHeight(y.right));
        return y;
    }

    static ATNode insert(ATNode root,int data){
        if(root==null){
            ATNode nn = new ATNode(data);
            return nn;
        }

        if(data<root.data)
            root.left = insert(root.left, data);
        else if(data>root.data)
            root.right = insert(root.right, data);

        root.height = 1+Math.max(findHeight(root.left), findHeight(root.right));
        int heiBal = findHeiBal(root);

        // Case LL
        if(heiBal>1 && root.left.data>data)
            return rightRotation(root);

        // Case LR
        if(heiBal>1 && root.left.data<data){
            root.left = leftRotation(root.left);
            return rightRotation(root);
        }

        // Case RR
        if(heiBal<-1 && root.right.data<data)
            return leftRotation(root);

        // Case RL
        if(heiBal<-1 && root.right.data>data){
            root.right = rightRotation(root.right);
            return leftRotation(root);
        }
        return root;
    }

    static ATNode delete(ATNode root, int data){
        if(root==null){
            System.out.println("No elements in the tree");
            return null;
        }

        if(data<root.data)
            root.left = delete(root.left, data);
        else if(data>root.data)
            root.right = delete(root.right, data);
        else if(data==root.data){
            // Case 1: if both side is null, return null
            if(root.left==null && root.right==null)
                return null;

            // Case 2: if any one side is null, return the other side
            if(root.left==null)
                return root.right;
            else if(root.right==null)
                return root.left;

            // Case 3: If both sides are not null
            else{
                int minEle = findMinEle(root.right);
                root.data = minEle;
                root.right = delete(root.right, minEle);
            }
        }

        if(root==null)
            return null;
        root.height = 1+Math.max(findHeight(root.left), findHeight(root.right));

        int heiBal = findHeiBal(root);

            // Case LL
            if(heiBal>1 && findHeiBal(root.left)>=0)
                return rightRotation(root);
            
            // Case LR
            if(heiBal>1 && findHeiBal(root.left)<0){
                root.left = leftRotation(root.left);
                return rightRotation(root);
            }

            // Case RR
            if(heiBal<-1 && findHeiBal(root.right)<=0)
                return leftRotation(root);

            // Case RL
            if(heiBal<-1 && findHeiBal(root.right)>0){
                root.right = rightRotation(root.right);
                return leftRotation(root);
            }
        return root;
    }

    static int findMinEle(ATNode root){
        ATNode ptr = root;
        while(ptr.left!=null)
            ptr = ptr.left;
        return ptr.data;
    }

    static void inorder(ATNode root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }

    static boolean search(ATNode root,int key){
        if(root==null)
            return false;

        if(root.data==key)
            return true;
        else if(key<root.data)
            return search(root.left, key);
        else if(key>root.data)
            return search(root.right, key);
        else
            return false;
    }

    public static void main(String[] args) {
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 20);
        root = insert(root, 35);
        inorder(root);
        System.out.println("\nCurrent root before delete: "+root.data); //30
        root = delete(root, 20);
        inorder(root);
        System.out.println("\nCurrent root after delete: "+root.data); //35
    }
}