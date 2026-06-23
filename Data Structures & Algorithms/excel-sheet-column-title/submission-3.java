class Solution {
    public String convertToTitle(int columnNumber) 
    {
        HashMap<Integer, Character> hm = new HashMap<>();
        String result = "";

        for(int i = 1; i < 27; i++)
        {
            hm.put(i, (char)(64 + i));
        }

        while(columnNumber > 26)
        {
            int val = columnNumber % 26;
            
            if(val > 0)
            {
                result = hm.get(val) + result;
            }
               
            columnNumber = columnNumber / 26;
        }
        result = hm.get(columnNumber) + result;
        return result;
    }
}