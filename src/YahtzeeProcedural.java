public class YahtzeeProcedural {
    public static int lancerDe () {
        return Math.random() * 6 + 1;
    }

    public static void des () {
        int[] liste = {lancerDe(),  lancerDe(), lancerDe(), lancerDe(),  lancerDe()};
        for (int i = 0; i < liste.length; i++){
            System.out.println("Élément " + i + " : " + liste[i]);

        }

    }

    public static int resultatDe () {
    }
    public static void main(String[] args) {


        for (int i = 0; i < 5; i++) {
            int deActuel = lancerDe();
            System.out.println("Dé " + i + " : " + deActuel);
        }
    }
}
