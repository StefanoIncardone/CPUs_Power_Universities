package gestoreNumero;

import java.text.*;
import java.util.Random;

/**
 * Una libreria per aiutare nella gestione e rappresentazione di vari tipi e formati di numeri
 * 
 * @see Frazione libreria per gestione di numeri in forma di frazione
 *
 * @author Stefano Incardone
 */
public abstract class Numero
{
	//------------------//
	//	DATI DI CLASSE	//
	//------------------//

	/**
	 * Istanze classe DecimalFormat per formattare in diversi stili
	 * <p>
	 * a == m/s²
     * <p>
	 * pc == %, i valori hanno un moltiplicatore di 100, per evitarlo inserire il token % come '%',
	 * oppure usare il metodo setMultiplier()
	 */
	public static final DecimalFormat
		df_X_XX_		= new DecimalFormat( "0.00" ),
		df_X_XX_cm_		= new DecimalFormat( "0.00 cm" ),
		df_X_XX_cm2_	= new DecimalFormat( "0.00 cm²" ),
		df_X_XX_Kg_		= new DecimalFormat( "0.00 Kg" ),
		df_X_XX_a_		= new DecimalFormat( "0.00 m/s²" ),
		df_€_X_XX_		= new DecimalFormat( "€ 0.00" ),
		df_X_XX_pc_		= new DecimalFormat( "0.00 %" );


	//----------------------//
	//	METODI DI CLASSE	//
	//----------------------//

	/**
	 * Genera e restituisce un numero casuale compreso tra i due valori MIN e MAX
	 *
	 * @param MIN l'estremo inferiore
	 * @param MAX l'estremo superiore
	 *
	 * @return il numero casuale generato tra MIN e MAX
	 */
	public static final int randomInt( int MIN, int MAX )
	{
		return (int) Math.floor( Math.random() * (MAX - MIN + 1) + MIN );
	}

	/**
	 * Genera e restituisce un numero casuale compreso tra 0 e MAX
	 *
	 * @param MAX l'estremo superiore
	 *
	 * @return il numero casuale generato tra 0 e MAX
	 */
	public static final int randomInt( int MAX )
	{
		return randomInt( 0, MAX );
	}

	/**
	 * Genera e restituisce un numero casuale compreso tra i due valori MIN e MAX
	 *
	 * @param MIN l'estremo inferiore
	 * @param MAX l'estremo superiore
	 *
	 * @return il numero casuale generato tra MIN e MAX
	 */
	public static final double randomDouble( double MIN, double MAX )
	{
		return new Random().nextDouble() * (MAX - MIN) + MIN;
	}

	/**
	 * Genera e restituisce un numero casuale compreso tra 0 e MAX
	 *
	 * @param MAX l'estremo superiore
	 *
	 * @return il numero casuale generato tra 0 e MAX
	 */
	public static final double randomDouble( double MAX )
	{
		return randomDouble( 0, MAX );
	}

	/**
	 * Sceglie e ritorna casualmente uno dei due numeri specificati
	 * 
	 * @param primo il primo numero tra cui scegliere
	 * @param secondo il secondo numero tra cui scegliere
	 * 
	 * @return un numero casuale tra i due
	 */
	public static final int scegli( int primo, int secondo )
	{
		return (randomInt( 1 ) == 0) ? primo : secondo;
	}

	/**
	 * Calcola se il numero sia o meno un primo e ritorna vero in caso lo sia
	 *
	 * @param numero il numero da testare
	 *
	 * @return vero se il numero è primo
	 */
	public static final boolean isPrimo( int numero )
	{
		if( numero < 2 )
		{
			return false;
		}

		for( int fattore = 2; fattore * fattore <= numero; fattore++ )
		{
			if( numero % fattore == 0 )
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * Restituisce il massimo comune divisore tra i due numeri
	 *
	 * @param primo il primo numero
	 * @param secondo il secondo numero
	 *
	 * @return il massimo comune divisore
	 */
	public static final int MCD( int primo, int secondo )
	{
		int resto;
		while( (resto = secondo % primo) != 0 )
		{
			secondo	= primo;
			primo	= resto;
		}
		return primo;
	}
}
