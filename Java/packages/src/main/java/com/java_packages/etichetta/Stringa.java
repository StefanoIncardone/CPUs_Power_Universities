package etichetta;

import java.awt.*;
import java.text.*;

/**
 * Classe per aiutare nella rappresentazioni sotto forma di stringa
 */
public abstract class Stringa
{
	/**
	 * Un font monospaced per garantire una corretta tabulazioni delle informazioni dei veicolo
	 */
	public static final Font
		monospaced = new Font( "Monospaced", Font.BOLD, 15 );

	/**
	 * Un oggetto SimpleDateFormat per formattare le date in formato "dd/MM/yyyy, hh:mm:ss a"
	 */
	public static final SimpleDateFormat
		formatoData = new SimpleDateFormat( "dd/MM/yyyy, hh:mm:ss a" );
}
