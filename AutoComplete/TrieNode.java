import java.util.HashMap;

public class TrieNode {
    private char c;
    private HashMap<Character, TrieNode> children = new HashMap<>();
    private boolean endOfWord;

    public TrieNode() {

    }
    public TrieNode(char c){
        this.c = c;
    }
    public String getC() {
        return ""+ c;
    }
    public HashMap<Character, TrieNode> getChildren () {
        return children;
    }
    public boolean isEndOfWord (){
        return endOfWord;
    }
    public void setEndOfWord(boolean value){
        this.endOfWord = value;
    }

    public String toString(){
        return "{"+c+", " + endOfWord+"}";
    }
}
