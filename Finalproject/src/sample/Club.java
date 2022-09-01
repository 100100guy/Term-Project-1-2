package sample;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Club implements Serializable {
    private String name;
    public NetworkUtil networkutil;
    public List<Player> players;


    public void setPlayers(String name) throws Exception {
        List<Player> temp=FileReader.readFromFile();
        for(Player P: temp){
            if (P.getClub().equals(this.name)){
                this.players.add(P);
            }
        }
    }

    public Club(String name) throws Exception {
        this.name = name;
        this.players=new ArrayList<>();
        List<Player> temp=FileReader.readFromFile();
        for(Player P: temp){
            if (P.getClub().equals(this.name)){
                this.players.add(P);
            }
        }
        networkutil=new NetworkUtil("127.0.0.1",44444);
        new ReadThreadClient(networkutil,this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public static void main(String[] args) throws Exception {
        Club club=new Club();
    }*/
}
