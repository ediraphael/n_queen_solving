package algo;

import java.util.ArrayList;

import model.Chess;

public class Solver
{
	private Chess chess;
	private LocalResearch research;

	public Solver(Chess chess, LocalResearch research)
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

	public LocalResearch getResearch()
	{
		return research;
	}

	public void setResearch(LocalResearch research)
	{
		this.research = research;
	}
}
