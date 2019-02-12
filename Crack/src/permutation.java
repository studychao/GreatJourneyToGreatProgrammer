public class permutation {
    void permutation(String str){
        permutation(str,"");
    }

    void permutation(String str, String perfix){
        if(str.length() == 0){
            System.out.println(perfix);
        }
        else{
            for (int i = 0;i < str.length(); i++){
                String rem = str.substring(0,i) + str.substring(i+1);
                permutation(rem, perfix + str.charAt(i));
            }
        }
    }
}
