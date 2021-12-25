package com.stefano.utilita;

import java.util.*;
import javax.swing.*;

import com.stefano.etichetta.Etichetta;

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
		SI, NO;

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
		private static final Risposta chiediConferma( JFrame frame, String titolo )
		{
			return Risposta.values()[ Math.abs( JOptionPane.showOptionDialog
			(
				frame,
				Etichetta.CONFERMA_SICURO,
				titolo,
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				Etichetta.OPZIONI_CONFERMA,
				Etichetta.OPZIONI_CONFERMA[ 0 ]
			) ) ];
		}

		public static final Risposta chiediConfermaIndietro( JFrame frame )
		{
			return chiediConferma( frame, Etichetta.TITOLO_TORNA_INDIETRO );
		}

		public static final Risposta chiediConfermaAnnulla( JFrame frame )
		{
			return chiediConferma( frame, Etichetta.TITOLO_ANNULLA );
		}
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
			terminaProgrammaErrore( null );
		}
	}

	private static final void terminaProgramma
		( JFrame frame, String messaggio, String titolo, int tipoMessaggio, int codice )
	{
		JOptionPane.showMessageDialog( frame, messaggio, titolo, tipoMessaggio );
		System.exit( codice );
	}

	/**
	 * Termina l'esecuzione del programma a causa di un errore
	 * 
	 * @param frame il frame su cui centrare la finestra
	 */
	public static final void terminaProgrammaErrore( JFrame frame )
	{
		terminaProgramma
		(
			frame,
			Etichetta.MESSAGGIO_ERRORE,
			Etichetta.TITOLO_ERRORE,
			JOptionPane.ERROR_MESSAGE,
			-1
		);
	}

	/**
	 * Termina l'esecuzione del programma dopo la richiesta d'annullamento dell'utente
	 * 
	 * @param frame il frame su cui centrare la finestra
	 */
	public static final void terminaProgrammaAnnulla( JFrame frame )
	{
		terminaProgramma
		(
			frame,
			Etichetta.MESSAGGIO_ANNULLAMENTO,
			Etichetta.TITOLO_ANNULLAMENTO,
			JOptionPane.INFORMATION_MESSAGE,
			0
		);
	}
}