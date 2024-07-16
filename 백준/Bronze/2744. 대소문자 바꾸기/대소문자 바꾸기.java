import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String str;
    static List<Character> charList = new ArrayList<>();

    public static void main(String[] args) {
        str = sc.nextLine();
        for (int i = 0; i < str.length(); i++) {
            charList.add(str.charAt(i));
        }

        /**
         * 대문자 <-> 소문자 +-32
         */
        for (int i = 0; i < charList.size(); i++) {
            char ch = charList.get(i);
            if (ch >= 'a' && ch <= 'z') {
                charList.set(i, (char) (ch - 32));
            } else if (ch >= 'A' && ch <= 'Z') {
                charList.set(i, (char) (ch + 32));
            }
        }

        Iterator<Character> it = charList.iterator();
        while(it.hasNext()) {
            System.out.print(it.next());
        }
    }
}
