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
        System.out.print("Quels dés voulez-vous relancer ?");
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

    public static int[] compterOccurrences(int[] des) {
        int[] compteur = new int[6]; // indices 0 à 5 pour les faces 1 à 6

        for (int de : des) {
            compteur[de - 1]++; // incrémente la case correspondant à la face
        }

        System.out.println("Occurrences des faces :");
        for (int i = 0; i < compteur.length; i++) {
            System.out.println("Face " + (i + 1) + " : " + compteur[i]);
        }
        return compteur;
    }

    public static void detecterCombinaisons(int[] des) {

        int[] compteur = compterOccurrences(des);

        int points = 0;

        boolean paire = false;
        boolean doublePaires = false;
        boolean brelan = false;
        boolean carre = false;
        boolean fullHouse = false;
        boolean petiteSuite = false;
        boolean grandeSuite = false;
        boolean yahtzee = false;

        int nbPaires = 0;
        int sommeBrelan = 0;
        int sommeCarre = 0;

        for (int i = 0; i < 6; i++) {
            if (compteur[i] == 2) {
                nbPaires++;
            }
            if (compteur[i] == 3) {
                brelan = true;
                sommeBrelan = 3 * (i + 1);
            }
            if (compteur[i] == 4) {
                carre = true;
                sommeCarre = 4 * (i + 1);
            }
            if (compteur[i] == 5) {
                yahtzee = true;
            }
        }

        if ((compteur[0] == 1 && compteur[1] == 1 && compteur[2] == 1 && compteur[3] == 1 && compteur[4] == 1) ||
                (compteur[1] == 1 && compteur[2] == 1 && compteur[3] == 1 && compteur[4] == 1 && compteur[5] == 1)) {
            grandeSuite = true;
        } else if ((compteur[0] >= 1 && compteur[1] >= 1 && compteur[2] >= 1 && compteur[3] >= 1) ||
                (compteur[1] >= 1 && compteur[2] >= 1 && compteur[3] >= 1 && compteur[4] >= 1) ||
                (compteur[2] >= 1 && compteur[3] >= 1 && compteur[4] >= 1 && compteur[5] >= 1)) {
            petiteSuite = true;
        }

        paire = nbPaires == 1;
        doublePaires = nbPaires == 2;
        fullHouse = brelan && paire;

        if (fullHouse) {doublePaires = true;}

        System.out.println("\n");

        if (paire){ points += 5;
            System.out.println("Paire : \t5 pts");
        }else{System.out.println("Paire : \t0 pts");}
        if (doublePaires){ points += 10;
            System.out.println("Double paires : \t10 pts");
        }else{System.out.println("Double paires : \t0 pts");}
        if (brelan){ points += sommeBrelan;
            System.out.println("Brelan : \t" + sommeBrelan + " pts");
        }else{System.out.println("Brelan : \t0 pts");}
        if (carre) {points += sommeCarre;
            System.out.println("Carré : \t" + sommeCarre + " pts");
        }else{System.out.println("Carré : \t0 pts");}
        if (fullHouse) {points += 25;
            System.out.println("Full House : \t25 pts");
        }else{System.out.println("Full House : \t0 pts");}
        if (petiteSuite) {points += 30;
            System.out.println("Petite suite : \t30 pts");
        }else {System.out.println("Petite suite : \t0 pts");}
        if (grandeSuite) {points += 40;
            System.out.println("Grande suite : \t40 pts");
        }else  {System.out.println("Grande suite : \t0 pts");}
        if (yahtzee) {points += 50;
            System.out.println("Yahtzee : \t50 pts");
        }else {System.out.println("Yahtzee : \t0 pts");}
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
        detecterCombinaisons(des);
    }
}
