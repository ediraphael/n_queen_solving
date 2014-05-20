package algo;

import java.util.ArrayList;
import java.util.Random;

import model.Chess;
import exception.ChessExeption;

public class LocalResearch 
{
	private ArrayList<Chess> solutions = new ArrayList<Chess>();
	private String searchResult;


	public void research(Chess chess)
	{
		searchResult="";
		int nbMouvement = 0;
		int lastLineMoved = -1;
		ArrayList<Integer> lastLinesMoved = new ArrayList<Integer>();
		while (!chess.checkGeneralConsistency() && lastLineMoved != 0)
		{
			//if there is conflict, find, the queen who got the most conflict
			//First initialyse variable
			int lineOfMaxQueenConflict = 0;
			int positionOfMaxQueenConflict = 0;
			int maxQueenConflict = 0;
			int tempQueenConflict = 0;
			//look over all lines of the chess and fine the one who have the most conflict
			for (int i = 1; i <= chess.getSizeOfChess(); i++)
			{
				tempQueenConflict = chess.checkNbGeneralConflict(i);
				//If there is more conflict and the line is not in the past line conflict
				if (tempQueenConflict > maxQueenConflict && i != lastLineMoved && !lastLinesMoved.contains(i))
				{
					maxQueenConflict = tempQueenConflict;
					lineOfMaxQueenConflict = i;
					positionOfMaxQueenConflict = chess.getQueenPosition()[i - 1];
				}
			}
			//If we haven't find a line to change
			if (lineOfMaxQueenConflict == 0)
			{
				//we search for a random line
				Random random = new Random();
				lineOfMaxQueenConflict = random.nextInt(chess.getSizeOfChess()) + 1;
				positionOfMaxQueenConflict = chess.getQueenPosition()[lineOfMaxQueenConflict - 1];
				maxQueenConflict = chess.getSizeOfChess();
				lastLineMoved = lineOfMaxQueenConflict;
				lastLinesMoved.add(lineOfMaxQueenConflict);
				//If there is no more last move than the size of the chess
				//Instead that's mean we have no solution
				if (lastLinesMoved.size() >= chess.getSizeOfChess())
				{
					lastLineMoved = 0;
				}
			} else
			{
				lastLineMoved = lineOfMaxQueenConflict;
				lastLinesMoved.add(lineOfMaxQueenConflict);
			}

			// For the finded queen, we will explore all the other solution possible
			int savedPosition = positionOfMaxQueenConflict;
			//System.out.println(lineOfMaxQueenConflict);
			//System.out.println(lastLinesMoved);
			searchResult+="Tour n°"+lineOfMaxQueenConflict+" : ";
			searchResult+=lastLinesMoved+"\n";
			// Then we generate other position for the queen
			try
			{
				for (int i = 1; i <= chess.getSizeOfChess(); i++)
				{
					if (i != positionOfMaxQueenConflict)
					{
						chess.setQueenPosition(lineOfMaxQueenConflict, i);
						// If the new position generate less conflict than the initial
						int nbConflict = chess.checkNbGeneralConflict(lineOfMaxQueenConflict);
						if (nbConflict < maxQueenConflict)
						{
							nbMouvement++;
							lastLinesMoved.clear();
							maxQueenConflict = nbConflict;
							savedPosition = i;
						}
					}
				}
				if (savedPosition != 0)
				{
					chess.setQueenPosition(lineOfMaxQueenConflict, savedPosition);
				}
			} catch (ChessExeption e)
			{
				System.err.println(e.getMessage());
			}
		}// That mean we have a solution
		//System.out.println("fin");
		if (chess.checkGeneralConsistency())
		{
			//System.out.println(chess);
			searchResult+="\n\n"+chess;
			searchResult+="\n\nNombre de mouvements effectués : " + nbMouvement;
			//searchResult+="\nSolution trouvée";
			//System.out.println("Nombre de mouvements effectués : " + nbMouvement);
			//System.out.println("Solution trouvée");
			this.addSolution(chess);
		} else
		{
			//System.out.println("Aucune solution trouvée");
			searchResult+="\nAucune solution trouvée";
		}
	}

	
	public boolean addSolution(Chess chess)
	{
		return this.solutions.add(chess);
	}

	public ArrayList<Chess> getSolutions()
	{
		return solutions;
	}

	public void setSolutions(ArrayList<Chess> solutions)
	{
		this.solutions = solutions;
	}

	public String getSearchResult() 
	{
		return searchResult;
	}

	public void setSearchResult(String searchResult) 
	{
		this.searchResult = searchResult;
	}
}
