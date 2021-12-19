package utilita;

import java.io.*;

/**
 * Una libreria per aiutare nella gestione di operazioni di input e output su file
 * 
 * @author Stefano Incardone
 */
public abstract class GestoreFile
{
	/**
	 * Il percorso del file da cercare
	 */
	private static String
		nomeFile		= null,
		nomeCartella	= null;

	/**
	 * Esegue un attraversamento ricorsivo della directory specificata
	 * ritornando il percorso dell'obbiettivo selezionato
	 * 
	 * @param directory la directory di partenza da cui eseguire la ricerca
	 * @param obbiettivo il file da dover cercare
	 * 
	 * @return il percorso del file nel caso in cui sia stato trovato, altrimenti null
	 */
	public static final String cercaFile( File directory, String obbiettivo )
	{
		if( directory.isFile() )
		{
			if( directory.getName().equals( obbiettivo ) )
			{
				nomeFile = directory.getAbsolutePath();
			}
		}
		else
		{
			for( var fileCorrente : directory.list() )
			{
				cercaFile( new File( directory.getAbsolutePath(), fileCorrente ), obbiettivo );
			}
		}
		return nomeFile;
	}

	/**
	 * Esegue un attraversamento ricorsivo dalla present working directory
	 * ritornando il percorso del file selezionato
	 * 
	 * @param obbiettivo il file da dover cercare
	 * 
	 * @return il percorso del file nel caso in cui sia stato trovato, altrimenti null
	 */
	public static final String cercaFile( String obbiettivo )
	{
		return cercaFile( new File( System.getProperty( "user.dir" ) ), obbiettivo );
	}

	/**
	 * Esegue un attraversamento ricorsivo della directory specificata
	 * ritornando il percorso dell'obbiettivo selezionato
	 * 
	 * @param directory la directory di partenza da cui eseguire la ricerca
	 * @param obbiettivo la cartella da dover cercare
	 * 
	 * @return il percorso della cartella nel caso in cui sia stato trovato, altrimenti null
	 */
	public static final String cercaCartella( File directory, String obbiettivo )
	{
		if( directory.isDirectory() )
		{
			if( directory.getName().equals( obbiettivo ) )
			{
				nomeCartella = directory.getAbsolutePath();
			}
			else
			{
				for( var fileCorrente : directory.list() )
				{
					cercaCartella( new File( directory.getAbsolutePath(), fileCorrente ), obbiettivo );
				}
			}
		}
		return nomeCartella;
	}

	/**
	 * Esegue un attraversamento ricorsivo dalla present working directory
	 * ritornando il percorso del file selezionato
	 * 
	 * @param obbiettivo la cartella da dover cercare
	 * 
	 * @return il percorso della cartella nel caso in cui sia stato trovato, altrimenti null
	 */
	public static final String cercaCartella( String obbiettivo )
	{
		return cercaCartella( new File( System.getProperty( "user.dir" ) ), obbiettivo );
	}

	/**
	 * Scrive un oggetto sul file specificato
	 * 
	 * @param file il file su cui scrivere l'oggetto
	 * @param oggetto l'oggetto da scrivere su file
	 * 
	 * @throws IOException
	 */
	public static final void scriviOggetto( File file, Object oggetto )
		throws
			IOException
	{
		try( ObjectOutputStream output = new ObjectOutputStream( new FileOutputStream( file ) ) )
		{
			output.writeObject( oggetto );
		}
	}

	/**
	 * Legge un oggetto dal file specificato
	 * 
	 * @param file il file da cui leggere l'oggetto
	 * 
	 * @return l'oggetto letto dal file specificato
	 * 
	 * @throws IOException
	 */
	public static final Object leggiOggetto( File file )
		throws
			IOException
	{
		try( ObjectInputStream input = new ObjectInputStream( new FileInputStream( file ) )	)
		{
			return input.readObject();
		}
		catch( ClassNotFoundException exception )
		{
			return null;
		}
	}
}
