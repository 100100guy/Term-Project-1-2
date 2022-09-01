package sample;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    private static final String INPUT_FILE_NAME = "player.txt";
    private static final String OUTPUT_FILE_NAME = "player.txt";
    public static List<Player> readFromFile() throws Exception {
        List<Player> PlayerList = new ArrayList();
        // var PlayerList = new ArrayList();
        BufferedReader br = new BufferedReader(new java.io.FileReader(INPUT_FILE_NAME));
        // var br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            String[] tokens = line.split(",");
            Player p = new Player();
            p.setName(tokens[0]);
            p.setCountry(tokens[1]);
            p.setAge(Integer.parseInt(tokens[2]));
            p.setHeight(Double.parseDouble(tokens[3]));
            p.setClub(tokens[4]);
            p.setPosition(tokens[5]);
            p.setNumber(Integer.parseInt(tokens[6]));
            p.setWeeklysalary(Double.parseDouble(tokens[7]));
            PlayerList.add(p);
        }
        br.close();
        return PlayerList;
    }
}
