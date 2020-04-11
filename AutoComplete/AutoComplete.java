import javafx.scene.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AutoComplete {
    private TrieNode root;
    public AutoComplete() {
        root = new TrieNode();
    }
    public AutoComplete(String[] wordBank)   {
        root = new TrieNode();
        for (String word:wordBank){
            this.insert(word);
        }
    }

    public LinkedList search(String input){//prints out the possible words from the word bank
        HashMap<Character, TrieNode> children = root.getChildren();

        TrieNode temporaryNode = null;
        TrieNode chosenNode = null;
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(children.containsKey(c)) {
                temporaryNode = children.get(c);
                children = temporaryNode.getChildren();
            }else {
                temporaryNode = null;
                break;
            }


        }
        List<String> results = new LinkedList<String>();
        List<String> finalResults = new LinkedList<String>();

        findAllChildWords(temporaryNode,results,"");

        for (int i = 0; i<results.size();i++) {
            finalResults.add(input.toLowerCase().substring(0,input.length()-1)+ results.get(i));
        }
        return (LinkedList) finalResults;//placeholder
    }
    private void findAllChildWords(TrieNode n, List<String> results,String word) {
        if (n==null) {
            return;
        }
        if (n.isEndOfWord()) {
            word += n.getC();
            results.add(word);
        }else {
            word += n.getC();
        }


        String finalWord = word;
        n.getChildren().forEach((k, v) ->
                        findAllChildWords(v,results, finalWord)
                );

    }




    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.getChildren();

        for (int i = 0; i < word.length(); i++) {//traverses through each letter in the word
            char c = word.charAt(i);
            TrieNode temporaryNode;
            if (children.containsKey(c)) {//traverses to the next letter
                temporaryNode = children.get(c);
            } else {//adds the new character to the trienode
                temporaryNode = new TrieNode(c);
                children.put(c, temporaryNode);
            }
            children = temporaryNode.getChildren();//the next trienode in place

            if (i == word.length() - 1) {//marks the end of a word
                temporaryNode.setEndOfWord(true);
            }
        }

    }





}

