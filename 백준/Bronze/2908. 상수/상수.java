import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] inputs = sc.nextLine().split(" "); // 345 435 입력
        String first = "";
        String second = "";
        for(int i = 2; i >= 0; i--){
            first += inputs[0].charAt(i);
            second += inputs[1].charAt(i);
        }
        if(Integer.parseInt(first) > Integer.parseInt(second)) {
            System.out.println(first);
        } else {
            System.out.println(second);
        }
    }
}