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

        if(strs.size() == 0)
        {
            return "";
        }

        while(i < strs.size())
        {
            String s = strs.get(i++);
            encodedStr = encodedStr  + s + "|__|";
        }
        return encodedStr;
    }

    public List<String> decode(String str) {

        int len = str.length();
        if(len == 0)
        {
            return new ArrayList<>();
        }
        int startIndex = 0;
        ArrayList<String> result = new ArrayList<>();
        String s = "";

        while(startIndex < len && startIndex != -1)
        {
            int nextIndex = str.indexOf("|__|",startIndex);
            s = (nextIndex != -1 ? str.substring(startIndex, nextIndex) : str.substring(startIndex));
            startIndex = nextIndex +4;
            result.add(s);
            if(nextIndex == -1)
            {
                break;
            }
        }

        
        return result;
    }
}
