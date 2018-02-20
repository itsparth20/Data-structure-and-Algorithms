/*
https://leetcode.com/problems/lru-cache/description/
146. LRU Cache
*/
class LRUCache {
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }        
    }
    
    Map<Integer, Node> map = new HashMap<Integer, Node>();
    int capacity;
    Node head = null;
    Node tail = null;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            removeNode(map.get(key));
            setHead(map.get(key));
            return map.get(key).value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            n.value = value;
            removeNode(map.get(key));
            setHead(map.get(key));
            return;
        }
        if(capacity <= map.size()){            
            map.remove(tail.key);
            removeNode(tail);                        
        }
        Node n = new Node(key, value);
        map.put(key, n);        
        setHead(n);
    }
    
    private void setHead(Node node){
        node.next = head;
        node.prev = null;
        
        if (head == null){
            tail = node;
        }else{
            head.prev = node;
        }
        head = node;
    }
    
    private void removeNode(Node node){
        if(node.next != null){
            node.next.prev = node.prev;
        }else{
            tail = node.prev;    
        }        
        if(node.prev != null){
            node.prev.next = node.next;
        }else{
            head = node.next;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */