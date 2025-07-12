import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> inputs = new ArrayList<>();
        ArrayList<String> outputs = new ArrayList<>();
        // todo: 여러 줄의 문자열 입력. 온점만 입력 시 종료
        while (true) {
            String line = sc.nextLine();
            if (line.equals(".")) { // 온점만 입력 시
                break; // 종료
            }
            inputs.add(line);
        }

        // todo: line별 balanced string인지 검사
        for (int i = 0; i < inputs.size(); i++) {
            String line = inputs.get(i);
            Stack<Character> stack = new Stack<>();
            boolean isBanlance = true;

            // todo: symbol이 없을 경우 -> balanced string
            if (!line.contains("[") && !line.contains("]") && !line.contains("(") && !line.contains(")")) {
                outputs.add("yes"); // symbol이 없을 경우 균형잡힌 문자열
                continue;
            }

            // todo: symbol이 있는 경우
            for (int j = 0; j < line.length(); j++) {
                char ch = line.charAt(j);

                // todo: open symbol 담기
                if (ch == '[' || ch == '(') {
                    stack.push(ch);
                }
                // todo: close symbol을 만나면 최근 open symbol과 비교
                if (ch == ']') { // 닫는 대괄호를 만났는데
                    // 스택이 비었거나
                    if (stack.empty() || stack.peek() != '[') { // 조합이 맞지 않다면
                        isBanlance = false;
                        break; // 해당 line 검사 종료
                    }
                    stack.pop(); // 조합이 맞다면 삭제
                } else if (ch == ')') { // 닫는 소괄호를 만났는데
                    // 스택이 비었거나
                    if (stack.empty() || stack.peek() != '(') { // 조합이 맞지 않다면
                        isBanlance = false;
                        break; // 해당 line 검사 종료
                    }
                    stack.pop(); // 조합이 맞다면 삭제
                } // close symbol 소진
            }
            // todo: 마지막 stkOpen가 비었는지 확인
            if (stack.empty() && isBanlance) { // open symbol도 없다면
                outputs.add("yes"); // balanced string
            } else {
                outputs.add("no");
            }
        }
        for(int i = 0; i < outputs.size(); i++) {
            if(i < outputs.size()-1) {
                System.out.println(outputs.get(i));
            } else if(i == outputs.size()-1) {
                System.out.print(outputs.get(i));
            }
        }
    }
}