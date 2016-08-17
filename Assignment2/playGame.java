package dice;

/* Run 1:
 * The sum of dice rolled was 0
 * The minimum sum rolled was 7
 * The maximum sum rolled was 7
 */

/* Run 2:
 * The sum of dice rolled was 69893
 * The minimum sum rolled was 2
 * The maximum sum rolled was 12
 */

/* Run 3:
 * The sum of dice rolled was 58514
 * The minimum sum rolled was 2
 * The maximum sum rolled was 10
 */
public class playGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//make two variables for each dice
		Die die1 = new Die();
		Die die2 = new Die();
		
		//set all variables to 0
		int minSum = 0;
		int maxSum = 0;
		int twoDieSum = 0;
		int sum = 0;
		
		//roll dice and get total
		twoDieSum = die1.rollDie() + die2.rollDie();
		
		//set min and max to initial value
		minSum = twoDieSum;
		maxSum = twoDieSum;
		
		while(twoDieSum != 7)
		{
			sum += twoDieSum;
			
			if (twoDieSum > maxSum)
				maxSum = twoDieSum;
			if(twoDieSum < minSum)
				minSum = twoDieSum;
			
			twoDieSum = die1.rollDie() + die2.rollDie();
			//System.out.printf("Roll: %d\n", twoDieSum);
		}
		
		System.out.printf("The sum of dice rolled was %d\n", sum);
		System.out.printf("The minimum sum rolled was %d\n", minSum);
		System.out.printf("The maximum sum rolled was %d\n", maxSum);
	}

}

class Die {

	private int diceNumber;
	
	public Die()
	{
		diceNumber = 0;
	}
	
	public int rollDie()
	{	
		long seed = (new java.util.Date().getTime());
		java.util.Random rnd = new java.util.Random(seed);
		return rnd.nextInt(6) + 1;
	}
	
}
