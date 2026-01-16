package vacation.challenges0701.stringsIntroduction;

import java.io.*;

public class Solution1 {
    static void main() throws IOException {
        String palavra1;
        String palavra2;
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            palavra1 = bufferedReader.readLine();
            palavra2 = bufferedReader.readLine();
        } catch(IOException ex){
            throw ex;
        }

        int wordsLenght = palavra1.length() + palavra2.length();
        System.out.println(wordsLenght);

        if(palavra1.compareTo(palavra2) < 0) {
            System.out.println("No");
        }else if (palavra1.compareTo(palavra2) > 0) {
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }

        System.out.println(capitalize(palavra1) + " " + capitalize(palavra2));
    }

    public static String capitalize(String str) {
        if (str == null || str.isEmpty()){
            return str;
        }

        return str.substring(0,1).toUpperCase() + str.substring(1);
    }
}
