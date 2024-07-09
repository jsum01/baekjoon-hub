import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int N = sc.nextInt();

        if (N <= 0) return;

        Vector<Integer> v = new Vector<>();
        // N번 Pi분을 입력
        for (int i = 0; i < N; i++) {
            v.add(i, sc.nextInt());
        }

        Collections.sort(v);

        int minimumTime = 0;
        for (int i = 0; i < v.size(); i++) {
            int eachTime = 0;
            for (int j = 0; j <= i; j++) {
                eachTime += v.get(j);
            }
            minimumTime += eachTime;
        }
        System.out.println(minimumTime);

        sc.close();
    }
}
