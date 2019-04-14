package NRepeated961;

import java.util.HashSet;

class Solution {
    public int repeatedNTimes(int[] A) {
        HashSet<Integer> a = new HashSet<Integer>();
        for (int i = 0 ; i < A.length ; i++)
        {
            if (a.add(A[i]) == false)
                return A[i];
        }
        return 0 ;
    }
}