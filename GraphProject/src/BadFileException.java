import java.io.IOException;

public class BadFileException extends IOException
{
	private static final long serialVersionUID = -2854781356278888090L;

	public BadFileException(String e)
	{
		super(e);
	}
}