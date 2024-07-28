import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int startYear = 1946;
        int inputYear = sc.nextInt();
        System.out.println(inputYear - startYear);

    }
}