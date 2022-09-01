package sample;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Server {
    public static List<Player> allplayers=new ArrayList<>();
    private ServerSocket serversocket;
    public static List<Player> auctionedplayers=new ArrayList<>();
    public static volatile List<Club> clubs=new ArrayList<>();
    public static HashMap<String, ClientInfo> clientMap= new HashMap<>();

    public Server() throws Exception {

        serversocket = new ServerSocket(44444);
        allplayers=FileReader.readFromFile();

        while(true){

            Socket clientsocket=serversocket.accept();
            System.out.println("server accepts");
            serve(clientsocket);
        }
    }

    private void serve(Socket clientsocket) throws IOException, ClassNotFoundException {
        NetworkUtil networkUtil=new NetworkUtil(clientsocket);
        new ReadThreadServer(clientMap,networkUtil);
    }
    public static void addClub(String c) throws Exception {
        Club C=new Club(c);
        Server.clubs.add(C);
    }



    public static void main(String[] args) throws Exception {
        Server server=new Server();
    }
}
