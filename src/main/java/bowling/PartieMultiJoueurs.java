package bowling;

import java.util.HashMap;

public class PartieMultiJoueurs implements IPartieMultiJoueurs{
    private HashMap<String,PartieMonoJoueur> map;
    private int joueurCourant;
    private String[] nomsDesJoueurs;

    @Override
    public String demarreNouvellePartie(String[] nomsDesJoueurs) throws IllegalArgumentException {
        this.map= new HashMap<String,PartieMonoJoueur>();
        this.joueurCourant = 0;
        this.nomsDesJoueurs = nomsDesJoueurs;
        for(String nom : nomsDesJoueurs){
            map.put(nom, new PartieMonoJoueur());
        }
        return "Prochain tir : joueur "+nomsDesJoueurs[0]+", tour n° 1, boule n° 1";
    }

    @Override
    public String enregistreLancer(int nombreDeQuillesAbattues) throws IllegalStateException {
        if(!map.get(nomsDesJoueurs[joueurCourant]).enregistreLancer(nombreDeQuillesAbattues))suivant();
        if(map.get(nomsDesJoueurs[nomsDesJoueurs.length-1]).estTerminee()){
            return "Partie terminée";
        } else{
            return "Prochain tir : joueur "+nomsDesJoueurs[joueurCourant]+", tour n° "+map.get(nomsDesJoueurs[joueurCourant]).numeroTourCourant()+", boule n° "+map.get(nomsDesJoueurs[joueurCourant]).numeroProchainLancer();
        }
    }

    private void suivant() {
        joueurCourant=joueurCourant+1;
        if (joueurCourant==nomsDesJoueurs.length)joueurCourant=0;
    }

    @Override
    public int scorePour(String nomDuJoueur) throws IllegalArgumentException {
        if(map.get(nomDuJoueur)==null) throw new IllegalArgumentException(nomDuJoueur+" n'éxiste pas");
        return map.get(nomDuJoueur).score();
    }
    
}
