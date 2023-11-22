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
    void testScore(){
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
        assertEquals(partie.enregistreLancer(10),"Prochain tir : joueur Paul, tour n° 1, boule n° 1");
        assertEquals(partie.enregistreLancer(10),"Prochain tir : joueur Pierre, tour n° 2, boule n° 1");
        assertEquals(partie.enregistreLancer(10),"Prochain tir : joueur Paul, tour n° 2, boule n° 1");
        assertEquals(partie.enregistreLancer(10),"Prochain tir : joueur Pierre, tour n° 3, boule n° 1");
        assertEquals(partie.enregistreLancer(10),"Prochain tir : joueur Paul, tour n° 3, boule n° 1");
        assertEquals(partie.enregistreLancer(10),"Prochain tir : joueur Pierre, tour n° 4, boule n° 1");
        assertEquals(partie.enregistreLancer(10),"Prochain tir : joueur Paul, tour n° 4, boule n° 1");
        assertEquals(partie.enregistreLancer(10),"Prochain tir : joueur Pierre, tour n° 5, boule n° 1");
        assertEquals(partie.enregistreLancer(10),"Prochain tir : joueur Paul, tour n° 5, boule n° 1");
        assertEquals(partie.enregistreLancer(10),"Prochain tir : joueur Pierre, tour n° 6, boule n° 1");
        assertEquals(partie.enregistreLancer(10),"Prochain tir : joueur Paul, tour n° 6, boule n° 1");
        assertEquals(partie.enregistreLancer(10),"Prochain tir : joueur Pierre, tour n° 7, boule n° 1");
        assertEquals(partie.enregistreLancer(10),"Prochain tir : joueur Paul, tour n° 7, boule n° 1");
        assertEquals(partie.enregistreLancer(10),"Prochain tir : joueur Pierre, tour n° 8, boule n° 1");
        assertEquals(partie.enregistreLancer(10),"Prochain tir : joueur Paul, tour n° 8, boule n° 1");
        assertEquals(partie.enregistreLancer(10),"Prochain tir : joueur Pierre, tour n° 9, boule n° 1");
        assertEquals(partie.enregistreLancer(10),"Prochain tir : joueur Paul, tour n° 9, boule n° 1");
        assertEquals(partie.enregistreLancer(10),"Prochain tir : joueur Pierre, tour n° 10, boule n° 1");
        assertEquals(partie.enregistreLancer(10),"Prochain tir : joueur Pierre, tour n° 10, boule n° 2");
        assertEquals(partie.enregistreLancer(10),"Prochain tir : joueur Pierre, tour n° 10, boule n° 3");
        assertEquals(partie.enregistreLancer(10),"Prochain tir : joueur Paul, tour n° 10, boule n° 1");
        assertEquals(partie.enregistreLancer(10),"Prochain tir : joueur Paul, tour n° 10, boule n° 2");
        assertEquals(partie.enregistreLancer(10),"Prochain tir : joueur Paul, tour n° 10, boule n° 3");
        assertEquals(partie.enregistreLancer(10),"Partie terminée");
        assertEquals(300,partie.scorePour("Pierre"));
        assertEquals(300,partie.scorePour("Paul"));
    }
}