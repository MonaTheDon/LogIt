package ControllerClasses;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.util.Objects;

public class LoginControl {


    public TextField UserTF;
    public PasswordField PassTF;
    public JFXButton LoginBTN;
    public Label Stat;
    public JFXButton RegBTN;

    @FXML
    public void LoginAction(ActionEvent evt) {
        String username = UserTF.getText();
        String password = PassTF.getText();
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logit","root","tanisha0714");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from logindetails");

            while(rs.next()){
                if(rs.getString("Username").equals(username) && rs.getString("Password").equals(password)) {
                    Parent AdminBoard = FXMLLoader.load((getClass().getResource("/pageDesigns/UserRegis.fxml")));
                    Scene AdminBoardScene = new Scene(AdminBoard);
                    Stage userStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
                    userStage.setScene(AdminBoardScene);
                    userStage.setTitle("Welcome to LoggIt");
                    userStage.show();

                    /*if(rs.getString("Admin").equals("Yes")) {
                        String Admin = rs.getString("Admin");
                        stmt.executeUpdate("Insert into loginsession values('" + username + "','" + password + "','" + Admin + "')");
                        Parent AdminBoard = FXMLLoader.load((getClass().getResource("/pageDesigns/AdminBoard.fxml")));
                        Scene AdminBoardScene = new Scene(AdminBoard);
                        Stage userStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
                        userStage.setScene(AdminBoardScene);
                        userStage.setTitle("Welcome to Stocklog");
                        userStage.show();
                        break;
                    }*/
                }
                /*if(rs.getString("LoginID").equals(username) && rs.getString("Password").equals(password)) {
                    if(rs.getString("Admin").equals("No")){
                        Parent userAdd = FXMLLoader.load((getClass().getResource("/pageDesigns/dashb.fxml")));
                        Scene userAddScene = new Scene(userAdd);
                        Stage userStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
                        userStage.setScene(userAddScene);
                        userStage.setTitle("User Registration");
                        userStage.show();
                        break;
                    }
                }*/

                else
                    Stat.setText("Access Denied!!");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

        /*try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","Fallout@4");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from logindetails");

            while(rs.next()){
                if(rs.getString("LoginID").equals(username) && rs.getString("Password").equals(password)) {
                    if(rs.getString("Admin").equals("Yes")) {
                        String Admin = rs.getString("Admin");
                        stmt.executeUpdate("Insert into loginsession values('" + username + "','" + password + "','" + Admin + "')");
                        Parent AdminBoard = FXMLLoader.load((getClass().getResource("/pageDesigns/AdminBoard.fxml")));
                        Scene AdminBoardScene = new Scene(AdminBoard);
                        Stage userStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
                        userStage.setScene(AdminBoardScene);
                        userStage.setTitle("Welcome to Stocklog");
                        userStage.show();
                        break;
                    }
                }
                if(rs.getString("LoginID").equals(username) && rs.getString("Password").equals(password)) {
                    if(rs.getString("Admin").equals("No")){
                        Parent userAdd = FXMLLoader.load((getClass().getResource("/pageDesigns/dashb.fxml")));
                        Scene userAddScene = new Scene(userAdd);
                        Stage userStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
                        userStage.setScene(userAddScene);
                        userStage.setTitle("User Registration");
                        userStage.show();
                        break;
                    }
                }
                else
                    Stat.setText("Access Denied!!");

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
*/
    @FXML
    public void RegisterAction(ActionEvent evt) throws Exception {
        Parent userAdd = FXMLLoader.load((getClass().getResource("../pageDesigns/UserRegis.fxml")));
        Scene userAddScene = new Scene(userAdd);
        Stage userStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        userStage.setScene(userAddScene);
        userStage.show();
    }
    @FXML
    public void BackHome(ActionEvent evt) throws Exception {
        Parent userAdd = FXMLLoader.load((getClass().getResource("../pageDesigns/AdminBoard.fxml")));
        Scene userAddScene = new Scene(userAdd);
        Stage userStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        userStage.setScene(userAddScene);
        userStage.show();
    }
}

