package view;


public class OutputView {

    private static OutputView instance = new OutputView();


    private OutputView() {
    }

    public static OutputView getInstance() {
        return instance;
    }

    public void printError(String error) {
        print(error);
    }

    private void print(String output) {
        System.out.println(output);
    }

    public void printBatting(String name) {
        print(String.format("%s의 배팅 금액은?", name));
    }

    public void printPlayerName() {
        print("게임에 참여할 사람의 이름을 입렵하세요.(쉼표 기준으로 분리)");
    }
}
