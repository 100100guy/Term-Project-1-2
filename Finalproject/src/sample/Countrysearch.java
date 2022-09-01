package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Countrysearch implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    public TextField Countryname;
    @FXML
    public Button searchbtn;
    @FXML
    public TextArea outputtxt;
    @FXML
    private ImageView backgroundimage;

    public void Search(ActionEvent actionEvent) {
        String country=Countryname.getText();
        String output="";
        List<Player> temp=new ArrayList<>();
        List<Player> temp2 = new ArrayList<>();
        boolean check=false;
        for(Club C: Server.clubs){
            if(LoginController.cname.equals(C.getName())){

                temp=Searchfunctions.Searchbycountry(C.players,country);
                for(Player P: temp){
                    output+=P.getName()+","+P.getCountry()+"\n";
                }
                outputtxt.setText(output);
            }
        }
    }

    public void Back(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("clubmainpage.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add("sample/Loginpage.css");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image img1=new Image(getClass().getResourceAsStream("countrysearchbg.jpg"));
        backgroundimage.setImage(img1);
    }
}
