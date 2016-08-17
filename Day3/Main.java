package simpleCraps;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Die die1 = new Die();
		Die die2 = new Die();

		//winning number is 7
		//losing numbers are 2,3,12
		
		//initialize the counters and value holders to 0
		int totalGames = 100;
		int diceSum = 0;
		int currentPoint = 0;
		int die1Num = 0, die2Num = 0;
		int gamesWon = 0;
		boolean win, gameOver;
		boolean pointRolled = false;
		
		for(int i = 0; i <= totalGames;i++)
		{
			win = false; gameOver = false;
			while(!win && !gameOver)
			{
				diceSum = die1.rollDie() + die2.rollDie();
				//System.out.println("The roll was: " + diceSum);
				if(!pointRolled)
				{
					if(diceSum == 7)
					{	
						win = true;
						gamesWon++;
					}
					else if (diceSum == 2 || diceSum == 3 || diceSum == 12)
					{	gameOver = true;	}
					else 
					{	
						currentPoint = diceSum;
						pointRolled = true;
					}
				}
				else
				{
					if(diceSum == currentPoint)
					{	
						win = true;
						gamesWon++;
					}
					else if (diceSum == 7)
					{	gameOver = true;	}
				}
			}
			//if(gameOver)
			//	System.out.println("You lose!");
			//else if(win)
			//	System.out.println("You win!");
		}
		
		System.out.println("Games played: " + totalGames);
		System.out.println("Games won:    " + gamesWon);
		System.out.println("Games lost:   " + (totalGames - gamesWon));
	}
}

class Die {

	//private int diceNumber;
	private Random rnd;
	
	public Die()
	{
		//diceNumber = 0;
		long seed = (new java.util.Date().getTime());
		//rnd = new Random(seed);
		rnd = new Random();
	}
	
	public int rollDie()
	{	
		return rnd.nextInt(6) + 1;
	}
	
}