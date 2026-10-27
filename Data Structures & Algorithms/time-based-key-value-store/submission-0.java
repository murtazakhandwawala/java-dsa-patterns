class TimeMap {

    // we need to design a POJO which can hold key value and timestamp. 
    //Multiple values for the same key but different time stamp
    //and if key and timestamp is passed retrieve the value
    // a HashMap which can have a key - and internally it has another hashmap which will have timestamp and value
    // Tree map will sort and store the values in increasing order of timestamp

    HashMap<String,TreeMap<Integer,String>> tm;

    public TimeMap() {

        tm = new HashMap<>();


    }
    
    public void set(String key, String value, int timestamp) {
        
        if(tm.containsKey(key)){
            TreeMap<Integer,String> a = tm.get(key);
            a.put(timestamp,value);
        }else{
            TreeMap<Integer,String> a = new TreeMap<>();
            a.put(timestamp,value);
            tm.put(key,a);
        }
    }
    
    public String get(String key, int timestamp) {

     if(tm.containsKey(key)){

       if(!tm.containsKey(key)){
            return "";
       }

       TreeMap<Integer,String> a = tm.get(key);

       Map.Entry<Integer,String> entry = a.floorEntry(timestamp);

       return entry==null?"":entry.getValue();
     }

     else{
        return "";
     }

    }
}
