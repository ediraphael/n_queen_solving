package model;

public class Solver
{
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
