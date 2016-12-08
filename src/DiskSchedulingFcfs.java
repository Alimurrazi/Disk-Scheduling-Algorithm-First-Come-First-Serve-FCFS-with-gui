/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static java.lang.Math.abs;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.stage.Stage;

/**
 *
 * @author RANA_CSE
 */



public class DiskSchedulingFcfs extends Application{
    BorderPane border=new BorderPane();
    GridPane grid,grid1,grid2;
    static Scene scene,scene1,scene2,scene3,scene4,scenesn,scene5,scene6;
    int a=0,b=3,count=1;
    String s1=null,s2=null;
    boolean selectedpage[]=new boolean[20000];
    String inputfile = null;
    int lowestpage=9999999,highestpage=0;
    int d=0,coun=1;
    int ara[]=new int[2000];
    int secondpart[]=new int[2000];
    int row;
    boolean beforeend=false;
    boolean back=false;
    static Stage pristage;
    boolean textoffile=false;
    String filename=null;
    int ara_size=0;
    
    GridPane gridinfo()
    {
      GridPane gri=new GridPane();
      gri.setAlignment(Pos.TOP_LEFT);
      gri.setHgap(10);
      gri.setVgap(10);
      gri.setPadding(new Insets(25,25,25,25));
      return gri;
    }
    
    
    GridPane gridbybutton()
    {
        {
        if(coun==1)
        {
         grid1=gridinfo();
         Label text=new Label("Insert data (Please first put head)");
         text.setFont(new Font("Arial", 25));
         grid1.add(text, 0, 1);
         coun=2;
        }
        
           
             Button okbutton=new Button("OK");
             okbutton.setStyle("-fx-font: 12 arial; -fx-base: #b6e7c9;");
             TextField tf1=new TextField();
         //    TextField tf2=new TextField();
             tf1.setPrefWidth(100);
         //    tf2.setPrefWidth(100);
             if(coun==1)
             tf1.setPromptText("head");
             else
             tf1.setPromptText("data");
         //    tf2.setPromptText("To");
             
             HBox hbox1=new HBox();
             hbox1.setSpacing(10);
             hbox1.getChildren().addAll(tf1,okbutton);
             grid1.add(hbox1,0,b);
             
           

             okbutton.setOnAction(new EventHandler<ActionEvent>()
             {
                 int from,to;
                 @Override
                 public void handle(ActionEvent e)
                 {
                     boolean torf;
                     beforeend=true;
                     if ((tf1.getText() != null && !tf1.getText().isEmpty()))
                     {
                         okbutton.setStyle("-fx-font: 12 arial; -fx-base: #000000;");
                         row=GridPane.getRowIndex(hbox1);
                         s1=tf1.getText();
            //             s2=tf2.getText();
                   
                         {

                         from=Integer.parseInt(s1);
            //             to=Integer.parseInt(s2);
                         ara[row-2]=from;
                         System.out.println(row-2);
                         }
                    
                         {
                    
                         }
                     }
                     else
                     {
                         
                     }
                     
                 }
             }
             );
             b=b+1;
    }
      if(d==1)
      {
       grid1.getChildren().clear();
       d=0;
       coun=1;
       b=2;
      }
      
      return grid1;
    }
    
    void fbtn1()
    {
     BorderPane border=new BorderPane();
     
     grid1=gridinfo();
         NumberAxis xAxis = new NumberAxis();
         NumberAxis yAxis = new NumberAxis();
 
         ArrayList<Series<Number, Number>> seriesContainer = new ArrayList();
         xAxis.setLabel("Data");
         yAxis.setLabel("serial");
         
         LineChart<Number,Number> lineChart = 
                new LineChart<Number,Number>(xAxis,yAxis);
    //    lineChart.add(text);
        lineChart.setTitle("Disk Scheduling First come First Serve(FCFS)");
                          

        System.out.println("size "+ara.length);
        int i,j=0;
        for(i=1;i<ara.length;i++)
        {
          if(ara[i]!=0)
          j++  ;  
        }
        
    //    System.out.println("j==="+j);
        
        String str="Total Time = ";
        int time=0;
        for(i=1;i<j;i++)
        {
        Series<Number, Number> series1 = new Series<>();
        series1.getData().add(new XYChart.Data<>(ara[i],i));
        series1.getData().add(new XYChart.Data<>(ara[i+1],i+1));
        time=time+abs(ara[i+1]-ara[i]);
        if(i==1)
        str=str+abs(ara[i+1]-ara[i]);
        else
        str=str+" + "+abs(ara[i+1]-ara[i]);
        seriesContainer.add(series1);
        }
        System.out.println(time);
        str=str+" = "+time;
        lineChart.getData().addAll(seriesContainer);
        
        border.setTop(lineChart);
     Label text=new Label(str);
     text.setFont(new Font("Arial", 25));
     grid1.add(text, 0, 1);
     border.setBottom(grid1);
        
        scene1  = new Scene(border,800,600);
        
    }

    
    public void start(Stage primaryStage) {
        
     pristage=primaryStage;
     grid=gridinfo();
        
         HBox hbox=new HBox();
         hbox.setPadding(new Insets(15, 12, 15, 12));
         hbox.setSpacing(10);
    
          
     BorderPane border=new BorderPane();
     hbox.setStyle("-fx-background-color: #008000;");
    
     Button btn2=new Button("Add data");
     Button btn3=new Button("Finish");
     Button btn4=new Button("Refresh");
     Button btn5=new Button("Back");
     hbox.getChildren().addAll(btn2,btn3,btn4);
     
       HBox hbox1=new HBox();
       hbox1.setPadding(new Insets(0, 10, 10, 10));
    
        hbox1.setSpacing(10);
   
        btn5.setStyle("-fx-font: 18 arial; -fx-base: #b6e7c9;");
        hbox1.getChildren().add(btn5);
        border.setBottom(hbox1);
     
     border.setTop(hbox);
     border.setLeft(grid1);
     border.setBottom(hbox1);
        
         btn2.setOnAction(new EventHandler<ActionEvent>() {

             @Override
             public void handle(ActionEvent event) {
             border.setLeft(gridbybutton());
         }
        
     });
         
          btn3.setOnAction(new EventHandler<ActionEvent>()
             {
              @Override
              public void handle(ActionEvent event)
             {
              fbtn1();
              primaryStage.setScene(scene1);
              int i;
              for(i=1;i<3;i++)
              System.out.println(ara[i]);
             }        
             }
     );
     
          btn4.setOnAction(new EventHandler<ActionEvent>()
             {
             public void handle(ActionEvent event)
             {
             d=1;
             border.setLeft(gridbybutton());
             }
             }
     );
     
         btn5.setOnAction(new EventHandler<ActionEvent>()
         {
             @Override
             public void handle(ActionEvent event)
             {
                primaryStage.setScene(scenesn);
             }
         }
         );
  
    
        border.setBottom(hbox1);
        scene = new Scene(border, 420, 500);
        primaryStage.setTitle("Disk Scheduling FCFS");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }   
}