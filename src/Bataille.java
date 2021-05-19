import java.util.Random;

public class Bataille {

    public static void bataille(Joueur j1, Joueur j2){

        Random random = new Random();
        int carte1;
        int carte2;
        boolean jeu1Vide=false;
        boolean jeu2Vide=false;
        boolean tasPlein=false;

        int nbCoups= 0;

        // Création d'un paquet de carte de 52 cartes
        Carte[] jeuDeCarte = JeuCarte.getTabDeCarte();

        // Distribution aléatoire de la première moitié du paquet de cartes dans le deck du premier joueur
        j1.setDeck(JeuCarte.distribuerJeu(jeuDeCarte));

        // Distribution aléatoire de la deuxième moitié du paquet de cartes dans le deck du deuxième joueur
        j2.setDeck(JeuCarte.distribuerJeu(jeuDeCarte));

        // Création d'un tas qui récupère les cartes lors d'une égalité
        Carte[] tas = new Carte[52];

        do {
            //Verifie si aucun des deux decks n'est vide, si l'un ou l'autre est vide fin de la bataille avec méhtode checkDeckVide()
            //TODO remplacer checkDeckVide par une erreur
            jeu1Vide = checkDeckVide(j1.getDeck());

            jeu2Vide = checkDeckVide(j2.getDeck());

            if(!jeu1Vide&&!jeu2Vide) {
                //Piochage des cartes aléatoirement
                do {
                    carte1 = random.nextInt(52);
                } while (j1.getCarte(carte1) == null);
                do {
                    carte2 = random.nextInt(52);
                } while (j2.getCarte(carte2) == null);

                //TODO optimisation
                //Comparaison des cartes piochées et résolution du conflit
                if (j1.getCarte(carte1).getValeur().ordinal() > j2.getCarte(carte2).getValeur().ordinal()) {
                    System.out.printf("%s bat %s%n",j1.getCarte(carte1), j2.getCarte(carte2));
                    JeuCarte.ajouterCarte(j2.getDeck(), carte2, j1.getDeck());
                    // Si égalité antérieure, résolution
                    if(tasPlein){
                        for(int i =0; i<tas.length; i++){
                            if(tas[i]!=null){
                                JeuCarte.ajouterCarte(tas, i, j1.getDeck());
                            }
                        }
                        tasPlein=false;
                    }
                } else if (j1.getCarte(carte1).getValeur().ordinal() < j2.getCarte(carte2).getValeur().ordinal()) {
                    System.out.printf("%s bat %s%n",j2.getCarte(carte2), j1.getCarte(carte1));
                    JeuCarte.ajouterCarte(j1.getDeck(), carte1, j2.getDeck());
                    // Si égalité antérieure, résolution
                    if(tasPlein){
                        for(int i =0; i<tas.length; i++){
                            if(tas[i]!=null){
                                JeuCarte.ajouterCarte(tas, i, j2.getDeck());
                            }
                        }
                        tasPlein=false;
                    }
                } else{
                    System.out.printf("Egalite entre %s et %s%n", j1.getCarte(carte1), j2.getCarte(carte2));
                    JeuCarte.ajouterCarte(j1.getDeck(),carte1, tas);
                    JeuCarte.ajouterCarte(j2.getDeck(),carte2, tas);
                    tasPlein=true;
                }
                nbCoups++;

            } else{
                System.out.println("Fin de la bataille");
                if(jeu1Vide){
                    System.out.printf("%s a gagné en %d coups%n", j2, nbCoups);
                    JeuCarte.afficher(j2.getDeck());
                } else {
                    System.out.printf("%s a gagné en %d coups %n", j1, nbCoups);
                    JeuCarte.afficher(j1.getDeck());
                }
                }
        } while (!jeu1Vide&&!jeu2Vide);


    }

    public static boolean checkDeckVide(Carte[] Deck){
        boolean check=false;
        for (Carte value : Deck) {
            check = false;
            if (value != null) {
                break;
            } else {
                check = true;
            }
        }
        return check;
    }
}
