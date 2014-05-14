package model;

import java.util.ArrayList;

public abstract class AbstractResearch
{
	private ArrayList<Chess> solutions;

	public AbstractResearch()
	{
		this.solutions = new ArrayList<Chess>();
	}

	public AbstractResearch(ArrayList<Chess> solutions)
	{
		this.solutions = solutions;
	}

	public abstract void research(Chess chess);

	public boolean addSolution(Chess chess)
	{
		return this.solutions.add(chess);
	}

	public ArrayList<Chess> getSolutions()
	{
		return solutions;
	}

	public void setSolutions(ArrayList<Chess> solutions)
	{
		this.solutions = solutions;
	}
}
