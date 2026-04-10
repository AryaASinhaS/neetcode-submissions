class TrieNode
{
    TrieNode[] children;
    boolean isWordFlag;

    public TrieNode()
    {
        this.children = new TrieNode[26];
        this.isWordFlag = false;
    }
}
class PrefixTree {
    TrieNode root;
    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
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
        TrieNode curr = root;

        for(char c : word.toCharArray())
        {
            if(curr.children[c - 'a'] == null)
            {
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return curr.isWordFlag;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;

        for(char c : prefix.toCharArray())
        {
            if(curr.children[c - 'a'] == null)
            {
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return true;
    }
}
