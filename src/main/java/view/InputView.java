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
        return scanner.nextLine();
    }

    public Double inputBatting(String name) {
        try{
            System.out.println(String.format("%s의 배팅 금액은?", name)); // 이거 고쳐야함! ㅠㅠ
            double convertBatting = Double.parseDouble(scanner.nextLine());
            if(convertBatting<=0)
                throw new NumberFormatException();
            return convertBatting;
        }catch (NumberFormatException e){
            return inputBatting(name);
        }
    }

    public boolean inputPick() {
        String s = scanner.nextLine();
        if(s.equals("y"))
            return true;
        if(s.equals("n"))
            return false;
        throw new IllegalArgumentException("[ERROR] 유효한 뽑기를 위한 입력이 아닙니다! ");
    }
}
