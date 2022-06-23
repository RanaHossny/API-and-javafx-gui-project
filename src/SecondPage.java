
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
import javafx.scene.control.Button;
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

public class SecondPage {
	

 public  void display(Stage stage) throws Exception{
	    	 ArrayList<String> s=parent.api_names();
	    	 ArrayList<String> names= new ArrayList<String>(s.size());
	    	 for(int k =0;k<s.size();k++) {
	    		 for(int in=0;in<s.get(k).length();in++) {
	    			 if(s.get(k).charAt(in)=='(') {
	    			names.add(s.get(k).substring(in+1, s.get(k).length()-1));
	    				 in=s.get(k).length();
	    			 }
	    			 
	    		 }
	    	 }
	    	
	    	 Button [] button= new Button[s.size()];
	    	// Stage stage =new Stage();      
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
	    	        
	    	    
	    	          Text text1= new Text("\nChoose the wanted api name\n");
	    	          text1.setFont(Font.font("Serif", FontPosture.ITALIC, 30));
	    	           text1.setFill(Color.DARKBLUE);
	    	            text1.setStrokeWidth(1);
	    	          text1.setStroke(Color.BLUE);
	    	          Group root2 = new Group(text1);
	    	           bPane.setTop(e); 
	    	           bPane.setPadding(new Insets(40, 10, 10, 10));
	    	          FlowPane x=new FlowPane();
	    	           
	    	          for(int i=0 ; i<names.size();i++){
	    	        	  String ss =s.get(i);
	    	              button[i]=new Button();
	    	              button[i].setText(names.get(i));
	    	              button[i].setMaxSize(200, 200);
	    	               button[i].setMinSize(50, 50);
	    	               button[i].setTextFill(Color.DARKBLUE); 
	    	               button[i].setFont(Font.font("Serif", FontPosture.ITALIC, 12));
	    	            
	    	               button[i].setOnAction(new EventHandler<ActionEvent>() {
	                       public void handle(ActionEvent event) {
	                    	   try {
	                    	   NewWindow.display(ss);}
	                    	   catch(Exception e) {
	                    		   System.out.println(e.getMessage());
	                    	   }
	                	}});
	    	               x.getChildren().add(button[i]); 
	                }
	    	               
	    	          
	    	          
	    	          
	    	           x.setPadding(new Insets(5, 5, 5, 5));
	    	           x.setVgap(10);
	    	           x.setHgap(10);
	    	           x.setAlignment(Pos.CENTER);
	    	           VBox v=new VBox();
	    	           v.getChildren().addAll(root2,x);  
	    	           v.setAlignment(Pos.CENTER);
	    	          StackPane d= new StackPane();
	    	       Rectangle r = new Rectangle (35,35,400,400);
	    	       r.setArcWidth(20);
	    	       r.setArcHeight(20);
	    	       r.setFill(Color.rgb(246, 220, 245));
	    	       r.setStroke(Color.DARKGREY);
	    	       r.widthProperty().bind(stage.widthProperty().divide(1.8));
	    	        r.heightProperty().bind(stage.heightProperty().divide(1.8));
	    	         
	    	       
	    	        d.getChildren().addAll(root,bPane,r,v);
	    	       
	    	        
	    	        Scene scene = new Scene(d,850,800);
	    	        text.scaleXProperty().bind(stage.widthProperty().divide(800));
	    	        text.scaleYProperty().bind(stage.widthProperty().divide(800));
	    	        text.scaleZProperty().bind(stage.widthProperty().divide(800));
	    	        text1.scaleXProperty().bind(stage.widthProperty().divide(800));
	    	        text1.scaleYProperty().bind(stage.widthProperty().divide(800));
	    	        text1.scaleZProperty().bind(stage.widthProperty().divide(800));
	    	        
	    	        stage.setTitle("the APIs in the excel");
	    	        stage.setScene(scene);
	    	        stage.show();
	    	    
	    
	    
	}

}
