public class Main {
    public static void main(String[] args) {

        // Instantiation de deux joueurs
        Joueur j1 = new Joueur("Chatelard", "François");
        Joueur j2 = new Joueur("Morane", "Bob");

        // Bataille entre les deux joueurs
        Bataille.bataille(j1,j2);

    }
}


