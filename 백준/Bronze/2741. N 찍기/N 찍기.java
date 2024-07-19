import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static int N;

    public static void main(String[] args) {
        N = input.nextInt();
        for(int i = 1; i <= N; i++) {
            System.out.println(i);
        }
    }
}
