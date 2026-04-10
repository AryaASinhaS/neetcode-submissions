class TrieNode
{
    TrieNode[] children;
    boolean isWordFlag;

    public TrieNode()
    {
        children = new TrieNode[26];
        isWordFlag = false;
    }
}
class WordDictionary {

    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;

        for(char c : word.toCharArray())
        {
            if(curr.children[c - 'a'] == null)
            {
                TrieNode node = new TrieNode();
                curr.children[c - 'a'] = node;
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWordFlag = true;
    }

    public boolean search(String word) {
        
        return patternMatching(root, word, 0);
    }

    public boolean patternMatching(TrieNode root, String word, int index) {
        if(root == null)
            return false;
        
        if(index >= word.length())
            return root.isWordFlag;

        char charToBeChecked = word.charAt(index);
        if(charToBeChecked == '.')
        {
            for(int i = 0; i < 26; i++)
            {
                if(patternMatching(root.children[i],word, index + 1))
                {
                    return true;
                }
            }
        }
        else
        {
            if(root.children[charToBeChecked - 'a'] == null)
            {
                return false;
            }
            return patternMatching(root.children[charToBeChecked - 'a'],word, index + 1);
        }
        return false;
    }
}
