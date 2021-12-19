package gestoreNumero;

/**
 * Una libreria per aiutare nella gestione e rappresentazione
 * di diversi tipi di misure e unità di misura
 *
 * @author Stefano Incardone
 */
public abstract class Misura
{
	/**
	 * Formati di conversione per unità di misura per la lunghezza
	 */
	public static final double
		POLLICI_A_CM	= 2.54,
		CM_A_POLLICI	= 1 / POLLICI_A_CM,
		PIEDI_A_CM		= 30.48,
		CM_A_PIEDI		= 1 / PIEDI_A_CM,
		PIEDI_A_POLLICI	= 12,
		POLLICI_A_PIEDI	= 1 / PIEDI_A_POLLICI;

	/**
	 * Formati di conversione per unità di misura per la temperatura
	 * <p>
	 * celsius -> fahrenheit: (°C * CELSIUS_A_FAHRENHEIT) + FAHRENHEIT_OFFSET
	 * <p>
	 * fahrenheit -> celsius: (°F - FAHRENHEIT_OFFSET) * FAHRENHEIT_A_CELSIUS
	 */
	public static final double
		CELSIUS_A_FAHRENHEIT = 1.8,
		FAHRENHEIT_A_CELSIUS = 1 / CELSIUS_A_FAHRENHEIT;

	/**
	 * Offset per convertire tra temperature
	 */
	public static final int
		FAHRENHEIT_OFFSET = 32;

	/**
	 * Formati di conversione per unità di misura per il peso
	 */
	public static final double
		KG_A_LIBBRE	= 2.204623,
		LIBBRE_A_KG	= 1 / KG_A_LIBBRE;

	/**
	 * Informazioni misure terrestri
	 */
	public static final int
		MESI_IN_ANNO		= 12,
		SECONDI_IN_MINUTI	= 60,
		MINUTI_IN_ORE		= 60,
		ORE_IN_GIORNO		= 24;

	/**
	 * Informazioni sugli anni su altri pianeti espressi in giorni terrestri
	 */
	public static final int
		ANNO_MERCURIO	= 88,
		ANNO_VENERE		= 225,
		ANNO_TERRA		= 365,
		ANNO_LUNA		= 27,
		ANNO_MARTE		= 687,
		ANNO_GIOVE		= 4334,
		ANNO_SATURNO	= 10757,
		ANNO_URANO		= 30665,
		ANNO_NETTUNO	= 60224;

	/**
	 * Informazioni sulla gravità su altri pianeti espressi in m/s²
	 */
	public static final double
		GRAVITA_MERCURIO	= 3.7,
		GRAVITA_VENERE		= 8.87,
		GRAVITA_TERRA		= 9.81,
		GRAVITA_LUNA		= 1.62,
		GRAVITA_MARTE		= 3.72,
		GRAVITA_GIOVE		= 24.79,
		GRAVITA_SATURNO		= 10.44,
		GRAVITA_URANO		= 8.87,
		GRAVITA_NETTUNO		= 11.15;
}
