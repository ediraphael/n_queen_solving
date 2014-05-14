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
	 * Set the position of a queen, the first parameters is for the line number,
	 * this one can't be under one. For the first line, set line number to 1.
	 * The second parameters is the column position. Set the column position to
	 * 0 to unset the queen in the line.
	 * 
	 * @param line
	 * @param column
	 * @throws Exception
	 */
	public void setQueenPosition(int line, int column) throws Exception
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
