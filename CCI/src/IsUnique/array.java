package IsUnique;

import java.util.ArrayList;

public class array {
    ArrayList<String> merge(String[] words,String[] more) {
        ArrayList<String> sentence = new ArrayList<String>();
        for (String w : words) sentence.add(w);
        for (String w : more) sentence.add(w);
        return sentence;
    }

    Boolean isunique(String str){
        int length = str.length();
        boolean[] char_set = new boolean[128];
        for (int i = 0 ; i< length ; i++)
        {
            int a = (int)str.charAt(i);
            if(char_set[a]) return false;
            char_set[a] = true;
        }
        return true;
    }
}


