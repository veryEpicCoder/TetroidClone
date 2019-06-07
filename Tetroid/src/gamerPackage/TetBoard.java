package gamerPackage;

public class TetBoard {
	int boardPeice;
	public int[][] board = new int[24][10];
	int activeBlock1[] = new int[2];
	int activeBlock2[] = new int[2];
	int activeBlock3[] = new int[2];
	int activeBlock4[] = new int[2];
	boolean lose =false;
	int provided = 0; 
	int state = 0;
	
	private void checkAndClearRow() 
	{
		for(int i = 0; i < 24;i++) 
		{
			boolean quickRow = true;
			int blockCounter = 0;
			for(int j = 0; j < 10 && quickRow == true;j++) 
			{
				if(board[i][j] == 1) 
				{
					blockCounter+=1;
				} 
				if(board[i][j] == 0) 
				{
					quickRow = false;
				}
				if(blockCounter == 10) 
				{
					clearRowAndDropBoard(i);
				}
			}
			blockCounter = 0;
		}
	}
	
	private void clearRowAndDropBoard(int row) 
	{
		for(int i = 0; i < 10;i++) 
		{
			board[row][i] = 0;
		}
		for(int i = row; i > 0; i--) 
		{
			for(int j = 0; j < 10;j++) 
			{
				board[i][j] = board[i-1][j];
			}
		}
	}
	
	
	
	private boolean checkMoveRight() 
	{
		if(activeBlock1[0] == 9 ||
				activeBlock2[0] == 9 ||
				activeBlock3[0] == 9 ||
				activeBlock4[0] == 9 ||
				board[activeBlock2[1]][activeBlock2[0]+1] == 1 ||
				board[activeBlock3[1]][activeBlock3[0]+1] == 1 ||
				board[activeBlock4[1]][activeBlock4[0]+1] == 1 )
		{
			return false;
		}
		return true;
	}
	
	private boolean checkMoveLeft() 
	{
		if(activeBlock1[0] == 0 ||
				activeBlock2[0] == 0 ||
				activeBlock3[0] == 0 ||
				activeBlock4[0] == 0 ||board[activeBlock1[1]][activeBlock1[0]-1] == 1 ||
				board[activeBlock2[1]][activeBlock2[0]-1] == 1 ||
				board[activeBlock3[1]][activeBlock3[0]-1] == 1 ||
				board[activeBlock4[1]][activeBlock4[0]-1] == 1 )
		{
			return false;
		}
		return true;
	}
	
	public void moveRight() 
	{
		if(checkMoveRight() == true) {
			
		String P[] = new String[4];
		int p[] = new int[4];
		p[0] = activeBlock1[0];
		p[1] = activeBlock2[0];
		p[2] = activeBlock3[0];
		p[3] = activeBlock4[0];
		Boolean b1 = false;
		Boolean b2 = false;
		Boolean b3 = false;
		Boolean b4 = false;
		
		for(int i = 0; i < 4;i++) 
		{
			for(int j = 0;j<3;j++) 
			{
				if(p[j] > p[j+1]) 
				{
					int temp;
					temp = p[j];
					p[j] = p[j+1];
					p[j+1] = temp;
				}
			}
		}
		
		for(int i = 3; i >= 0;i--) 
		{
			if(p[i] == activeBlock1[0] && b1 == false) 
			{
				b1 = true;
				P[i] = "B1";
			}
			
			else if(p[i] == activeBlock2[0] && b2 == false) 
			{
				b2 = true;
				P[i] = "B2";
			}
			
			else if(p[i] == activeBlock3[0] && b3 == false) 
			{
				b3 = true;
				P[i] = "B3";
			}
			
			else if(p[i] == activeBlock4[0] && b4 == false) 
			{
				b4 = true;
				P[i] = "B4";
			}
		}
		for(int i = 3; i > -1;i--) 
		{
			System.out.println(P[i]);
			
			if(P[i] == "B1") 
			{
				board[activeBlock1[1]][activeBlock1[0]] = 0;
				activeBlock1[0] = activeBlock1[0]+1;
				board[activeBlock1[1]][activeBlock1[0]] = 2;
			}
			
			if(P[i] == "B2") 
			{
				board[activeBlock2[1]][activeBlock2[0]] = 0;
				activeBlock2[0] = activeBlock2[0]+1;
				board[activeBlock2[1]][activeBlock2[0]] = 2;
			}
			
			if(P[i] == "B3") 
			{
				board[activeBlock3[1]][activeBlock3[0]] = 0;
				activeBlock3[0] = activeBlock3[0]+1;
				board[activeBlock3[1]][activeBlock3[0]] = 2;
			}
			
			if(P[i] == "B4") 
			{
				board[activeBlock4[1]][activeBlock4[0]] = 0;
				activeBlock4[0] = activeBlock4[0]+1;
				board[activeBlock4[1]][activeBlock4[0]] = 2;
			}
		}
		
		}
	}
	
	public void moveLeft() 
	{
		if(checkMoveLeft() == true) {
			
		String P[] = new String[4];
		int p[] = new int[4];
		p[0] = activeBlock1[0];
		p[1] = activeBlock2[0];
		p[2] = activeBlock3[0];
		p[3] = activeBlock4[0];
		Boolean b1 = false;
		Boolean b2 = false;
		Boolean b3 = false;
		Boolean b4 = false;
		
		for(int i = 0; i < 4;i++) 
		{
			for(int j = 0;j<3;j++) 
			{
				if(p[j] > p[j+1]) 
				{
					int temp;
					temp = p[j];
					p[j] = p[j+1];
					p[j+1] = temp;
				}
			}
		}
		
		for(int i = 3; i >= 0;i--) 
		{
			if(p[i] == activeBlock1[0] && b1 == false) 
			{
				b1 = true;
				P[i] = "B1";
			}
			
			else if(p[i] == activeBlock2[0] && b2 == false) 
			{
				b2 = true;
				P[i] = "B2";
			}
			
			else if(p[i] == activeBlock3[0] && b3 == false) 
			{
				b3 = true;
				P[i] = "B3";
			}
			
			else if(p[i] == activeBlock4[0] && b4 == false) 
			{
				b4 = true;
				P[i] = "B4";
			}
		}
		for(int i = 3; i > -1;i--) 
		{
			System.out.println(P[i]);
			
			if(P[i] == "B1") 
			{
				board[activeBlock1[1]][activeBlock1[0]] = 0;
				activeBlock1[0] = activeBlock1[0]-1;
				board[activeBlock1[1]][activeBlock1[0]] = 2;
			}
			
			if(P[i] == "B2") 
			{
				board[activeBlock2[1]][activeBlock2[0]] = 0;
				activeBlock2[0] = activeBlock2[0]-1;
				board[activeBlock2[1]][activeBlock2[0]] = 2;
			}
			
			if(P[i] == "B3") 
			{
				board[activeBlock3[1]][activeBlock3[0]] = 0;
				activeBlock3[0] = activeBlock3[0]-1;
				board[activeBlock3[1]][activeBlock3[0]] = 2;
			}
			
			if(P[i] == "B4") 
			{
				board[activeBlock4[1]][activeBlock4[0]] = 0;
				activeBlock4[0] = activeBlock4[0]-1;
				board[activeBlock4[1]][activeBlock4[0]] = 2;
			}
		}
		
		}
	}
	
	private void replaceBlocks(int b1x,int b2x,int b3x,int b4x,
			int b1y, int b2y, int b3y, int b4y) 
	{
		board[activeBlock1[1]][activeBlock1[0]] = 0;
		board[activeBlock2[1]][activeBlock2[0]] = 0;
		board[activeBlock3[1]][activeBlock3[0]] = 0;
		board[activeBlock4[1]][activeBlock4[0]] = 0;
		
		activeBlock1[0] = b1x;
		activeBlock1[1] = b1y;
		activeBlock2[0] = b2x;
		activeBlock2[1] = b2y;
		activeBlock3[0] = b3x;
		activeBlock3[1] = b3y;
		activeBlock4[0] = b4x;
		activeBlock4[1] = b4y;
		
		board[activeBlock1[1]][activeBlock1[0]] = 2;
		board[activeBlock2[1]][activeBlock2[0]] = 2;
		board[activeBlock3[1]][activeBlock3[0]] = 2;
		board[activeBlock4[1]][activeBlock4[0]] = 2;
		
	}
	
	public void rotateRight() 
	{
		if(boardPeice == 0) 
		{
			System.out.println("No Change");
		}
		System.out.println("Rotate");
		if(boardPeice == 1) 
		{
			if(state == 1 &&
					board[activeBlock1[1]][activeBlock1[0]+1] != 1 &&
					board[activeBlock1[1]+1][activeBlock1[0]+1] != 1 &&
					activeBlock1[0] != 9)
			{
				replaceBlocks(activeBlock1[0]+1,activeBlock2[0]+2,activeBlock3[0]+1,
						activeBlock4[0],activeBlock1[1]+1,activeBlock2[1],
						activeBlock3[1]-1,activeBlock4[1]-2);
			} 
			if((state == 2 && activeBlock1[1] !=23)&& 
					board[activeBlock1[1]+1][activeBlock1[0]-2] != 1 &&
					board[activeBlock1[1]+1][activeBlock1[0]-1] != 1 &&
					board[activeBlock1[1]][activeBlock1[0]-1] != 1) 
			{
				replaceBlocks(activeBlock1[0]-2,activeBlock2[0]-1,activeBlock3[0],
						activeBlock4[0]+1,activeBlock1[1]+1,activeBlock2[1]+2,
						activeBlock3[1]+1,activeBlock4[1]);
			}
			if(state == 3 && activeBlock1[0] != 0 &&
					board[activeBlock1[1]+1][activeBlock1[0]] != 1&&
					board[activeBlock1[1]+1][activeBlock1[0]-1] != 1&&
					board[activeBlock1[1]+2][activeBlock1[0]-1] != 1) 
			{
				replaceBlocks(activeBlock1[0]-1,activeBlock2[0]-2,activeBlock3[0]-1,
						activeBlock4[0],activeBlock1[1]-2,activeBlock2[1]-1,
						activeBlock3[1],activeBlock4[1]+1);
			}
			if(state == 4 && activeBlock1[1] != 23 &&
					board[activeBlock1[1]][activeBlock1[0]+2] != 1&&
					board[activeBlock1[1]][activeBlock1[0]+1] != 1&&
					board[activeBlock1[1]+2][activeBlock1[0]+1] != 1) 
			{
				replaceBlocks(activeBlock1[0]+2,activeBlock2[0]+1,activeBlock3[0],
						activeBlock4[0]-1,activeBlock1[1],activeBlock2[1]-1,
						activeBlock3[1],activeBlock4[1]+1);
				state =0;
			}
			state +=1;
		}

		if(boardPeice == 2) 
		{
			if(state == 1) 
			{
				replaceBlocks(activeBlock1[0]+1,activeBlock2[0],activeBlock3[0]-1,
						activeBlock4[0]-2,activeBlock1[1],activeBlock2[1]+1,
						activeBlock3[1],activeBlock4[1]-1);
			}
			if(state == 2) 
			{
				replaceBlocks(activeBlock1[0],activeBlock2[0]-1,activeBlock3[0],
						activeBlock4[0]+1,activeBlock1[1]+2,activeBlock2[1]+1,
						activeBlock3[1],activeBlock4[1]-1);
			}
			if(state == 3) 
			{
				replaceBlocks(activeBlock1[0]-1,activeBlock2[0],activeBlock3[0]+1,
						activeBlock4[0]+2,activeBlock1[1]-1,activeBlock2[1]-2,
						activeBlock3[1]-1,activeBlock4[1]);
			}
			if(state == 4) 
			{
				replaceBlocks(activeBlock1[0],activeBlock2[0]+1,activeBlock3[0],
						activeBlock4[0]-1,activeBlock1[1]-1,activeBlock2[1],
						activeBlock3[1]+1,activeBlock4[1]+2);
				state =0;
			}
			state +=1;
		}
		
		if(boardPeice == 3) 
		{
			if(state == 1) 
			{
				replaceBlocks(activeBlock1[0]+2,activeBlock2[0]+1,activeBlock3[0],
						activeBlock4[0]-1,activeBlock1[1]+1,activeBlock2[1],
						activeBlock3[1]-1,activeBlock4[1]-2);
			}
			if(state == 2) 
			{
				replaceBlocks(activeBlock1[0]-1,activeBlock2[0],activeBlock3[0]+1,
						activeBlock4[0]+2,activeBlock1[1]+2,activeBlock2[1]+1,
						activeBlock3[1],activeBlock4[1]-1);
			}
			if(state == 3) 
			{
				replaceBlocks(activeBlock1[0]-2,activeBlock2[0]-1,activeBlock3[0],
						activeBlock4[0]+1,activeBlock1[1]-1,activeBlock2[1],
						activeBlock3[1]+1,activeBlock4[1]+2);
			}
			if(state == 4) 
			{
				replaceBlocks(activeBlock1[0]+2,activeBlock2[0]+1,activeBlock3[0],
						activeBlock4[0]-1,activeBlock1[1]-1,activeBlock2[1],
						activeBlock3[1]+1,activeBlock4[1]+2);
				state =0;
			}
			state +=1;
		}
		
		if(boardPeice == 4) 
		{
			if(state == 1) 
			{
				replaceBlocks(activeBlock1[0],activeBlock2[0],activeBlock3[0]-1,
						activeBlock4[0]-2,activeBlock1[1],activeBlock2[1]-2,
						activeBlock3[1]-1,activeBlock4[1]);
			}
			if(state == 2) 
			{
				replaceBlocks(activeBlock1[0],activeBlock2[0]+2,activeBlock3[0]+1,
						activeBlock4[0],activeBlock1[1],activeBlock2[1],
						activeBlock3[1]-1,activeBlock4[1]-2);
			}
			if(state == 3) 
			{
				replaceBlocks(activeBlock1[0],activeBlock2[0],activeBlock3[0]+1,
						activeBlock4[0]+2,activeBlock1[1],activeBlock2[1]+2,
						activeBlock3[1]+1,activeBlock4[1]);
			}
			if(state == 4) 
			{
				replaceBlocks(activeBlock1[0],activeBlock2[0]-2,activeBlock3[0]-1,
						activeBlock4[0],activeBlock1[1],activeBlock2[1],
						activeBlock3[1]+1,activeBlock4[1]+2);
				state =0;
			}
			state +=1;
		}
		
		if(boardPeice == 5) 
		{
			if(state == 1) 
			{
				replaceBlocks(activeBlock1[0]+1,activeBlock2[0],activeBlock3[0]+1,
						activeBlock4[0],activeBlock1[1]+2,activeBlock2[1]+1,
						activeBlock3[1],activeBlock4[1]-1);
			}
			if(state == 2) 
			{
				replaceBlocks(activeBlock1[0]-2,activeBlock2[0]-1,activeBlock3[0],
						activeBlock4[0]+1,activeBlock1[1],activeBlock2[1]-1,
						activeBlock3[1],activeBlock4[1]-1);
			}
			if(state == 3) 
			{
				replaceBlocks(activeBlock1[0],activeBlock2[0]+1,activeBlock3[0],
						activeBlock4[0]+1,activeBlock1[1]-1,activeBlock2[1],
						activeBlock3[1]+1,activeBlock4[1]+2);
			}
			if(state == 4) 
			{
				replaceBlocks(activeBlock1[0]+1,activeBlock2[0],activeBlock3[0]-1,
						activeBlock4[0]-2,activeBlock1[1]-1,activeBlock2[1],
						activeBlock3[1]-1,activeBlock4[1]);
				state =0;
			}
			state +=1;
		}
		
		if(boardPeice == 6) 
		{
			if(state == 1) 
			{
				replaceBlocks(activeBlock1[0]+1,activeBlock2[0],activeBlock3[0]-1,
						activeBlock4[0]-2,activeBlock1[1],activeBlock2[1]-1,
						activeBlock3[1],activeBlock4[1]-1);
			}
			if(state == 2) 
			{
				replaceBlocks(activeBlock1[0],activeBlock2[0]+1,activeBlock3[0],
						activeBlock4[0]+1,activeBlock1[1]+2,activeBlock2[1]+1,
						activeBlock3[1],activeBlock4[1]-1);
			}
			if(state == 3) 
			{
				replaceBlocks(activeBlock1[0]-2,activeBlock2[0]-1,activeBlock3[0],
						activeBlock4[0]+1,activeBlock1[1]-1,activeBlock2[1],
						activeBlock3[1]-1,activeBlock4[1]);
			}
			if(state == 4) 
			{
				replaceBlocks(activeBlock1[0]+1,activeBlock2[0],activeBlock3[0]+1,
						activeBlock4[0],activeBlock1[1]-1,activeBlock2[1],
						activeBlock3[1]+1,activeBlock4[1]+2);
				state =0;
			}
			state +=1;
		}
	}
	
	TetBoard() 
	{
		for(int i = 0; i < 24;i++) 
		{
			for(int j = 0; j < 10;j++) 
			{
				board[i][j] = 0; 
			}
		}
	}
	
	public void printBoard() 
	{
		for(int i = 0; i < 24;i++) 
		{
			for(int j = 0; j < 10;j++) 
			{
				System.out.print(board[i][j]+" ");
				
			}
			System.out.println("");
		}
	}
	
	public void spawnBlock(int peiceType) 
	{
		state = 1;
		boardPeice = peiceType;
		if(boardPeice == 0) 
		{
		activeBlock1[0] = 4;
		activeBlock1[1] = 0;
		board[activeBlock1[1]][activeBlock1[0]] = 2;
		activeBlock2[0] = 5;
		activeBlock2[1] = 0;
		board[activeBlock2[1]][activeBlock2[0]] = 2;
		activeBlock3[0] = 4;
		activeBlock3[1] = 1;
		board[activeBlock3[1]][activeBlock3[0]] = 2;
		activeBlock4[0] = 5;
		activeBlock4[1] = 1;
		board[activeBlock4[1]][activeBlock4[0]] = 2;
		}
		
		if(boardPeice == 1) 
		{
		activeBlock1[0] = 5;
		activeBlock1[1] = 0;
		board[activeBlock1[1]][activeBlock1[0]] = 2;
		activeBlock2[0] = 4;
		activeBlock2[1] = 0;
		board[activeBlock2[1]][activeBlock2[0]] = 2;
		activeBlock3[0] = 4;
		activeBlock3[1] = 1;
		board[activeBlock3[1]][activeBlock3[0]] = 2;
		activeBlock4[0] = 4;
		activeBlock4[1] = 2;
		board[activeBlock4[1]][activeBlock4[0]] = 2;
		}
		
		if(boardPeice == 2) 
		{
		activeBlock1[0] = 4;
		activeBlock1[1] = 0;
		board[activeBlock1[1]][activeBlock1[0]] = 2;
		activeBlock2[0] = 5;
		activeBlock2[1] = 0;
		board[activeBlock2[1]][activeBlock2[0]] = 2;
		activeBlock3[0] = 5;
		activeBlock3[1] = 1;
		board[activeBlock3[1]][activeBlock3[0]] = 2;
		activeBlock4[0] = 5;
		activeBlock4[1] = 2;
		board[activeBlock4[1]][activeBlock4[0]] = 2;
		}
		
		if(boardPeice == 3) 
		{
		activeBlock1[0] = 4;
		activeBlock1[1] = 0;
		board[activeBlock1[1]][activeBlock1[0]] = 2;
		activeBlock2[0] = 4;
		activeBlock2[1] = 1;
		board[activeBlock2[1]][activeBlock2[0]] = 2;
		activeBlock3[0] = 4;
		activeBlock3[1] = 2;
		board[activeBlock3[1]][activeBlock3[0]] = 2;
		activeBlock4[0] = 4;
		activeBlock4[1] = 3;
		board[activeBlock4[1]][activeBlock4[0]] = 2;
		}
		
		if(boardPeice == 4) 
		{
		activeBlock1[0] = 4;
		activeBlock1[1] = 0;
		board[activeBlock1[1]][activeBlock1[0]] = 2;
		activeBlock2[0] = 3;
		activeBlock2[1] = 1;
		board[activeBlock2[1]][activeBlock2[0]] = 2;
		activeBlock3[0] = 4;
		activeBlock3[1] = 1;
		board[activeBlock3[1]][activeBlock3[0]] = 2;
		activeBlock4[0] = 5;
		activeBlock4[1] = 1;
		board[activeBlock4[1]][activeBlock4[0]] = 2;
		}
		
		if(boardPeice == 5) 
		{
		activeBlock1[0] = 5;
		activeBlock1[1] = 0;
		board[activeBlock1[1]][activeBlock1[0]] = 2;
		activeBlock2[0] = 5;
		activeBlock2[1] = 1;
		board[activeBlock2[1]][activeBlock2[0]] = 2;
		activeBlock3[0] = 4;
		activeBlock3[1] = 1;
		board[activeBlock3[1]][activeBlock3[0]] = 2;
		activeBlock4[0] = 4;
		activeBlock4[1] = 2;
		board[activeBlock4[1]][activeBlock4[0]] = 2;
		}
		
		if(boardPeice == 6) 
		{
		activeBlock1[0] = 4;
		activeBlock1[1] = 0;
		board[activeBlock1[1]][activeBlock1[0]] = 2;
		activeBlock2[0] = 4;
		activeBlock2[1] = 1;
		board[activeBlock2[1]][activeBlock2[0]] = 2;
		activeBlock3[0] = 5;
		activeBlock3[1] = 1;
		board[activeBlock3[1]][activeBlock3[0]] = 2;
		activeBlock4[0] = 5;
		activeBlock4[1] = 2;
		board[activeBlock4[1]][activeBlock4[0]] = 2;
		}
	}
	
	private String[] getPriority() 
	{
		String[] P = new String[4];
		int[] p = new int[4];
		p[0] = activeBlock1[1];
		p[1] = activeBlock2[1];
		p[2] = activeBlock3[1];
		p[3] = activeBlock4[1];
		Boolean b1 = false;
		Boolean b2 = false;
		Boolean b3 = false;
		Boolean b4 = false;
		
		for(int i = 0; i < 4;i++) 
		{
			for(int j = 0;j<3;j++) 
			{
				if(p[j] > p[j+1]) 
				{
					int temp;
					temp = p[j];
					p[j] = p[j+1];
					p[j+1] = temp;
				}
			}
		}
		
		for(int i = 3; i >= 0;i--) 
		{
			if(p[i] == activeBlock1[1] && b1 == false) 
			{
				b1 = true;
				P[i] = "B1";
			}
			
			else if(p[i] == activeBlock2[1] && b2 == false) 
			{
				b2 = true;
				P[i] = "B2";
			}
			
			else if(p[i] == activeBlock3[1] && b3 == false) 
			{
				b3 = true;
				P[i] = "B3";
			}
			
			else if(p[i] == activeBlock4[1] && b4 == false) 
			{
				b4 = true;
				P[i] = "B4";
			}
		}
		return P;
	}
	
	public void DropBlock() 
	{
		String[] Pri = getPriority();
		for(int i = 3; i > -1;i--) 
		{
			System.out.println(Pri[i]);
			
			if(Pri[i] == "B1") 
			{
				board[activeBlock1[1]][activeBlock1[0]] = 0;
				activeBlock1[1] = activeBlock1[1]+1;
				board[activeBlock1[1]][activeBlock1[0]] = 2;
			}
			
			if(Pri[i] == "B2") 
			{
				board[activeBlock2[1]][activeBlock2[0]] = 0;
				activeBlock2[1] = activeBlock2[1]+1;
				board[activeBlock2[1]][activeBlock2[0]] = 2;
			}
			
			if(Pri[i] == "B3") 
			{
				board[activeBlock3[1]][activeBlock3[0]] = 0;
				activeBlock3[1] = activeBlock3[1]+1;
				board[activeBlock3[1]][activeBlock3[0]] = 2;
			}
			
			if(Pri[i] == "B4") 
			{
				board[activeBlock4[1]][activeBlock4[0]] = 0;
				activeBlock4[1] = activeBlock4[1]+1;
				board[activeBlock4[1]][activeBlock4[0]] = 2;
			}
		}
		System.out.println("Drop");
	}
	
	public boolean checkForDrop() 
	{
		if(activeBlock1[1] == 23 || board[activeBlock1[1]+1][activeBlock1[0]] == 1) 
		{
			setBlock();
			return false;
		}
		if(activeBlock2[1] == 23 || board[activeBlock2[1]+1][activeBlock2[0]] == 1) 
		{
			setBlock();
			return false;
		}
		if(activeBlock3[1] == 23 || board[activeBlock3[1]+1][activeBlock3[0]] == 1) 
		{
			setBlock();
			return false;
		}
		if(activeBlock4[1] == 23 || board[activeBlock4[1]+1][activeBlock4[0]] == 1) 
		{
			setBlock();
			return false;
		}
		return true;
		
	}
	
	private void setBlock() 
	{
		board[activeBlock1[1]][activeBlock1[0]] = 1;
		board[activeBlock2[1]][activeBlock2[0]] = 1;
		board[activeBlock3[1]][activeBlock3[0]] = 1;
		board[activeBlock4[1]][activeBlock4[0]] = 1;
		checkAndClearRow();
		if(activeBlock1[1] == 0 ||
				activeBlock2[1] == 0 ||
				activeBlock3[1] == 0 ||
				activeBlock4[1] == 0) 
		{
			lose = true;
		}
	}
	
	public boolean checkLose() 
	{
		for(int i = 0; i < 10;i++) 
		{
			if(board[0][i] == 1) 
			{
				System.out.println("You lose");
				return true;
			}
		}
		if(lose == true) 
		{
			return true;
		}
		System.out.println("Continue");
		return false;
	}
}
