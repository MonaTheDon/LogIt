package ControllerClasses;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class DashboardControl {
    public JFXButton viewstocksbtn;
    public JFXButton incstocksbtn;
    public JFXButton outgostocksbtn;
    public JFXButton logoutbtn;
    public JFXButton swuserbtn;
    public PieChart PieChar;
    public JFXButton Ref1;
    public JFXButton Ref;

    @FXML
    LineChart<String,Number> lineChart;
    public void loadChart(javafx.event.ActionEvent event){
        lineChart.getData().clear();
        XYChart.Series<String,Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("Jan", 200));
        series.getData().add(new XYChart.Data<>("Feb", 100));
        series.getData().add(new XYChart.Data<>("March", 500));
        series.getData().add(new XYChart.Data<>("April", 400));
        lineChart.getData().add(series);
    }

    @FXML
    public void loadPieChart(javafx.event.ActionEvent event){
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("2019", 13),
                new PieChart.Data("2020", 25),
                new PieChart.Data("2021", 10),
                new PieChart.Data("2022", 22));
        PieChar.setData(pieChartData);
        PieChar.setClockwise(true);
        PieChar.setLabelLineLength(150);
        PieChar.setLabelsVisible(true);
        PieChar.setStartAngle(180);
    }

    @FXML
    public void loadPieChart(){
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("2019", 13),
                new PieChart.Data("2020", 25),
                new PieChart.Data("2021", 10),
                new PieChart.Data("2022", 22));
        PieChar.setData(pieChartData);
        PieChar.setClockwise(true);
        PieChar.setLabelLineLength(150);
        PieChar.setLabelsVisible(true);
        PieChar.setStartAngle(180);
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
