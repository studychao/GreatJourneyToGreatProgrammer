package LongestSubstring;

import java.util.HashSet;

public class SlidingShadow {
    public  int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int i = 0;
        int j = 0;
        HashSet<Character> set = new HashSet<>();
        if(!set.contains(s.charAt(j)))
        {
            set.add(s.charAt(j++));
            ans = Math.max(ans,j-i);
        }
        else
        {
            set.remove(s.charAt(i++));
        }
        return ans;
    }
}
