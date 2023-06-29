class Solution {
    class Pair{
        String word;
        int frq;
        Pair(String word, int frq){
            this.word = word;
            this.frq = frq;
        }
    }
    public List<String> topKFrequent(String[] arr, int k) {
        
        List<String> res = new ArrayList<>();
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            if(a.frq == b.frq){
                return a.word.compareTo(b.word);
            }
            return b.frq-a.frq;});
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String word : arr){
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        
        for(String word : map.keySet()){
            pq.add(new Pair(word, map.get(word)));
        }
        int i = k;
        while(i >0){
            Pair curr = pq.remove();
            res.add(curr.word);
            i--;
        }
        return res;
    }
}