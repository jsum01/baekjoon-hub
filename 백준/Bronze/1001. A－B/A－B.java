import java.io.*;

class Main {
    public static void main(String[] a) throws Exception {
        var r = new BufferedReader(new InputStreamReader(System.in));
        var w = new BufferedWriter(new OutputStreamWriter(System.out));
        var s = r.readLine().split(" ");
        w.write(Integer.parseInt(s[0]) - Integer.parseInt(s[1]) + "");
        w.flush();
    }
}