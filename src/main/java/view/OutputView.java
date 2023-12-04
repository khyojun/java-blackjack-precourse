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
}
