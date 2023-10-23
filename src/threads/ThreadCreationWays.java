package threads;

public class ThreadCreationWays {
    public static void main(String[] args) {

        //her java programında 1 tane thread default olarak çalıştırılır.
        System.out.println("Mevcut thread : "
                +Thread.currentThread().getName());

        MyThread thread1=new MyThread();
        thread1.start();//Threadi başlatır ve run methodu çağırır.
        //thread1.run();sadece run içindeki methodları calıştırır fakat yeni bit thread başlatmaz
        //threadleri kendimiz de isim verebiliyoruz..setName
        thread1.setName("threadcik");


        //2.YOL:RUNNABLE:functional-----------------
        MyRunnable myRunnable=new MyRunnable();//class
        //Runnable myRunnable=new MyRunnable();
        // MyRunable referansı aldıgım gibi Runable da alabilirm
        Thread thread2=new Thread(myRunnable);//methodda eklemek zorundayız..
        //thread2 başlat
        thread2.start();//3 tane calışır

        //ANONYMOUS CLASS(İsimsiz sınıf)=====başka bir thread oluşturalım...
        //obje yada class oluşturmadan =2.yolun kısayolu
        //Interface olduğu için new yapamıyoruz fakat new lediğimizde ;
        // interface içindeki metodun override edilmesi gerektiğini anlıyor ve onu yapıyor.
        Thread thread3=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Anonim thread: "+Thread.currentThread().getName());
                System.out.println("Anonim sınıf ile thread oluşturuldu...");

            }
        });
        thread3.start();

        //Runnable:functional interface:sadece run implemente edilecek:lambda exp.
        Thread thread4=new Thread(()->{
            System.out.println("lambda ile run metodunu override ettik ve runnable parametresi verdik.  ");
        });
        thread4.start();

        //encok thread4 veya thread 3 kulllanılır......
        //3.ve 4. için dogrudan main içinde yazmamız yeterli.

        //thread classının sleep methodu uyutuyor:exception fırlatır try cath ile
        //sleep methodu hangi thread calışırken kullanılırsa bu threadi bekletir
       try {//kesin çözüm değil....(main) uyuyacak.
           Thread.sleep(5000);
       }catch (InterruptedException e){
           throw new RuntimeException(e);
       }
        System.out.println("burada main method bitti");

    }


}
//iç içe class yaptık yapmak zorunda değiliz ama
//Thread oluşturmanın 2 yolu var..
//1.YOL:Thread classını extends ederek
class MyThread extends Thread{

    @Override
    public void run() {
        //threade yaptırmak istediğimiz işlemler
        System.out.println("Çalışan thread= "+Thread.currentThread().getName());
        System.out.println("MyThread threadi çalışıyor. HARİKA:)");
    }
}

//2.YOL:Runnable interfaceini implemente etmek
class MyRunnable implements Runnable{//methodunu overloading yapmam lazım:tek methodu var =RUN

    public void run(){
        //threade yaptırmak istediğimiz işlemler
        System.out.println("Çalışan thread runnable= "+Thread.currentThread().getName());
        System.out.println("Runnable interface ile oluşturulan thread çalışıyor. HARİKA:)");

    }

        }