/**
 * Created by Xueyong on 2018/6/26.
 */
import java.util.LinkedList;
public class Storage {

    private final int MAX_SIZE = 10; //此处为设置缓冲区大小

    //消息的容器类，也可以选择队列这种先入先出的数据结构
    private LinkedList<String> list = new LinkedList<String>();

    //生产方法：由生产者调用
    public void produce(String str){
        //阻塞其他对list同步块的访问
        synchronized(list){
            //如果容器的大小等于预设的缓冲区大小，则为满，此处用while意味着被唤醒后需要再次检查
            while(list.size()==MAX_SIZE){
                try {
                    System.out.println("满");
                    //当前生产者线程交出list控制权，并进入等待
                    list.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            //解除锁定以后继续执行
            list.push(str);
            System.out.println(Thread.currentThread().getName()+"生产:"+str);
            //通知所有在等待list权限的线程继续运行（唤醒消费者）
            list.notifyAll();
        }
    }

    //消费方法：由消费者调用
    public void consume(){
        //阻塞其他对list同步块的访问
        synchronized(list){
            //如果缓冲区为空,此处用while意味着被唤醒后需要再次检查
            while(list.size()==0){
                try {
                    System.out.println("空");
                    //当前消费者交出list的权限，进入等待
                    list.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            //解除锁定以后继续执行
            String a  = list.pop();
            System.out.println(Thread.currentThread().getName()+"消费："+a);
            //通知所有在等待list权限的线程继续运行（唤醒生产者）
            list.notifyAll();
        }
    }
}


