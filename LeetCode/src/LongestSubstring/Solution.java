package LongestSubstring;

import java.util.HashSet;

public class Solution {
    public  int lengthOfLongestSubstring(String s) {
        HashSet<Character> a = new HashSet<>();
        int max = 0;
        int i = 0;
        int tmp = 0;
        while (i < s.length())
        {
            System.out.println(i);
            if (a.add(s.charAt(i)) == false)
            {
                if (a.size()>max)
                {
                    max = a.size();
                }
                tmp = a.size();
                a.clear();
                i = s.indexOf(s.charAt(i),i-tmp)+1;
            }
            else
            {
                i++;
            }
        }
        if(a.size()>max)
        {
            max = a.size();
        }
        return max;
    }
}
