package model;

import java.util.ArrayList;

public class Solver
{
	private Chess chess;
	private AbstractResearch research;

	public Solver(Chess chess, AbstractResearch research)
	{
		this.chess = chess;
		this.research = research;
	}

	public void solve()
	{
		this.research.research();
	}

	public ArrayList<Chess> getSolutions()
	{
		return this.research.getSolutions();
	}

	public Chess getChess()
	{
		return chess;
	}

	public void setChess(Chess chess)
	{
		this.chess = chess;
	}

	public AbstractResearch getResearch()
	{
		return research;
	}

	public void setResearch(AbstractResearch research)
	{
		this.research = research;
	}

	public static void main(String[] args) throws ChessExeption
	{
		Chess chess = new Chess(5);
		chess.setQueenPosition(1, 2);
		chess.setQueenPosition(2, 1);
		chess.setQueenPosition(3, 4);
		chess.setQueenPosition(4, 2);
		chess.setQueenPosition(5, 1);
		System.out.print(chess);
		System.out.println(chess.checkNbLineConflict(1));
		System.out.println(chess.checkNbDiagonalConflict(1));
		System.out.println(chess.checkNbGeneralConflict(1));
	}
}
