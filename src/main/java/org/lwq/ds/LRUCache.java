package org.lwq.ds;

import org.assertj.core.api.Assertions;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU Cache : Constructed with a HashMap and a Double linkedList.
 *
 * It's a non parallel solution
 */
public class LRUCache {

    private int capacity;
    private Map<Integer, Node> map = new HashMap<>();
    private Node head = null;
    private Node end = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            setHead(node);
            return node.value;
        }
        return -1;
    }

    public void set(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            remove(node);
            setHead(node);
        } else {
            Node node = new Node(key, value);
            if(capacity == map.size()){
                map.remove(end.key);
                remove(end);
            }
            setHead(node);
            map.put(key, node);
        }
    }

    private void remove(Node n){
        if(n.prev != null){
            n.prev.next = n.next;
        } else {
            head = n.next;
        }
        if(n.next != null){
            n.next.prev = n.prev;
        } else {
            end = n.prev;
        }
    }

    private void setHead(Node n){
        // set node
        n.next = head;
        n.prev = null;

        // set head
        if(head != null){
            head.prev = n;
        }
        head = n;

        if(end == null){
            end = n;
        }
    }

    class Node{

        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.set(1,1);
        cache.set(2,1);
        cache.set(2,2);
        Assertions.assertThat(cache.get(2)).isEqualTo(2);
        cache.set(3, 3);
        Assertions.assertThat(cache.get(1)).isEqualTo(-1);
    }
}
