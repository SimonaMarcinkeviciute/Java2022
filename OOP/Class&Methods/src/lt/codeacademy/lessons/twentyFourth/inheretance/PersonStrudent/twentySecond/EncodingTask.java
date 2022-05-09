package lt.codeacademy.lessons.twentyFourth.inheretance.PersonStrudent.twentySecond;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class EncodingTask {
    //klases parametrus galim pasiekti is bet kur, nereikia deti i metodu parametrus
    private static final String CODES = "32 tarpas;65 A;82 R;105 i;33 !;" +
            "66 B;83 S;106 j;44 ,;67 C;84 T;107 k;46 .;68 D;85 U;108 l;" +
            "48 0;69 E;86 V;109 m;49 1;70 F;87 W;110 n;50 2;71 G;88 X;" +
            "111 o;51 3;72 H;89 Y;112 p;52 4;73 I;90 Z;113 q;53 5;74 J;" +
            "97 a;114 r;54 6;75 K;98 b;115 s;55 7;76 L;99 c;116 t;56 8;" +
            "77 M;100 d;117 u;57 9;78 N;101 e;118 v;63 ?;79 O;102 f;" +
            "119 w;80 P;103 g;120 x;81 Q;104 h;121 y;122 z";
    public static final String SPACE = " ";
    private Map<Integer, String> decode = new HashMap<>();
    private Map<String, Integer> encode = new HashMap<>();

    public static void main(String[] args) {
        EncodingTask encodingTask = new EncodingTask();
        Scanner scanner = new Scanner(System.in);
        encodingTask.fillCodeToMap();

        String action;
        do{
            encodingTask.menu();
            action = scanner.nextLine();
            encodingTask.selectAction(action, scanner);
        }while(!action.equals("3"));
    }

    private void selectAction(String action, Scanner scanner) {
        switch (action) {
            case"1" -> encodeMessage(scanner);
            case"2" -> decodeMessage(scanner);
            case"3" -> System.out.println("Programa baige darba");
            default -> System.out.println("Tokio veiksmo nera");

        }
    }

    private void encodeMessage(Scanner scanner) {
        System.out.println("Iveskite teksta kuri norite uzkoduoti");
        String text = scanner.nextLine();
        StringBuilder sb = new StringBuilder();

        for(char c: text.toCharArray()) {
            String letter = String.valueOf(c);
            Integer code = encode.get(letter);
            sb.append(code).append(SPACE);
        }
        System.out.println(sb.toString());
    }

    private void decodeMessage(Scanner scanner) {
        System.out.println("Iveskite koduote");
        String text = scanner.nextLine();
        String[] codes = text.split(SPACE);
        StringBuilder sb = new StringBuilder();

        for (String c : codes) {
            int code = Integer.parseInt(c);
            sb.append(decode.get(code));
        }
        System.out.println(sb.toString());
    }

    private void menu() {
        System.out.println("""
                1. Uzkoduoti teksta i JA
                2. Atkoduoti teksta is Ja
                3. Baigti
                """);
    }

    private void fillCodeToMap() {
        String[] codes = CODES.split(";");

        for(String code : codes) {
            String [] splitPair = code.split(SPACE);
            if(splitPair.length!=2) {
                continue; // tesia toliau, nelendant giliau i koda
            }
            int key = Integer.parseInt(splitPair[0]);
            String value = splitPair[1].equals("tarpas") ? SPACE : splitPair[1];
            decode.put(key,value);
            encode.put(value,key);
        }
    }
}
