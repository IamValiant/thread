/**
 * Created by Xueyong on 2018/6/26.
 */
public class Consumer extends Thread {
    private Storage storage;
    //生产者与消费者通过缓冲区发生联系
    public Consumer(Storage storage){
        this.storage = storage;
    }

    public void run(){
        while(true){//此处为无限消费，现实的情况可能有所不同
            storage.consume();
        }
    }
}
