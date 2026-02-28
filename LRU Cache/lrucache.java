import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;
/*
    LRU Cache LLD Design

    get and put operation must be in O(1)

    if the size execeed then you must remove least used element

    put -> put -> put -> put -> get(1) -> get(2) -> get(3) -> get(4) -> get(1)

    1 -> 3 -> 4

    1 2 3 

    3 1 2 4

1. Desgin TTL
   time to leave
2. Use generic key value done
3. Thread Safe



*/

class LRU<K,V>{

    class Node{
        V val;
        K key;
        Node next;
        Node prev;

        Node(K k,V v){
            this.key = k;
            this.val = v;       
        }
    }

    private final int cache_size;
    private final ConcurrentHashMap<K,Node> hash_cache;
    private final Node start;
    private final Node end;
    private ReentrantLock lock = new ReentrantLock();
    // private ReentrantLock lock = new ReentrantLock(true); /// first come first serve

    public synchronized void printList(){
        Node temp = start;
        while(temp != null){
            System.out.print(temp.key + "--");
            temp = temp.next;
        }
        System.out.println("");
    }

    public void put(K key,V val){
        lock.lock();
        try{
            if(hash_cache.containsKey(key)){
                Node n = hash_cache.get(key);
                remove(n);
                insert(key,val);
                return;
            }
            if(hash_cache.size() >= cache_size){
                hash_cache.remove(end.prev.key);
                end.prev.prev.next = end;
                end.prev = end.prev.prev;
                
                insert(key,val);
                
            }else{
                insert(key,val);
            }

            printList();
        } finally {
            lock.unlock();
        }

        
    }
    public void insert(K key,V val){
            Node n = new Node( key, val);
            n.prev = start;
            n.next = start.next;
            start.next = n;
            n.next.prev = n;
            hash_cache.put(n.key,n);
    }
    public void remove(Node n){
        lock.lock();
        try{
            hash_cache.remove(n.key);
            n.prev.next = n.next;
            n.next.prev = n.prev;
        } finally {
            lock.unlock();
        }

    }
    public V get(K i){
        lock.lock();
        try{
            if(!hash_cache.containsKey(i)){
                return null;
            }
            Node n = hash_cache.get(i);
            remove(n);
            insert(n.key,n.val);
            printList();
            return n.val;
        } finally {
            lock.unlock();
        }
        
        
    }
    public LRU(int intial_size){
        // define the intial size of the LRU
        this.cache_size = intial_size;
        this.hash_cache = new ConcurrentHashMap<>();

        start = new Node(null,null);
        end = new Node(null,null);
        start.next = end;
        end.prev = start;
    }
}

public class lrucache {
    public static void main(String args[]){
        LRU<Integer, Integer> lru = new LRU<>(10);
    
    for (int i = 0; i < 10; i++) {
        final int key = i;
        new Thread(() -> {
            lru.put(key, key * 10);
            System.out.println("Inserted: " + key);
        }).start();
    }

    // ExecutorService executor = Executors.newFixedThreadPool(10);

    // for (int i = 0; i < 1000; i++) {
    //     int key = i % 50; // Keep keys repeating to trigger LRU logic
    //     executor.submit(() -> {
    //         lru.put(key, key * 10);
    //         lru.get(key);
    //     });
    // }

    // executor.shutdown();


    }
}



// 5 
// (8,24)->(5,23)->(3,10)