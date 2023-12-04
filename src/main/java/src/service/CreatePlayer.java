package src.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import src.domain.user.Player;

public class CreatePlayer {

    public  List<Player> CreatePlayer(Map<String, Integer> players) {

        List<Player> playerList = new ArrayList<>();

        for ( Entry<String, Integer> player : players.entrySet()) {
            Player ownPlayer = new Player(player.getKey(), player.getValue());
            playerList.add(ownPlayer);
        }
        return playerList;
    }
}
