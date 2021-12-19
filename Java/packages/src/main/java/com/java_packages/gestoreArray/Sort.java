package gestoreArray;

import java.util.*;

/**
 * Una classe contenente algoritmi di ordinamento per array.
 * algoritmi implementati:
 * Selection;
 * Bubble;
 * Insertion;
 * Heap;
 * Quick;
 * 
 * @see Array libreria di gesione array
 */
public abstract class Sort
	extends
		Array
{
	//------------------//
	//	SELECTION SORT	//
	//------------------//

	/**
	 * Ordina l'array con un algoritmo di tipo Selection sort
	 *
	 * @param array l'array da ordinare
	 */
	public static final void selection( int[] array )
	{
		for( int inizio = 0; inizio < array.length - 1; inizio++ )
		{
			for( int corrente = inizio + 1; corrente < array.length; corrente++ )
			{
				if( array[ corrente ] < array[ inizio ] )
				{
					scambia( array, inizio, corrente );
				}
			}
		}
	}

	/**
	 * Ordina e ritorna una copia dell'array con un algoritmo di tipo Selection sort
	 *
	 * @param array l'array da copiare per l'ordinamento
	 * 
	 * @return un nuovo array ordinato
	 */
	public static final int[] selectionCopyOf( int[] array )
	{
		int[] risultato = Arrays.copyOf( array, array.length );

		for( int inizio = 0; inizio < risultato.length - 1; inizio++ )
		{
			for( int corrente = inizio + 1; corrente < risultato.length; corrente++ )
			{
				if( risultato[ corrente ] < risultato[ inizio ] )
				{
					scambia( risultato, inizio, corrente );
				}
			}
		}
		return risultato;
	}


	//--------------//
	//	BUBBLE SORT	//
	//--------------//

	/**
	 * Ordina l'array con un algoritmo di tipo Bubble sort
	 *
	 * @param array l'array da ordinare
	 */
	public static final void bubble( int[] array )
	{
		for( int iterazione = 0; iterazione < array.length - 1; iterazione++)
		{
			for( int corrente = 0; corrente < (array.length - iterazione - 1); corrente++ )
			{
				if( array[ corrente ] > array[ corrente + 1 ] )
				{
					scambia( array, corrente, corrente + 1 );
				}
			}
		}
	}

	/**
	 * Ordina e ritorna una copia dell'array con un algoritmo di tipo Bubble sort
	 *
	 * @param array l'array da copiare per l'ordinamento
	 * 
	 * @return un nuovo array ordinato
	 */
	public static final int[] bubbleCopyOf( int[] array )
	{
		int[] risultato = Arrays.copyOf( array, array.length );

		for( int iterazione = 0; iterazione < risultato.length - 1; iterazione++)
		{
			for( int corrente = 0; corrente < (risultato.length - iterazione - 1); corrente++ )
			{
				if( risultato[ corrente ] > risultato[ corrente + 1 ] )
				{
					scambia( risultato, corrente, corrente + 1 );
				}
			}
		}
		return risultato;
	}


	//------------------//
	//	INSERTION SORT	//
	//------------------//

	/**
	 * Ordina l'array con un algoritmo di tipo Insertion sort
	 *
	 * @param array l'array da ordinare
	 */
	public static final void insertion( int[] array )
	{
		for( int iterazione = 1; iterazione < array.length; iterazione++ )
		{
			for( int corrente = iterazione - 1; corrente >= 0; corrente-- )
			{
				if( array[ corrente ] > array[ corrente + 1 ] )
				{
					scambia( array, corrente, corrente + 1 );
				}
			}
		}
	}

	/**
	 * Ordina e ritorna una copia dell'array con un algoritmo di tipo Insertion sort
	 *
	 * @param array l'array da copiare per l'ordinamento
	 * 
	 * @return un nuovo array ordinato
	 */
	public static final int[] insertionCopyOf( int[] array )
	{
		int[] risultato = Arrays.copyOf( array, array.length );

		for( int iterazione = 1; iterazione < risultato.length; iterazione++ )
		{
			for( int corrente = iterazione - 1; corrente >= 0; corrente-- )
			{
				if( risultato[ corrente ] > risultato[ corrente + 1 ] )
				{
					scambia( risultato, corrente, corrente + 1 );
				}
			}
		}
		return risultato;
	}


	//--------------//
	//	HEAP SORT	//
	//--------------//

	/**
	 * Ordina l'array con un algoritmo di tipo Heap sort
	 *
	 * @param array l'array da ordinare
	 */
	public static final void heap( int[] array )
	{
		for( int corrente = (array.length - 2) / 2; corrente >= 0; corrente-- )
		{
			creaHeap( array, corrente, array.length - 1 );
		}

		for( int corrente = array.length - 1; corrente >= 0; corrente-- )
		{
			scambia( array, corrente, 0 );
			creaHeap( array, 0, corrente );
		}
	}

	/**
	 * Ordina e ritorna una copia dell'array con un algoritmo di tipo Heap sort
	 *
	 * @param array l'array da copiare per l'ordinamento
	 * 
	 * @return un nuovo array ordinato
	 */
	public static final int[] heapCopyOf( int[] array )
	{
		int[] risultato = Arrays.copyOf( array, array.length );

		for( int corrente = (risultato.length - 2) / 2; corrente >= 0; corrente-- )
		{
			creaHeap( risultato, corrente, risultato.length - 1 );
		}

		for( int corrente = risultato.length - 1; corrente >= 0; corrente-- )
		{
			scambia( risultato, corrente, 0 );
			creaHeap( risultato, 0, corrente );
		}
		return risultato;
	}

	/**
	 * Ordina l'array secondo una struttura heap
	 *
	 * @param array l'array da ordinare
	 * @param inizio la posizione iniziale da cui partire
	 * @param fine la posizione fino a cui ordinare l'array
	 */
	private static void creaHeap( int[] array, int inizio, int fine )
	{
		while( (2 * inizio + 1) < fine )
		{
			int maxChildIndex = maxChild( array, inizio, fine );
			if( array[ inizio ] < array[ maxChildIndex ] )
			{
				scambia( array, inizio, maxChildIndex );
				inizio = maxChildIndex;
			}
			else
			{
				break;
			}
		}
	}

	/**
	 * Analizza l'array di numeri e ritorna l'indice del figlio maggiore
	 *
	 * @param array l'array da analizzare
	 * @param inizio la posizione del nodo corrente
	 * @param fine la poszione del nodo finale
	 *
	 * @return l'indice del figlio maggiore
	 */
	private static int maxChild( int[] array, int inizio, int fine )
	{
		int
			leftChildIndex	= 2 * inizio + 1,
			rightChildIndex	= 2 * inizio + 2;
		return
		(
			rightChildIndex < fine &&
			array[ leftChildIndex ] < array[ rightChildIndex ]
		) ?
		rightChildIndex : leftChildIndex;
	}


	//--------------//
	//	QUICK SORT	//
	//--------------//

	/**
	 * Ordina l'array con un algoritmo di tipo Quick sort
	 *
	 * @param array l'array da ordinare
	 * @param inizio l'idicie iniziale da cui eseguire l'ordinamento
	 * @param fine l'indice finale su cui terminare l'ordinamento
	 */
	public static final void quick( int[] array, int inizio, int fine )
	{
		if( inizio < fine )
		{
			int centro = partiziona( array, inizio, fine );

			quick( array, inizio, centro - 1 );
			quick( array, centro + 1, fine );
		}
	}

	/**
	 * Ordina l'array con un algoritmo di tipo Quick sort
	 *
	 * @param array l'array da ordinare
	 * @param inizio l'idicie iniziale da cui eseguire l'ordinamento
	 * @param fine l'indice finale su cui terminare l'ordinamento
	 */
	public static final void quick( Object[] array, int inizio, int fine )
	{
		if( inizio < fine )
		{
			int centro = partiziona( array, inizio, fine );

			quick( array, inizio, centro - 1 );
			quick( array, centro + 1, fine );
		}
	}

	/**
	 * Ordina l'array con un algoritmo di tipo Quick sort
	 *
	 * @param array l'array da ordinare
	 * @param inizio l'idicie iniziale da cui eseguire l'ordinamento
	 * @param fine l'indice finale su cui terminare l'ordinamento
	 * 
	 * @return un nuovo array ordinato
	 */
	public static final int[] quickCopyOf( int[] array, int inizio, int fine )
	{
		int[] risultato = Arrays.copyOf( array, array.length );

		if( inizio < fine )
		{
			int centro = partiziona( risultato, inizio, fine );

			quick( risultato, inizio, centro - 1 );
			quick( risultato, centro + 1, fine );
		}
		return risultato;
	}

	/**
	 * Ordina l'array con un algoritmo di tipo Quick sort
	 *
	 * @param array l'array di interi da ordinare
	 * @param inizio l'idicie iniziale da cui eseguire l'ordinamento
	 * @param fine l'indice finale su cui terminare l'ordinamento
	 *
	 * @return un nuovo array ordinato
	 */
	public static final Object[] quickCopyOf( Object[] array, int inizio, int fine )
	{
		Object[] risultato = Arrays.copyOf( array, array.length );

		if( inizio < fine )
		{
			int centro = partiziona( risultato, inizio, fine );

			quick( risultato, inizio, centro - 1 );
			quick( risultato, centro + 1, fine );
		}
		return risultato;
	}

	/**
	 * Partiziona il parametro array partendo dall'indice iniziale fino all'indice finale,
	 * facendo si che tutti i valori più piccoli del pivot (all'indice iniziale)
	 * vengano posti alla sua sinistra, mentre i più grandi a destra
	 * e ritorna l'indiice del pivot dopo la partizione
	 * 
	 * @param array l'array da partizionare
	 * @param inizio l'indice da cui iniziare la partizione
	 * @param fine l'indice a cui termianre la partizione
	 * 
	 * @return l'indice del pivot ottenuto
	 */
	private static int partiziona( int[] array, int inizio, int fine )
	{
		int pivot = array[ inizio ];
		do
		{
			while( inizio < fine && array[ fine ] >= pivot )
			{
				fine--;
			}

			if( inizio < fine )
			{
				array[ inizio ] = array[ fine ];

				while( inizio < fine && array[ inizio ] <= pivot )
				{
					inizio++;
				}

				if( inizio < fine )
				{
					array[ fine ] = array[ inizio ];
				}
			}
		}
		while( inizio < fine );

		array[ inizio ] = pivot;
		return inizio;
	}

	/**
	 * Partiziona il parametro array partendo dall'indice iniziale fino all'indice finale,
	 * facendo si che tutti i valori più piccoli del pivot (all'indice iniziale)
	 * vengano posti alla sua sinistra, mentre i più grandi a destra
	 * e ritorna l'indiice del pivot dopo la partizione
	 * 
	 * @param array l'array da partizionare
	 * @param inizio l'indice da cui iniziare la partizione
	 * @param fine l'indice a cui termianre la partizione
	 * 
	 * @return l'indice del pivot ottenuto
	 */
	private static int partiziona( Object[] array, int inizio, int fine )
	{
		Object pivot = array[ inizio ];
		do
		{
			while( inizio < fine && (array[ fine ].toString().compareTo( pivot.toString() ) <= 0) )
			{
				fine--;
			}

			if( inizio < fine )
			{
				array[ inizio ] = array[ fine ];

				while( inizio < fine && (array[ inizio ].toString().compareTo( pivot.toString() ) >= 0) )
				{
					inizio++;
				}

				if( inizio < fine )
				{
					array[ fine ] = array[ inizio ];
				}
			}
		}
		while( inizio < fine );

		array[ inizio ] = pivot;
		return inizio;
	}
}