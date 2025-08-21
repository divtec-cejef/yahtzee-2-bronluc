import java.util.Scanner;

public class YahtzeeProcedural {

    public static int lancerDe() {
        return (int) (Math.random() * 6) + 1;
    }

    public static int[] lancer5Des() {
        int[] liste = new int[5];
        for (int i = 0; i < liste.length; i++) {
            liste[i] = lancerDe();
        }
        return liste;
    }

    public static void afficherResultatDes(int[] liste) {
        for (int i = 0; i < liste.length; i++) {
            System.out.println("Dé " + (i + 1) + " : " + liste[i]);
        }
    }

    public static int[] demanderQuelDesLancer(Scanner sc) {
        System.out.print("Quels dés voulez-vous relancer ? (ex: 1 3 5, vide pour arrêter) : ");
        String saisie = sc.nextLine();

        if (saisie.isEmpty()) {
            return new int[0];
        }

        String[] parts = saisie.split(" ");
        int[] positions = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            positions[i] = Integer.parseInt(parts[i]);
        }
        return positions;
    }

    public static void relancer(int[] des, int[] positions) {
        for (int pos : positions) {
            if (pos >= 1 && pos <= 5) {
                des[pos - 1] = lancerDe();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] des = lancer5Des();
        int compteur = 1;

        System.out.println("Lancer " + compteur + " :");
        afficherResultatDes(des);

        while (compteur < 3) {
            compteur++;
            int[] positions = demanderQuelDesLancer(sc);
            if (positions.length == 0) {
                break;
            }
            relancer(des, positions);
            afficherResultatDes(des);
        }
    }
}
