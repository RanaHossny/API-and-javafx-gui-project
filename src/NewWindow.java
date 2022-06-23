

import java.util.ArrayList;
import java.util.Objects;

import org.apache.poi.xwpf.usermodel.TextAlignment;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
	
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
	import javafx.stage.Stage;
	
	public class NewWindow  {
	    
	    public static void display(String apiname) throws Exception{
	    Stage stage=new Stage();
       
	   
	    stage.initModality(Modality.APPLICATION_MODAL);
	   
		ArrayList <parent> ObjectList = parent.Split_ArrayObject(apiname);
		
        int  no_object = ObjectList.size();
         VBox [] x= new VBox[no_object];
      
        for(int i=0;i<no_object;i++){
       
       Rectangle object = new Rectangle (20,20,220,80);
       
  
       object.setArcWidth(20);
       object.setArcHeight(20);
       object.setFill(Color.rgb(100, 213, 230));
       object.setStroke(Color.BROWN);
        Text object_l = new Text(ObjectList.get(i).getName());
        object_l.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
       object_l.setFill(Color.WHITE);
       object_l.setStroke(Color.PURPLE);
       Group root1 = new Group(object_l);
        StackPane p1 = new StackPane();
         p1.getChildren().addAll(object,root1 );
       Rectangle object_fields = new Rectangle (10,10,220,280);
       object_fields.setArcWidth(20);
       object_fields.setArcHeight(20);
       object_fields.setFill(Color.rgb(246, 220, 245));
       object_fields.setStroke(Color.DARKGREY);
       Text object_fieldl = new Text();
       
       object_fieldl.setText(parent.ToStringObjects_Fields_children(i,apiname));
       object_fieldl.setFont(Font.font("Serif",FontPosture.REGULAR,15 ));
       object_fieldl.setFill(Color.NAVY);
       Group root2 = new Group(object_fieldl);
       
       StackPane p2 = new StackPane (object_fields,root2);
      
       VBox p3= new VBox();
        p3.setPadding(new Insets(10, 15, 15, 10));
       p3.getChildren().addAll(p1,p2);
        p3.setSpacing(5);
        p3.setAlignment(Pos.CENTER);
        x[i]=p3;
        }

        FlowPane y = new FlowPane();
         
        for(int k=0; k<no_object;k++){
          
            y.getChildren().add(x[k]);
        }
        y.setPadding(new Insets(5, 5, 5, 5));
        
        
        Image image = new Image(Objects.requireNonNull(NewWindow.class.getClassLoader().getResourceAsStream("thumb-1920-362074.jpg")));
       ImageView imageView = new ImageView(image);  
        imageView.setPreserveRatio(true); 
        Group root = new Group(imageView); 
        StackPane pane = new StackPane();
       pane.setMargin(y,new Insets(30, 30, 30, 30));
        pane.getChildren().addAll(root,y);
         
       Scene  scene = new Scene(pane,850,800);
       stage.setTitle(apiname);
	    stage.setScene(scene);
	    stage.showAndWait();
	    
	}}

