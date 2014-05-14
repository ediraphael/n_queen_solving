package model;

public class Chess
{
	private int[] queenPosition;
	private int sizeOfChess;

	public Chess(int sizeOfChess)
	{
		this.sizeOfChess = sizeOfChess;
		this.queenPosition = new int[sizeOfChess];
		for (int i = 0; i < queenPosition.length; i++)
		{
			queenPosition[i] = 0;
		}
	}

	public Chess(int[] queenPosition)
	{
		this.queenPosition = queenPosition;
	}

	/**
	 * Function to check if the linear position of queens are good. Mean if
	 * their are not more than one queen on the same line or column.
	 * 
	 * @return true if it's correct, false either
	 */
	public boolean checkLinearconsistency()
	{
		// Initialyse a occurency count
		int[] columnOccurency = new int[sizeOfChess];
		for (int i = 0; i < this.sizeOfChess; i++)
		{
			columnOccurency[i] = 0;
		}
		// Count the occurency of positition
		for (int i = 0; i < this.sizeOfChess; i++)
		{
			columnOccurency[this.queenPosition[i]]++;
		}

		// Check the occurency of position, except 0
		for (int i = 0; i < this.sizeOfChess; i++)
		{
			if (columnOccurency[i] > 1)
			{
				return false;
			}
		}

		return true;
	}

	/**
	 * Set the position of a queen, the first parameters is for the line number,
	 * this one can't be under one. For the first line, set line number to 1.
	 * The second parameters is the column position. Set the column position to
	 * 0 to unset the queen in the line.
	 * 
	 * @param line
	 * @param column
	 * @throws ChessExeption
	 */
	public void setQueenPosition(int line, int column) throws ChessExeption
	{
		if (line > this.sizeOfChess)
		{
			throw new ChessExeption("Line number (" + line + ") exceeds the size of the chess (" + this.sizeOfChess + ")");
		} else if (column > this.sizeOfChess)
		{
			throw new ChessExeption("Column number (" + column + ") exceeds the size of the chess (" + this.sizeOfChess + ")");
		} else if (line < 1)
		{
			throw new ChessExeption("Line number (" + line + ") can't be under 1");
		} else if (column < 0)
		{
			throw new ChessExeption("Column number (" + column + ") can't be negative");
		} else
		{
			this.queenPosition[line - 1] = column;
		}
	}

	public int getSizeOfChess()
	{
		return sizeOfChess;
	}

	public void setSizeOfChess(int sizeOfChess)
	{
		this.sizeOfChess = sizeOfChess;
	}

	public int[] getQueenPosition()
	{
		return queenPosition;
	}

	public void setQueenPosition(int[] queenPosition)
	{
		this.queenPosition = queenPosition;
	}

}
