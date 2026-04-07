class TimeMap {

    /**
    Approach :
    hashmap of String, TreeMap<Integer, String>
    set - add to hashmap
    get - if(string) exists --> if(key) exists return it's value else return arrayList.get(list.size()-1)
    **/

    public HashMap<String, ArrayList<ArrayList<String>>> tmMap = new HashMap<>();

    public TimeMap() {
        tmMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {

        ArrayList<String> list = new ArrayList<>();
        ArrayList<ArrayList<String>> listEntry = new ArrayList<>();
        if(tmMap.containsKey(key))
        {
            //already exists
            listEntry = tmMap.get(key);
        }
        list.add("" + timestamp);
        list.add(value);
        listEntry.add(list);
        tmMap.put(key,listEntry);
    }
    
    public String get(String key, int timestamp) {

        ArrayList<ArrayList<String>> list = new ArrayList<>();
        if(tmMap.containsKey(key))
        {
            list = tmMap.get(key);
        }

        int l = 0, r = list.size() - 1, mid = 0;
        String potentialLB = "";

        while(l <= r)
        {
            mid = (l+r)/2;
            int midVal = Integer.parseInt(list.get(mid).get(0));

            if(midVal == timestamp)
            {
                return list.get(mid).get(1);
            }
            else if(midVal < timestamp)
            {
                potentialLB = list.get(mid).get(1);
                l = mid+1;
            }
            else
            {
                r = mid-1;
            }
        }
        return potentialLB;
    }
}
