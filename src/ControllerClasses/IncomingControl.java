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
import java.sql.Statement;

public class IncomingControl {
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
    public Label addlbl;
    public JFXButton updbtn;

    @FXML
    public void AddAction(ActionEvent evt) throws IOException{
        String pdname, newdate;
        int pcode, newqt,newpric;
        pcode=Integer.parseInt(pctf.getText());
        pdname=pntf.getText();
        newqt=Integer.parseInt(qttf.getText());
        newpric=Integer.parseInt(ptf.getText());
        newdate=recdttf.getText();

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logit", "root", "tanisha0714");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("insert into logit.stocks(Prodcode, Prodname, Qty, recdate, price) VALUES ("+pcode+",'"+pdname+"',"+newqt+",'"+newdate+"',"+newpric+")");
            addlbl.setText("Stock Added Successfully!");

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

    @FXML
    public void UpdateW(ActionEvent evt) throws IOException {
        Parent AdminBoard = FXMLLoader.load((getClass().getResource("/pageDesigns/Update.fxml")));
        Scene AdminBoardScene = new Scene(AdminBoard);
        Stage userStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        userStage.setScene(AdminBoardScene);
        userStage.setTitle("Log In");
        userStage.show();
    }
}


