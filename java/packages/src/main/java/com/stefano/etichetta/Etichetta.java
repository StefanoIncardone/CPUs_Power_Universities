package com.stefano.etichetta;

/**
 * Classe per modellare le etichette di pulsanti e testi durante del'esecuzione del programma
 */
public abstract class Etichetta
{
	/**
	 * Etichetta da usare durante il programma
	 */
	public static final String
		FILE							= "File",
		ESCI							= "Esci",

		TITOLO_ERRORE					= "Errore!",
		TITOLO_ANNULLAMENTO				= "Termino Programma!",

		MESSAGGIO_ERRORE				= "Oops, qualcosa sembra essere andato storto!",
		MESSAGGIO_ANNULLAMENTO			= "Operazione annullata!",

		TITOLO_FINESTRA					= "Monitor Sicurezza",
		TITOLO_SCELTA_OPERAZIONE		= "Scegli il tipo di operazione da eseguire",
		TITOLO_SCELTA_CIFRARIO			= "Scegli il tipo di cifrario da utilizzare",
		TITOLO_IMMISSIONE_CHIAVE		= "Immetti la chiave da utilizzare",

		ERRORE_CAMPO_VUOTO				= "Il campo di immissione della chiave non può essere vuoto!",
		ERRORE_LUNGHEZZA_CHIAVE			= "La chiave supera il limite di 16 caratteri",
		ERRORE_LETTURA_FILE				= "Errore durante la lettura del file",
		ERRORE_SALVATAGGIO_FILE			= "Errore durante il salvataggio del file",
		ERRORE_INESISTENTE				= "Veicolo non trovato!",
		ERRORE_FORMATO_TARGA			= "Formato di targa errato!",
		RICHIESTA_RIPROVARE				= "Vuoi riprovare?",

		TITOLO_TORNA_INDIETRO			= "Stai tornando indietro!",
		TITOLO_ANNULLA					= "Stai annullando l'operazione!",
		CONFERMA_SICURO					= "Ne sei sicuro?",

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
		ANNULLA							= "Annulla",
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
}