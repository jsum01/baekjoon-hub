import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCycle = Integer.parseInt(br.readLine());
        while (testCaseCycle-- > 0) {
            int book1amt = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Set<String> book1 = new HashSet<>();
            for (int i = 0; i < book1amt; i++) {
                book1.add(st.nextToken());
            }

            int book2amt = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < book2amt; i++) {
                if (book1.contains(st.nextToken())) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            }

        }

        bw.flush();
        bw.close();
    }
}