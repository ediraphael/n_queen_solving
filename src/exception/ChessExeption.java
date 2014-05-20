package exception;

public class ChessExeption extends Exception
{
	private static final long serialVersionUID = 1L;

	public ChessExeption()
	{
		super();
	}

	public ChessExeption(String message)
	{
		super(message);
	}

	public ChessExeption(String message, Throwable cause)
	{
		super(message, cause);
	}

	public ChessExeption(Throwable cause)
	{
		super(cause);
	}
}
