import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<ReservationTime> reservationList = new ArrayList<>(n);

        // n개 회의 타임 입력
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            reservationList.add(new ReservationTime(start, end));
        }

        // 종료 시간을 기준으로 정렬, 종료 시간이 같으면 시작 시간을 기준으로 정렬
        Collections.sort(reservationList);

        // 최대 회의 개수 계산
        int maxMeetings = getMaxMeetings(reservationList);
        System.out.println(maxMeetings);
    }

    private static int getMaxMeetings(List<ReservationTime> reservationList) {
        int count = 0;
        int lastEndTime = 0;

        for (ReservationTime rt : reservationList) {
            if (rt.startT >= lastEndTime) {
                lastEndTime = rt.endT;
                count++;
            }
        }
        return count;
    }

    static class ReservationTime implements Comparable<ReservationTime> {
        private int startT;
        private int endT;

        public ReservationTime(int startT, int endT) {
            if (startT <= endT) { // 검사: 시작시간이 종료시간보다 작거나 같음
                this.startT = startT;
                this.endT = endT;
            } else {
                throw new IllegalArgumentException("Start time should be less than or equal to end time.");
            }
        }

        @Override
        public int compareTo(ReservationTime other) {
            if (this.endT != other.endT)
                return this.endT - other.endT; // 종료 시간을 기준 -> 오름차순
            else
                return this.startT - other.startT; // 종료 시간이 같으면 시작 시간을 기준 -> 오름차순
        }
    }
}
