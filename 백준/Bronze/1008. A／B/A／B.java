import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] inputs = sc.nextLine().split(" ");
        Double result = Double.parseDouble(inputs[0]) / Double.parseDouble(inputs[1]);

        System.out.println(result);
    }
}