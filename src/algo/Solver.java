package algo;

import java.util.ArrayList;

import model.Chess;

public class Solver
{
	private Chess chess;
	private LocalResearch research;

	public Solver(int nbDames)
	{
		this.chess = new Chess(nbDames);
		this.research = new LocalResearch();
	}

	public void solve()
	{
		this.research.research(this.chess);
	}

	public String showResult()
	{
		return this.research.getSearchResult();
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
