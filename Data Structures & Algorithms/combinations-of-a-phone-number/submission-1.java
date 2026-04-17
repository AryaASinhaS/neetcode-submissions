class Solution {

    final HashMap<String, ArrayList<String>> hm;

    public Solution()
    {
        //inserting mobile number codes
        hm = new HashMap<>();

        hm.put("2", new ArrayList<>(List.of("a", "b", "c")));
        hm.put("3", new ArrayList<>(List.of("d", "e", "f")));
        hm.put("4", new ArrayList<>(List.of("g", "h", "i")));
        hm.put("5", new ArrayList<>(List.of("j", "k", "l")));
        hm.put("6", new ArrayList<>(List.of("m", "n", "o")));
        hm.put("7", new ArrayList<>(List.of("p", "q", "r", "s")));
        hm.put("8", new ArrayList<>(List.of("t", "u", "v")));
        hm.put("9", new ArrayList<>(List.of("w", "x", "y", "z")));
    }

    public List<String> letterCombinations(String digits) {

        if(digits.length() == 0)
            return new ArrayList<>();

        String firstChar = "" + digits.charAt(0);

        //result.addAll(hm.get(firstChar));
        return findAllCombinations(digits, 0);
    }

    public List<String> findAllCombinations(String str, int index)
    {
        List<String> result = new ArrayList<>();
        if(index == str.length())
        {
            result.add("");
            return result;
        }

        List<String> temp = findAllCombinations(str, index + 1);
        String curChar = "" + str.charAt(index);
        List<String> letters = hm.get(curChar);

        for(String l : letters)
        {
            for(String r : temp)
            {
                String newS =  l + r;
                result.add(newS);
            }
        }

        
        return result;

    }
}
