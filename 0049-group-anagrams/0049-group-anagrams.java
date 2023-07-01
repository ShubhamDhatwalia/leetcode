class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String , List<String>> map = new HashMap<>();
        
        for(String word : strs){
            char [] wordsChar = word.toCharArray();
            Arrays.sort(wordsChar);
            String sortedWord = new String(wordsChar);
            
            if(!map.containsKey(sortedWord)){
                map.put(sortedWord, new ArrayList<>());
            }
            map.get(sortedWord).add(word);
        }
        return new ArrayList<>(map.values());
    }
}