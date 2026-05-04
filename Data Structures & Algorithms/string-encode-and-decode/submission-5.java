class Solution {
    /**
    IP: List of String "Hi" "World"
    OP: List of String "Hi" "World"
    Edge Case: Empty List //return empty
    Approach: For each string in the list append it with a delimeter and return concatenated string, while decoding extract all strings inbetween delimeter
    */

    public String encode(List<String> strs) {
        int i = 0;
        String encodedStr = "";

        for(String s : strs)
        {
            encodedStr = encodedStr  + s + "|__|";
        }
        return encodedStr;
    }

    public List<String> decode(String str) {
        ArrayList<String> result = new ArrayList<>();

        while(str.length() > 0)
        {
            int delimeterIndex = str.indexOf("|__|");
            
            if(delimeterIndex != -1)
            {
                String s = str.substring(0, delimeterIndex);
                result.add(s);
                str = str.substring(delimeterIndex+4);
            }
            else
                break;
        }

        return result;
    }
}
