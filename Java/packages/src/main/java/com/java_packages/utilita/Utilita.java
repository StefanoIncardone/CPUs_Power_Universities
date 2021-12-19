package utilita;

import java.util.*;
import javax.swing.*;

import etichetta.*;

/**
 * Una libreria per aiutare durante l'utilizzo di strutture dati e metodi frequentemente usati
 *
 * @author Stefano Incardone
 */
public abstract class Utilita
{
	/**
	 * Risposte da parte dell'utente: SI, NO, INDIETRO
	 */
	public static enum Risposta
	{
		SI, NO
	}

	/**
	 * Funzione per introdurre un ritardo. in caso di errore ne stampa il messaggio
	 *
	 * @param lassoDiTempo durata ritardo espressa in millisecondi
	 */
	public static final void sleep( long lassoDiTempo )
	{
		try
		{
			Thread.sleep( lassoDiTempo );
		}
		catch( InterruptedException exception )
		{
			terminaProgramma();
		}
	}

	/**
	 * Mostra una finestra di dialogo contenente un testo chiedendo una conferma
	 * (SI, NO) (accetta sia maiuscole che minuscole)
	 * <p>
	 * confrontare successivamente il valore restituito da questa funzione
	 * con un oggetto dell'enum Risposta
	 * <p>
	 * viene mostrata un messaggio di errore nel caso in cui non si inserisca
	 * uno dei valori definiti nell'enum Risposte,
	 * e viene chiesto di inserire nuovamente una risposta
	 *
	 * @param scan l'oggetto Scanner da utilizzare per registrare l'azione dell'utente
	 * @param testo il testo da utilizzare per chiedere una conferma
	 *
	 * @return un valore dell'enum Risposta
	 */
	public static final Risposta chiediConferma( Scanner scan, String testo )
	{
		while( true )
		{
			System.out.print( "\n" + testo + " (SI, NO) ? " );
			switch( scan.next().toUpperCase() )
			{
				case "SI":
				case "S":
				case "YES":
				case "Y":
				case "1":
					return Risposta.SI;

				case "NO":
				case "N":
				case "2":
					return Risposta.NO;

				default:
					System.out.println( "\n" + "comando errato! riprovare! " );
			}
		}
	}

	/**
	 * Mostra una finestra di dialogo con il titolo specificato centrata sul frame padre,
	 * chiedendo conferma se si volesse riprovare
	 * <p>
	 * è necessario confrontare successivamente il valore restituito da questa funzione
	 * con un oggetto dell'enum Risposta
	 * <p>
	 * se la finestra di conferma viene chiusa viene ritornato il valore SI
	 *
	 * @param frame il frame padre su cui centrare la finstra
	 * @param titolo il titolo della finestra di dialogo
	 *
	 * @return un valore dell'enum Risposta
	 *
	 * @see Risposta
	 */
	public static final Risposta chiediConfermaRiprova( JFrame frame, String titolo )
	{
		return Risposta.values()[ Math.max( 0, JOptionPane.showOptionDialog
		(
			frame,
			Etichetta.RICHIESTA_RIPROVARE,
			titolo,
			JOptionPane.YES_NO_OPTION,
			JOptionPane.ERROR_MESSAGE,
			null,
			Etichetta.OPZIONI_CONFERMA,
			Etichetta.OPZIONI_CONFERMA[ 0 ]
		) ) ];
	}

	/**
	 * Mostra una finestra di dialogo notificando l'utente che si sta tornando indietro
	 * centrata sul frame padre, chiedendo conferma se si fosse sicuri di tornare indietro
	 * <p>
	 * è necessario confrontare successivamente il valore restituito da questa funzione
	 * con un oggetto dell'enum Risposta
	 * <p>
	 * se la finestra di conferma viene chiusa viene ritornato il valore NO
	 *
	 * @param frame il frame padre su cui centrare la finstra
	 *
	 * @return un valore dell'enum Risposta
	 *
	 * @see Risposta
	 */
	public static final Risposta chiediConfermaCancella( JFrame frame )
	{
		return Risposta.values()[ Math.abs( JOptionPane.showOptionDialog
		(
			frame,
			Etichetta.CONFERMA_TORNA_INDIETRO,
			Etichetta.TITOLO_TORNA_INDIETRO,
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			null,
			Etichetta.OPZIONI_CONFERMA,
			Etichetta.OPZIONI_CONFERMA[ 0 ]
		) ) ];
	}

	/**
	 * Termina l'esecuzione del programma
	 */
	public static final void terminaProgramma()
	{
		JOptionPane.showMessageDialog
		(
			null,
			Etichetta.MESSAGGIO_ERRORE,
			Etichetta.TITOLO_ERRORE,
			JOptionPane.ERROR_MESSAGE
		);

		System.exit( -1 );
	}
}