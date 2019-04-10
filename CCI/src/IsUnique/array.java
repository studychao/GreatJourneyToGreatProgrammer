package IsUnique;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class array {
    static String change(String a){
        StringBuilder sb = new StringBuilder();
        int count = 0;
        char[] chars = new char[1000];
        String result = "";
        for (int i = 0;i<a.length();i++)
        {
            if ((i+1) <a.length()) {
                if (a.charAt(i + 1) != '(') {
                    if (a.charAt(i) != '(' && a.charAt(i) !=')') {
                        chars[count] = a.charAt(i);
                        count = count + 1;
                    }
                }
                if (a.charAt(i + 1) == '(') {
                    int times = a.charAt(i) - '0';
                    for (int m = 1; m < times; m++) {
                        chars[count] = a.charAt(i + 2);
                        count = count + 1;
                    }
                }
            }
            else
            {
                if (a.charAt(i) != '(' && a.charAt(i) !=')') {
                    chars[count] = a.charAt(i);
                    count = count + 1;
                }
            }

        }
        for (int i = 0;i<chars.length;i++)
        {
            sb.append(chars[i]);
        }
        sb.reverse();
        result = sb.toString().trim();
        return result;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        System.out.println(change(a));

    }

}


