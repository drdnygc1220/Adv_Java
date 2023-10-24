package threads.TEKRAR;

public class Thread1 {
    public static void main(String[] args) {
        //her classın aslında main threadi var onu görmek için ;
        System.out.println("mevcut thread:"+Thread.currentThread().getName());

        //1.YOL İÇİN OBJE OLUŞTURMAM GEREKİYOR
        MyThread thread1=new MyThread();
        thread1.start();
        thread1.setName("başardım");

        //2.YOL İÇİN OBJE OLUŞTURMALIYIM
        //Runnable interfaceni implement yaptıımız için start methodu kayboldu.
        //Önemli olan kısım MyRunable classını Thread içinde methoda eklemek zorundayız
        MyThread2 myRunable=new MyThread2();
        Thread thread2=new Thread(myRunable);
        //Thread oldu start kullanabiliriz.
        thread2.start();
        thread2.setName("pes etmek yok");



 //3.yol=ANONYMOUS class=isimsiz class
//classa yada objeye gerek kalmadan main içinde oluşturabiliriz.
        Thread thread3=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("thread3 :)");

            }
        });
        thread3.start();
        thread3.getName();
 //4.yol:FUNCTİONAL İNTERFACE:sadece run implement edilecek.
        // Lambda ile run methodunu override etmek
        Thread thread4=new Thread(()->{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("lamba ile override ettik.");
        });
        thread4.start();
        thread4.getName();

    }

}
//1.yol:Thread classının kendisini extends etmek
//run methodunu overrıde etmek zorundayız.
class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("çalışan thread1: "+Thread.currentThread().getName());
    }

}


//2.yol:Runnable interfaceni implement ediyoruz.
//bunun amacı:1 classta 1 tane extends yapabiliriz dolayısıyla runnable interfaceni yaparsak daha sonra
//runnable classını da extends yapabilirirz..
class MyThread2 implements Runnable{
    @Override
    public void run() {
        System.out.println("çalışan thread2: "+Thread.currentThread().getName());



    }
}

