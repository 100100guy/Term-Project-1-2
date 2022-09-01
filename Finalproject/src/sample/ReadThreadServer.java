package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

public class ReadThreadServer implements Runnable {
    private Thread thr;
    private NetworkUtil networkUtil;
    public HashMap<String, ClientInfo> clientMap=new HashMap<>();
    private Stage stage;
    private Scene scene;
    private Parent root;


    public ReadThreadServer(HashMap<String , ClientInfo> map, NetworkUtil networkUtil) {
        this.clientMap = map;
        this.networkUtil = networkUtil;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {

               while (true) {
                   Object o = networkUtil.read();
                   //System.out.println(o);
                   if (o instanceof Player) {
                       Player p = (Player) o;
                       Server.auctionedplayers.add(p);
                       for (Player pp : Server.auctionedplayers) {
                           System.out.println(pp.getName());
                       }
                   }
                   if (o instanceof String) {
                       networkUtil.write(Server.auctionedplayers);
                   }


                   if (o instanceof Soldplayer) {
                       //System.out.println("booooooooooop");

                           Soldplayer sp = (Soldplayer) o;

                           for (Iterator<Player> iterator = Server.auctionedplayers.iterator(); iterator.hasNext(); ) {
                               Player P = iterator.next();
                               if (sp.getPlayer().getName().equals(P.getName())) {
                                   iterator.remove();
                               }
                           }
                           networkUtil.write((Object)sp.getPlayer());




                       //System.out.println(sp.getRequestedclub());
//                       for (Club cc : Server.clubs) {
//                           System.out.println(cc.getName());
//                       }
//                       for (Club cc : Server.clubs) {
//                           if (sp.getRequestedclub().equals(cc.getName())) {
//                               //Player p=sp.player;
//                               System.out.println("Yessssss");
//                               for (Player p : cc.players) {
//                                   System.out.println(p.getName());
//                               }
//                           }
//                       }
//                       for (Club c : Server.clubs) {
//                           if (sp.getRequestedclub().equals(c.getName())) {
//                               Player p = sp.getPlayer();
//                               p.setClub(sp.getRequestedclub());
//                               c.players.add(p);
//                           }
//                       }
//                       for (Club c : Server.clubs) {
//                           if (sp.getPlayer().getClub().equals(c.getName())) {
//                               //Player p=sp.player;
//                               for (Player p : c.players) {
//                                   if (p.getName().equals(sp.getPlayer().getName())) {
//                                       c.players.remove(p);
//                                   }
//                               }
//
//                           }
//                       }
//                           for (Club cc : Server.clubs) {
//                               if (sp.getRequestedclub().equals(cc.getName())) {
//                                   //Player p=sp.player;
//                                   for (Player p : cc.players) {
//                                       System.out.println(p.getName());
//                                       }
//                                       }
//                                   }
                       }

                   }

               } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
    catch (Exception e) {
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



