import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<User> users = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            users.add(new User(age, name));
        }
        Collections.sort(users);
        for (User user : users) {
            bw.write(user.age + " " + user.name + "\n");
        }
        bw.flush();
        bw.close();
    }

    static class User implements Comparable<User> {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(User u) {
            if (this.age > u.age) {
                return 1;
            } else if (this.age < u.age) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
