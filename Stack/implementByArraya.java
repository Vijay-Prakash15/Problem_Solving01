package Stack;
class Stack{
    int[] arr;
    int top;
    int size;
    Stack(int size){
        this.size=size;
        arr=new int[size];
        top=-1;
    }

    void push(int x){
        if(top == size - 1){
            System.err.println("Stack Overflow.");
            return;
        }
        top++;
        arr[top] = x;
        System.out.println(x+" is pushed into stack.");
    }
    int pop(){
        if(top == -1){
            System.err.println("Stack UnderFlow");
            return -1;
        }
        int popped = arr[top];
        top--;
        return popped;
    }
    boolean isEmpty() {
        return top == -1;
    }
    
    int peek(){
        if(top == -1){
            System.err.println("Stack is Empty.");
            return -1;
        }
        return arr[top];
    }
    boolean isFull() {
        return top == size - 1;
    }
    void display(){
        if(top == -1){
            System.out.println("Stack is Empty.");
            return;
        }
        System.out.println("Stack elements are:");
        for(int i=top; i>=0; i--){
            System.out.println(arr[i]);
        }
    }
}
public class implementByArraya {
    public static void main(String[] args) {
        Stack st = new Stack(5);
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(55);
        System.out.println("Top element is: " + st.peek());
        System.out.println("Top element is: " + st.peek());
        st.display();

    }
}
