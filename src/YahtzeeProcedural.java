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
    public static void main(String[] args) {
        int[] des = lancer5Des();

        afficherResultatDes(des);

        int compteur = 0;

        while (compteur < 3) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Quels dés voulez-vous relancer (0 pour terminer)");
            int position = sc.nextInt();
            if (position != 0) {
                des[position - 1] = lancerDe();
                compteur++;
            }else{
                compteur += 3;
            }
        }
        afficherResultatDes(des);
    }
}
