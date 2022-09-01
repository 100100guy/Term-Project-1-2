package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.naming.spi.InitialContextFactory;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ClubmainpageController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ImageView image;
    @FXML
    private Label club;
    @FXML
    private ImageView backgroundimage;

    public void Namesearch(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Namesearch.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add("sample/Loginpage.css");
        stage.setScene(scene);
        stage.show();
    }

    public void Back(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Loginpage.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add("sample/Loginpage.css");
        stage.setScene(scene);
        stage.show();

    }

    public void sell(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("sellwindow.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add("sample/Loginpage.css");
        stage.setScene(scene);
        stage.show();
    }

    public void buy(ActionEvent actionEvent) throws IOException {
        /*for(Player pp: Server.auctionedplayers){
            System.out.println(pp.getName());
        }*/
        for(Club C: Server.clubs){
            if(LoginController.cname.equals(C.getName())){
                String req="req";
                   C.networkutil.write((Object)req);
                }

            }
        //System.out.println("bop");
        root = FXMLLoader.load(getClass().getResource("buywindow.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add("sample/Loginpage.css");
        stage.setScene(scene);
        stage.show();
    }

    public void countrysearch(ActionEvent actionEvent) throws IOException {

        root = FXMLLoader.load(getClass().getResource("Countrysearch.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add("sample/Loginpage.css");
        stage.setScene(scene);
        stage.show();
    }

    public void Maxage(ActionEvent actionEvent) {
        List<Player> temp= new ArrayList<>();
        String output="";
        for(Club C: Server.clubs){
            if(LoginController.cname.equals(C.getName())){
                System.out.println(C.getName());
                temp=Searchfunctions.maxage(C.players);
                for(Player P: temp){
                    output+=P.getName()+","+P.getAge()+"\n";
                }

            }
        }
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(output);
        alert.showAndWait();
    }

    public void Maxheight(ActionEvent actionEvent) {
        List<Player> temp= new ArrayList<>();
        String output="";
        for(Club C: Server.clubs){
            if(LoginController.cname.equals(C.getName())){
                System.out.println(C.getName());
                temp=Searchfunctions.maxheight(C.players);
                for(Player P: temp){
                    output+=P.getName()+","+P.getHeight()+"\n";
                }

            }
        }
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(output);
        alert.showAndWait();
    }

    public void Maxsalary(ActionEvent actionEvent) {
        List<Player> temp= new ArrayList<>();
        String output="";
        for(Club C: Server.clubs){
            if(LoginController.cname.equals(C.getName())){
                System.out.println(C.getName());
                temp=Searchfunctions.maxsalary(C.players);
                for(Player P: temp){
                    output+=P.getName()+","+P.getWeeklysalary()+"\n";
                }

            }
        }
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(output);
        alert.showAndWait();

    }

    public void positionsearch(ActionEvent actionEvent) throws IOException {

        root = FXMLLoader.load(getClass().getResource("Positionsearch.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add("sample/Loginpage.css");
        stage.setScene(scene);
        stage.show();
    }

    public void salarysearch(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Salarysearch.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add("sample/Loginpage.css");
        stage.setScene(scene);
        stage.show();
    }

    public void Totalsalary(ActionEvent actionEvent) {
        List<Player> temp= new ArrayList<>();
        String output="";
        double result = 0;
        for(Club C: Server.clubs){
            if(LoginController.cname.equals(C.getName())){
                //System.out.println(C.getName());
                result=Searchfunctions.totalsalary(C.players);
            }
        }
        output="Total salary is: "+ Double.toString(result);
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(output);
        alert.showAndWait();

    }
    public void Countrywisecount(ActionEvent actionEvent) {
        Map<String, Integer> hm = new HashMap<String, Integer>();
        String out="";
        for(Club C: Server.clubs){
            if(LoginController.cname.equals(C.getName())){
               // System.out.println(C.getName());
               hm=Searchfunctions.Countrywisecount(C.players);
               for (Map.Entry<String, Integer> pair : hm.entrySet()) {
                    out+=(String.format("Country is: %s, Number is : %s", pair.getKey(), pair.getValue()))+"\n";
            }

            }

        }
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(out);
        alert.showAndWait();


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        club.setText(LoginController.cname);
        if(LoginController.cname.equalsIgnoreCase("Arsenal")){

              Image img = new Image(getClass().getResourceAsStream("arsenal.png"));
              image.setImage(img);

            Image img1=new Image(this.getClass().getResourceAsStream("Arsenalbg.jpg"));
            backgroundimage.setImage(img1);
        }
        if(LoginController.cname.equalsIgnoreCase("Chelsea")){
            Image img1=new Image(ClubmainpageController.class.getResourceAsStream("Chelseabg.jpg"));
            backgroundimage.setImage(img1);
//
            Image img = new Image(getClass().getResourceAsStream("chelsea.png"));
            image.setImage(img);

        }
        if(LoginController.cname.equalsIgnoreCase("Manchester United")){
            Image img1=new Image(ClubmainpageController.class.getResourceAsStream("manubg.jpg"));
            backgroundimage.setImage(img1);
//
            Image img = new Image(ClubmainpageController.class.getResourceAsStream("manchester united.png"));
            image.setImage(img);
        }
        if(LoginController.cname.equalsIgnoreCase("Liverpool")){

            Image img = new Image(ClubmainpageController.class.getResourceAsStream("liverpool.png"));
            image.setImage(img);
            Image img1=new Image(ClubmainpageController.class.getResourceAsStream("liverpoolbg.jpeg"));
            backgroundimage.setImage(img1);
        }
        if(LoginController.cname.equalsIgnoreCase("Manchester City")){

            Image img = new Image(ClubmainpageController.class.getResourceAsStream("mcity.png"));
            image.setImage(img);
            Image img1=new Image(ClubmainpageController.class.getResourceAsStream("mcitybg.jpg"));
            backgroundimage.setImage(img1);
        }
    }


}
