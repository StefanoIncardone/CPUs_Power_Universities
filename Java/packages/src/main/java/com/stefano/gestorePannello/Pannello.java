package com.stefano.gestorePannello;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;


/**
 * libreria per aiutare nella gestione di operazioni di creazione e gestione pannelli grafici
 *
 * @author Stefano Incardone
 */
public abstract class Pannello
{
	/**
	 * Valore minimo scala RGB
	 */
	public static final int
		COLORE_MIN = 0;

	/**
	 * Valore massimo scala RGB
	 */
	public static final int
		COLORE_MAX = 255;

	/**
	 * Dimensione schermo corrente
	 */
	public static final Dimension
		DIMENSIONE_SCHERMO = Toolkit.getDefaultToolkit().getScreenSize();

	/**
	 * Applica un fattore di scala alle dimensioni iniziali e ritorna un oggetto Dimension
	 * con le dimensioni aggiornate
	 * 
	 * @param iniziale le dimensioni da modificare
	 * @param scala il fattore di scala da applicare alle dimensioni iniziali
	 * 
	 * @return un nuovo oggetto Dimensio con le dimensioni in scala rispetto a quelle iniziali
	 * 
	 * @throws IllegalArgumentException se il fattore di scala è maggiore di 1 o minore di 0.1
	 */
	public static final Dimension ridimensiona( Dimension iniziale, double scala )
		throws
			IllegalArgumentException
	{
		if( scala > 1 )
		{
			throw new IllegalArgumentException
			(
				"Errore: il fattore di scala pone il frame a una dimensione maggiore dello schermo corrente"
			);
		}
		else if( scala < 0.1 )
		{
			throw new IllegalArgumentException
			(
				"Errore: il fattore di scala pone il frame a una dimensione troppo piccola"
			);
		}

		return new Dimension( (int) (iniziale.width * scala), (int) (iniziale.height * scala) );
	}

	/**
	 * Applica un fattore di scala all'icona iniziale e ritorna una nuova icona
	 * con le dimensioni aggiornate in proporzione al frame su cui vengono poste
	 * 
	 * @param frame il frame di cui mantenere le proporzioni
	 * @param icona l'icona da ridimensionare
	 * @param scala il fattore di scala da applicare alla icona
	 * 
	 * @return un nuova icona in scala e in proporzione al frame corrente
	 * 
	 * @throws IllegalArgumentException se il fattore di scala è maggiore di 0.7 o minore di 0.1
	 */
	public static final ImageIcon ridimensiona( JFrame frame, ImageIcon icona, double scala )
		throws
			IllegalArgumentException
	{
		if( scala > 0.7 )
		{
			throw new IllegalArgumentException
			(
				"Errore: il fattore di scala pone l'icona a una dimensione maggiore del frame"
			);
		}
		else if( scala < 0.1 )
		{
			throw new IllegalArgumentException
			(
				"Errore: il fattore di scala pone l'icona a una dimensione troppo piccola"
			);
		}

		return new ImageIcon( icona.getImage().getScaledInstance
		(
			(int) (frame.getWidth() * scala),
			(int) (frame.getHeight() * scala),
			Image.SCALE_SMOOTH
		) );
	}

	/**
	 * Centra il frame di dimensioni specificate al centro dello schermo corrente e ne
	 * e ritorna il punto di origine
	 * 
	 * @param dimensioneFrame dimensioni del frame da centrare
	 * 
	 * @return il punto di origine del frame in modo che sia centrato sullo schermo corrente
	 */
	public static final Point centraFrame( Dimension dimensioneFrame )
	{
		return new Point
		(
			DIMENSIONE_SCHERMO.width / 2 - dimensioneFrame.width / 2,
			DIMENSIONE_SCHERMO.height / 2 - dimensioneFrame.height/ 2
		);
	}

	/**
	 * Imposta un bordo con titolo al pannello specificato
	 * 
	 * @param pannello il pannello a cui applicare il bordo con titolo
	 * @param titolo il titolo da impostare al bordo del pannello
	 */
	public static void setTitolo( JPanel pannello, String titolo )
	{
		pannello.setBorder
		(
			BorderFactory.createTitledBorder( null, titolo, TitledBorder.TOP, TitledBorder.DEFAULT_POSITION )
		);
	}
}
