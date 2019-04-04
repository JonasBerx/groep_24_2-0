package domain;

import static org.junit.Assert.*;

import java.util.ArrayList;


import domain.db.DbException;
import domain.db.WoordLezer;
import domain.db.WoordenLijst;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WoordenLijstTest {
	
	private WoordenLijst woordenlijstLeeg;
	private WoordenLijst woordenlijstMetEenGeldigWoord;
	private WoordenLijst woordenlijstMetGeldigeWoorden;
	private WoordenLijst woordelijstWoordLezer;

	private WoordLezer woordLezer;

	private ArrayList<String> geldigeWoorden;

	@Before
	public void setUp() throws Exception, DbException {
		geldigeWoorden = new ArrayList<String>();
		geldigeWoorden.add("test");
		geldigeWoorden.add("game");
		geldigeWoorden.add("hangman");

		woordLezer = new WoordLezer("src\\domain\\db\\hangman.txt");
		
		woordenlijstLeeg = new WoordenLijst();

		woordelijstWoordLezer = new WoordenLijst(woordLezer);
		
		woordenlijstMetEenGeldigWoord = new WoordenLijst();
		woordenlijstMetEenGeldigWoord.voegToe(geldigeWoorden.get(0));
		
		woordenlijstMetGeldigeWoorden = new WoordenLijst();
		woordenlijstMetGeldigeWoorden.voegToe(geldigeWoorden.get(0));
		woordenlijstMetGeldigeWoorden.voegToe(geldigeWoorden.get(1));
		woordenlijstMetGeldigeWoorden.voegToe(geldigeWoorden.get(2));
		
	}

	@Test
	public void WoordenLijst_moet_een_Woordenlijst_maken_zonder_woorden() throws DbException, DomainException {
		WoordenLijst woordenlijstLeeg = new WoordenLijst();
		assertEquals(0,woordenlijstLeeg.getAantalWoorden());
	}
	
	@Test
	public void voegToe_moet_een_woord_toevoegen() throws DbException, DomainException {
		woordenlijstLeeg.voegToe(geldigeWoorden.get(0));
		assertEquals(1,woordenlijstLeeg.getAantalWoorden());
	}
	
	@Test (expected = DbException.class)
	public void voegToe_moet_exception_gooien_als_gegeven_woord_null() throws DbException {
		woordenlijstLeeg.voegToe(null);
	}
	
	@Test (expected = DbException.class)
	public void voegToe_moet_exception_gooien_als_gegeven_woord_leeg() throws DbException {
		woordenlijstLeeg.voegToe("");
	}
	
	@Test (expected = DbException.class)
	public void voegToe_moet_exception_gooien_als_gegeven_woord_reeds_in_lijst() throws DbException {
		String woordAlInLijst = geldigeWoorden.get(2);

		woordenlijstMetGeldigeWoorden.voegToe(woordAlInLijst);
	}

	@Test
	public void random_woord_geeft_Null_Lege_ArrayList() {
		woordenlijstLeeg.getRandomWoord();
		Assert.assertEquals("null",woordenlijstLeeg.getRandomWoord());
	}

	@Test
	public void random_woord_geeft_eerste_woord_van_Lijst_size_is_1() {
		woordenlijstMetEenGeldigWoord.getRandomWoord();
		Assert.assertEquals("test",woordenlijstMetEenGeldigWoord.getRandomWoord());
	}

	@Test
	public void random_woord_geeft_random_woord_van_Lijst() {
		woordenlijstMetGeldigeWoorden.getRandomWoord();
		Assert.assertEquals(String.class,woordenlijstMetEenGeldigWoord.getRandomWoord().getClass());
	}

	@Test
	public void geeft_size_terug_bij_woordlezer_lijst() throws DbException, DomainException {
		woordelijstWoordLezer.getAantalWoorden();
		Assert.assertEquals(12, woordelijstWoordLezer.getAantalWoorden());
		//Antwoord = 12
	}


}