class Solution {
    List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {

        if(digits.length() == 0)
            return new ArrayList<>();

        HashMap<String, ArrayList<String>> hm = new HashMap<>();

        hm.put("2", new ArrayList<>(List.of("a", "b", "c")));
        hm.put("3", new ArrayList<>(List.of("d", "e", "f")));
        hm.put("4", new ArrayList<>(List.of("g", "h", "i")));
        hm.put("5", new ArrayList<>(List.of("j", "k", "l")));
        hm.put("6", new ArrayList<>(List.of("m", "n", "o")));
        hm.put("7", new ArrayList<>(List.of("p", "q", "r", "s")));
        hm.put("8", new ArrayList<>(List.of("t", "u", "v")));
        hm.put("9", new ArrayList<>(List.of("w", "x", "y", "z")));

        String firstChar = "" + digits.charAt(0);

        result.addAll(hm.get(firstChar));
        return findAllCombinations(digits, 1, hm);
    }

    public List<String> findAllCombinations(String str, int index, HashMap<String, ArrayList<String>> hm)
    {
        if(index == str.length())
        {
            return result;
        }

        List<String> temp = new ArrayList<>();
        String curChar = "" + str.charAt(index);
        List<String> letters = hm.get(curChar);

        for(String l : letters)
        {
            for(String r : result)
            {
                String newS = r + l;
                temp.add(newS);
            }
        }

        result.clear();

        for(String r : temp)
        {
            result.add(r);
        }

        findAllCombinations(str, index + 1, hm);
        return result;

    }
}
