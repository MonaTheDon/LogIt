package ControllerClasses;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateControl {
    public JFXButton viewstocksbtn;
    public JFXButton incstocksbtn;
    public JFXButton outgostocksbtn;
    public JFXButton logoutbtn;
    public JFXButton swuserbtn;
    public TextField pntf;
    public TextField qttf;
    public TextField ptf;
    public TextField recdttf;
    public TextField pctf;
    public JFXButton addbtn;
    public Label uplbl;
    public JFXButton upbtn1;
    public JFXButton backbtn;


    @FXML
    public void UpdateAction(ActionEvent evt) throws IOException {
        int pcode, upqt, uppric;

        pcode=Integer.parseInt(pctf.getText());
        upqt=Integer.parseInt(qttf.getText());
        uppric=Integer.parseInt(ptf.getText());

        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logit", "root", "tanisha0714");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from stocks where Prodcode="+pcode);

            if(rs.next()){
                int x=rs.getInt("Qty");
                stmt.executeUpdate("update stocks set Qty="+(x+upqt)+" , Price="+uppric+" where ProdCode="+pcode);
                uplbl.setText("Unit updated Successfully!");

            }

        }
        catch(Exception e){
            e.printStackTrace();
        }





    }

    @FXML
    public void ViewStockOpenAction(ActionEvent evt) throws IOException {
        Parent AdminBoard = FXMLLoader.load((getClass().getResource("/pageDesigns/ViewStock.fxml")));
        Scene AdminBoardScene = new Scene(AdminBoard);
        Stage userStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        userStage.setScene(AdminBoardScene);
        userStage.setTitle("Welcome to LoggIt");
        userStage.show();
    }

    @FXML
    public void IncomingOpen(ActionEvent evt) throws IOException {
        Parent AdminBoard = FXMLLoader.load((getClass().getResource("/pageDesigns/Incoming.fxml")));
        Scene AdminBoardScene = new Scene(AdminBoard);
        Stage userStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        userStage.setScene(AdminBoardScene);
        userStage.setTitle("Welcome to LoggIt");
        userStage.show();
    }

    @FXML
    public void OutgoingOpen(ActionEvent evt) throws IOException {
        Parent AdminBoard = FXMLLoader.load((getClass().getResource("/pageDesigns/Outgoing.fxml")));
        Scene AdminBoardScene = new Scene(AdminBoard);
        Stage userStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        userStage.setScene(AdminBoardScene);
        userStage.setTitle("Outgoing Stock");
        userStage.show();
    }

    @FXML
    public void LogOut(ActionEvent evt) throws IOException {
        Parent AdminBoard = FXMLLoader.load((getClass().getResource("/pageDesigns/Login.fxml")));
        Scene AdminBoardScene = new Scene(AdminBoard);
        Stage userStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        userStage.setScene(AdminBoardScene);
        userStage.setTitle("Log In");
        userStage.show();
    }

}

