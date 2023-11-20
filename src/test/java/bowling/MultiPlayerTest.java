package bowling;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MultiPlayerTest {

	private PartieMultiJoueurs partie;

	@BeforeEach
	public void setUp() {
		partie = new PartieMultiJoueurs();
	}

    @Test
    void test2tourPlusScore(){
        PartieMultiJoueurs partie = new PartieMultiJoueurs();
        String [] monTableau = {"Pierre", "Paul"};
        assertEquals(partie.demarreNouvellePartie(monTableau),"Prochain tir : joueur Pierre, tour n° 1, boule n° 1");
        assertEquals(partie.enregistreLancer(5),"Prochain tir : joueur Pierre, tour n° 1, boule n° 2");
        assertEquals(partie.enregistreLancer(3),"Prochain tir : joueur Paul, tour n° 1, boule n° 1");
        assertEquals(partie.enregistreLancer(10),"Prochain tir : joueur Pierre, tour n° 2, boule n° 1");
        assertEquals(partie.enregistreLancer(7),"Prochain tir : joueur Pierre, tour n° 2, boule n° 2");
        assertEquals(partie.enregistreLancer(3),"Prochain tir : joueur Paul, tour n° 2, boule n° 1");
        assertEquals(partie.scorePour("Pierre"),18);
        assertEquals(partie.scorePour("Paul"),10);
    }

    @Test
    void testScoreMauvaisNom(){
        assertThrows(NullPointerException.class, () -> { partie.scorePour("Jacques"); },"Cet appel doit lever une exception");
    }

    @Test
    void testPartieEntiereEtFin(){
        PartieMultiJoueurs partie = new PartieMultiJoueurs();
        String [] monTableau = {"Pierre", "Paul"};
        assertEquals(partie.demarreNouvellePartie(monTableau),"Prochain tir : joueur Pierre, tour n° 1, boule n° 1");
        assertEquals(partie.enregistreLancer(5),"Prochain tir : joueur Pierre, tour n° 1, boule n° 2");
        assertEquals(partie.enregistreLancer(3),"Prochain tir : joueur Paul, tour n° 1, boule n° 1");
        assertEquals(partie.enregistreLancer(10),"Prochain tir : joueur Pierre, tour n° 2, boule n° 1");
        assertEquals(partie.enregistreLancer(7),"Prochain tir : joueur Pierre, tour n° 2, boule n° 2");
        assertEquals(partie.enregistreLancer(3),"Prochain tir : joueur Paul, tour n° 2, boule n° 1");
        assertEquals(partie.scorePour("Pierre"),18);
        assertEquals(partie.scorePour("Paul"),10);
    }
}