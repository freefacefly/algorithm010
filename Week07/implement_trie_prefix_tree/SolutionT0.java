package io.kvh.algo.w7.c13.implement_trie_prefix_tree;

import org.junit.Assert;

/**
 * Created by kvh on 2020/7/22.
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 */
public class SolutionT0 {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        Assert.assertTrue(trie.search("apple"));   // 返回 true
        Assert.assertFalse(trie.search("app"));     // 返回 false
        Assert.assertTrue(trie.startsWith("app"));      // 返回 true
        trie.insert("app");
        Assert.assertTrue(trie.search("app"));     // 返回 true
    }

    static class Trie {

        private boolean isEnd;
        private Trie[] next;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            isEnd = false;
            next = new Trie[26];
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            if (word == null || word.length() == 0) return;
            Trie curr = this;

            char[] chars = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                int n = chars[i] - 'a';
                if (curr.next[n] == null) {
                    curr.next[n] = new Trie();
                }
                curr = curr.next[n];
            }
            curr.isEnd = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            if (word == null || word.length() == 0) return false;
            Trie node = searchWithPrefix(word);
            return node != null && node.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            if (prefix == null || prefix.length() == 0) return false;
            Trie node = searchWithPrefix(prefix);
            return node != null;
        }

        private Trie searchWithPrefix(String prefix) {
            Trie node = this;
            char[] chars = prefix.toCharArray();
            for (int i = 0; i < prefix.length(); i++) {
                node = node.next[chars[i] - 'a'];
                if (node == null) return null;
            }
            return node;
        }
    }
}
