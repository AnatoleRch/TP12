package bowling;

public class main {
    public static void main(String[] args) {
        PartieMultiJoueurs partie = new PartieMultiJoueurs();
        String [] monTableau = {"Pierre", "Paul"};
System.out.println(partie.demarreNouvellePartie(monTableau));
    //➜ String "Prochain tir : joueur Pierre, tour n° 1, boule n° 1"
System.out.println(partie.enregistreLancer(5));
    //➜ String "Prochain tir : joueur Pierre, tour n° 1, boule n° 2"
System.out.println(partie.enregistreLancer(3));
    //➜ String "Prochain tir : joueur Paul, tour n° 1, boule n° 1"
System.out.println(partie.enregistreLancer(10));
    //➜ String "Prochain tir : joueur Pierre, tour n° 2, boule n° 1"
System.out.println(partie.enregistreLancer(7));
    //➜ String "Prochain tir : joueur Pierre, tour n° 2, boule n° 2"
System.out.println(partie.enregistreLancer(3));
    //➜ String "Prochain tir : joueur Paul, tour n° 2, boule n° 1"
System.out.println(partie.scorePour("Pierre"));
    //➜ int 18
System.out.println(partie.scorePour("Paul"));
    //➜ int 10
try {
    System.out.println(partie.scorePour("Jacques"));
} catch (IllegalArgumentException e) {
   System.out.println("error");
}
}
}
