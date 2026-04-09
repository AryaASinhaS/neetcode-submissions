class PrefixTree {

    public HashSet<String> trie;
    public PrefixTree() {
         trie = new HashSet<>();
    }

    public void insert(String word) {
        trie.add(word);
    }

    public boolean search(String word) {
        return trie.contains(word);
    }

    public boolean startsWith(String prefix) {
        for(String word : trie)
        {
            if(word.indexOf(prefix) == 0)
                return true;
        }
        return false;
    }
}
