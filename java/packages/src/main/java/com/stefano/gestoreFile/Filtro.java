package com.stefano.gestoreFile;

import java.io.*;
import javax.swing.filechooser.FileFilter;

public class Filtro extends FileFilter
{
	private String estensioneFile;

	private String descrizioneFiltro;
	
	public Filtro( String estensione, String descrizione )
	{
		this.estensioneFile = estensione;
		this.descrizioneFiltro = descrizione;
	}
		
	public void setEstensione( String estensione )
	{
		this.estensioneFile = estensione;
	}

	public String getEstensione()
	{
		return this.estensioneFile;
	}

	public void setDescrizione( String descrizione )
	{
		this.descrizioneFiltro = descrizione;
	}

	public String getDescrizione()
	{
		return this.descrizioneFiltro;
	}

	public String getDescription()
	{
		return descrizioneFiltro + " (." + this.estensioneFile + ")";
	}

	public boolean accept( File file )
	{
		return file.isDirectory() ? true : extension( file ).equalsIgnoreCase( this.estensioneFile );
	}
	
	public String extension( File file )
	{
		String nomeFile = file.getName();
		int posizione = nomeFile.lastIndexOf( "." );

		return (posizione > 0 && posizione < (nomeFile.length() - 1)) ? nomeFile.substring( posizione + 1 ) : "";
	}
}