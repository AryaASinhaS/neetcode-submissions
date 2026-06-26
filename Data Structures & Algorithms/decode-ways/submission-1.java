class Solution {
    HashMap<String, Integer> hm = new HashMap<>();

    public int numDecodings(String s) {
        if(s.length() == 0)
            return 1;

        if(s.charAt(0) == '0')
            return 0;

        if(s.length() <= 1)
            return 1;
        
        if(hm.containsKey(s))
            return hm.get(s);

        String firstStr = "" +  s.charAt(0), secondStr = s.substring(0, 2);
        String exclFirstStr = s.substring(1), exclSecondStr = s.substring(2);

        int firstStrNum = Integer.parseInt(firstStr), secondStrNum = Integer.parseInt(secondStr);
        int result = numDecodings(exclFirstStr) + (secondStrNum > 26 ? 0 : numDecodings(exclSecondStr));

        hm.put(s, result);

        return result;

    }
}
