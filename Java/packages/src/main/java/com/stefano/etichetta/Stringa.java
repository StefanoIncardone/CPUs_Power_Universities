package com.stefano.etichetta;


import java.awt.*;
import java.text.*;

import com.stefano.gestoreNumero.Numero;

/**
 * Classe per aiutare nella rappresentazioni sotto forma di stringa
 */
public abstract class Stringa
{
	public static final int MAIUSCOLE = 0;

	public static final int MINUSCOLE = 1;

	public static final int MIN_ASCII_MAIUSCOLE = 64;

	public static final int MAX_ASCII_MAIUSCOLE = 90;

	public static final int MIN_ASCII_MINUSCOLE = 97;

	public static final int MAX_ASCII_MINUSCOLE = 122;

	/**
	 * Un font monospaced
	 */
	public static final Font monospaced = new Font( "Monospaced", Font.BOLD, 16 );

	/**
	 * Un oggetto SimpleDateFormat per formattare le date in formato "dd/MM/yyyy, hh:mm:ss a"
	 */
	public static final SimpleDateFormat formatoData = new SimpleDateFormat( "dd/MM/yyyy, hh:mm:ss a" );

	/**
	 * Restituisce la versione con la prima lettera in maiuscolo della parola specificata
	 * 
	 * @param parola la parola da elaborare
	 * 
	 * @return la parola con la prima lettera in maiuscolo
	 */
	public static final String primaLetteraMaiuscola( String parola )
	{
		parola = parola.toLowerCase();
		return parola.substring( 0, 1 ).toUpperCase() + parola.substring( 1 );
	}

	/**
	 * Converte la frase in un formato senza spazi
	 *
	 * @param frase la frase da convertire
	 *
	 * @return la frase in formato convertito
	 */
	public static final String rimuoviSpazi( String frase )
	{
		return frase.replaceAll( "[^A-Za-z0-9]", "" );
	}

	public static final void rimuoviDuplicati( StringBuilder testo )
	{
		for( int i = 0; i < testo.length(); i++ )
		{
			for( int j = i + 1; j < testo.length(); j++ )
			{
				if( testo.charAt( i ) == testo.charAt( j ) )
				{
					testo.delete( j, j + 1 );
				}
			}
		}
	}

	public static final char randomChar( int opzione, int MIN, int MAX )
	{
		switch( opzione )
		{
			case MAIUSCOLE:
				return (char) Numero.randomInt( MIN_ASCII_MAIUSCOLE, MAX_ASCII_MAIUSCOLE );

			case MINUSCOLE:
				return (char) Numero.randomInt( MIN_ASCII_MINUSCOLE, MAX_ASCII_MINUSCOLE );

			default:
				return (char) Numero.randomInt( MIN, MAX );
		}
	}

	public static final char randomChar()
	{
		return randomChar( -1, 0, 255 );
	}
}
