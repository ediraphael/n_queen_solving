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
		Chess chess = new Chess(100);
		//chess.setQueenPosition(1, 1);
		//chess.setQueenPosition(2, 3);
		//chess.setQueenPosition(3, 5);
		//chess.setQueenPosition(4, 2);
		//chess.setQueenPosition(5, 1);
		//System.out.println(chess);
		Solver solver = new Solver(chess, new LocalResearch());
		long start = System.currentTimeMillis();
		solver.solve();
		long end = System.currentTimeMillis();
		System.out.println("Durée de calcul : " + ((float) (end - start)) / 1000 + "s");
	}
}
