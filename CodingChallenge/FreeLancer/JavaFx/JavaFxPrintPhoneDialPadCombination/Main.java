//package application;
	

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

//Main Class
public class Main extends Application implements EventHandler<ActionEvent> {
	
	//Stage 
	Stage window;
	
	//Array Of Alpha for dial pad
	static final String[] alpha= {
			"",
			"",
			"ABC",
			"DEF",
			"GHI",
			"JKL",
			"MNO",
			"PQRS",
			"TUV",
			"WXYZ"
	};
	
	//List to add alpha
	static final List<String> list = new ArrayList<>();
	
	
	@Override
	public void start(Stage primaryStage) {
		try {

			
			window = primaryStage;
			window.setTitle("Phone Dial");
			
			//Grid to display widget
			GridPane grid = new GridPane();
			grid.setPadding(new Insets(10,10,10,10));
			grid.setVgap(8);
			grid.setHgap(10);
			
			//Created dialpad buttons. 
			Button one = new Button("1\n     ");
			one.setAlignment(Pos.BASELINE_LEFT);
			one.setMaxWidth(60);
			GridPane.setConstraints(one, 0, 0);
			
			Button two = new Button("2\nABC");
			two.setAlignment(Pos.BASELINE_LEFT);
			two.setMaxWidth(60);
			two.setOnAction(x -> list.add(alpha[2]));
			GridPane.setConstraints(two, 1, 0);
			
			Button three = new Button("3\nDEF");
			three.setAlignment(Pos.BASELINE_LEFT);
			three.setMaxWidth(60);
			three.setOnAction(x -> list.add(alpha[3]));
			GridPane.setConstraints(three, 2, 0);
	
			Button four = new Button("4\nGHI");
			four.setOnAction(x -> list.add(alpha[4]));
			four.setAlignment(Pos.BASELINE_LEFT);
			four.setMaxWidth(60);
			GridPane.setConstraints(four, 0, 1);
			
			Button five = new Button("5\nJKL");
			five.setAlignment(Pos.BASELINE_LEFT);
			five.setMaxWidth(60);
			five.setOnAction(x -> list.add(alpha[5]));
			GridPane.setConstraints(five, 1, 1);
			
			Button six = new Button("6\nMNO");
			six.setAlignment(Pos.BASELINE_LEFT);
			six.setMaxWidth(60);
			six.setOnAction(x -> list.add(alpha[6]));
			GridPane.setConstraints(six, 2, 1);
			
			Button seven = new Button("7\nPQRS");
			seven.setAlignment(Pos.BASELINE_LEFT);
			seven.setMaxWidth(60);
			seven.setOnAction(x -> list.add(alpha[7]));
			GridPane.setConstraints(seven, 0, 2);
			
			Button eight = new Button("8\nTUV");
			eight.setAlignment(Pos.BASELINE_LEFT);
			eight.setMaxWidth(60);
			eight.setOnAction(x -> list.add(alpha[8]));
			GridPane.setConstraints(eight, 1, 2);
	
			Button nine = new Button("9\nWXYZ");
			nine.setAlignment(Pos.BASELINE_LEFT);
			nine.setMaxWidth(60);
			nine.setOnAction(x -> list.add(alpha[9]));
			GridPane.setConstraints(nine, 2, 2);
			
			Button star = new Button("*\n ");
			star.setAlignment(Pos.BASELINE_LEFT);
			star.setMaxWidth(60);
			GridPane.setConstraints(star, 0, 3);
			
			Button zero = new Button("0\n ");
			zero.setAlignment(Pos.BASELINE_LEFT);
			zero.setMaxWidth(60);
			GridPane.setConstraints(zero, 1, 3);
	
			Button hash = new Button("#\n ");
			hash.setAlignment(Pos.BASELINE_LEFT);
			hash.setMaxWidth(60);
			GridPane.setConstraints(hash, 2, 3);
			
			Button combination = new Button("Generate Combination");
			combination.setOnAction(this);
			GridPane.setConstraints(combination, 4, 4);
				
			//Add all buttons to grid
			grid.getChildren().addAll(one, two, three, four, five, six, seven, eight, nine, star, zero, hash, combination);
			Scene scene = new Scene(grid, 400, 300);
			
			//Show windoes to screen
			window.setScene(scene);
			window.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void handle(ActionEvent event) {
		printCombination("", list, 0, list.size());
		
	}
	
	//Recursion method to display the combination
	public void printCombination(String s, List<String> l, int i, int lSize){
		if(s.length() == lSize){
			System.out.println(s);
			return;
		}
		
		for(int j = 0; j < l.get(i).length(); j++){
			printCombination(s+l.get(i).charAt(j), l, i+1, lSize);
		}
		
		
	}
	
	
}
