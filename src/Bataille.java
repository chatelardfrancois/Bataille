import java.util.ArrayList;
import java.util.Random;

public class Bataille {

    public static void bataille(Joueur j1, Joueur j2){

        final int CARTE = 0;

        boolean tasPlein=false;

        boolean j1GagnantManche=false;

        int nbCoups= 0;

        // Création d'un paquet de carte de 52 cartes
        Carte[] jeuDeCarte = JeuCarte.getTabDeCarte();

        // Distribution aléatoire de la première moitié du paquet de cartes dans le deck du premier joueur
        j1.setDeck(JeuCarte.distribuerJeu(jeuDeCarte));

        // Distribution aléatoire de la deuxième moitié du paquet de cartes dans le deck du deuxième joueur
        j2.setDeck(JeuCarte.distribuerJeu(jeuDeCarte));

        // Création d'un tas qui récupère les cartes lors d'une égalité
        ArrayList<Carte> tas = new ArrayList<>();

        ArrayList<Carte> defausse = new ArrayList<>();



        do {


            //Vérifie si les decks sont vides
            if(!j1.getDeck().isEmpty() && !j2.getDeck().isEmpty()){


                //Comparaison des premières cartes de chaque liste et résolution de conflit

                //Carte joueur 1 > Carte joueur 2
                if (j1.getCarte(CARTE).getValeur().ordinal() > j2.getCarte(CARTE).getValeur().ordinal()) {
                    System.out.printf("%s bat %s%n",j1.getCarte(CARTE), j2.getCarte(CARTE));

                    if(j1GagnantManche){
                        JeuCarte.ajouterCarteListe(j2.getDeck(), CARTE, defausse);
                        JeuCarte.ajouterCarteListe(j1.getDeck(), CARTE, defausse);
                    } else {
                        JeuCarte.ajouterCarteListe(j1.getDeck(), CARTE, defausse);
                        JeuCarte.ajouterCarteListe(j2.getDeck(), CARTE, defausse);
                    }

                    JeuCarte.viderTas(defausse, j1.getDeck());
                    j1GagnantManche=true;

                    // Si égalité antérieure, résolution
                    if(tasPlein){

                        JeuCarte.viderTas(tas, j1.getDeck());
                        tasPlein=false;
                    }

                // Carte joueur 1 < Carte joueur 2
                } else if (j1.getCarte(CARTE).getValeur().ordinal() < j2.getCarte(CARTE).getValeur().ordinal()) {
                    System.out.printf("%s bat %s%n", j2.getCarte(CARTE), j1.getCarte(CARTE));


                    if(j1GagnantManche){
                        JeuCarte.ajouterCarteListe(j2.getDeck(), CARTE, defausse);
                        JeuCarte.ajouterCarteListe(j1.getDeck(), CARTE, defausse);
                    } else {
                        JeuCarte.ajouterCarteListe(j1.getDeck(), CARTE, defausse);
                        JeuCarte.ajouterCarteListe(j2.getDeck(), CARTE, defausse);
                    }

                    JeuCarte.viderTas(defausse, j2.getDeck());
                    j1GagnantManche=false;
                    // Si égalité antérieure, résolution
                    if (tasPlein) {

                        JeuCarte.viderTas(tas, j2.getDeck());
                        tasPlein = false;
                    }

                // Carte joueur 1 = Carte joueur 2
                } else{
                    System.out.printf("Egalite entre %s et %s%n", j1.getCarte(CARTE), j2.getCarte(CARTE));
                    JeuCarte.ajouterCarteListe(j1.getDeck(),CARTE, tas);
                    JeuCarte.ajouterCarteListe(j2.getDeck(),CARTE, tas);
                    tasPlein=true;
                }
                nbCoups++;

            // Une des deux listes n'a pas de première carte = vide
            }
            if(j1.getDeck().isEmpty()||j2.getDeck().isEmpty()){
                System.out.println("Fin de la bataille");
                if(j1.getDeck().isEmpty()){
                    System.out.printf("%s a gagné en %d coups%n", j2, nbCoups);

                } else {
                    System.out.printf("%s a gagné en %d coups %n", j1, nbCoups);

                }
                }
            System.out.printf("Deck 1 : %d cartes, Deck 2 : %d cartes%n",j1.getDeck().size(), j2.getDeck().size());


        } while (!j1.getDeck().isEmpty() && !j2.getDeck().isEmpty());

    }

}
