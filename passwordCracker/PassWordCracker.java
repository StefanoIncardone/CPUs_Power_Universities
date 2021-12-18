import java.util.Arrays;

public class PassWordCracker
{
	public static void main( String args[] )
	{
		Cracker cracker = new Cracker( 97, 127, "admin" );
		cracker.crack();
		cracker.displayPassword();
		cracker.displayElapsedTime();
	}
}

class Cracker
{
	private final char MIN_CHAR;
	private final char MAX_CHAR;

	private final String passwordToCrack;
	private final int passwordLength;
	private char[] password;

	private long initialTime;
	private long finalTime;

	public Cracker( int minChar, int maxChar, String targetPassword )
	{
		MIN_CHAR = (char) minChar;
		MAX_CHAR = (char) maxChar;

		passwordToCrack = targetPassword;
		passwordLength = targetPassword.length();

		password = new char[ passwordLength ];
		Arrays.fill( password, MIN_CHAR );
	}

	public void crack()
	{
		initialTime = System.currentTimeMillis();

		while( !String.valueOf( password ).equals( passwordToCrack ) )
		{
			incrementPassword( passwordLength - 1 );
		}

		finalTime = System.currentTimeMillis();
	}

	private void incrementPassword( int index )
	{
		if( ++password[ index ] == MAX_CHAR )
		{
			password[ index ] = MIN_CHAR;
			incrementPassword( index - 1 );
		}
	}

	public void displayPassword()
	{
		System.out.println( "\n" + "the brute-forced password is: " + String.valueOf( password ) + "\n" );
	}

	public void displayElapsedTime()
	{
		System.out.println( "\n" + "password cracked in: " + (finalTime - initialTime) + " milliseconds" + "\n" );
	}
}