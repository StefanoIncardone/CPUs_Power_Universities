package gestoreNumero;

/*
Codice per implementare supporto per frazioni partendo da un numero decimale
double numero = 14;
String
	numeroStr = String.valueOf( numero ),

	parteIntera = numeroStr.substring( 0, numeroStr.indexOf( "." ) ),
	parteDecimale = numeroStr.substring( numeroStr.indexOf( "." ) + 1, numeroStr.length() );

int
	numeratore = Integer.parseInt( parteIntera + parteDecimale ),
	denominatore = (Integer.parseInt( parteDecimale ) == 0) ?
					1 : (int) Math.pow( 10, parteDecimale.length() );
 */

/**
 * Una classe per rappresentare e gestire numeri in forma di frazione
 */
public class Frazione
	extends
		Numero
{
	//----------//
	//	DATI	//
	//----------//

	/**
	 * il numeratore di questa Frazione
	 */
	private int numeratore;

	/**
	 * il denominatore di questa Frazione
	 */
	private int denominatore;


	//--------------//
	//	COSTRUTTRI	//
	//--------------//

	/**
	 * Crea una Frazione del tipo numeratore / denominatore nel caso in cui
	 * entrambi i membri della Frazione siano positivi o negativi
	 * <p>
	 * Crea una Frazione del tipo -numeratore / denominatore nel caso in cui
	 * solo uno dei due membri della Frazione sia negativo
	 * <p>
	 * Crea una Frazione del tipo 0 / 1 quanto il numeratore è 0
	 *
	 * @param numeratore il numeratore della nuova Frazione
	 * @param denominatore il denominatore della nuova Frazione
	 */
	public Frazione( int numeratore, int denominatore )
	{
		this.numeratore = (denominatore < 0) ? -numeratore : numeratore;
		this.denominatore = (numeratore == 0) ? 1 : Math.abs( denominatore );
	}

	/**
	 * Crea una copia di una Frazione
	 *
	 * @param frazione la frazione da copiare
	 */
	public Frazione( Frazione frazione )
	{
		this( frazione.getNumeratore(), frazione.getDenominatore() );
	}
	
	/**
	 * Crea una Frazione del tipo: numeratore / 1
	 *
	 * @param numeratore il numeratore della nuova Frazione
	 */
	public Frazione( int numeratore )
	{
		this( numeratore, 1 );
	}
	
	/**
	 * Crea una Frazione del tipo: 1 / 1
	 */
	public Frazione()
	{
		this( 1, 1 );
	}


	//----------------------//
	//	METODI DI CLASSE	//
	//----------------------//

	/**
	 * Confronta i valori decimali corrispondenti delle due frazioni e
	 * restituisce la Frazione con il valore minore
	 *
	 * @param prima la prima Frazione da confrontare
	 * @param seconda la seconda Frazione da confrontare
	 *
	 * @return la Frazione con il valore minore
	 */
	public static final Frazione min( Frazione prima, Frazione seconda )
	{
		return (prima.decimale() <= seconda.decimale()) ? prima : seconda;
	}

	/**
	 * Confronta i valori decimali corrispondenti della Frazione
	 * e della Frazione corrispondente al numero e ritorna la Frazione con il valore minore
	 *
	 * @param prima la prima Frazione da confrontare
	 * @param numero il numero intero da confrontare
	 *
	 * @return la Frazione con il valore minore
	 */
	public static final Frazione min( Frazione prima, int numero )
	{
		return min( prima, new Frazione( numero ) );
	}

	/**
	 * Confronta i valori decimali corrispondenti delle due frazioni e
	 * restituisce la Frazione con il valore maggiore
	 *
	 * @param prima la prima Frazione da confrontare
	 * @param seconda la seconda Frazione da confrontare
	 *
	 * @return la Frazione con il valore maggiore
	 */
	public static final Frazione max( Frazione prima, Frazione seconda )
	{
		return (prima.decimale() >= seconda.decimale()) ? prima : seconda;
	}

	/**
	 * Confronta i valori decimali corrispondenti di questa Frazione
	 * e della frazione corrispondente al numero e ritorna la Frazione con il valore maggiore
	 *
	 * @param prima la prima Frazione da confrontare
	 * @param numero il numero intero da confrontare
	 *
	 * @return la Frazione con il valore maggiore
	 */
	public static final Frazione max( Frazione prima, int numero )
	{
		return max( prima, new Frazione( numero ) );
	}


	//----------------------//
	//	METODI DI ISTANZA	//
	//----------------------//

	/**
	 * Restituisce il valore decimale equivalente di questa Frazione
	 *
	 * @return il valore decimale equivalente di questa Frazione
	 */
	private double decimale()
	{
		return (double) (this.numeratore / this.denominatore);
	}

	/**
	 * Restituisce la rappresentazione sotto forma di String di questa Frazione
	 *
	 * @return la rappresentazione sotto forma di String di questa Frazione
	 */
	@Override
	public String toString()
	{
		return this.numeratore + " / " + this.denominatore;
	}

	/**
	 * Restituisce la Frazione ridotta ai minimi termini di questa Frazione
	 * oppure una copia di questa Frazione nel caso in cui quest'ultima sia zero
	 *
	 * @return un nuovo oggetto Fraction corrispondente alla forma ridotta di questa Frazione
	 */
	public Frazione semplifica()
	{
		int divisore = (this.numeratore != 0) ?
						Numero.MCD( Math.abs( this.numeratore ), this.denominatore ) : 1;

		return new Frazione( this.numeratore / divisore, this.denominatore / divisore );
	}

	/**
	 * Confronta questa Frazione con un'altra Frazione e ritorna vero se sono uguali
	 *
	 * @param frazione la Frazione da confrontare
	 *
	 * @return vero se il valore di questa Frazione e del parametro frazione sono uguali
	 */
	public boolean equals( Frazione frazione )
	{
		Frazione
			primaFrazione = this.semplifica(),
			secondaFrazione = frazione.semplifica();

		return	(primaFrazione.getNumeratore() == secondaFrazione.getNumeratore()) &&
				(primaFrazione.getDenominatore() == secondaFrazione.getDenominatore());
	}

	/**
	 * Confronta questa Frazione con un'altra Frazione
	 *
	 * @param frazione la Frazione da confrontare
	 *
	 * @return -1 se questa Frazione è minore del parametro frazione,
	 * 0 se questa Frazione è uguale al parametro frazione e
	 * 1 se questa Frazione è maggioe del parametro frazione
	 */
	public int compare( Frazione frazione )
	{
		return	(this.equals( frazione )) ? 0 : (this.decimale() < frazione.decimale()) ? -1 : 1;
	}

	/**
	 * Confronta questa Frazione con il parametro numero
	 *
	 * @param numero il numero intero da confrontare
	 *
	 * @return -1 se questa Frazione è minore del parametro numero,
	 * 0 se questa Frazione è uguale al parametro numero e
	 * 1 se questa Frazione è maggioe del parametro numero
	 */
	public int compare( int numero )
	{
		return this.compare( new Frazione( numero ) );
	}

	/**
	 * Restituisce la somma tra questa Frazione e un'altra Frazione
	 *
	 * @param frazione la Frazione da sommare a questa Frazione
	 *
	 * @return la Frazione somma NON ridotta tra questa Frazione e e un'altra Frazione
	 */
	public Frazione somma( Frazione frazione )
	{
		return new Frazione
		(
			this.numeratore * frazione.getDenominatore() +
				this.denominatore * frazione.getNumeratore(),
			this.denominatore * frazione.getDenominatore()
		);
	}

	/**
	 * Restituisce la somma tra questa Frazione e la Frazione corrispondente al numero
	 *
	 * @param numero il numero da sommare a questa Frazione
	 *
	 * @return la Frazione somma NON ridotta tra questa Frazione
	 * e la Frazione corrispondente al numero
	 */
	public Frazione somma( int numero )
	{
		return this.somma( new Frazione( numero ) );
	}

	/**
	 * Restituisce la differenza tra questa Frazione e un'altra Frazione
	 *
	 * @param frazione la Frazione da sottrarre a questa Frazione
	 *
	 * @return la Frazione differenza NON ridotta tra questa Frazione e un'altra Frazione
	 */
	public Frazione sottrai( Frazione frazione )
	{
		return new Frazione
		(
			this.numeratore * frazione.getDenominatore() -
				this.denominatore * frazione.getNumeratore(),
			this.denominatore * frazione.getDenominatore()
		);
	}

	/**
	 * Restituisce la differenza tra questa Frazione e la Frazione corrispondente al numero
	 *
	 * @param numero il numero da sottrarre a questa Frazione
	 *
	 * @return la Frazione differenza NON ridotta tra questa Frazione
	 * e la Frazione corrispondente al numero
	 */
	public Frazione sottrai( int numero )
	{
		return this.sottrai( new Frazione( numero ) );
	}

	/**
	 * Restituisce il quoziente tra questa Frazione e un'altra frazione
	 *
	 * @param frazione la Frazione divisore della divisione
	 *
	 * @return la Frazione quoziente NON ridotta tra questa Frazione e un'altra frazione
	 */
	public Frazione dividi( Frazione frazione )
	{
		return new Frazione
		(
			this.numeratore * frazione.getDenominatore(),
			this.denominatore * frazione.getNumeratore()
		);
	}

	/**
	 * Restituisce il quoziente tra questa Frazione e la Frazione corrispondente al numero
	 *
	 * @param numero il numero divisore della divisione
	 *
	 * @return la Frazione quoziente NON ridotta tra questa Frazione
	 * e la Frazione corrispondente al numero
	 */
	public Frazione dividi( int numero )
	{
		return this.dividi( new Frazione( numero ) );
	}

	/**
	 * Restituisce il prodotto tra questa Frazione e un'altra frazione
	 *
	 * @param frazione la Frazione moltiplicatore della moltiplicazione
	 *
	 * @return la Frazione prodotto NON ridotta tra questa Frazione e un'altra frazione
	 */
	public Frazione moltiplica( Frazione frazione )
	{
		return new Frazione
		(
			this.numeratore * frazione.getNumeratore(),
			this.denominatore * frazione.getDenominatore()
		);
	}

	/**
	 * Restituisce il prodotto tra questa Frazione e la Frazione corrispondente al numero
	 *
	 * @param numero il numero moltiplicatore della moltiplicazione
	 *
	 * @return la Frazione prodotto NON ridotta tra questa Frazione
	 * e la Frazione corrispondente al numero
	 */
	public Frazione moltiplica( int numero )
	{
		return this.moltiplica( new Frazione( numero ) );
	}

	/**
	 * Imposta il numeratore di questa Frazine
	 *
	 * @param unNumeratore il numeratore da assegnare a questa Frazione
	 */
	public void setNumeratore( int unNumeratore )
	{
		this.numeratore = unNumeratore;
	}

	/**
	 * Restituisce il numeratore di questa Frazione
	 *
	 * @return il numeratore di questa Frazione
	 */
	public int getNumeratore()
	{
		return this.numeratore;
	}

	/**
	 * Imposta il denominatore di questa Frazine
	 *
	 * @param unDenominatore il denominatore da assegnare a questa Frazione
	 */
	public void setDenominatore( int unDenominatore )
	{
		if( unDenominatore == 0 )
		{
			System.out.println( "\n" + "Errore fatale" + "\n" );
			System.exit( -1 );
		}
		this.denominatore = unDenominatore;
	}

	/**
	 * Restituisce il denominatore di questa Frazione
	 *
	 * @return il denominatore di questa Frazione
	 */
	public int getDenominatore()
	{
		return this.denominatore;
	}
}
