package threads.TEKRAR;
//multithread2:İki thread aynı kaynagı kulllanmak isterse hata verebilir
//sırayla çalıştırmak adına:SYNCHRONİZE cevirmeliyiz.
//for olan sorularda method oluşturmak işimiz kolaylaştıracak
//burada hangi method kullanılıyorsa onu synchd.edecegiz.
public class Thread3 {
    //ortak olan bir sayac olsun
    public static int counter=0;

    public static void main(String[] args) {
        //TOM İÇİN YAPTIK
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("kodlar1");
                for (int i=1;i<=5;i++){
                    System.out.println();
                }
                Counter1.count();
            }
        });
        thread1.start();
        thread1.setName("Tom");

        //JERRY İÇİN YAPTIK
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                Counter1.count();

            }
        });
        thread2.start();
        thread2.setName("jery");

    }



}
class Counter1{
    //synch. da işimi bitirene kadar anahtar bende
    public synchronized static void count(){
        for (int i=1;i<=1000;i++){
            Thread3.counter++;
            //son halini görmek için
            System.out.println(Thread.currentThread().getName()+
                    "--->COUNTER: "+Thread3.counter);
        }
    }

}
