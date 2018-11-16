/**
 * Created by Xueyong on 2018/6/26.
 */

import java.util.Random;
public class Producer extends Thread {
    private Storage storage;
    //生产者与消费者通过缓冲区发生联系
    public Producer(Storage storage){
        this.storage = storage;
    }
    public void run(){
        while(true){//此处为无限生产，现实的情况可能有所不同，生产一个随机数
            Random a = new Random();
            storage.produce(a.nextInt(100)+"");
        }
    }
}

