class PrefixTree {

    class TrieNode {

        TrieNode[] children;
        boolean endFlag;

        public TrieNode() {
            children = new TrieNode[26];
            endFlag = false;
        }
    }

    TrieNode root;


    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode curr = root;

        // Iterate through the characters of the word
        for (int i = 0; i < word.length(); i++) {

            char character = word.charAt(i);
            int index = character - 'a';

            // Does child exist?
            if (curr.children[index] != null) {
                // Move there
                curr = curr.children[index];
            } else {
                // Create child
                TrieNode child = new TrieNode();
                curr.children[index] = child;
                // Move there
                curr = child;
            }
        }
        curr.endFlag = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;   

        for(int i = 0; i < word.length(); i++) {

            int index = word.charAt(i) - 'a';

            if(curr.children[index] == null) {
                return false;
            } else {
                curr = curr.children[index];
            }   
        } 
        return curr.endFlag;
    }

    public boolean startsWith(String prefix) {

        TrieNode curr = root;   

        for(int i = 0; i < prefix.length(); i++) {

            int index = prefix.charAt(i) - 'a';

            if(curr.children[index] == null) {
                return false;
            } else {
                curr = curr.children[index];
            }   
        } 
        return true;
    }
}
