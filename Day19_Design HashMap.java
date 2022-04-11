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
                {class MyHashMap {
    private static final int ARR_SIZE = 1000000;
    
    private  ArrayList[] buckets;
    
    public MyHashMap() {
        this.buckets = new ArrayList[ARR_SIZE];    
    }
    
    public void put(int key, int val) {
        Integer _key = Integer.valueOf(key);
        
        //calc the hashcode
        int hash = _key.hashCode();
        
        //calc the index
        int index = hash % ARR_SIZE;
        
        //create a collection to store the item and place the address in the array
        if(this.buckets[index]!=null){
            int flag = 1;
            ArrayList list_ref = this.buckets[index];
            for(int i=0;i<list_ref.size();i++){
                if(((List)list_ref.get(i)).get(0).equals(key))
                {   
                    flag = 0;
                    ((List)list_ref.get(i)).set(1,val);
                }
            }
            //means key is no there in the list
            if(flag==1)  list_ref.add(Arrays.asList(key,val));
        } else {
            ArrayList list_ref = new ArrayList();
            list_ref.add(Arrays.asList(key,val));
            this.buckets[index] = list_ref;
        }
    
    }
    
    public int get(int key) {
        Integer _key = Integer.valueOf(key);
        
        //calc the hashcode
        int hash = _key.hashCode();
        
        //calc the index
        int index = hash % ARR_SIZE;
        
        if(this.buckets[index] == null){
            return -1;
        }
        else{
            ArrayList list_ref = this.buckets[index];
            //iterate through the list to get the key
            for(int i=0;i<list_ref.size();i++){
                if(((List)list_ref.get(i)).get(0).equals(key)){
                    return (Integer)((List)list_ref.get(i)).get(1);
                }
            }
        }
        return -1;
    }
    
    public void remove(int key) {
         Integer _key = Integer.valueOf(key);
        
        //calc the hashcode
        int hash = _key.hashCode();
        
        //calc the index
        int index = hash % ARR_SIZE;
        
        if(this.buckets[index]==null){
            return;
        }
        else{
            ArrayList list_ref = this.buckets[index];
            //iterate through the list to get the key
            for(int i=0;i<list_ref.size();i++){
                if(((List)list_ref.get(i)).get(0).equals(key)){
                   list_ref.remove(i);
                }
            }
        }
 
    }
}

                    if(hm.get(w2.charAt(j)) < hm.get(ch1))
                        return false;
                    
                    break;
                }
            }
        }
        
        return true;
    }
}
