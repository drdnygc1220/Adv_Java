package threads;

public class SynchronizedBlock {
    public static void main(String[] args) {
        //task: 14 defa [ [ [ [ [ ] ] ] ] ] satırını yazdıralım
        Brackets2 brackets=new Brackets2();

        long start=System.currentTimeMillis();
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<=7;i++){
                    brackets.generateBrackets();
                }
            }
        });
        thread1.start();
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i=1;i<=7;i++){
                    brackets.generateBrackets();
                }

            }
        });
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long finish=System.currentTimeMillis();

        //System.out.println("blok ile geçen süre : "+(finish-start));//2199
        System.out.println("metod ile geçen süre : "+(finish-start));//4363
    }
    }






class Brackets2{

    public /*synchronized*/ void generateBrackets(){
        //sadece burası synchronized olsun
        //methodu sekronize etmek yerine bir blok oluşturarak bu blok sekronize olsun..
        synchronized (this){//buradaki this=bu bloga erişen obje demek
            for (int i=1;i<=10;i++){
                if (i<6){
                    System.out.print("[ ");
                }else {
                    System.out.print("] ");
                }
            }
            System.out.println(" - "+Thread.currentThread().getName());
        }



        //senkron olması gerekmeyen diğer kodları da içeriyor olsun..generate methodu
        //1,den 5 e kadar
        for (int i=1;i<6;i++){
            System.out.println(i);

            //yazdırma işlemini bekleyerek yazdırsın sleep methodu=try catch içinde
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

