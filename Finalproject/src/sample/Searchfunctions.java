package sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Searchfunctions {
    public static List<Player> Searchbyname(List<Player> li, String playername ){

        playername=playername.trim();
        List<Player> result= new ArrayList<>();
        int flag=0;
        for (int i = 0; i < li.size(); i++) {
            Player p = li.get(i);
            if((p.getName()).equalsIgnoreCase(playername)){
                result.add(p);
            }
        }
        return result;
        // scn.close();
    }

    public static List<Player> Searchbyposition(List<Player> li , String pos){

        pos=pos.trim();
        int flag=0;
        List<Player> result= new ArrayList<>();
        for (int i = 0; i < li.size(); i++) {
            Player p = li.get(i);
            if(p.getPosition().equalsIgnoreCase(pos)){
                result.add(p);
            }
        }
        return result;
        // scn.close();
    }

    public static List<Player> Searchbycountry(List<Player> li,String country ){

        int flag=0;
        List<Player> result= new ArrayList<>();
        for (int i = 0; i < li.size(); i++) {
            Player p = li.get(i);
            if(p.getCountry().equalsIgnoreCase(country)){
                result.add(p);
            }
        }
        return result;
        //scn.close();
    }

    public static List<Player> Searchbysalary(List<Player> li, double lowsalary, double highsalary ){

        double low=lowsalary;
        double high=highsalary;
        int flag=0;
        List<Player> result= new ArrayList<>();
        for (int i = 0; i < li.size(); i++) {
            Player p = li.get(i);
            if(p.getWeeklysalary()<=high && p.getWeeklysalary()>=low){
                result.add(p);
            }
        }

        // scn.close();
        return result;
    }



    public static List<Player> maxsalary(List<Player> li ){
        //club=club.trim();
        int flag=0;
        double max=-1;
        List<Player> result= new ArrayList<>();
        for (int i = 0; i < li.size(); i++) {
            Player p = li.get(i);
            if(p.getWeeklysalary()>max ){
                max=p.getWeeklysalary();
            }
        }
        for (int i = 0; i < li.size(); i++) {
            Player p = li.get(i);
            if(p.getWeeklysalary()==max){
                result.add(p);
            }
        }
        return result;

        //scn.close();
    }
    public static List<Player>maxage(List<Player> li){
        //club=club.trim();
        int flag=0;
        int max=-1;
        List<Player> result= new ArrayList<>();

        for (int i = 0; i < li.size(); i++) {
            Player p = li.get(i);
            if(p.getAge()>max){
                max=p.getAge();
            }
        }
        for (int i = 0; i < li.size(); i++) {
            Player p = li.get(i);
            if(p.getAge()==max ){
                result.add(p);
            }
        }
        return result;

        //scn.close();
    }
    public static List<Player> maxheight(List<Player> li ){

      //  club=club.trim();
        int flag=0;
        double max=-1;
        List<Player> result= new ArrayList<>();

        for (int i = 0; i < li.size(); i++) {
            Player p = li.get(i);
            if(p.getHeight()>max ){
                max=p.getHeight();
            }
        }
        for (int i = 0; i < li.size(); i++) {
            Player p = li.get(i);
            if(p.getHeight()==max){
                result.add(p);
            }
        }
        return result;
        //scn.close();
    }

    public static double totalsalary(List<Player> li ){
        // club=club.trim();
        int flag=0;
        double total=0;
        List<Player> result= new ArrayList<>();
        for (int i = 0; i < li.size(); i++) {
            Player p = li.get(i);
                //result.add(p);
                //total+=p.getWeeklysalary();
                //flag=1;
            total+=p.getWeeklysalary();
        }

        //scn.close();
        return total;
    }
    public static Map<String, Integer> Countrywisecount(List<Player> li ){
        Map<String, Integer> hm = new HashMap<String, Integer>();
        for (int i = 0; i < li.size(); i++) {
            Player p = li.get(i);
            Integer count = hm.get(p.getCountry());
            if (count == null) {
                hm.put(p.getCountry(), 1);
            }
            else {
                hm.put(p.getCountry(), count + 1);
            }
        }
        //System.out.println("Countries and counts: "+hm);
//        for (Map.Entry<String, Integer> pair : hm.entrySet()) {
//            System.out.println(String.format("Country is: %s, Number is : %s", pair.getKey(), pair.getValue()));
//        }
      return hm;
    }
}
