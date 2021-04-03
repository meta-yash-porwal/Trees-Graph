import java.util.*;

/**
 * this class is used to find the order of the bowler so that 
 * Virat score as low as possible 
 * A cricket team is playing against Virat Kohli 
 * and we want him to score as low as possible. 
 * Virat scores max runs on the bowler who has minimum balls left to bowl.
 * @author yash.porwal_metacube
 *
 */
public class vKohli {
	/**
	  * Used to get the order of balls bowled by which bowler
	  * 
	  * @param numberOfBalls
	  *            total number of balls left in match
	  * @param numberOfBowlers
	  *            total number of bowlers left
	  * @param ballsForEachBowler
	  *            balls per each bowler
	  * @return array of order of bowlers should be bowled
	  */
	public static int[] findOrderOfBowlers(int numberOfBalls,
			int numberOfBowlers, int ballsForEachBowler[]) {
		int arrangedOrderOfBowlers[] = new int[numberOfBalls];

		if (numberOfBowlers != ballsForEachBowler.length) {
			throw new AssertionError("bowls allocation per bowler is incorrect");
		}

		int sum = 0;
		for (int ball : ballsForEachBowler) {
			sum += ball;
		}

		if (sum < numberOfBalls) {
			throw new AssertionError("Number of balls and its sum is not equal");
		}

		Map<Integer, Integer> ballsPerBowler = 
				new HashMap<Integer, Integer>();
		int key = 0;
		for (int i = 0; i < numberOfBowlers; i++) {
			ballsPerBowler.put(++key, ballsForEachBowler[i]);
		}

		int i = 0;

		while (numberOfBalls != 0) {

			int maxBalls = Collections.max(ballsPerBowler.values());
			for (Map.Entry<Integer, Integer> entry : ballsPerBowler.entrySet()) {

				if (entry.getValue() == maxBalls) {
					int bowlerIndex = entry.getKey();

					arrangedOrderOfBowlers[i++] = bowlerIndex;

					ballsPerBowler.put(bowlerIndex, --maxBalls);
					numberOfBalls--;
					break;
				}
			}
		}
		return arrangedOrderOfBowlers;
	}
	public static void main( String args[]){
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter number of bowlers : ");
		int i,j, numOfBowlers = sc.nextInt();
		int ballPerBowler[]=new int[numOfBowlers];
		int ballsLeft;
		System.out.println("*******************************************************************************************************************************************************");
		for( i=0 ; i<numOfBowlers; i++){
			System.out.println("\nEnter number of balls left for bowler " + (i+1) + " : ");
			ballsLeft = sc.nextInt();
			ballPerBowler[i] = ballsLeft;
		}
		System.out.println("*******************************************************************************************************************************************************");
		System.out.println("\nEnter the balls left to be played by virat kohli : ");
		int viratBalls = sc.nextInt();
		int result[] = new int[viratBalls];
		result = findOrderOfBowlers(viratBalls,numOfBowlers,ballPerBowler);
		System.out.println("*******************************************************************************************************************************************************\n");
		for(j=0 ; j < viratBalls; j++){
			System.out.println("\n\tBall " + (j+1) +" : \t" + result[j] + " Bowler.");
		}
		
	}
}
