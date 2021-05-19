public class Joueur {
    private String nom;
    private String prenom;
    private Carte carte;
    private Carte[] deck;

    /**
     * Constructeur d'un joueur avec initialisation d'un deck de 52 cartes vide (null)
     * @param nom
     * @param prenom
     */
    public Joueur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.deck = new Carte[52];
    }

    public Carte[] getDeck() {
        return deck;
    }

    public Carte getCarte(int carteDemandee){
        return this.deck[carteDemandee];
    }

    public void setDeck(Carte[] deck) {
        this.deck = deck;
    }

    @Override
    public String toString() {
        return String.format("%s", this.prenom);
    }
}
