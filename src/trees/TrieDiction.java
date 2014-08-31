/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trees;

import java.util.HashMap;

class TrieNode {
    boolean isEnd;
    HashMap<Character, TrieNode> children;
    public TrieNode() {
        isEnd = false;
        children = new HashMap<>();
    }
}
class TrieDictionary {
    HashMap<Character, TrieNode> roots = new HashMap<>();
    
    public boolean search (String word) {
        if (roots.containsKey(word.charAt(0))) {
            if (word.length() == 1 && roots.get(word.charAt(0)).isEnd)
                return true;
            return searchFor(word.substring(1),roots.get(word.charAt(0)));
        }
        return false;
    }
    private boolean searchFor(String word, TrieNode node) {
        if (word.length() == 0)
            return (node.isEnd);
        if(node.children.containsKey(word.charAt(0))) {
            return searchFor(word.substring(1), node.children.get(word.charAt(0)));
        }
        return false;
    }
    public void insert(String word) {
        if (!roots.containsKey(word.charAt(0))) {
            roots.put(word.charAt(0), new TrieNode());
        }
        if (word.length() == 1)
            roots.get(word.charAt(0)).isEnd = true;
        else
            insertWord(word.substring(1),roots.get(word.charAt(0)));
    }
    private void insertWord(String word, TrieNode node) {
        if(!node.children.containsKey(word.charAt(0))) {
            node.children.put(word.charAt(0), new TrieNode());
        }
        if (word.length() == 1) {
            node.children.get(word.charAt(0)).isEnd = true;
        }   
        else
            insertWord(word.substring(1), node.children.get(word.charAt(0)));
    }
    public void delete(String word) {
    	if(deleteNode(roots.get(word.charAt(0)),word.substring(1)))
    		roots.remove(word.charAt(0));
    }
    private boolean deleteNode(TrieNode node, String word) {
    	if (word.length() == 0) {
    		node.isEnd = false;
    		return(node.children.size() == 0);
    	}
    	if (deleteNode(node.children.get(word.charAt(0)),word.substring(1))) {
    		node.children.remove(word.charAt(0));
    		return (!node.isEnd && node.children.size() == 0);
    	}
    	return false;
    }
}
public class TrieDiction {
    
    public static void main(String args[]) {
        TrieDictionary dictionary = new TrieDictionary();
        dictionary.insert("word");
        dictionary.insert("hello");
        dictionary.insert("a");
        dictionary.insert("aakward");
        System.out.println(dictionary.search("hello"));
        System.out.println(dictionary.search("hello world"));   
        System.out.println(dictionary.search("a"));
        System.out.println(dictionary.search("aakward"));
        dictionary.delete("hello");
        dictionary.insert("hell");
        System.out.println("hello = "+dictionary.search("hello"));
        System.out.println("hell = "+dictionary.search("hell"));
        dictionary.insert("hello");
        System.out.println("hello = "+dictionary.search("hello"));
        dictionary.delete("aakward");
        System.out.println("a = "+dictionary.search("a"));
    }
}