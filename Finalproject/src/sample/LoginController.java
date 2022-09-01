package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    public TextField clubname;
    @FXML
    public ImageView background;
    public static String cname;


    private Stage stage;
    private Scene scene;
    private Parent root;
    public static ActionEvent e;
   // public static Club C;

    public void Login(ActionEvent actionEvent) throws Exception {
        boolean flag=false;

        cname=clubname.getText();

        for(Club c:Server.clubs){
            if(c.getName().equals(cname)){
              flag=true;
            }
        }
        if(flag==false){

            Server.addClub(cname);
        }

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
        background.setImage(img1);
    }
}
