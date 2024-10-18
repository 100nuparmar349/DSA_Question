# 01 1381. Design a Stack With Increment Operation
Design a stack that supports increment operations on its elements.
Implement the CustomStack class:
CustomStack(int maxSize) Initializes the object with maxSize which is the maximum number of elements in the stack.
void push(int x) Adds x to the top of the stack if the stack has not reached the maxSize.
int pop() Pops and returns the top of the stack or -1 if the stack is empty.
void inc(int k, int val) Increments the bottom k elements of the stack by val. If there are less than k elements in the stack, increment all the elements in the stack.


class CustomStack {
    int[] stack;
    int top=-1;
    public CustomStack(int n) {
        this.stack=new int[n];   
    }
    public void push(int x) {
        if (top < this.stack.length - 1) {
            top ++;
            this.stack[top] = x;
        }
    }
    public int pop() {
        if(top==-1)return -1;
        return stack[top--];
    }
    public void increment(int k, int val) {
        for(int i=0;i<Math.min(k,top+1);i++){
            stack[i]+=val;
        }
    }
}