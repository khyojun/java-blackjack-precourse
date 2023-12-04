package src.dto;

import java.util.Map;

public class TransferViewToModelDto {

    private  Map<String, Integer> PlayerList;


    public void transferPlayerList(Map<String, Integer> playerList){
        this.PlayerList = playerList;
    }

    public Map<String, Integer> getPlayerList(){
        return PlayerList;
    }
}
