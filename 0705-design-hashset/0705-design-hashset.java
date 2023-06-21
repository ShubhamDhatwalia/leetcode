class MyHashSet {

    int size = 750000;
    List<Integer> []hashTable;
    
    public MyHashSet() {
        hashTable = new LinkedList[size];
    }
    
    public int hashFunction(int key){
        return key%size;
    }
    
    public void add(int key) {
        int hashValue = hashFunction(key);
        
        if(hashTable[hashValue] == null){
            hashTable[hashValue] = new LinkedList<>();
        }
        if(hashTable[hashValue].indexOf(key) == -1){
            hashTable[hashValue].add(key);
        }
    }
    
    public void remove(int key) {
        int hashValue = hashFunction(key);
        
        if(hashTable[hashValue] == null){
            return;
        }
        if(hashTable[hashValue].indexOf(key) != -1){
            hashTable[hashValue].remove(hashTable[hashValue].indexOf(key));
        }
    }
    
    public boolean contains(int key) {
        int hashValue = hashFunction(key);
        
         if(hashTable[hashValue] == null){
            return false;
        }
         if(hashTable[hashValue].indexOf(key) != -1){
           return true;
        }else{
        return false;
         }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */