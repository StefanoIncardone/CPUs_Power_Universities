package gestoreArray;

/**
 * Una classe contenente algoritmi di ricerca per array.
 * algoritmi implementati:
 * Linear search;
 * Binary search;
 * IsPresente [BinarySearch];
 */
public abstract class Search
{
	/**
	 * codice di ritorno in caso di un elemento non trovato
	 */
	public static final int
		NOT_FOUND = -1;


	/**
	 * Ricerca all'interno dell'array mediante un algoritmo di ricerca lineare e ritorna l'indice dell'elemento
	 * da ricercare oppure NOT_FOUND (-1) nel caso in cui non fosse presente
	 *
	 * @param array l'array su cui applicare la ricerca
	 * @param elemento l'elemento da ricercare dentro l'array
	 *
	 * @return l'indice dell'elemento da ricercare oppure NOT_FOUND (-1)
	 */
	public static final int linear( int[] array, int elemento )
	{
		for( int indice = 0; indice < array.length; indice++ )
		{
			if( array[ indice ] == elemento )
			{
				return indice;
			}
		}
		return NOT_FOUND;
	}

	/**
	 * Ricerca all'interno dell'array mediante un algoritmo di ricerca lineare e ritorna l'indice dell'elemento
	 * da ricercare oppure NOT_FOUND (-1) nel caso in cui non fosse presente
	 *
	 * @param array l'array su cui applicare la ricerca
	 * @param elemento l'elemento da ricercare dentro l'array
	 *
	 * @return l'indice dell'elemento da ricercare oppure NOT_FOUND (-1)
	 */
	public static final int linear( Object[] array, Object elemento )
	{
		for( int indice = 0; indice < array.length; indice++ )
		{
			if( array[ indice ].toString().equals( elemento ) )
			{
				return indice;
			}
		}
		return NOT_FOUND;
	}

	/**
	 * NB: l'array deve essere ordinato prima di poter applicare questo algoritmo.
	 * Ricerca all'interno dell'array mediante un algoritmo di ricerca binaria e ritorna l'indice dell'elemento
	 * da ricercare oppure NOT_FOUND (-1) nel caso in cui non fosse presente
	 *
	 * @param array l'array su cui applicare la ricerca
	 * @param ricerca l'elemento da ricercare dentro l'array
	 *
	 * @return l'indice dell'elemento da ricercare oppure NOT_FOUND (-1)
	 */
	public static final int binary( int[] array, int ricerca )
	{
		for( int minimo = 0, massimo = array.length - 1; minimo <= massimo; )
		{
			int centro = minimo + (massimo - minimo) / 2;

			if( array[ centro ] == ricerca )
			{
				return centro;
			}
			else if( array[ centro ] < ricerca )
			{
				minimo = centro + 1;
			}
			else
			{
				massimo = centro - 1;
			}
		}
		return NOT_FOUND;
	}

	/**
	 * NB: l'array deve essere ordinato prima di poter applicare questo algoritmo.
	 * Ricerca all'interno dell'array mediante un algoritmo di ricerca binaria e ritorna vero nel caso in cui
	 * l'elemento sia stato trovato
	 *
	 * @param array l'array su cui applicare la ricerca
	 * @param elemento l'elemento da ricercare dentro l'array
	 *
	 * @return vero se il parametro ricerca è presente dentro l'array
	 */
	public static final boolean isPresenteBinary( int[] array, int elemento )
	{
		return binary( array, elemento ) > NOT_FOUND;
	}

	/**
	 * NB: l'array deve essere ordinato prima di poter applicare questo algoritmo.
	 * Ricerca all'interno dell'array mediante un algoritmo di ricerca lineare e ritorna vero nel caso in cui
	 * l'elemento sia stato trovato
	 *
	 * @param array l'array su cui applicare la ricerca
	 * @param elemento il numero da ricercare dentro l'array
	 *
	 * @return vero se il parametro ricerca è presente dentro l'array
	 */
	public static final boolean isPresenteLinear( int[] array, int elemento )
	{
		return linear( array, elemento ) > NOT_FOUND;
	}
}