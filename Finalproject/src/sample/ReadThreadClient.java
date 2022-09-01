package sample;

import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class ReadThreadClient implements Runnable {
    private Thread thr;
    private NetworkUtil networkUtil;
    //private ClientMenu clientMenu;
    private Club club;

    public ReadThreadClient(NetworkUtil networkUtil, Club club) {
        this.networkUtil = networkUtil;
        this.thr = new Thread(this);
        this.club=club;

        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = networkUtil.read();
                if (o instanceof List) {
                    Buywindow.list.clear();
                   List<Player> li=(List<Player>) o;
                    for (Player pp : li) {
                        System.out.println(pp.getName());
                    }
                    for (Player pp : li) {

                            Buywindow.list.add(pp);

                    }



                }
                if (o instanceof Player) {

                Player p = (Player) o;
                    for (Iterator<Club> iterator = Server.clubs.iterator(); iterator.hasNext(); ) {
                        Club C = iterator.next();
                        for (Iterator<Player> iterator1 = C.players.iterator(); iterator1.hasNext(); ) {
                            Player P = iterator1.next();
                            if (p.getClub().equals(C.getName()) && p.getName().equals(P.getName())) {

                                iterator1.remove();
                            }

                        }

                    }

                    p.setClub(club.getName());
                    club.players.add(p);

                }


            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                networkUtil.closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



