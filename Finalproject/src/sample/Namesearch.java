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

public class Namesearch implements Initializable {
    @FXML
    public TextField Playername;
    @FXML
    public Button searchbtn;
    @FXML
    public TextArea outputtxt;
    @FXML
    private ImageView backgroundimage;

    private Stage stage;
    private Scene scene;
    private Parent root;


    public void Search(ActionEvent actionEvent) {
        String player=Playername.getText();
        String out="";
        List<Player> temp;
        List<Player> temp2 = new ArrayList<>();
        boolean check=false;
        for(Club C: Server.clubs){
            if(LoginController.cname.equals(C.getName())){
                System.out.println(C.getName());
                check=true;
                temp2=C.players;
            }
        }
        if(check==true){
            temp = Searchfunctions.Searchbyname(temp2, player);
            for(Player P: temp){
                out+=P.getName()+","+P.getCountry()+"\n";

            }
            outputtxt.setText(out);
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
        Image img1=new Image("file:///C:/Users/Asus/Downloads/searchbg.jpg");
        backgroundimage.setImage(img1);
    }
}
