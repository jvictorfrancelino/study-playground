package hackerrank.javaMap;

import java.util.HashMap;
import java.util.Scanner;

class PlayGround {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int qtdContatos = Integer.valueOf(scan.nextLine());

        HashMap<String, Integer> mapaContatos = new HashMap<>();

        for(int i = 0; i < qtdContatos; i++){
            String name = scan.nextLine();
            int phone = Integer.valueOf(scan.nextLine());
            mapaContatos.put(name, phone);
        }

        String s;
        while(scan.hasNextLine()){
            s = scan.nextLine();
            if(mapaContatos.containsKey(s)){
                System.out.println(s + "=" + mapaContatos.get(s));
            }else{
                System.out.println("Not found");
            }
        }
        scan.close();
    }
}