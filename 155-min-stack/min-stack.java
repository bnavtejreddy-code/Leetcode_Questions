class MinStack {

    // Main stack stores all the elements
    Stack<Integer> stack;

    // Min stack stores the minimum elements
    Stack<Integer> minStack;

    // Constructor
    public MinStack() {

        // Initialize both stacks
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    // Push an element onto the stack
    public void push(int val) {

        // Push into the main stack
        stack.push(val);

        // If minStack is empty OR the new value is
        // smaller than or equal to the current minimum,
        // also push it into minStack.
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    // Remove the top element
    public void pop() {

        // Remove the top element from the main stack
        int removed = stack.pop();

        // If the removed element is also the current minimum,
        // remove it from minStack as well.
        if (removed == minStack.peek()) {
            minStack.pop();
        }
    }

    // Return the top element
    public int top() {

        return stack.peek();
    }

    // Return the current minimum element
    public int getMin() {

        return minStack.peek();
    }
}