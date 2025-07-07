import java.io.*;
import java.math.BigInteger;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger N = new BigInteger(br.readLine());

        for(int i = 64; i > 0; i--) {
            BigInteger mistakeVal = BigInteger.TWO.pow(i).subtract(BigInteger.ONE); // 2^i - 1
            BigInteger result = mistakeVal;

            for(int j = i + 1; j <= 64; j++) {
                result = result.multiply(BigInteger.TWO);
            }

            if(result.equals(N)) {
                System.out.println(i);
                return;
            }
        }
    }
}