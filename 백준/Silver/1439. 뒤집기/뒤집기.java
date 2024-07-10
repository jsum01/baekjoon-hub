import java.util.Scanner;
import java.util.Vector;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String input = sc.nextLine();
        Vector<Character> v = new Vector<>();
        for(int i = 0; i < input.length(); i++) {
            v.add(input.charAt(i));
        }


        int cnt = 1;
        for (int i = 0; i < v.size() - 1; i++) {
            if (v.get(i) != v.get(i + 1))
                cnt++;
        }
        System.out.printf(cnt / 2 + "");

        sc.close();
    }
}
