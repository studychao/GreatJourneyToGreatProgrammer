package WithoutAAA984;

class Solution {
    public String strWithout3a3b(int A, int B) {
        StringBuilder a = new StringBuilder();
        boolean max_is_A = false;
        double max = 0;
        int max_pairs = 0;
        if (A > B)
        {
            max_is_A = true;
            max = A;
            max_pairs = (int)Math.ceil(max / 2);
        }
        else
        {
            max_is_A = false;
            max = B;
            max_pairs = (int)Math.ceil(max / 2);
        }
        while ( A != 0 || B != 0){
            if (max_is_A) {
                if (A == 1) {
                    a.append('a');
                    A = A - 1;
                } else if (A > 0) {
                    a.append("aa");
                    A = A - 2;
                    max_pairs--;
                }
                if (B > max_pairs +1) {
                    a.append("bb");
                    B = B - 2;
                } else if (B > 0) {
                    a.append('b');
                    B = B - 1;
                }
            }
            if (!max_is_A) {
                if (B == 1){
                    a.append('b');
                    B = B - 1;
                }
                else if (B > 0){
                    a.append("bb");
                    B = B - 2;
                    max_pairs--;
                }
                if (A > (max_pairs+1) ){
                    a.append("aa");
                    A = A - 2;
                }
                else if (A > 0){
                    a.append('a');
                    A = A - 1;
                }
            }

        }
        String result = a.toString().trim();
        return result;

    }
}
