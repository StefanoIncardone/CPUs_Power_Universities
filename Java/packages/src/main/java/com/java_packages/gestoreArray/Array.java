package gestoreArray;

/**
 * Una libreria per aiutare nella gestione di strutture di tipo array
 */
public abstract class Array
{
	/**
	 * Inverte l'ordine degli elementi dentro un array
	 * 
	 * @param array L'array da invertire
	 */
	public static final void inverti( int[] array )
	{
		for( int inizio = 0, fine = array.length - 1; inizio < fine; inizio++, fine-- )
		{
			scambia( array, inizio, fine );
		}
	}

	/**
	 * Inverte l'ordine degli elementi dentro un array
	 * 
	 * @param array L'array da invertire
	 */
	public static final void inverti( Object[] array )
	{
		for( int inizio = 0, fine = array.length - 1; inizio < fine; inizio++, fine-- )
		{
			scambia( array, inizio, fine );
		}
	}

	/**
	 * Controlla lo stato dell'array e ritorna vero se è ordinato
	 *
	 * @param array l'array da controllare
	 *
	 * @return vero se l'array è ordinato
	 */
	public static final boolean isOrdinata( int[] array )
	{
		for( int indice = 0; indice < array.length - 1; indice++ )
		{
			if( array[ indice ] > array[ indice + 1 ] )
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * Algoritmo per scambiare due elementi di un array
	 *
	 * @param array l'array su cui applicare lo scambio
	 * @param originale la posizione originale dell'elemento da scambiare
	 * @param finale la posizione verso cui eseguire lo scambio
	 */
	public static final void scambia( int[] array, int originale, int finale )
	{
		int temp			= array[ originale ];
		array[ originale ]	= array[ finale ];
		array[ finale ]		= temp;
	}

	/**
	 * Algoritmo per scambiare due elementi di un array
	 *
	 * @param array l'array su cui applicare lo scambio
	 * @param originale la posizione originale dell'elemento da scambiare
	 * @param finale la posizione verso cui eseguire lo scambio
	 */
	public static final void scambia( Object[] array, int originale, int finale )
	{
		Object temp			= array[ originale ];
		array[ originale ]	= array[ finale ];
		array[ finale ]		= temp;
	}
}
