package YK_Cracking16_Moderate;

import YK_Common.YK_Exception;

import java.util.HashMap;

/*
Source: Cracking 16.25
Implement a cache with limited space.
Actions: add, lookup, update.
Every time a space runs out, remove oldest not used (added/looked up/updated) item.

Implementations:
- Initial implementation before improvements from the book (see history in github):
    Insert - O(1)
    Retrieve - O(1) - but actually there is a bug that retrieval doesn't change priority
    Update - O(n)
- Implementation after reading the book with update also with O(1) for retrieve and update.
 */

public class YK_Mod25_LRUCache {

    class Node {
        int key;
        int value;
        Node next = null;
        Node prev = null;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        void remove() {
            if(prev != null) {
                prev.next = next;
            }
            if(next != null) {
                next.prev = prev;
            }
        }

        void insertEnd(Node newNode) {
            if(next != null) {
                throw  new YK_Exception("Node not last, key: " + key + ", value: " + value);
            }
            next = newNode;
            newNode.prev = this;
            newNode.next = null;
        }

        String printAll() {
            Node node = this;
            StringBuilder sb = new StringBuilder();

            while(node != null) {
                sb.append(" [");
                sb.append(node.key);
                sb.append(',');
                sb.append(node.value);
                sb.append(']');
                node = node.next;
            }
            return sb.toString();
        }

        String printBack() {
            Node node = this;
            StringBuilder sb = new StringBuilder();

            while(node != null) {
                sb.append(" [");
                sb.append(node.key);
                sb.append(',');
                sb.append(node.value);
                sb.append(']');
                node = node.prev;
            }
            return sb.toString();
        }
    }

    private HashMap<Integer,Node> map;
    private Node first;
    private Node last;
    private int maxSize;

    public YK_Mod25_LRUCache(int maxSize) {
        map = new HashMap<>();
        first = null;
        last = null;
        this.maxSize = maxSize;
    }

    private void removeFirst() {
        Node nodeToRemove = first;
        first = nodeToRemove.next;
        nodeToRemove.remove();
        map.remove(nodeToRemove.key);
    }

    public void insert(int key, int value) {
        if(map.size() == maxSize) {
            removeFirst();
        }
        Node newNode = new Node(key, value);
        if(last == null) {
            last = newNode;
            first = newNode;
        } else {
            last.insertEnd(newNode);
            last = newNode;
        }
        map.put(key, newNode);
    }

    private void moveToEnd(Node nodeToMove) {
        if(nodeToMove != last) {
            if(nodeToMove == first) {
                first = nodeToMove.next;
            }
            nodeToMove.remove();
            last.insertEnd(nodeToMove);
            last = nodeToMove;
        }
    }

    public int retrieve(int key) {
        Node node = map.get(key);
        moveToEnd(node);
        return node.value;
    }

    public void update(int key, int value) {
        Node node = map.get(key);
        moveToEnd(node);
        node.value = value;
    }

    public void printList() {
        System.out.println("Printing list: ----------------------------------");
        System.out.println("First: [" + first.key + "," + first.value + "], last: [" + last.key + "," + last.value + "]");
        System.out.println("List from first: " + first.printAll());
        System.out.println("List from last: " + last.printBack());
    }
}
