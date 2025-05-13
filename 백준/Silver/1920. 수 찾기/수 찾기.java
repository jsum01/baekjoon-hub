import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] Ns = br.readLine().split(" ");
        Set<String> Nset = new HashSet<>(Arrays.asList(Ns)); // HashSet 사용

        int M = Integer.parseInt(br.readLine());
        String[] Ms = br.readLine().split(" ");

        for (int i = 0; i < M; i++) {
            if (Nset.contains(Ms[i])) {
                bw.write("1");
            } else {
                bw.write("0");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}