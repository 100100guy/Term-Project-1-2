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
import java.util.List;
import java.util.ResourceBundle;

public class Salarysearch implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    public TextField lowsalarytxt;
    @FXML
    public TextField highsalarytxt;
    @FXML
    public Button searchbtn;
    @FXML
    public TextArea outputtxt;
    @FXML
    private ImageView backgroundimage;

    public void Search(ActionEvent actionEvent) {
        String low=lowsalarytxt.getText();
        String high=highsalarytxt.getText();
        double lowsal=Double.parseDouble(low);
        double highsal=Double.parseDouble(high);
        String output="";
        for(Club C: Server.clubs){
            if(LoginController.cname.equals(C.getName())){
                System.out.println(C.getName());
                List <Player> temp=Searchfunctions.Searchbysalary(C.players,lowsal,highsal);
                for(Player P: temp){
                    output+=P.getName()+","+P.getWeeklysalary()+"\n";
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
        Image img1=new Image(getClass().getResourceAsStream("salarysearchbg.jpg"));
        backgroundimage.setImage(img1);
    }
}
