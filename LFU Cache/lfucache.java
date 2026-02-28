import java.util.HashMap;

class Node<K,V>{
        K key;
        V value;


        Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

class LinkedHashMap<K,V>{
    private final Node starNode;
    private final Node endNode;

    public final HashMap<K,Node> hash_cahe;

    public LinkedHashMap() {
        this.starNode = new Node(null,null);
        this.endNode = new Node(null,null);
        this.hash_cahe = new HashMap<>();
    }

    public void put(K k,V v){

    }

    public void get(){

    }

    public void remove(Node n){

    }

    public void remove(){

    }

    public void insert(){

    }

    
};


class LFU<K,V>{

    private final HashMap<Integer,LinkedHashMap> freq_hash;
    private final HashMap<K,Integer> freq_map;
    private final int intial_capacity;
    private int minmum_freq = 1;

    public LFU(int capacity) {
        this.freq_hash = new HashMap<>();
        this.intial_capacity = capacity;
        this.freq_map = new HashMap<>();
    }

    public void put(K key, V value){
        if(freq_map.containsKey(key)){
            int key_count = freq_map.get(key);
            LinkedHashMap linkedHashMap = freq_hash.get(key_count);
            Node node = (Node)linkedHashMap.hash_cahe.get(key);
            linkedHashMap.remove(node);
            int new_freq = ++key_count;
            freq_map.put(key,freq_map.getOrDefault(key, 0)+1);
            if(freq_map.get(key) < minmum_freq){
                minmum_freq = freq_map.get(key);
            }
            if(freq_hash.containsKey(new_freq)){
                freq_hash.get(new_freq).put(key, value);
            } else{
                LinkedHashMap linkedHashMap1 = new LinkedHashMap();
                linkedHashMap1.put(key,value);
                freq_hash.put(new_freq, linkedHashMap1);
            }
        }
        else{
            
            if(freq_map.size() >= intial_capacity){
                LinkedHashMap linkedHashMap = freq_hash.get(minmum_freq);
                linkedHashMap.remove();
            } else{
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(key, value);
                freq_hash.put(1, linkedHashMap);
            }
            freq_map.put(key,freq_map.getOrDefault(key, 0)+1);
            if(freq_map.get(key) < minmum_freq){
                minmum_freq = freq_map.get(key);
            }
        }
    }

    public V get(K key){

        return null;
    }

    
};


public class lfucache{
    public static void main(String[] args) {
        
    }
}