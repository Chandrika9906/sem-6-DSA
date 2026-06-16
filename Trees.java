class TNode{
    int data;  
    TNode left, right;

    TNode(int data){ 
        this.data = data;
        left = right = null;
    }
}

public class Trees {
    static TNode root = null;
    static void preorder(TNode root){
        if(root!=null){
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    static void inorder(TNode root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }

    static void postorder(TNode root){
        if(root!=null){
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }
    }

    static TNode insert(TNode root,int data){
        if(root==null){
            TNode nn = new TNode(data);
            return nn;
        }

        if(data<root.data)
            root.left = insert(root.left, data);
        else if(data>root.data)
            root.right = insert(root.right, data);
        return root;
    }

    static TNode delete(TNode root, int data){
        if(root==null)
            return null;
        if(data<root.data)
            root.left = delete(root.left, data);
        else if(data>root.data)
            root.right = delete(root.right, data);
        else if(data==root.data){
            // Case 1: if both left and right is null, return null
            if(root.left==null && root.right==null)
                return null;

            // Case 2: if any of the side is null, return the opposite side
            if(root.left==null)
                return root.right;
            else if(root.right==null)
                return root.left;

            // Case 3: if both sides are not null, find minimum ele in right sub tree
            else{
                int minEle = findMinEle(root.right);
                root.data = minEle;
                root.right = delete(root.right, minEle);
            }
        }
        return root;
    }

    static int findMinEle(TNode root){
        TNode ptr = root;
        while(ptr.left!=null)
            ptr = ptr.left;
        return ptr.data;
    }

    static boolean search(TNode root, int data){
        if(root==null)
            return false;
        if(data==root.data)
            return true;
        else if(data>root.data)
            return search(root.right, data);
        else if(data<root.data)
            return search(root.left, data);
        else
            return false;
    }

    public static void main(String[] args) {
        root = insert(root, 50);
        root = insert(root, 70);
        root = insert(root, 30);
        root = insert(root, 60);
        root = insert(root, 80);
        root = insert(root, 65);
        root = insert(root, 20);
        root = insert(root, 15);
        root = insert(root, 10);
        root = insert(root, 12);
        root = insert(root, 5);
        root = insert(root, 11);
        root = insert(root, 75);
        root = insert(root, 90);
        root = insert(root, 85);
        root = insert(root, 83);
        root = insert(root, 95);
        System.out.print("Preorder: ");
        preorder(root);
        System.out.print("\nInorder: "); 
        inorder(root);
        System.out.print("\nPostorder: ");
        postorder(root);

        System.out.println(search(root, 15)?"\nElement found":"\nElement not found");

        root = delete(root, 12);
        System.out.print("Inorder: ");
        inorder(root);
        root = delete(root, 65);
        System.out.print("\nInorder: ");
        inorder(root);
        root = delete(root, 80);
        System.out.print("\nInorder: ");
        inorder(root);
    }
}