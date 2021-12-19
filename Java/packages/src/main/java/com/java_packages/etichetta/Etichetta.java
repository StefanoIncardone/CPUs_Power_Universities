package etichetta;

import java.awt.*;
import javax.swing.*;

import utilita.GestoreFile;

/**
 * Classe per modellare le etichette di pulsanti e testi durante del'esecuzione del programma
 */
public abstract class Etichetta
{
	/**
	 * Immagine icona finestra
	 */
	public static final Image
		ICONA_KORE = new ImageIcon( GestoreFile.cercaFile( "KORE.png" ) ).getImage();

	/**
	 * Icona da impostare come icona pulsante Home nella schermata del monitor
	 */
	public static final ImageIcon
		ICONA_MONITOR		= getIcona( "ENNA.png",				60, 120 );

	/**
	 * Icona da impostare sul pulsante per mostrare i veicoli ammessi e i relativi formati di targa
	 */
	public static final ImageIcon
		ICONA_INFO_TARGHE	= getIcona( "INTERROGATIVO.png",	15, 15 );

	/**
	 * Icona da impostare sul pulsante per pulire i pannelli delle informazioni dei veicoli
	 */
	public static final ImageIcon
		ICONA_REFRESH		= getIcona( "REFRESH.png",			15, 15 );

	/**
	 * Etichetta da usare durante il programma
	 */
	public static String
		FILE							= "File",
		ESCI							= "Esci",

		TITOLO_ERRORE					= "Errore!",
		MESSAGGIO_ERRORE				= "Oops, qualcosa sembra essere andato storto!",

		TITOLO_FINESTRA					= "Monitor (C)ome (F)ind (U)s Enna",

		ERRORE_CAMPO_VUOTO				= "Il campo non può essere vuoto",
		ERRORE_INESISTENTE				= "Veicolo non trovato",
		ERRORE_FORMATO_TARGA			= "Formato di targa errato",
		RICHIESTA_RIPROVARE				= "Vuoi riprovare?",

		TITOLO_TORNA_INDIETRO			= "Stai tornando indietro",
		CONFERMA_TORNA_INDIETRO			= "Ne sei sicuro?",

		MESSAGGIO_INIZIO				= "Gestione ingressi",
		MONITOR_VEICOLI					= "Mostra monitor entrate",

		MONITOR							= "Monitor",
		MESSAGGIO_INFO					= "Veicoli ammessi",

		VEICOLI_PRESENTI				= "Veicoli presenti",
		LISTA_TARGHE					= "Lista targhe registrate",
		CERCA_TARGA						= "Cerca una targa",

		SUGGERIMENTO_HOME				= "Torna alla pagina iniziale",
		SUGGERIMENTO_INFO				= "Informazioni veicoli ammessi",
		SUGGERIMENTO_REFRESH			= "Pulisci pannelli",
		SUGGERIMENTO_RICERCA			= "Cerca targa selezionata",
		SUGGERIMENTO_CARATTERISTICHE	= "Seleziona un veicolo per visionarne le caratteristiche",
		SUGGERIMENTO_MULTE				= "Seleziona un veicolo per visionarne le multa",

		INFO_VEICOLO					= "Informazioni veicolo",
		CARATTERISTICHE_VEICOLO			= "Caratteristiche veicolo",
		NON_DISPONIBILE					= "Non Disponibile",

		LISTA_MULTE						= "Lista multe",
		GESTIONE_MULTA					= "Gestisci multe",

		ORDINA_PER						= "Ordina per",

		SI								= "Si",
		NO								= "No",

		INVIO							= "Invio",
		INDIETRO						= "Indietro",

		ASSEGNA							= "Assegna",
		RIMUOVI							= "Rimuovi"
		;

	/**
	 * Opzioni per richiedere una conferma all'utente tramite pannello JOptionPane
	 * (in quanto quelle standard sono in inglese)
	 */
	public static final Object[]
		OPZIONI_CONFERMA = { SI, NO };

	/**
	 * Modalità ordinamento disponibili per la lista delle targhe registrate dentro il centro storico
	 */
	public static final String[]
		OPZIONI_ORDINAMENTO =
		{
			"Data (crescente)",
			"Data (decrescente)",
			"Alfabetico (A-Z)",
			"Alfabetico (Z-A)",
			"Categoria (speciale)",
			"Categoria (comune)"
		};

	/**
	 * Carica e converte a icona l'immagine specificata e ne ritorna la versione ridimensionata sotto forma di
	 * oggetto Image
	 * 
	 * @param immagine L'immagine iniziale da convertire a icona
	 * @param larghezza La larghezza finale dell'icona
	 * @param altezza L'altezza finale dell'icona
	 * 
	 * @return Un oggetto ImageIcon da poter essere applicato come icona di un pulsante
	 */
	private static ImageIcon getIcona( String immagine, int larghezza, int altezza )
	{
		return new ImageIcon
		(
			new ImageIcon( GestoreFile.cercaFile( immagine ) )
				.getImage()
				.getScaledInstance( larghezza, altezza, Image.SCALE_SMOOTH )
		);
	}
}