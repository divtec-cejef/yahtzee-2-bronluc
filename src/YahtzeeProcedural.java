public class YahtzeeProcedural {
    public static int lancerDe () {
        return (int) (Math.random() * 6) + 1;
    }

    public static void des () {
        int[] liste = {lancerDe(),  lancerDe(), lancerDe(), lancerDe(),  lancerDe()};
        for (int i = 0; i < liste.length; i++){
            System.out.println("Dé " + (i + 1) + " : " + liste[i]);
        }
    }

    public static void main(String[] args) {

        des();
    }
}
