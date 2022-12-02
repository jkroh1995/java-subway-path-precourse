package subway.view;

import java.util.List;

public class OutputView {

    private static final String PRINT_INFO = "[INFO] ";
    private static final String PRINT_BLOCK = "---";
    private static final String PRINT_MAIN = "메인 화면";
    private static final String PRINT_LOOKUP = "1. 경로 조회";
    private static final String PRINT_QUIT = "Q. 종료";
    private static final String PRINT_STANDARD = "##경로기준\n"
            + "1. 최단 거리\n"
            + "2. 최소 시간\n"
            + "B. 돌아가기";
    private static final String PRINT_DISTANCE = "총 거리: %dkm\n";
    private static final String PRINT_TIME = "총 소요 시간: %d분\n";
    private static final String PRINT_ERROR = "[ERROR] 연결되지 않은 역입니다.";

    public void printMain() {
        System.out.println(PRINT_MAIN);
        System.out.println(PRINT_LOOKUP);
        System.out.println(PRINT_QUIT);
        System.out.println();
    }

    public void printStandard() {
        System.out.println(PRINT_STANDARD);
        System.out.println();
    }

    public void printError(String message) {
        System.out.println(message);
        System.out.println();
    }

    public void printResult(int distance, int time, List<String> shortestPath) {
        System.out.println(PRINT_INFO + PRINT_BLOCK);
        System.out.printf(PRINT_INFO + PRINT_DISTANCE, distance);
        System.out.printf(PRINT_INFO + PRINT_TIME, time);
        System.out.println(PRINT_INFO + PRINT_BLOCK);
        for (String result : shortestPath) {
            System.out.println(PRINT_INFO + result);
        }
        System.out.println();
    }

    public void printLinkedError() {
        System.out.println(PRINT_ERROR);
        System.out.println();
    }
}
