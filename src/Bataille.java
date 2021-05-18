import java.util.Random;

public class Bataille {
    public static void bataille(Carte[] jeu1, Carte[] jeu2){
        Random random = new Random();
        int carte1;
        int carte2;
        boolean jeu1Vide=false;
        boolean jeu2Vide=false;
        do {
            //Verifie si aucun des deux jeux n'est vide, si l'un ou l'autre est vide fin de la bataille+
            for (int i=0; i<jeu1.length;i++){
                jeu1Vide=false;
                if(jeu1[i]!=null){
                    break;
                }else{
                    jeu1Vide=true;
                }
            }

            for (int i=0; i<jeu2.length;i++){
                jeu2Vide=false;
                if(jeu2[i]!=null){
                    break;
                }else{
                    jeu2Vide=true;
                }
            }

            if(!jeu1Vide&&!jeu2Vide) {
                //Piochage des cartes aléatoirement
                do {
                    carte1 = random.nextInt(52);
                } while (jeu1[carte1] == null);
                do {
                    carte2 = random.nextInt(52);
                } while (jeu2[carte2] == null);

                //Comparaison des cartes piochées et résolution du conflit
                if (jeu1[carte1].getValeur().ordinal() > jeu2[carte2].getValeur().ordinal()) {
                    System.out.printf("%s bat %s%n",jeu1[carte1], jeu2[carte2]);
                    JeuCarte.ajouterCarte(jeu2, carte2, jeu1);
                } else if (jeu1[carte1].getValeur().ordinal() < jeu2[carte2].getValeur().ordinal()) {
                    System.out.printf("%s bat %s%n",jeu2[carte2], jeu1[carte1]);
                    JeuCarte.ajouterCarte(jeu1, carte1, jeu2);
                } else{
                    System.out.printf("Egalite entre %s et %s%n", jeu1[carte1], jeu2[carte2]);
                }

            } else{
                System.out.println("Fin de la bataille");
                if (jeu1Vide){
                    System.out.println("Le deck 1 a gagné");
                } else {
                    System.out.println("Le deck 2 a gagné");
                }
            }

        } while (!jeu1Vide&&!jeu2Vide);  //

    }
}
