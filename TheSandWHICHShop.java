package application;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TheSandWHICHShop extends Application {
	
	NumberFormat money = NumberFormat.getCurrencyInstance();
	
	 HBox breadChoice;
	 TitledPane breadPane;
	 RadioButton italian, wholeWheat, rosemary, sourdough;
	 ToggleGroup breadGroup;
	 
	 HBox meatChoice;
	 TitledPane meatPane;
	 RadioButton chicken, turkey, ham, tuna;
	 ToggleGroup meatGroup;
	 
	 TitledPane toppingsPane;
	 CheckBox lettuce, cheese, tomato, mayo, pickles, onion;
	 VBox checkVBox;
	 
	 Label textField;
	 Label textFieldOrder;
	
	double price = 0.00;
	
	 public void start(Stage primaryStage) {
		 
		 
		 Label name = new Label("The SandWHICH Shop");
		 HBox titleHBox = new HBox();
		 titleHBox.setAlignment(Pos.CENTER);
		 name.setFont(Font.font("Comic Sans", FontWeight.BOLD, 20));
		 titleHBox.getChildren().add(name);
  
		 
		//Create bread section and buttons
    
		 breadGroup = new ToggleGroup();
		 italian = new RadioButton("Italian");
		 italian.setToggleGroup(breadGroup);
		 wholeWheat = new RadioButton("Whole Wheat");
		 wholeWheat.setToggleGroup(breadGroup);
		 rosemary = new RadioButton("Rosemary");
		 rosemary.setToggleGroup(breadGroup);
		 sourdough = new RadioButton("Sourdough");
		 sourdough.setToggleGroup(breadGroup);
		 italian.setSelected(true);
	
		 breadChoice = new HBox(50);
		 breadChoice.getChildren().addAll(italian, wholeWheat, rosemary, sourdough);
		 // Adding radio buttons to pane
		 breadPane = new TitledPane("Bread", breadChoice);
		 breadPane.setCollapsible(false);
		 breadPane.setPrefHeight(75);
   
    
		 //Creating the meat section and buttons
		 
		 meatGroup = new ToggleGroup();
		 // Creating radio buttons
		 chicken = new RadioButton("Chicken");
		 chicken.setToggleGroup(meatGroup);
		 turkey = new RadioButton("Turkey");
		 turkey.setToggleGroup(meatGroup);
		 ham = new RadioButton("Ham");
		 ham.setToggleGroup(meatGroup);
		 tuna = new RadioButton("Tuna");
		 tuna.setToggleGroup(meatGroup);
		 chicken.setSelected(true);
		 
		 meatChoice = new HBox(50);
		 meatChoice.getChildren().addAll(chicken, turkey, ham, tuna);
		 meatPane = new TitledPane("Meat", meatChoice);
		 meatPane.setCollapsible(false);
		 meatPane.setPrefHeight(75);
		 
		 
		 // Create toppings sections and buttons
		 
		 checkVBox = new VBox();
		 checkVBox.setSpacing(10);
		 checkVBox.setPadding(new Insets(50));
		 
		 lettuce = new CheckBox("Lettuce add $0.50");
		 cheese = new CheckBox("Cheese add $1.25");
		 tomato = new CheckBox("Tomato add $0.50");
		 mayo = new CheckBox("Mayo add $0.85");
		 pickles = new CheckBox("Pickles add $0.50");
		 onion = new CheckBox("Onion add $0.50");
		 
		 GridPane toppingsGridPane = new GridPane();
		 toppingsGridPane.add(lettuce, 0, 0);
		 toppingsGridPane.add(cheese, 0, 1);
		 toppingsGridPane.add(tomato, 0, 2);
		 toppingsGridPane.add(mayo, 0, 3);
		 toppingsGridPane.add(pickles, 0, 4);
		 toppingsGridPane.add(onion, 0, 5);
	     toppingsPane = new TitledPane("Toppings", toppingsGridPane);
	     toppingsPane.setPrefHeight(150);
	     toppingsPane.setCollapsible(false);
		
	     
	     HBox buttonHBox;
	     VBox main;
	     Button totalButton, clearOrderButton;
	     Label l = new Label("Total");
	     l.setFont(Font.font("Comic Sans", 16));
	     
	     textField = new Label();
	     textFieldOrder = new Label();
	    		 
	       
	     totalButton = new Button("Add Item");
	     totalButton.setPrefWidth(80);
	     totalButton.setPrefHeight(50);
	     
	     
	     ////// Second Window
	        HBox layout2= new HBox(200);
	       
	        layout2.setPrefSize(700, 100);
	        layout2.getChildren().addAll(l, textField, textFieldOrder);
	        Scene newScene = new Scene(layout2);
	        
	        Label totalWithTax = new Label("Total with Tax");
	    ///// End of second window
	        
	        //Button to place order - opens new window
	        Button newWindow = new Button("Place Order");
	        newWindow.setPrefWidth(95);
		    newWindow.setPrefHeight(50);
	        newWindow.setOnAction(e -> primaryStage.setScene(newScene));  
	        
	       
	        totalButton.setOnAction(e -> SubmitButtonClick());
	       
	        clearOrderButton = new Button("Clear");
	        clearOrderButton.setPrefWidth(65);
	        clearOrderButton.setPrefHeight(50);
	       
	        clearOrderButton.setOnAction(e -> ClearOrderButtonClick());
	        buttonHBox = new HBox(50);
	        buttonHBox.setPadding(new Insets(10, 10, 10, 10));
	        buttonHBox.setSpacing(10);
	       
	        buttonHBox.setStyle("-fx-border-style: solid;"
	                + "-fx-border-width: 1;"
	                + "-fx-border-color: grey");
	        
	       
	        buttonHBox.getChildren().addAll(clearOrderButton, totalButton, newWindow);
	       
	        
	      //Main scene
	        main = new VBox(10);
	        main.setPadding(new Insets (20));
	        main.getChildren().addAll(name, breadPane, meatPane, toppingsPane, buttonHBox);
	      
	       
	       
	        Scene scene = new Scene(main);
	        primaryStage.setTitle("The SandWHICH Shop");
	        primaryStage.setScene(scene);
	        primaryStage.show();
	        
	        
	       
	    }
	
	 public static void main(String[] args) {
	        launch(args);
	    }
	  
	 	// Price for a sandwich without toppings
	    // i is bread, j is meat
	 	// All bread types cost the same - meat is the price difference
	    public double sandwichPrice(int i,int j){
	        double[][] sandwich = new double[4][4];
	        
	        // Meat Choice Chicken
	        sandwich[0][0]= 7.75; //italian 
	        sandwich[1][0]= 7.75; //whole wheat 
	        sandwich[2][0]= 7.75; // rosemary 
	        sandwich[3][0] = 7.75; // sourdough 
	        
	        // Meat Choice Turkey
	        sandwich[0][1]= 6.75; //italian 
	        sandwich[1][1]= 6.75; //whole wheat
	        sandwich[2][1]= 6.75; // rosemary 
	        sandwich[3][1] = 6.75;// sourdough 
	        
	        // Meat Choice Ham
	        sandwich[0][2]= 7.75; //italian 
	        sandwich[1][2]= 7.75; //whole wheat
	        sandwich[2][2]= 7.75; // rosemary 
	        sandwich[3][2] = 7.75; // sourdough 
	        
	        // Meat Choice Tuna
	        sandwich[0][3] = 6.35; //italian 
	        sandwich[1][3] = 6.35; //whole wheat
	        sandwich[2][3] = 6.35; // rosemary 
	        sandwich[3][3] = 6.35; // sourdough 
	        
	        return sandwich[i][j];
	        
	    }
	    
	    
	    	// Topping prices
	    public double toppingsPrice(int i, int k){
	    
	        double[][] toppings = new double[4][6];
	        
	        //Toppings with Chicken
	        toppings[0][0] = 0.50; // lettuce
	        toppings[0][1] = 0.85; // mayo
	        toppings[0][2] = 1.25; // cheese
	        toppings[0][3] = 0.50; // pickles
	        toppings[0][4] = 0.50; // tomato
	        toppings[0][5] = 0.50; // onion
	        
	        //Toppings with Turkey
	        toppings[1][0] = 0.50; // lettuce
	        toppings[1][1] = 0.85; // mayo
	        toppings[1][2] = 1.25; // cheese
	        toppings[1][3] = 0.50; // pickles
	        toppings[1][4] = 0.50; // tomato
	        toppings[1][5] = 0.50; // onion
	        
	        //Toppings with Ham
	        toppings[2][0] = 0.50; // lettuce
	        toppings[2][1] = 0.85; // mayo
	        toppings[2][2] = 1.25; // cheese
	        toppings[2][3] = 0.50; // pickles
	        toppings[2][4] = 0.50; // tomato
	        toppings[2][5] = 0.50; // onion
	        
	        //Toppings with Tuna
	        toppings[3][0] = 0.50; // lettuce
	        toppings[3][1] = 0.85; // mayo
	        toppings[3][2] = 1.25; // cheese
	        toppings[3][3] = 0.50; // pickles
	        toppings[3][4] = 0.50; // tomato
	        toppings[3][5] = 0.50; // onion
	        
	        return toppings[i][k];
	    }
	    
	    public String toppingsName(int i, int k) {
	    	String name = "";
	    	
	    	name = name + toppingsName(i,k);
	    	return name;
	    }
	 
	 private void SubmitButtonClick() {
	        int i=0,j=0,k=0;
	        String name = "";
	      
	       if(italian.isSelected()){
	           i = 0;
	           name = name + "Italian Bread ";
	       }
	       if(wholeWheat.isSelected()){
	           i = 1;
	           name = name + "Wheat Bread ";
	       }
	       if(rosemary.isSelected()){
	           i = 2;
	           name = name + "Rosemary Bread ";
	       }
	       if(sourdough.isSelected()){
	           i = 3;
	           name = name + "Sourdough Bread ";
	       }
	       if(chicken.isSelected()){
	           j = 0;
	           name = name + "Chicken ";
	           
	       }
	       if(turkey.isSelected()){
	           j = 1;
	           name = name + "Turkey ";
	       }
	       if(ham.isSelected()){
	           j = 2;
	          name = name + "Ham ";
	       }
	       if(tuna.isSelected()){
	           j = 3;
	           name = name + "Tuna ";
	       }
	       // Calculating price for plain pizza
	       price = price + sandwichPrice(i,j);
	       
	       // Calculating prize for toppings
	       if(lettuce.isSelected()){
	           k = 0;
	           price = price + toppingsPrice(j,k);
	           name = name + "add lettuce ";
	       }
	       if(mayo.isSelected()){
	           k = 1;
	           price = price + toppingsPrice(j,k);
	           name = name + "add mayo ";
	       }
	       if(cheese.isSelected()){
	           k = 2;
	           price = price + toppingsPrice(j,k);
	           name = name + "add cheese ";
	       }
	       if(pickles.isSelected()){
	           k = 3;
	           price = price + toppingsPrice(j,k);
	           name = name + "add pickles ";
	       }
	       if(tomato.isSelected()){
	           k = 4;
	           price = price + toppingsPrice(j,k);
	           name = name + "add tomato ";
	       }
	       if(onion.isSelected()){
	           k = 5;
	           price = price + toppingsPrice(j,k);
	           name = name + "add onion ";
	       }
	       
	       //format price and calculate with tax
	       DecimalFormat decimal = new DecimalFormat("$0.00");
	       
	       double finalPrice = 1.065*price;
	       String formatPrice = decimal.format(finalPrice);
	       
	       
	       textField.setText(decimal.format(price)); 
	       textFieldOrder.setText("The total with tax is " + formatPrice);
	       
	       //store sandwiches in an Arraylist
	       ArrayList<String> orderToPrint = new ArrayList<String>();
	       orderToPrint.add(name);
	       System.out.println(orderToPrint);
	       
	       
	    }
	 //inital button settings
	    private void ClearOrderButtonClick() {
	        price=0;
	        italian.setSelected(true);
	        chicken.setSelected(true);
	        lettuce.setSelected(false);
	        mayo.setSelected(false);
	        cheese.setSelected(false);
	        pickles.setSelected(false);
	        tomato.setSelected(false);
	        onion.setSelected(false);
	        textField.setText("");
	        textFieldOrder.setText("");
	    
	    }
	    
	    
	}
