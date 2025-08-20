public class YahtzeeProcedural {
    public static double lancerDe () {
        return Math.floor(Math.random() * 6) + 1;
    }
    public static void main(String[] args) {

        for (int i = 1; i < 6; i++) {
            double deActuel = lancerDe();
            System.out.println("Dé " + i + " : " + deActuel);
        }
    }
}
