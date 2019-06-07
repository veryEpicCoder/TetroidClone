package gamerPackage;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;



public class Graphics extends Application {
	int Board[][];
	private static Button[][] slots = new Button[24][10];
	TetBoard board = new TetBoard();
	public static void rn(String[] args){	
		launch(args);
	}

	@Override
	public void start(Stage arg) throws Exception {
		Random random = new Random(); 
		int boardPeice = random.nextInt(7);
		board.spawnBlock(boardPeice);
		board.printBoard();
		Timer time = new Timer();
		time.schedule(new TimerTask() {

            public void run() {
        		if(board.checkLose() == true) 
        		{
        			time.cancel();
        		}
            	if(board.checkForDrop() == true) 
            	{
            		//board.moveLeft();
            		board.DropBlock();
            	}else 
            	{
            		int boardPeice = random.nextInt(7);
            		board.spawnBlock(boardPeice);
            	}
            	updateBoard(board.board);
            	board.printBoard();
            }
        },5000, 300);
		//Grid Height
		int bHight = 20; 
		//Grid Width
		int bWidth = 20;
		
		arg.setWidth(220);
		arg.setHeight(792);
		arg.setTitle("Tetrahedron");
		
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.TOP_CENTER);
		
		for (int i = 0; i < 24; i++) {
			for (int j = 0; j < 10; j++) {
					slots[i][j] = new Button();
					slots[i][j].setPrefSize(bWidth, bHight);
					slots[i][j].setStyle("-fx-base: #000000;");
			}
		}
		for (int i = 0; i < 24; i++) {
			for (int j = 0; j < 10; j++) {
				gridPane.add(slots[i][j], j,i+1);
			}
		}

		Scene myScene = new Scene(gridPane);
		arg.setScene(myScene);
		arg.show();
	
		
		myScene.setOnKeyPressed(event -> 
		{
			if(event.getCode() == event.getCode().UP) 
			{
				board.rotateRight();
				updateBoard(board.board);
			}
			if(event.getCode() == event.getCode().LEFT) 
			{
				board.moveLeft();
				updateBoard(board.board);
			}
			if(event.getCode() == event.getCode().RIGHT) 
			{
				board.moveRight();
				updateBoard(board.board);
			}
			if(event.getCode() == event.getCode().DOWN) 
			{
				if(board.checkForDrop() == true)
				{board.DropBlock();
				updateBoard(board.board);}
			}
		});
	}
	
	public void updateBoard(int[][] board) 
	{

		for(int i = 0; i < 24;i++) 
		{
			for(int j = 0; j < 10; j++) 
			{
				if(board[i][j] == 1) 
				{
					slots[i][j].setStyle("-fx-base: #0000ff;");
				}
				if(board[i][j] == 2) 
				{
					slots[i][j].setStyle("-fx-base: #ff0000;"); 
				}
				if(board[i][j] == 0) 
				{
					slots[i][j].setStyle("-fx-base: #000000;");
				}
			}
		}
	}
}
