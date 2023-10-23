package threads;

public class Multithreading02 {
    //biletlerimtakip edebilmek için sayac oluşturuyorum
    // ikiside  aynı degeri görecek public
    public volatile static int counter=0;
    //İKİ THREAD DE AYNI ANDA AYNI KAYNAGI OKUMA VE YAZDIRMA VE
    // İŞLEMİ YAPMAYA ÇALIŞTIGI İÇİN İSTENMEYEN SONUÇLAR ELDE EDİLİR..
    //SIRAYLA CALIŞTIMAK İSTEYEBİLİRİZ....SYNCHRONİZE CEVİR COUNT METHODUNU

    //1000 kere bu degere bak sonraki sayaca ekle.class oluşturyorum
    public static void main(String[] args) {

        //THREAD KULLANIYORUZ..
        Thread thread1=new Thread(new Runnable() {
            //başka kodlarda olabilir.synchronized sadece sıralıma işinde için içine dahil oluyor
            @Override
            public void run() {
                System.out.println("kodlar1");
                for (int i=1;i<5;i++){
                    System.out.println();
                }
                //tom ne iş yapacak :count methodunu cagıracagız.(okuma ve artırma)
           Counter01.count();
            }
        });
        //threadi başlatalım..
        thread1.setName("Tom");//isim verdik..
        thread1.start();
        //THREAD TEKRAR CAGIRILICAK..
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                Counter01.count();
            }
        });
        thread2.setName("Jerry");
        thread2.start();
//bu problemi joın=diğerini bekle demek ile diğer threadı bekletmek çözmez
//multithreading uygulama olmamış olur..

    }
}
class Counter01{

    //bir tane method,geriye bir deger döndürmeyeck class isimiyle cagırmak istiyoruz.
    public synchronized static void count(){
        //synchronized keywordu=bu methoda aynı anda sadece 1 thread erişebilsin.
        //1000 kere yapabilmek için for yapıyorum
        for(int i=1;i<=1000;i++){
            Multithreading02.counter++;
            //1.işlem:okuma..2.işlem:+1..
            //SON DEGERİ GÖRMEK İSTİYORUM
            System.out.println(Thread.currentThread().getName()+
                    "----->counter: "+Multithreading02.counter);
        }
        }

}
