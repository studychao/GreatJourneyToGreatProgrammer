package  IsUnique;
import java.util.Scanner;
import java.util.Arrays;
public class Main {
    static String[] change(String a){
        String[] strs = new String[3];
        StringBuilder sb = new StringBuilder();
        String result;
        String[] resultstr = new String[100];
        String[] resultstr2 = new String[100];
        int cur = 0;
        int t = 0;
        int z = 0;
        int count = 0;
        int count_str = 0;
        int space= a.indexOf(' ');
        int space_tmp;
        int times = Integer.parseInt(a.substring(0,space));
        int fstspace = a.indexOf(' ',space+1);
        if (fstspace == -1)
        {
            fstspace = a.length();
        }
        strs[0] = a.substring(space+1,fstspace);
        for (int i = 1; i< times; i++)
        {
            space = a.indexOf(' ',space+1);
            space_tmp = a.indexOf(' ',space+1);
            if (space_tmp == -1)
            {
                space_tmp = a.length();
            }
            strs[i] = a.substring(space+1,space_tmp);
        }

        for (int i = 0 ;i < times; i++)
        {
            t = 0;
            char[] chars = new char[strs[i].length()];
            cur = 0;
            int length = strs[i].length();
            while (length > 8) {
                sb = new StringBuilder();
                for (int m = 0; m < 8; m++) {
                    chars[m] = strs[i].charAt(t * 8 + m);
                }
                while (z < chars.length) {
                    if ((int)chars[z] <= 127 && (int)chars[z] >= 32) {
                        sb.append(chars[z]);
                        count++;
                    }
                    z++;
                    if (count == 8)
                    {
                        break;
                    }
                }
                resultstr[count_str] = sb.toString().trim();
                length = length - 8;
                t++;
                Arrays.fill(chars, '~');
                z = 0;
                count = 0;
                count_str++;
            }
            sb = new StringBuilder();
            for (int m = 0; m< length;m++)
            {
                chars[m] = strs[i].charAt(t*8+m);
            }
            for (int m = 0; m<length;m++)
            {
                sb.append(chars[m]);
                cur = cur + 1;
            }
            if (cur <= 8)
            {
                for (int m =0 ; m < 8 - cur ; m++)
                {
                    sb.append("0");
                }
            }
            resultstr[count_str] = sb.toString().trim();
            count_str++;
        }

        char min ='~';
        int cal = 0;
        for (int i = 0;i<resultstr.length;i++) {
            if (resultstr[i].charAt(0) < min)
            {
                cal = i;
            }
        }

        return resultstr;

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        for (String m : change(a))
        {
            if (m!= null)
             System.out.print(m);
             System.out.print(' ');
        }
    }
}
