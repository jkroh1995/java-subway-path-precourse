package subway.view;

import java.util.List;

public class OutputView {

    private static final String PRINT_INFO = "[INFO] ";
    private static final String PRINT_BLOCK = "---";

    public void printMain() {
        System.out.println("메인 화면");
        System.out.println("1. 경로 조회");
        System.out.println("Q. 종료");
        System.out.println();
    }

    public void printStandard() {
        System.out.println("##경로기준\n"
                + "1. 최단 거리\n"
                + "2. 최소 시간\n"
                + "B. 돌아가기");
        System.out.println();
    }

    public void printError(String message) {
        System.out.println(message);
        System.out.println();
    }

    public void printResult(int distance, int time, List<String> shortestPath) {
        System.out.println(PRINT_INFO + PRINT_BLOCK);
        System.out.printf(PRINT_INFO + "총 거리: %dkm\n", distance);
        System.out.printf(PRINT_INFO + "총 소요 시간: %d분\n", time);
        System.out.println(PRINT_INFO + PRINT_BLOCK);
        for(int i=0;i<shortestPath.size();i++){
            System.out.println(PRINT_INFO + shortestPath.get(i));
        }
        System.out.println();
    }

    public void printLinkedError() {
        System.out.println("[ERROR] 연결되지 않은 역입니다.");
        System.out.println();
    }
}
