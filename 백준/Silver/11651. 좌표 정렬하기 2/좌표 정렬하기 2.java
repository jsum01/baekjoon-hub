import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int coordinateAmount = sc.nextInt();
        Set<Coordinate> coordinateSet = new HashSet<>(); // 중복 제거를 위해 Set 사용
        LinkedList<Coordinate> coordinates = new LinkedList<>();

        while (coordinateAmount > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            Coordinate coordinate = new Coordinate(x, y);

            if (!coordinateSet.contains(coordinate)) {
                coordinateSet.add(coordinate);
                coordinates.add(coordinate);
            }

            coordinateAmount--;
        }

        // y 좌표 기준으로 정렬하고, y가 같으면 x 좌표 기준으로 정렬
        coordinates.sort(Comparator.comparingInt((Coordinate c) -> c.y).thenComparingInt(c -> c.x));

        for (Coordinate coordinate : coordinates) {
            System.out.println(coordinate);
        }
    }

    static class Coordinate {
        private int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Coordinate that = (Coordinate) obj;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}
