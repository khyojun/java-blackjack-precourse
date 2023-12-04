package src.view.inputView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import src.domain.user.Player;

public class InputView {

    public  List<String> getPlayers() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("게임에 참여할 사람의 이름을 입력하세요 (쉼표로 구분): ");
        String input = scanner.nextLine();

        // 입력 받은 문자열을 쉼표로 분리하여 리스트로 반환
        return Arrays.asList(input.split("\\s*,\\s*"));
    }

    public  Map<String, Integer> getBetAmounts(List<String> playerNames) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> betAmounts = new HashMap<>();

        for (String playerName : playerNames) {
            System.out.println(playerName + "의 배팅 금액을 입력하세요: ");
            int betAmount = scanner.nextInt();
            betAmounts.put(playerName, betAmount);
        }
        return betAmounts;
    }

    public boolean askOneMoreCard(Player player){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%s는 한장의 카드를 더 받겠습니까 ?(예는 y, 아니오는 n)",player.getName());
        System.out.println();
        String yesNo = scanner.nextLine();
        if(yesNo.equals("y")){
            return true;
        }
        return false;
    }



}
