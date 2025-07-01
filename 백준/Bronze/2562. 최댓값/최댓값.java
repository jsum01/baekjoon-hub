import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // Variables
        Scanner sc = new Scanner(System.in);
        int[] inputs = new int[9];

        // Input
        int inputIdx = 0; // fixed input amount: 9
        while (inputIdx < 9) {
            inputs[inputIdx] = Integer.parseInt(sc.nextLine());
            inputIdx++;
        }

        // Calculation
        int max = inputs[0];
        int maxNumIdx = 1;
        for(int i = 1; i < inputs.length; i++) {
            if(inputs[i] > max) {
                max = inputs[i];
                maxNumIdx = i + 1;
            }
        }

        // Output
        System.out.println(max); // Maximum
        System.out.print(maxNumIdx); // Index
    }
}