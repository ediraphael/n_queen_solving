package model;

public class Chess
{
	private int[] queenPosition;

	public Chess(int sizeOfChess)
	{
		this.queenPosition = new int[sizeOfChess];
		for (int i = 0; i < queenPosition.length; i++)
		{
			queenPosition[i] = 0;
		}
	}

	public Chess(int[] queenPosition)
	{
		super();
		this.queenPosition = queenPosition;
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
