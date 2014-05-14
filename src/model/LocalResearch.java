package model;

public class LocalResearch extends AbstractResearch
{
	@Override
	public void research(Chess chess)
	{
		// first, check if there is something to do
		if (!chess.checkGeneralConsistency())
		{
			// Then, if there is conflict, find, the queen who got the most conflict
			int lineOfMaxQueenConflict = 0;
			int maxQueenConflict = 0;
			int tempQueenConflict = 0;
			for (int i = 1; i <= chess.getSizeOfChess(); i++)
			{
				tempQueenConflict = chess.checkNbGeneralConflict(i);
				if (tempQueenConflict > maxQueenConflict)
				{
					maxQueenConflict = tempQueenConflict;
					lineOfMaxQueenConflict = i;
				}
			}

		}// That mean we have a solution
		else
		{
			// So we store it
			this.addSolution(chess);
		}
	}
}
