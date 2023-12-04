package view;


import java.util.Scanner;

public class InputView {

    private static InputView instance = new InputView();

    private Scanner scanner = new Scanner(System.in);


    private InputView() {
    }

    public static InputView getInstance() {
        return instance;
    }


    public String inputPlayers() {
        String value = scanner.next();
        scanner.close();
        return value;
    }
}
