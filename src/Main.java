import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        System.out.println("------------magicBox1 = MagicBox(int maxItemsCount)--------------");
        MagicBox<String> magicBox1 = new MagicBox(11);
        System.out.println(Arrays.toString(magicBox1.getTItems()));

        for (int m = 0; m < magicBox1.getItems().length; m++) {
            magicBox1.getItems()[m] = String.valueOf(getRandomInt(magicBox1.getItems().length));
        }
        magicBox1.getItems()[1] = String.valueOf(1223);

        System.out.println("filled magicBox1: "+Arrays.toString(magicBox1.getItems()));

        System.out.println(magicBox1.pick());
        System.out.println(magicBox1.pick());

        System.out.println("------------magicBox2 = MagicBox(Class<T> _class, int maxItemsCount)--------------");
        MagicBox<Integer> magicBox2 = new MagicBox(Integer.class,15);
        System.out.println(Arrays.toString(magicBox2.getTItems()));

        for (int m = 0; m < magicBox2.getTItems().length; m += 2) {
            magicBox2.getTItems()[m] = getRandomInt(magicBox2.getItems().length);
        }
        magicBox2.getTItems()[1] = Integer.valueOf(1223);
        System.out.println("filled magicBox2: "+Arrays.toString(magicBox2.getItems()));

        System.out.println(Arrays.toString(magicBox2.getItems()));
        magicBox2.add(9876789);
        System.out.println(Arrays.toString(magicBox2.getItems()));
        System.out.println(magicBox2.pick());
    }
    public static int getRandomInt(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }
}