package org.lwq.ds;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by longweiquan on 15/7/27.
 */
public class LRUCache {

    private int capacity;
    private Map<Integer, Node> values = new HashMap<Integer, Node>();
    private Node head;
    private Node end;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(values.containsKey(key)){
            Node node = values.get(key);


            return node.value;
        }
        return -1;
    }

    public void set(int key, int value) {

    }

    private void remove(Node n){
        
    }

    public class Node{

        int value;
        Node next;
        Node prev;
    }
}
