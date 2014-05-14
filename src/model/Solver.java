package model;

public class Solver
{
	public static void main(String[] args) throws ChessExeption
	{
		Chess chess = new Chess(4);
		chess.setQueenPosition(1, 4);
		chess.setQueenPosition(2, 4);
		System.out.println(chess);
	}
}
