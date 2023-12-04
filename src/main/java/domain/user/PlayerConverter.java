package domain.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class PlayerConverter {


    public static List<Player> toPlayer(Map<String, Double> playerInfo){
        List<Player> players = new ArrayList<>();
        playerInfo.forEach((key, value) -> players.add(new Player(key, value)));
        return players;
    }



}
