import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JeuCarte {

    /**
     * Création jeu de 52 cartes trié
     * Retourne le jeu de 52 cartes
     */
    public static Carte[] getTabDeCarte() {
        Carte[] tabDeCarte = new Carte[52];
        int i = 0;
        for (Couleur tabDesCouleur : Couleur.values()) {
            for (Valeur tabDesValeur : Valeur.values()) {
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
    public static ArrayList<Carte> distribuerJeu(Carte[] jeuDistrib){
        ArrayList<Carte> listeDeCarte = new ArrayList<>();
        int i = 0;
        do{
            Random random = new Random();
            int nb;
            nb = random.nextInt(52);
            if(jeuDistrib[nb]!=null){
               listeDeCarte.add(jeuDistrib[nb]);
               retirerCarteTableau(jeuDistrib, nb);
               i++;
           }
        }while(i<26);
        return listeDeCarte;
    }

    /**
     * Retirer une carte d'une liste de cartes
     * @param listeDeCarte
     * @param i
     */
    public static void retirerCarteListe(ArrayList<Carte> listeDeCarte, int i){
        listeDeCarte.remove(i);
    }


    /**
     * Retirer une carte d'un tableau de cartes
     */
    public static void retirerCarteTableau(Carte[] tabDeCarte, int i){
        tabDeCarte[i]=null;
    }

    /**
     * Ajoute la carte d'un tableau dans un autre tableau
     * @param tabDeCarteCopie > tableau dont la carte est copié
     * @param carteCopiee > carte du tableau copié
     * @param tabDeCarteAjout > tableau qui reçoit la carte
     * @return
     */
    public static void ajouterCarteTableau(Carte[] tabDeCarteCopie, int carteCopiee, Carte[] tabDeCarteAjout){
        for(int i = 0; i<tabDeCarteAjout.length; i++){
            if(tabDeCarteAjout[i]==null){
                tabDeCarteAjout[i]=tabDeCarteCopie[carteCopiee];
                retirerCarteTableau(tabDeCarteCopie, carteCopiee);
                break;
            }
        }
    }

    public static void ajouterCarteListe(ArrayList<Carte> listeDeCarteCopie, int carteCopiee, ArrayList<Carte> listeDeCarteAjout){

        listeDeCarteAjout.add(listeDeCarteCopie.get(carteCopiee));

        retirerCarteListe(listeDeCarteCopie, carteCopiee);

    }

    public static void viderTas(ArrayList<Carte> tas, ArrayList<Carte> listeDeCarteAjout){
        listeDeCarteAjout.addAll(tas);
        tas.removeAll(listeDeCarteAjout);
    }


    /**
     * Affichage tableau de cartes
     */
    public static void afficherTableau(Carte[] tabDeCarte){
        for (Carte carte : tabDeCarte) {
            System.out.println(carte);
        }
    }

    public static void afficherListe(ArrayList<Carte> listeDeCarte){
        for (Carte carte : listeDeCarte) {
            System.out.println(carte);
        }
    }





}
