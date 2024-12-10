import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class QTree
{
	
	
	Scanner in;
	PrintStream out;
	QNodes<String> curr;
	boolean alive = true;
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
		boolean kP = true;
		String question = "a";
		String answer;
		
		QNodes<String> duck = new QNodes<>(Strings.DUCK);
		QNodes<String> rock = new QNodes<>(Strings.ROCK);
		QNodes<String> root = new QNodes<>(Strings.IS_IT_ALIVE, duck,rock,null);
		duck.prev = root;
		rock.prev = root;
		curr = root;
		QNodes<String> otherSide = root;
		
		while(kP)
		{
			out.println(root.getVal());
			answer = in.next().toLowerCase();
//			if(answer.equals("y"))
//			{
//				out.println(root.getYes().getVal());
//				answer = in.next().toLowerCase();
				boolean isCorrect = traverse(answer,curr, otherSide);
				if(isCorrect) 
				{
					out.println(Strings.I_WIN);
					out.println(Strings.PLAY_AGAIN);
					answer = in.next().toLowerCase();
					if(answer.equals("y"))
					{
						kP = true;
						curr = root;
					}
					else {
						kP = false;
					}
					


				}	
				
				else 
					{
						out.println(Strings.WHAT_IS_THE_ANSWER);
						String realA = in.next();//.toLowerCase();
						QNodes<String> nType = new QNodes<>(realA, null,null,null);
						
						out.println(Strings.NEW_QUESTION + curr.getVal() + " and a " + nType.getVal());
						in.nextLine();
						String qAnswer = in.nextLine();
						
						out.println("Answering yes to " + qAnswer + " means " + nType.getVal() + "?");
						String a = in.next().toLowerCase();
						QNodes<String> newQ;
						if(a.equals("y"))
						{
							newQ = new QNodes<>(qAnswer,nType, curr,curr.prev);
							if(alive) {
								//System.out.println(alive);
								curr.prev.y = newQ;
							}
							else {
								curr.prev.n = newQ;
							}
							curr.prev = newQ;
							nType.prev = newQ;//curr;
							//newQ.prev.y = nType;
//							curr.y = null;
//							curr.n = null;
						}
						else
						{
						//	System.out.println(curr.prev.getVal());
							newQ = new QNodes<>(qAnswer,curr, nType,curr.prev);
							if(alive) {
								curr.prev.y = newQ;
							}
							else {
							curr.prev.n = newQ;
							}
							curr.prev = newQ;
							nType.prev = newQ;
							//newQ.prev.n = nType;
//							curr.y = null;
//							curr.n = null;
						}
						nType.prev = newQ;
						curr.y = null;
						curr.n = null;
						out.println(Strings.THANKS);
						
						
						
						out.println(Strings.PLAY_AGAIN);
						answer = in.next().toLowerCase();
						if(answer.equals("y")) 
						{
							kP = true;
							curr = root;
						}
						
						if(answer.equals("n")) 
						{
							 kP = false;
						}
						
					}
				
//				out.println(Strings.PLAY_AGAIN);
//				answer = in.next().toLowerCase();
//				if(answer.equals("y")) 
//				{
//					kP = true;
//				}
//				
//				if(answer.equals("n")) 
//				{
//					 kP = false;
//				}
			
			
//			}
//			else
//			{
//				out.println(root.getNo().getVal());
//			}
		alive = true;
		}
        
	}
	private boolean traverse(String answer,QNodes<String> curr,QNodes<String> otherSide)
	{
	this.curr = curr;	
		if(curr.n == null && curr.y == null) {
		//	System.out.println(curr.getVal());
			return answer.equals("y");
		}
		
		if(answer.equals("y"))
		{
			alive = true;
			if(curr.getYes() != null)
			{
				//otherSide = curr.getNo();
				curr = curr.y;
				if(curr.y == null || curr.n == null) {
					out.println(Strings.IS_IT_A + curr.getVal() + "?");}
				else {
					out.println(curr.getVal());
				}
				answer = in.next().toLowerCase();
				return traverse(answer,curr,otherSide);
			}
		}
		
		if(answer.equals("n"))
		{
			alive = false;
//			if(curr.getVal().equals(Strings.IS_IT_ALIVE)) {
//			//	System.out.println("HI");
//				alive = false;
//			}
			if(curr.getNo() != null)
			{
				
				//otherSide = curr.getYes();
				curr = curr.n;
				
				if(curr.n == null || curr.y == null) 
				{
					out.println(Strings.IS_IT_A + curr.getVal() + "?");}
				
				else 
				{
					
					out.println(curr.getVal());
				}
				answer = in.next().toLowerCase();
				return traverse(answer,curr,otherSide);
			}
		}
	//	System.out.print(curr.n);
		//System.out.println(curr.y);
		
		return false;
	}	
//		if(answer.equals("y"))
//		{
//			out.println(Strings.I_WIN);
//			out.println(Strings.PLAY_AGAIN);
//			answer = in.next().toLowerCase();
//			return;
////			if(answer.equals("y")) 
////			{
////				return keepPlaying = true;
////			}
////			
////			if(answer.equals("n")) 
////			{
////				return keepPlaying = false;
////			}
//
//		}
//		
//		else 
//		{
//			out.println(Strings.WHAT_IS_THE_ANSWER);
//			String realA = in.next().toLowerCase();
//			QNodes<String> nType = new QNodes<>(realA, null,null,null);
//			
//			out.println(Strings.NEW_QUESTION + curr.getVal() + " and a " + nType.getVal());
//			in.nextLine();
//			String qAnswer = in.nextLine();
//			
//			out.println("Answering yes to " + qAnswer + " means " + nType.getVal() + "?");
//			String a = in.next().toLowerCase();
//			QNodes<String> newQ;
//			if(a.equals("y"))
//			{
//				newQ = new QNodes<>(qAnswer,nType, curr,curr.prev);
//				curr.prev.y = newQ;
////				curr.y = null;
////				curr.n = null;
//			}
//			else
//			{
//				newQ = new QNodes<>(qAnswer,curr, nType,curr.prev);
//				curr.prev.n = newQ;
////				curr.y = null;
////				curr.n = null;
//			}
//			nType.prev = newQ;
//			curr.y = null;
//			curr.n = null;
//			out.println(Strings.THANKS);
//			
//			return;
//			
//			out.println(Strings.PLAY_AGAIN);
//			answer = in.next().toLowerCase();
//			if(answer.equals("y")) 
//			{
//				return keepPlaying = true;
//			}
//			
//			if(answer.equals("n")) 
//			{
//				return keepPlaying = false;
//			}
			
		//}
		//return keepPlaying;
	
	
	
	public static void main(String[] args)
	{
		QTree t = new QTree(System.in, System.out);
		t.playGame();
	}
	
	
}
