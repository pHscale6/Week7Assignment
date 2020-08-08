// Paul Hyde
import java.util.Scanner;
import java.util.Random;
public class Paul_Hyde_Week7Assignment {
	public static void main(String[] args) 
	{
		menuPrompt();
	}
	private static void menuPrompt()
	{
		Scanner input = new Scanner(System.in);
		printDots(65);
		System.out.println("Football Team Randomized Season Scores");
		printDots(65);
		System.out.print("Enter the number of teams: ");
		int a = input.nextInt() + 1;
		System.out.print("Enter the number of games: ");
		int b = input.nextInt() + 1;
		printDots(65);
		printDots(65);
		System.out.println("Football Scores Report");  
		printDots(65);
		System.out.print("Team   Scores");
		lineSpacing(b);
		System.out.println("Tot     Avg");
		printDashes(b);
		// declaring the 2-D array using user inputs (a = team, for rows) (b = games, for columns). 
		int [][] array = new int [a][b];
		Random r = new Random();
		int min = 0;
		// I chose the max to be 75, because 73 is the highest score made by an NFL team in an official match. 
		int max = 75;
		float sum = 0;
		float topAverage = 0;
		int topTeam = 0;
		// I used for statements to declare the user generated integers. They are arranged in a nested loop because this is how I can generate a 2-D array.
		// the outer loop generates the number of teams (rows) and the inner loop generates the number of games (column).
		for(int i = 1; i < a; i++)
		{
			System.out.print(i + ":     ");
			for (int j = 1; j < b; j++)
			{
				array [i][j] = r.nextInt((max-min) + 1) + min;
				sum = sum + array [i][j];
				System.out.print(array [i][j] + " ");
			}
			float average = sum/b;
			System.out.print("       " + sum + "    " + average);
			if (average > topAverage)
			{
				topTeam = i;
				topAverage = average;
			}
			sum = 0;
			System.out.println(" ");
		}
		input.close();
		printDashes(b);
		System.out.println("Top Team: Team " + topTeam); 
		printDashes(b);

	}
	// this may not have been necessary, but it was my attempt to clean things up better so the data matches each header.
	// still doesn't look the cleanest because of the spacing of different random integers, but it helped a lot, I believe.
	private static void lineSpacing(int b)
	{
		for (int i = 1; i <= 3*b-2; i++)
		{
			System.out.print(" ");
		}
	}
	// this is for the beginning of the prompt where the dashes will always be 65 long.
	private static void printDots(int dashes)
	{
		for (int i = 1; i  <= dashes; i++)
		{
			System.out.print("-");
		}
		System.out.print("\n");
	}
	// this is for the generated scores so the dashes scale with games played.
	// I pretty much tried to make it look nicer for 32 teams playing 256 games (standard for NFL).
	private static void printDashes(int b)
	{
		for (int i = 1; i  <= 30 + (3 * b); i++)
		{
			System.out.print("-");
		}
		System.out.print("\n");
	}
}