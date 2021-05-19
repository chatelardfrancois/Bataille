import java.util.Random;

public class JeuCarte {

    /**
     * Création jeu de 52 cartes trié
     * Retourne le jeu de 52 cartes
     */
    public static Carte[] getTabDeCarte() {
        Carte[] tabDeCarte = new Carte[52];
        Couleur[] tabDesCouleurs = Couleur.values();
        Valeur[] tabDesValeurs = Valeur.values();
        int i = 0;
        for (Couleur tabDesCouleur : tabDesCouleurs) {
            for (Valeur tabDesValeur : tabDesValeurs) {
                tabDeCarte[i] = new Carte(tabDesCouleur, tabDesValeur);
                i++;
            }
        }

        return tabDeCarte;
    }

    /**
     * Distribue la moitié d'un jeu entré en paramètre dans un nouveau deck
     * Retourne le nouveau deck créé
     */
    public static Carte[] distribuerJeu(Carte[] jeuDistrib){
        Carte[] tabDeCarte = new Carte[52];
        int i = 0;
        do{
            Random random = new Random();
            int nb;
            nb = random.nextInt(52);
            if(jeuDistrib[nb]!=null){
               tabDeCarte[i]=jeuDistrib[nb];
               retirerCarte(jeuDistrib, nb);
               i++;
           }
        }while(i<26);
        return tabDeCarte;
    }

    /**
     * Retirer une carte d'un jeu de carte
     */
    public static void retirerCarte(Carte[] tabDeCarte, int i){
        tabDeCarte[i]=null;
    }

    /**
     * Ajoute la carte d'un jeu dans un autre jeu
     * @param tabDeCarteCopie > jeu dont la carte est copié
     * @param carteCopiee > carte du jeu copié
     * @param tabDeCarteAjout > jeu qui reçoit la carte
     * @return
     */
    public static void ajouterCarte(Carte[] tabDeCarteCopie, int carteCopiee, Carte[] tabDeCarteAjout){
        for(int i = 0; i<tabDeCarteAjout.length; i++){
            if(tabDeCarteAjout[i]==null){
                tabDeCarteAjout[i]=tabDeCarteCopie[carteCopiee];
                retirerCarte(tabDeCarteCopie, carteCopiee);
                break;
            }
        }
    }

    /**
     * Affichage jeu de cartes
     */
    public static void afficher(Carte[] tabDeCarte){
        for (Carte carte : tabDeCarte) {
            System.out.println(carte);
        }
    }





}
