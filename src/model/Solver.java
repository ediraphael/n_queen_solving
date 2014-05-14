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
		this.research.research(this.chess);
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
		chess.setQueenPosition(1, 1);
		chess.setQueenPosition(2, 1);
		chess.setQueenPosition(3, 1);
		chess.setQueenPosition(4, 1);
		chess.setQueenPosition(5, 1);
		System.out.println(chess);
		Solver solver = new Solver(chess, new LocalResearch());
		solver.solve();
	}
}
