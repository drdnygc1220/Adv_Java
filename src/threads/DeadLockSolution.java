package threads;
/*
Ölümcül kilitlenme, iki veya daha fazla threadin çalışmak için
aynı kaynağa erişmek istemesiyle oluşur.

Kaynağa erişmek için sürekli birbirlerini beklemesi sonucunda
sistem kaynakları olumsuz etkilenir ve uygulama(sunucu) cevap veremez hale gelir.
 */
public class DeadLockSolution {
    public static void main(String[] args) {

        String seker="şeker";
        String kahve="kahve";

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (kahve){
                    System.out.println(Thread.currentThread().getName()+" "+kahve+" i kullanıyor.");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName()+" "+seker+" i istiyor.");
                    synchronized (seker){
                        System.out.println(Thread.currentThread().getName()+" "+seker+" i kullanıyor.");
                    }//seker bırakıldı
                }//kahve bırakıldı.
                System.out.println(Thread.currentThread().getName()+" sıcak su ekledi ve kahvesini yudumluyor...");
            }
        },"Tom");
        thread1.start();

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (kahve){
                    System.out.println(Thread.currentThread().getName()+" "+kahve+" i kullanıyor.");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName()+" "+seker+" i istiyor.");
                    synchronized (seker){
                        System.out.println(Thread.currentThread().getName()+" "+seker+" i kullanıyor.");
                    }//seker serbest
                }//kahve serbest
                System.out.println(Thread.currentThread().getName()+" sıcak su ekledi ve kahvesini keyifle yudumluyor...");
            }
        },"Jerry");
        thread2.start();




    }
}
