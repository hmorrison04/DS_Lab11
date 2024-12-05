import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class QTree
{
	
	
	Scanner in;
	PrintStream out;
	
    //initializes the game
	public QTree(InputStream in,PrintStream out)
	{
		this.out=out;
		this.in=new Scanner(in);
		//Please initialize your data here
	}
	
    
    //plays the game, be sure to grab input from the Scanner "in", and send your output to "out".
	public void playGame()
	{
		//??
		String kP = "Y";
		String question = "a";
		String answer;
		
		QNodes<String> duck = new QNodes<>(Strings.IS_IT_A + Strings.DUCK + "?");
		QNodes<String> rock = new QNodes<>(Strings.IS_IT_A + Strings.ROCK + "?");
		QNodes<String> root = new QNodes<>(Strings.IS_IT_ALIVE, duck,rock);
		QNodes<String> curr = root;
		while(kP.equals("Y"))
		{
			out.println(root.getVal());
			answer = in.next().toLowerCase();
//			if(answer.equals("y"))
//			{
//				out.println(root.getYes().getVal());
//				answer = in.next().toLowerCase();
				traverse(answer,curr);
//			}
//			else
//			{
//				out.println(root.getNo().getVal());
//			}
		}
        
	}
	private void traverse(String answer,QNodes<String> curr)
	{
		if(answer.equals("y"))
		{
			if(curr.getYes() != null)
			{
				curr = curr.getYes();
				out.println(curr.getVal());
				answer = in.next().toLowerCase();
				traverse(answer,curr);
			}
		}
		if(answer.equals("n"))
		{
			if(curr.getNo() != null)
			{
				curr = curr.getNo();
				out.println(curr.getVal());
				answer = in.next().toLowerCase();
				traverse(answer,curr);
			}
		}
	}
	
	
	public static void main(String[] args)
	{
		QTree t = new QTree(System.in, System.out);
		t.playGame();
	}
	
	
}
