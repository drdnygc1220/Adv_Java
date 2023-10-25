package threads;

import java.util.concurrent.Semaphore;

/*

Semaphore, ortak bir kaynağa aynı anda sadece n tane threadin
erişmesine izin vermemizi sağlar.

Synchronized, ortak bir kaynağa(metod/blok) aynı anda sadece 1 tane
threadin erişmesine izin verir.

threadpool ile semaphore farkı:
ThreadPoolda birçok threadin yapabileceği işi sadece n tane threadin yapmasını sağlarız.
Semaphoreda n tane işi n thread yapar fakat işin ortak olan kısmına sadece belli sayıda thread erişir.
threadpool da bir thread tekrar çalışabiliyor, ama burada bir defa çalışıp çıkıyor
Örneklerde:threadpoolda 7 işi  yapan canlı 4 thread var.
          :semaphoreda 7 tane thread aktif sadece 4 tanesi ortak kodlara aynı anda erişir
 */
public class Semaphore01 {
    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(4);
        System.out.println("Toplam park yeri: "+semaphore.availablePermits());
        Car car1=new Car("Audi",9000,semaphore);
        Car car2=new Car("Volvo",5000,semaphore);
        Car car3=new Car("Tofaş",7000,semaphore);
        Car car4=new Car("Honda",3000,semaphore);
        Car car5=new Car("Toyota",8000,semaphore);
        Car car6=new Car("Lada",9000,semaphore);
        Car car7=new Car("Mercedes",7000,semaphore);
        car1.start();
        car2.start();
        car3.start();
        car4.start();
        car5.start();
        car6.start();
        car7.start();
    }

}
class  Car extends Thread{
    private String carName;
    private int duration;
    private Semaphore semaphore;

    //param const

    public Car(String carName, int duration, Semaphore semaphore) {
        this.carName = carName;
        this.duration = duration;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {

        try {
            System.out.println(carName+"park etmek yasaktır...");
            semaphore.acquire();//ortak kodlara erişim isteniyor.
            System.out.println("-->"+carName+"park yerine girdi");
            Thread.sleep(duration);
            System.out.println("<--"+carName+"park yerinden ayrılıyor");
            semaphore.release();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}