package model;

import exception.ChessExeption;

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
			queenPosition[i] = 1;
		}
	}

	public Chess(int[] queenPosition)
	{
		this.queenPosition = queenPosition;
		this.sizeOfChess = queenPosition.length;
	}

	public int checkNbGeneralConflict(int line)
	{
		return checkNbDiagonalConflict(line) + checkNbLineConflict(line);
	}

	public int checkNbDiagonalConflict(int line)
	{
		int nbConflict = 0;
		// Count the occurency of position
		line--;
		for (int i = 0; i < this.sizeOfChess; i++)
		{
			if ((this.queenPosition[i] == (this.queenPosition[line] + (line - i)) || this.queenPosition[i] == (this.queenPosition[line] + (i - line))) && this.queenPosition[i] != 0 && this.queenPosition[line] != 0 && line != i)
			{
				nbConflict++;
			}
		}
		return nbConflict;
	}

	public int checkNbLineConflict(int line)
	{
		int nbConflict = 0;
		// Count the occurency of position
		for (int i = 0; i < this.sizeOfChess; i++)
		{
			if (i != (line - 1) && this.queenPosition[i] == this.queenPosition[line - 1])
			{
				nbConflict++;
			}
		}
		return nbConflict;
	}

	/**
	 * Function to check if the linear position of queens are good. Mean if their are not more than one queen on the same line or column.
	 * 
	 * @return true if it's correct, false either
	 */
	public boolean checkLinearConsistency()
	{
		// Initialyse a occurency count
		int[] columnOccurency = new int[sizeOfChess + 1];
		for (int i = 0; i < this.sizeOfChess + 1; i++)
		{
			columnOccurency[i] = 0;
		}
		// Count the occurency of position
		for (int i = 0; i < this.sizeOfChess; i++)
		{
			columnOccurency[this.queenPosition[i]]++;
		}
		// Check the occurency of position, except 0
		for (int i = 1; i < this.sizeOfChess + 1; i++)
		{
			if (columnOccurency[i] > 1)
			{
				return false;
			}
		}

		return true;
	}

	/**
	 * Function to check if queens are not in conflict by diagonal
	 * 
	 * @return true if it's correct, false either
	 */
	public boolean checkDiagonalConsistency()
	{
		for (int i = 0; i < this.sizeOfChess; i++)
		{
			for (int j = i + 1; j < this.sizeOfChess; j++)
			{
				if ((this.queenPosition[i] == (this.queenPosition[j] + (j - i)) || this.queenPosition[i] == (this.queenPosition[j] + (i - j))) && this.queenPosition[i] != 0 && this.queenPosition[j] != 0)
				{
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Function to test if queens position are not in conflict
	 * 
	 * @return true if it's correct, false either
	 */
	public boolean checkGeneralConsistency()
	{
		return this.checkLinearConsistency() && this.checkDiagonalConsistency();
	}

	/**
	 * Set the position of a queen, the first parameters is for the line number, this one can't be under one. For the first line, set line number to 1. The second parameters is the column position. Set the column position to 0 to unset the queen in the line.
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
		this.sizeOfChess = queenPosition.length;
	}

	@Override
	public String toString()
	{
		StringBuilder text = new StringBuilder();
		for (int i = 0; i < sizeOfChess; i++)
		{
			for (int j = 0; j < sizeOfChess; j++)
			{
				text.append("+---");
			}
			text.append("+\n");

			for (int j = 0; j < sizeOfChess; j++)
			{
				if (this.queenPosition[i] == j + 1)
				{
					text.append("| X ");
				} else
				{
					text.append("|   ");
				}
			}
			text.append("|\n");
		}
		for (int j = 0; j < sizeOfChess; j++)
		{
			text.append("+---");
		}
		text.append("+\n");
		return text.toString();
	}
}
