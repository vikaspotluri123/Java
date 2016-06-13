
public class TokenPass
{
	private int [] board;
	private int currentPlayer;
	public TokenPass(int playerCount)
	{
		board = new int[playerCount]; //+1
		for(int i =0; i<board.length;i++) //+1
			board[i] = 1 + (int)(Math.random()*9); //+.5 
		currentPlayer = (int)(Math.random()*playerCount); //+1
	}
	
	public void distributeCurrentPlayerTokens()
	{
		while(//code)
		{
		advancePlayer();
		//Code to remove a token from the board //
		}
	}
}
