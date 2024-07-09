class Solution {
    class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }

    class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.isEndOfWord = true;
        }

        String longestPrefix() {
            TrieNode node = root;
            StringBuilder sb = new StringBuilder();
            while (node != null) {
                TrieNode next = null;
                int cnt = 0;
                for (int i = 0; i < 26; i++) {
                    if (node.children[i] != null) {
                        cnt++;
                        next = node.children[i];
                    }
                }
                if (cnt == 1 && !node.isEndOfWord) {
                    sb.append((char) ('a' + getIndex(next, node.children)));
                    node = next;
                } else {
                    break;
                }
            }
            return sb.toString();
        }

        private int getIndex(TrieNode node, TrieNode[] children) {
            for (int i = 0; i < children.length; i++) {
                if (children[i] == node) {
                    return i;
                }
            }
            return -1;
        }
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Trie trie = new Trie();
        // for (String str : strs) {
        //     trie.insert(str);
        // }
        // return trie.longestPrefix();


        String prefix = strs[0];
        int idx = strs[0].length();
        for(int i = 1; i < strs.length; i++){
            
            if(strs[i].length() < prefix.length()){
                idx = strs[i].length();
            }
            for(int j = 0; j < idx; j++){
                if(prefix.charAt(j) != strs[i].charAt(j)){
                    idx = j;
                    break;
                }
            }

            prefix = prefix.substring(0,idx);
            
        }
        return prefix;
    }


}
