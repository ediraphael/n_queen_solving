package model;

public class Solver
{
	public static void main(String[] args) throws ChessExeption
	{
		Chess chess = new Chess(4);
		chess.setQueenPosition(1, 2);
		chess.setQueenPosition(3, 3);
		chess.setQueenPosition(4, 1);
		System.out.println(chess);
		System.out.println(chess.checkLinearConsistency());
		System.out.println(chess.checkDiagonalConsistency());
		System.out.println(chess.checkGeneralConsistency());
	}
}
