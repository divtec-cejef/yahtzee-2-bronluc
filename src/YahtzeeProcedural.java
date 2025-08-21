import java.util.Scanner;

public class YahtzeeProcedural {
    public static int lancerDe () {
        return (int) (Math.random() * 6) + 1;
    }

    public static int[] lancer5Des () {
        int[] liste = new int[5];
        for (int i = 0; i < liste.length; i++) {
            liste[i] = lancerDe();
        }
        return liste;
    }

    public static void afficherResultatDes (int[] liste) {
for (int i = 0; i < liste.length; i++){
        System.out.println("Dé " + (i + 1) + " : " + liste[i]);
        }
    }

    public static int demanderRelance (Scanner sc) {
        System.out.println("Quels dés voulez-vous relancer ? (3 max)");
        return sc.nextInt();
    }

    public static void relancer(int[] des, int position) {
        if (position >= 1 && position <= des.length) {
            des[position - 1] = lancerDe();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] des = lancer5Des();

        int compteur = 1;
        afficherResultatDes(des);

        // Jusqu’à 3 lancers
        while (compteur < 3) {
            System.out.print("Quels dés voulez-vous relancer ? : ");
            String saisie = sc.nextLine();

            if (saisie.isEmpty()) {
                break; // le joueur arrête
            }

            String[] positions = saisie.split(" "); // découpe en tableau de chaînes

            for (String posStr : positions) {
                int pos = Integer.parseInt(posStr); // conversion en int
                if (pos >= 1 && pos <= 5) {
                    des[pos - 1] = lancerDe(); // relancer uniquement ce dé
                }
            }

            compteur++;
            System.out.println("Lancer " + compteur + " :");
            afficherResultatDes(des);
        }
    }
}