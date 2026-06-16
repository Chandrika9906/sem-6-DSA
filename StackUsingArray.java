public class StackUsingArray {
    static int top = -1, len;
    static int stk[];

    StackUsingArray(int len){
        this.len = len;
        stk = new int[len];
        for(int i=0; i<len; i++)
            stk[i] = Integer.MIN_VALUE;
    }

    static void push(int data){
        if(isFull()){
            System.out.println("Stack overflow");
            return;
        }
        top++;
        stk[top] = data;
    }

    static void pop(){
        if(isEmpty()){
            System.out.println("Stack Underflow");
            return;
        }
        stk[top] = Integer.MIN_VALUE;
        top--;
    }

    static int peek(){
        if(isEmpty())
            return Integer.MIN_VALUE;
        else
            return stk[top];
    }

    static boolean isFull(){
        return top==len-1;
    }

    static boolean isEmpty(){
        return top==-1;
    }

    static void display(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Display:");
        for(int i=top; i>=0; i--)
            System.out.println(stk[i]);
    }

    public static void main(String[] args) {
        StackUsingArray s = new StackUsingArray(5);
        push(10);
        push(20);
        push(30);
        push(40);
        push(50);
        display();
        pop();
        pop();
        pop();
        pop();
        pop();
        display();
        System.out.println("Peek: "+(peek()==Integer.MIN_VALUE?"Stack is Empty":peek()));
    }
}