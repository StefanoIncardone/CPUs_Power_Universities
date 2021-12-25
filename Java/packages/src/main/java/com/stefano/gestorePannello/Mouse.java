package com.stefano.gestorePannello;

import java.awt.event.*;
import javax.swing.SwingUtilities;

/**
 * libreria per aiutare nella gestione di eventi generati da mouse
 *
 * @author Stefano Incardone
 */
public abstract class Mouse
{
	/**
	 * Controlla il tipo di evento mouse e ritorna vero se corrisponde al tasto destro
	 * 
	 * @param evento evento generato dalla pressione di un tasto del mouse
	 * 
	 * @return vero se l'evento corrisponde alla pressione del tasto destro del mouse
	 */
	public static final boolean isTastoDestro( MouseEvent evento )
	{
		return evento.isMetaDown() || SwingUtilities.isRightMouseButton( evento );
	}
}