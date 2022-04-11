class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] resArr = new int[k];
        for(int num :nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int j = 0;
        while(k > 0){
            int maxOccurance = 0;
            int maxIdx = 0;
            for(int i: map.keySet()){
                if(map.get(i) >= maxOccurance){
                    maxIdx = i;
                    maxOccurance = map.get(i);
                }
            }
            resArr[j++] = maxIdx;
            map.remove(maxIdx);
            k--;
        }
        return resArr;
    }
}