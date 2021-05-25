import java.util.ArrayList;
import java.util.List;

public class Joueur {
    private String nom;
    private String prenom;
    private Carte carte;
    private ArrayList<Carte> deck;

    /**
     * Constructeur d'un joueur avec initialisation d'un deck de 52 cartes vide (null)
     * @param nom
     * @param prenom
     */
    public Joueur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public ArrayList<Carte> getDeck() {
        return deck;
    }

    public Carte getCarte(int carteDemandee){
        return this.deck.get(carteDemandee);
    }

    public void setDeck(ArrayList<Carte> deck) {
        this.deck = deck;
    }

    @Override
    public String toString() {
        return String.format("%s", this.prenom);
    }
}
