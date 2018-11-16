/**
 * Created by Xueyong on 2018/6/26.
 */
public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();
        Producer p1 = new Producer(storage);
        Producer p2 = new Producer(storage);
        Consumer c1 = new Consumer(storage);
        Consumer c2 = new Consumer(storage);

        p1.start();
        c1.start();
        p2.start();
        c2.start();
    }
}