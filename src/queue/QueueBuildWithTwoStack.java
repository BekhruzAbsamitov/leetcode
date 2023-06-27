package queue;

import stack.Stack;
import stack.StackOverflowException;
import stack.StackUnderflowException;

public class QueueBuildWithTwoStack<T> {

    private Stack<T> forwardStack = new Stack<>();
    private Stack<T> reverseStack = new Stack<>();

    public QueueBuildWithTwoStack() {
    }

    public void enqueue(T data) throws StackOverflowException, QueueOverflowException {
        if (isFull()) {
            throw new StackOverflowException();
        }

        try {
            if (forwardStack.isEmpty()) {
                while (!reverseStack.isEmpty()) {
                    forwardStack.push(reverseStack.pop());
                }
            }
            forwardStack.push(data);
        } catch (StackOverflowException | StackUnderflowException e) {
            throw new QueueOverflowException();
        }
    }

    public T dequeue() throws QueueOverflowException, QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueOverflowException();
        }
        try {
            if (reverseStack.isEmpty()) {
                while (!forwardStack.isEmpty()) {
                    reverseStack.push(forwardStack.pop());
                }
            }
            return reverseStack.pop();
        } catch (StackOverflowException | StackUnderflowException e) {
            throw new QueueUnderflowException();
        }
    }

    public boolean isFull() {
        return forwardStack.isFull() || reverseStack.isFull();
    }

    public boolean isEmpty() {
        return forwardStack.isEmpty() && reverseStack.isEmpty();
    }

}
