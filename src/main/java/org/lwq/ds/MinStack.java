package org.lwq.ds;

import org.assertj.core.api.Assertions;

/**
 * Data Structure : LinkedList of Node
 *
 * A node is on top of other nodes. a node contain its value and the the minimal value of all nodes below.
 */
public class MinStack {

    private Node top;

    public void push(int x) {
        Node node = new Node(x);

        if(top == null){
            top = node;
        } else {
            node.min = Math.min(top.min, node.min);
            node.next = top;
            top = node;
        }
    }

    public void pop() {

        if(top != null){
            top = top.next;
        }
    }

    public int top() {
        return top != null ? top.value : Integer.MAX_VALUE;
    }

    public int getMin() {
        return top != null ? top.min : Integer.MAX_VALUE;
    }

    class Node {
        int value;
        int min;
        Node next;
        public Node(int value){
            this.value = value;
            this.min = value;
        }
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(10);
        stack.push(5);
        stack.push(11);
        stack.push(3);
        Assertions.assertThat(stack.top()).isEqualTo(3);
        Assertions.assertThat(stack.getMin()).isEqualTo(3);
        stack.pop();
        Assertions.assertThat(stack.top()).isEqualTo(11);
        Assertions.assertThat(stack.getMin()).isEqualTo(5);
    }
}
