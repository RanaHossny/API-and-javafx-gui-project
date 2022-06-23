// Import statements
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import javafx.event.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
// Main class
public class apach extends Application{

	
	// Main driver method
	public static void main(String[] args) throws Exception
    {
        launch(args);

    }


    @Override
    public void start(Stage stage) throws Exception {
        Image image = new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("thumb-1920-362074.jpg")));
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        Group root = new Group(imageView);
        Text text = new Text();
        text.setText("Welcome ");
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
        text.setFill(Color.rgb(246, 220, 245));
        text.setStrokeWidth(2);
        text.setStroke(Color.BLUE);
        Group root1 = new Group(text);
        StackPane e= new StackPane();
        e.getChildren().addAll(root1);
        BorderPane bPane = new BorderPane();
        Text text1= new Text("\nPlease entre the excel path \n");
        text1.setFont(Font.font("Serif", FontPosture.ITALIC, 30));
       
       
        text1.setFill(Color.DARKBLUE);
        text1.setStrokeWidth(1);
        text1.setStroke(Color.BLUE);
        Group root2 = new Group(text1);
        bPane.setTop(e);
        bPane.setPadding(new Insets(40, 10, 10, 10));
        VBox vpane = new VBox(20);
        TextField excel=new TextField();
        excel.setMaxSize(400, 30);
        excel.setPadding(new Insets(5, 5, 5, 5));
        Button answer = new Button ("Ok");
        answer.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                try {
                    SecondPage page = new SecondPage();
                    String path=excel.getText();
                    if(path.charAt(0)=='"') {
                        path= path.substring(1, path.length() - 1);
                    }
                    operation organizer = new operation(path);
                    organizer.startOperation();
                    page.display(stage);
                }

                catch(Exception e) {
                    System.out.println(e.getMessage());
                }
            }});
        vpane.getChildren().addAll(root2,excel,answer);
        vpane.setAlignment(Pos.CENTER);
        StackPane d= new StackPane();
        Rectangle r = new Rectangle (35,35,400,400);
        r.setArcWidth(20);
        r.setArcHeight(20);
        r.setFill(Color.rgb(246, 220, 245));
        r.setStroke(Color.DARKGREY);
        r.widthProperty().bind(stage.widthProperty().divide(1.8));
        r.heightProperty().bind(stage.heightProperty().divide(1.8));


        d.getChildren().addAll(root,bPane,r,vpane);
     
        Scene scene = new Scene(d,850,800);
        text1.scaleXProperty().bind(stage.widthProperty().divide(800));
        text1.scaleYProperty().bind(stage.widthProperty().divide(800));
        text1.scaleZProperty().bind(stage.widthProperty().divide(800));
        text.scaleXProperty().bind(stage.widthProperty().divide(800));
        text.scaleYProperty().bind(stage.widthProperty().divide(800));
        text.scaleZProperty().bind(stage.widthProperty().divide(800));
        excel.scaleXProperty().bind(stage.widthProperty().divide(800));
        excel.scaleYProperty().bind(stage.widthProperty().divide(800));
        excel.scaleZProperty().bind(stage.widthProperty().divide(800));
        stage.setTitle("Advanced Project");
        stage.setScene(scene);
        stage.show();
    }


}