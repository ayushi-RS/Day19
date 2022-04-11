class Solution 
{
    public boolean isAlienSorted(String[] words, String order) 
    {
        HashMap<Character , Integer> hm = new HashMap<>();
        
        for(int i = 0; i < order.length(); i++)
            hm.put(order.charAt(i) , i);
        
        
        for(int i = 0; i < words.length - 1; i++)
        {
            String w1 = words[i];
            String w2 = words[i + 1];
           
            for(int j = 0; j < w1.length(); j++)
            {
                char ch1 = w1.charAt(j);
                
                if(j == w2.length())
                    return false;
                if(ch1 != w2.charAt(j))
                {
                    if(hm.get(w2.charAt(j)) < hm.get(ch1))
                        return false;
                    
                    break;
                }
            }
        }
        
        return true;
    }
}
