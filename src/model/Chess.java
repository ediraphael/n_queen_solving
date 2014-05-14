package model;

public class Chess
{
	private int[] queenPosition;
	private int sizeOfChess;

	public Chess(int sizeOfChess)
	{
		this.sizeOfChess=sizeOfChess;
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

	public void setQueenPosition(int line, int column) throws Exception
	{
		if (line > this.sizeOfChess)
		{
			throw new Exception("Error");
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
