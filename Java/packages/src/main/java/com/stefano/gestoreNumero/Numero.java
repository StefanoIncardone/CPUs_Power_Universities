package com.stefano.gestoreNumero;

import java.security.SecureRandom;
import java.math.BigInteger;
import java.text.*;
import java.util.*;

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
	public static final int random( int primo, int secondo )
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
	public static final int GCD( int primo, int secondo )
	{
		int resto;
		while( secondo > 0 )
		{
			resto = primo % secondo;
			primo = secondo;
			secondo = resto;
		}

		return primo;
	}

	public static final int inversoMoltiplicativo( int modulo, int numero )
	{
		int a = 0, b = 1;
		int q, t0, t1;

		while( numero > 0 )
		{
			if( numero == 1 )
			{
				return b;
			}

			q = Math.floorDiv( modulo, numero );

			t0 = a - q * b;
			t1 = modulo - q * numero;

			a = b;
			modulo = numero;

			b = t0;
			numero = t1;
		}

		return modulo;
	}

	public static final int[][] moltiplicaMatriciGF2_8( byte[][] prima, int[][] seconda )
	{
		int[][] temp = new int[ 4 ][ 4 ];

		for( int riga = 0; riga < 4; riga++ )
		{
			for( int colonna = 0; colonna < 4; colonna++ )
			{
				temp[ riga ][ colonna ] =
				(
					moltiplicaInGF2_8( prima[ riga ][ 0 ], seconda[ 0 ][ colonna ] ) ^
					moltiplicaInGF2_8( prima[ riga ][ 1 ], seconda[ 1 ][ colonna ] ) ^
					moltiplicaInGF2_8( prima[ riga ][ 2 ], seconda[ 2 ][ colonna ] ) ^
					moltiplicaInGF2_8( prima[ riga ][ 3 ], seconda[ 3 ][ colonna ] )
				);
			}
		}

		return temp;
	}

	public static final int moltiplicaInGF2_8( int moltiplicando, int moltiplicatore )
	{
		int prodotto = 0;

		for( int counter = 0; counter < 8 && moltiplicando > 0 && moltiplicatore > 0; counter++ )
		{
			if( (moltiplicatore & 0b1) == 1 )
			{
				prodotto ^= moltiplicando;
			}
			moltiplicatore >>= 1;

			boolean isCarrySet = (moltiplicando & (0b1 << 7)) > 0;

			moltiplicando = (moltiplicando << 1) & 0xff;

			if( isCarrySet )
			{
				moltiplicando ^= 0x1b;
			}
		}

		return prodotto;
	}

	public static final SortedSet<Integer> scomponiInFattoriPrimi( int numero )
	{
		SortedSet<Integer> fattori = new TreeSet<Integer>();

		for( int fattore = 2; fattore <= numero; fattore++ )
		{
			while( numero % fattore == 0 )
			{
				fattori.add( fattore );
				numero /= fattore;
			}
		}

		return fattori;
	}

	public static final int toziente( int numero )
	{
		SortedSet<Integer> fattori = scomponiInFattoriPrimi( numero );

		double valoreToziente = 1;
		double uno = 1;

		for( Object fattore : fattori.toArray() )
		{
			valoreToziente *= (uno - (uno / (int) fattore) );
		}

		valoreToziente *= numero;

		return (int) valoreToziente;
	}

	public static boolean isPrimeMillerRabin( int numero, int iterazioni )
	{
		if( numero < 2 )
		{
			return false;
		}
	 
		int d = numero - 1;
		 
		while( d % 2 == 0 )
		{
			d /= 2;
		}
	 
		for( int i = 0; i < iterazioni; i++ )
		{
			if( !miillerTest( d, numero ) )
			{
				return false;
			}
		}
	 
		return true;
	}

	// questa funzione viene chiama tutte le k volte, ritorna vero se il numero è probabilmente primo
	// d è un numero primo tale che 2^r * q = n - 1 per r >= 1
	private static boolean miillerTest( int q, int numero )
	{
		// prende un numero casuale tra 2 e n - 2 assicurandosi che n sia maggiore di 4
		int a = 2 + (int) (Math.random() % (numero - 4));
	
		int x = powMod( a, q, numero );
	 
		if( x == 1 || x == numero - 1 )
		{
			return true;
		}
	 
		while( q != numero - 1 )
		{
			x = (x * x) % numero;
			q *= 2;
		 
			if( x == 1 )
			{
				return false;
			}
			if( x == numero - 1 )
			{
				return true;
			}
		}
	 
		return false;
	}

	public static int powMod( int x, int y, int modulo )
	{
		int risultato = 1;
		 
		x = x % modulo;
 
		while( y > 0 )
		{
			if( (y & 1) == 1 )
			{
				risultato = (risultato * x) % modulo;
			}
		 
			// y + sicuramente pari adesso
			y /= 2; // y = y/2
			x = (x * x) % modulo;
		}
		 
		return risultato;
	}

	public static final List<BigInteger> getFattoriRhoDiPollard( BigInteger numero )
	{
		RhoDiPollard rho = new RhoDiPollard();
		rho.calcolaFattori( numero );

		return rho.getFattori();
	}

	public static final BigInteger applicaTeoreaCineseDelResto( String coefficienti, String moduli )
	{
		if( coefficienti.length() != moduli.length() )
		{
			throw new IllegalArgumentException( "il numero dei coefficienti non corrisponde al numero dei moduli" );
		}

		List<Integer> listaCoefficienti = new ArrayList<Integer>();
		List<Integer> listaModuli = new ArrayList<Integer>();

		for( int posizione = 0; posizione < coefficienti.length(); posizione++ )
		{
			listaCoefficienti.add( (int) coefficienti.charAt( posizione ) );
			listaModuli.add( (int) moduli.charAt( posizione ) );
		}

		BigInteger M = BigInteger.ONE;
		for( int carattere : listaModuli )
		{
			M = M.multiply( new BigInteger( String.valueOf( carattere ) ) );
		}

		BigInteger risultato = BigInteger.ZERO;
		for( int posizione = 0; posizione < listaCoefficienti.size(); posizione++ )
		{
			BigInteger M_diviso_m = M.divide( new BigInteger( listaModuli.get( posizione ).toString() ) );

			risultato =
			(
				risultato.add
				(
					new BigInteger( listaCoefficienti.get( posizione ).toString() )
						.multiply( M_diviso_m )
						.multiply( trovaSoluzioneTCR( M_diviso_m, listaModuli.get( posizione ).toString() ) )
				)
			);
		}

		return risultato;
	}

	private static BigInteger trovaSoluzioneTCR( BigInteger M_diviso_m, String carattereChiave )
	{
		BigInteger soluzione;
		BigInteger modulo = new BigInteger( carattereChiave );

		for( soluzione = BigInteger.ONE; ;soluzione = soluzione.add( BigInteger.ONE ) )
		{
			if( M_diviso_m.multiply( soluzione ).mod( modulo ).compareTo( BigInteger.ONE ) == 0 )
			{
				return soluzione;
			}
		}
	}
}

final class RhoDiPollard
{
	private final List<BigInteger> fattori = new ArrayList<BigInteger>();

	private final SecureRandom random = new SecureRandom();

	private BigInteger rho( BigInteger numero )
	{
		BigInteger divisor;
		BigInteger c = new BigInteger( numero.bitLength(), random );
		BigInteger x = new BigInteger( numero.bitLength(), random );
		BigInteger x2 = x;

		// check divisibility by 2
		if( numero.mod( BigInteger.TWO ).compareTo( BigInteger.ZERO ) == 0 )
		{
			return BigInteger.TWO;
		}

		do
		{
			x = x.multiply( x ).mod( numero ).add( c ).mod( numero );
			x2 = x2.multiply( x2 ).mod( numero ).add( c ).mod( numero );
			x2 = x2.multiply( x2 ).mod( numero ).add( c ).mod( numero );
			divisor = x.subtract( x2 ).gcd( numero );
		}
		while( divisor.compareTo( BigInteger.ONE ) == 0 );

		return divisor;
	}

	public void calcolaFattori( BigInteger numero )
	{
		if( numero.compareTo( BigInteger.ONE ) == 0 )
		{
			return;
		}

		if( numero.isProbablePrime( 20 ) )
		{
			fattori.add( numero );
			return;
		}

		BigInteger divisor = rho( numero );
		calcolaFattori( divisor );
		calcolaFattori( numero.divide( divisor ) );
	}

	public List<BigInteger> getFattori()
	{
		return fattori;
	}
}