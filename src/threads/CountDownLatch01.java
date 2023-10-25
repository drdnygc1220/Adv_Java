package threads;
/*
bazı threadlerin diğer threadlerden ve main threadden önce çalışıp işini
bitirmesini ve bu arada diğer threadlerin beklemesini(first worker threads) istedğimizde;
CountDownLatch objesiyle bir sayaç oluşturulur, ve her bir worker thread işini tamamladığında
sayacın bir azaltılması için objenin countDown metodu kullanılır. Sayaç=0 olduğunda
latch objesinin await metodu ile bekleyen threadler çalışmaya devam eder.
 */
import java.util.concurrent.CountDownLatch;

//öncelik vermem gereken threadler gerekirse countdownlatch classını kullanacagız.
public class CountDownLatch01 {
    public static void main(String[] args) {
        //kaç tane worker öncelik vereceksin..
        CountDownLatch latch=new CountDownLatch(4);
        System.out.println("main thread calışıyor....");
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"ÇALIŞMAYA BAŞLADI,kodlarını yazıyor");
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+"ÇALIŞMAYA BDEVAM EDİYOR");

            }
            //setname ile aynı işi görüyor.
        },"Developer");//parametreli const içine string dahil ettiğimiz için.
        thread1.start();
        //temizlik görevlileirmiz için
        WorkerThreads workers1=new WorkerThreads("worker1",5000,latch);
        WorkerThreads workers2=new WorkerThreads("worker2",2000,latch);
        WorkerThreads workers3=new WorkerThreads("worker3",7000,latch);
        WorkerThreads workers4=new WorkerThreads("worker4",8000,latch);
        workers1.start();
        workers2.start();
        workers3.start();
        workers4.start();

        //main threadi bekletecegim..
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("main thread serbest kaldı..");

    }
}
//işci threadler için class oluşturudum
class WorkerThreads extends Thread{
    //görevlerin süresi farklı farklı olsun duration şeklinde field kulllanacgım.
    private int duraction;
    //countdownlatch tipinde bir field tanımlayacgım.
    private CountDownLatch latch;

    //paramtrl.const
    public WorkerThreads(String name,int duraction, CountDownLatch latch) {
        super(name);//parentın constrını cagır..
        this.duraction = duraction;
        this.latch = latch;
    }
    //run methodunu overrıde edelim

    @Override
    public void run() {
        try {
            //bir süre calışmasını istiyorum demek için duractionu burada kullenıyorum.
            System.out.println(Thread.currentThread().getName()+"Çalışmaya başladı....");
            Thread.sleep(duraction);
            System.out.println(Thread.currentThread().getName()+"İşimiz bitti......");
            latch.countDown();//4,3,2,1,
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}