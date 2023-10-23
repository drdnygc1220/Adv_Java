package threads;
/*
 Birden fazla thread kullanılan bir uygulamada ,değişkenler performans nedeniyle CPU
 cache'inde tutulabilir.
 Bilgisayarın birden fazla CPU'su(çekirdek) olduğunu düşünürsek her thread farklı
 CPU üzerinde çalısabilir
 bu nedenle her thread değişkenlerin değerini CPU cache'ine farklı değerde yazabilir.

 "volatile" keywordü değişken üzerinde bir değişiklik olduğunda diğer threadler tarafından
 görünmesini garanti eder.
 "volatile" ile bir değişken CPU cache yerine bilgisayarın main memory'sinden okunur ve
 CPU cache yerine main memory'sine yazılır.
 non-volatile değişkenler için böyle bir garanti yoktur.
 */
public class Volatile01 {
    public static int flag=0;

    public static void main(String[] args) {

        Thread thread1=new Thread(new Runnable() {//core 1 ön belleğine yazabilir
            @Override
            public void run() {
                while (flag!=1){
                    System.out.println("Threadlerle calışmak harika:(");
//thread1 önce calışşırsa bu döngü thread2 calışana kadar dönecek
                }
            }
        });
        thread1.start();

        Thread thread2=new Thread(new Runnable() {//core 2 ön belleğe yazılır
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);//bilerek beklettik ki
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                //flag degişkenin degerini 1 kere artırsın
                flag++;//cache:x=1,main:x=0
                System.out.println("flag degeri 1 oldu");

            }
        });
        thread2.start();
    }
}
