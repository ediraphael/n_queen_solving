package model;

import java.util.ArrayList;
import java.util.Random;

public class LocalResearch extends AbstractResearch
{
	@Override
	public void research(Chess chess)
	{
		int nbMouvement = 0;
		int lastLineMoved = -1;
		ArrayList<Integer> lastLinesMoved = new ArrayList<Integer>();
		while (!chess.checkGeneralConsistency() && lastLineMoved != 0)
		{
			//if there is conflict, find, the queen who got the most conflict
			int lineOfMaxQueenConflict = 0;
			int positionOfMaxQueenConflict = 0;
			int maxQueenConflict = 0;
			int tempQueenConflict = 0;
			for (int i = 1; i <= chess.getSizeOfChess(); i++)
			{
				tempQueenConflict = chess.checkNbGeneralConflict(i);
				if (tempQueenConflict > maxQueenConflict && i != lastLineMoved && !lastLinesMoved.contains(i))
				{
					maxQueenConflict = tempQueenConflict;
					lineOfMaxQueenConflict = i;
					positionOfMaxQueenConflict = chess.getQueenPosition()[i - 1];
				}
			}
			if (lineOfMaxQueenConflict == 0)
			{
				Random random = new Random();
				lineOfMaxQueenConflict = random.nextInt(chess.getSizeOfChess()) + 1;
				positionOfMaxQueenConflict = chess.getQueenPosition()[lineOfMaxQueenConflict - 1];
				maxQueenConflict = chess.getSizeOfChess();
				lastLineMoved = lineOfMaxQueenConflict;
				lastLinesMoved.add(lineOfMaxQueenConflict);
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
			System.out.println(lineOfMaxQueenConflict);
			System.out.println(lastLinesMoved);
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
							// System.out.println(chess);

							// System.out.println("no Conflif:" + chess.checkGeneralConsistency());
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
				// System.err.println(e.getMessage());
			}
		}// That mean we have a solution
		System.out.println("fin");
		if (chess.checkGeneralConsistency())
		{
			System.out.println(chess);
			System.out.println("Nb mouvement effectué :" + nbMouvement);
			System.out.println("Trouvé!");
			this.addSolution(chess);
		} else
		{
			System.out.println("Pas de solution trouvée");
		}
	}
}
