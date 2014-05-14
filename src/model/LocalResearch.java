package model;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class LocalResearch extends AbstractResearch
{
	@Override
	public void research(Chess chess)
	{
		int nbMouvement = 0;
		int lastLineMoved = 0;
		while (!chess.checkGeneralConsistency())
		{
			// Then, if there is conflict, find, the queen who got the most conflict
			int lineOfMaxQueenConflict = 0;
			int positionOfMaxQueenConflict = 0;
			int maxQueenConflict = 0;
			int tempQueenConflict = 0;
			for (int i = 1; i <= chess.getSizeOfChess(); i++)
			{
				tempQueenConflict = chess.checkNbGeneralConflict(i);
				if (tempQueenConflict > maxQueenConflict && i != lastLineMoved)
				{
					maxQueenConflict = tempQueenConflict;
					lineOfMaxQueenConflict = i;
					positionOfMaxQueenConflict = chess.getQueenPosition()[i - 1];
				}
			}

			// For the finded queen, we will explore all the other solution possible
			// First we make a copy of the chess
			lastLineMoved = lineOfMaxQueenConflict;
			int savedPosition = positionOfMaxQueenConflict;
			System.out.println(lineOfMaxQueenConflict);
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
							System.out.println(chess);
							System.out.println("no Conflif:" + chess.checkGeneralConsistency());
							maxQueenConflict = nbConflict;
							savedPosition = i;
						}
					}
				}
				chess.setQueenPosition(lineOfMaxQueenConflict, savedPosition);
			} catch (ChessExeption e)
			{
				System.err.println(e.getMessage());
			}
		}// That mean we have a solution
		System.out.println(chess.checkLinearConsistency());
		System.out.println("fin");
		{
			// So we store it
			this.addSolution(chess);
		}
	}
}
