package strings.tagContentExtractor;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static final String REGEX = "<(.+)>([^<]+)</\\1>";
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = Integer.parseInt(scan.nextLine());

        while (lines-- > 0){
            String text = scan.nextLine();

            boolean matchFound = false;
            Pattern p = Pattern.compile(REGEX);
            Matcher m = p.matcher(text);

            while(m.find()){
                System.out.println(m.group(2));
                matchFound = false;
            }

            if(!matchFound){
                System.out.println("None");
            }

        }
    }

}