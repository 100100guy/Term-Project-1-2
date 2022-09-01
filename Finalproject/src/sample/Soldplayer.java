package sample;

import java.io.Serializable;

public class Soldplayer implements Serializable {
    Player player;
    String requestedclub;

    public String getRequestedclub() {
        return requestedclub;
    }

    public void setRequestedclub(String requestedclub) {
        this.requestedclub = requestedclub;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player p) {
        this.player = p;
    }
}
