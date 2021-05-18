public class Main {
    public static void main(String[] args) {

        Carte[] jeuDeCarte = JeuCarte.getTabDeCarte();
        JeuCarte.afficher(jeuDeCarte);

        System.out.println("Jeu 1 :");

        Carte[] deck1 = JeuCarte.distribuerJeu(jeuDeCarte);
        JeuCarte.afficher(deck1);

        System.out.println("Jeu 2 :");

        Carte[] deck2 = JeuCarte.distribuerJeu(jeuDeCarte);
        JeuCarte.afficher(deck2);

        Bataille.bataille(deck1,deck2);
    }
}


