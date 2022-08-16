import java.io.IOException;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static String calc(String input) throws IOException {
        new String();
        boolean rome = false;
        String[] inp = input.split(" ");
        int FST = 0;
        int SEC = 0;
        try {
            FST = Integer.parseInt(inp[0]);
        } catch (NumberFormatException e){
            rome = true;
            Integers inte1 = Integers.valueOf(inp[0]);
            FST = inte1.getInteger();
        }
        try {
            SEC = Integer.parseInt(inp[2]);
            if ( rome==true) {
                throw new IOException("несовпадение типов цифр");
            }
        } catch (NumberFormatException e){
            Integers inte2 = Integers.valueOf(inp[2]);
            SEC = inte2.getInteger();
            if ( rome==false) {
                throw new IOException("несовпадение типов цифр");
            }
        }
        if ( FST>10 || SEC>10) {throw new IOException("излишне большое значение");}
        char i = inp[1].charAt(0);
        switch (i) {
            case '*' :
                input = Integer.toString(FST*SEC);
                break;
            case '/' :
                input = Integer.toString(FST/SEC);
                break;
            case '+' :
                input = Integer.toString(FST+SEC);
                break;
            case '-' :
                input = Integer.toString(FST-SEC);
                break;
            default:
                throw new IOException("неверный ввод");
        }

        if (rome==true) {
            if (Integer.valueOf(input) <= 0) {throw new IOException("неверный ввод");}
            if (input.length() > 1){
                if (Integer.valueOf(input) == 100) {
                    input = Integers.С.name();
                } else {
                    String a = input.charAt(0) + "0";
                    String b = input.substring(1);
                    Integers inte3 = Integers.fromString(Integer.valueOf(a));
                    try {
                        Integers inte4 = Integers.fromString(Integer.valueOf(b));
                        input = inte3.name()+inte4.name();
                    } catch (NullPointerException e) {
                        input = inte3.name();
                    }

                }
            } else {

                Integers inte5 = Integers.fromString(Integer.valueOf(input));
                input = inte5.name();
            }

        }
        return input;
    }

    public static void main(String[] args) throws IOException {
        while(true) {
            System.out.println("Введите ваши два числа и операцию, разделённые пробелами:");
            Scanner in = new Scanner(System.in);
            String str = in.nextLine();
            System.out.println(calc(str));
        }
    }
}