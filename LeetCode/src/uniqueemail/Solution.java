package uniqueemail;

import java.util.HashSet;

class Solution {
    public static int numUniqueEmails(String[] emails) {
        HashSet<String> validemails= new HashSet<String>();
        for (int i = 0; i < emails.length;i++)
        {
            String str = emails[i];
            int at = str.indexOf('@');
            String address = str.substring(0,at);
            String server = str.substring(at);
            if (address.indexOf('+') != -1)
            {
                address = str.substring(0,address.indexOf('+'));
            }
            address = address.replaceAll("\\.","");
            System.out.println(address);
            validemails.add(address+server);
        }
        return validemails.size();
    }
    public static void main(String[] args) {
        String[] strs = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(strs));
    }
}
