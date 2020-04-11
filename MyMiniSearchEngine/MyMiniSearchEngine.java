import java.util.*;

public class MyMiniSearchEngine {
    // default solution. OK to change.
    // do not change the signature of index()
    private HashMap<String, List<List<Integer>>> indexes;

    // disable default constructor
    private MyMiniSearchEngine() {
    }

    public MyMiniSearchEngine(List<String> documents) {
        index(documents);
    }

    // each item in the List is considered a document.
    // assume documents only contain alphabetical words separated by white spaces.
    private void index(List<String> texts) {
        //homework
        indexes = new HashMap<String, List<List<Integer>>>();

        for (int i = 0; i<texts.size();i++) {
            String [] words = texts.get(i).toLowerCase().split(" ");//breaks up the string into an array of words

            //This adds words to the HashMap along with what string and their location
            for (int j=0;j<words.length;j++) {
                //This checks if a keyword is already present or not
                if (!indexes.containsKey(words[j])) {
                    List<List<Integer>> temporary = new ArrayList<List<Integer>>();
                    for(int t = 0; t<texts.size();t++) {
                        temporary.add(new ArrayList<Integer>()) ;
                    }
                    indexes.put(words[j],temporary);
                }
                indexes.get(words[j]).get(i).add(j);
            }
        }
//        System.out.println(indexes);
    }

    // search(key) return all the document ids where the given key phrase appears.
    // key phrase can have one or two words in English alphabetic characters.
    // return an empty list if search() finds no match in all documents.
    public List<Integer> search(String keyPhrase) {
        // homework
        HashMap<Integer, List<List<Integer>>> documents = new HashMap<Integer, List<List<Integer>>>();
        String [] words = keyPhrase.toLowerCase().split(" ");
        List<List<Integer>> list;
        List<Integer> sameDocs = new ArrayList<>();
        List<Integer> data;


        //This loop identifies every word and  stores their doc location and order location into the documents HashMap
        for(int i = 0; i< words.length;i++) {//traverse from each word to word
            if (indexes.containsKey(words[i])) {
                List<List<Integer>> temporary = new ArrayList<List<Integer>>();
                for (int j = 0; j<indexes.get(words[i]).size();j++) {//traverse each element in documents
                     list = new ArrayList<>();
                        list.add(indexes.get(words[i]).get(j));

                        temporary.add(list.get(0));
                }
                documents.put(i,temporary);
            }
        }
//        System.out.println(documents);

        //This checks if documents is empty (if by chance there is no where in the provided strings with the keyword then the program ends
        if (documents.isEmpty()) {
            return sameDocs;
        }

        //This adds all of the location of each word in each document to the array list data
        for (int i = 0;i<documents.get(0).size();i++) {//traverse number of elements
             data = new ArrayList<>();
            for (int j = 0; j<documents.size();j++) {//traverse each document ex. doc 0
                for (int t = 0;t<documents.get(j).get(i).size();t++) {
                    if (!data.contains(documents.get(j).get(i).get(t))) {
                        data.add(documents.get(j).get(i).get(t));
                    }
                }
            }
//            System.out.println(data);

            //This checks if the provided data is in any of the strings
            //I know the data is in a string if the # of data elements and # of words array elements are the same
                if (data.size() == words.length) {
                    //isCollectionSorted() is a method that checks if all the values are in order and only one value away from each other
                    //for ex. [0,1,2,3]
                    if(isCollectionSorted(data)) {
                        sameDocs.add(i);//if both tests past, number of String is added to sameDocs
                    }
                }
        }
        return  sameDocs;
    }
    public boolean isCollectionSorted(List<Integer> list) {
        for (int i = 0; i<list.size();i++) {
            if (i!=list.size()-1) {
                if ( list.get(i) + 1 != list.get(i+1)) {
                    return false;
                }
            }
        }
        return true;
    }
}
