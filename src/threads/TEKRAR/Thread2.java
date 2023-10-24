package threads.TEKRAR;
//multiThread:iki kişiye görev dagılımı
public class Thread2 {
    public static void main(String[] args) {
        long start=System.currentTimeMillis();
      MultiThread thread1=new MultiThread("FEYZA");
      MultiThread thread2=new MultiThread("SEFA");
        thread1.start();
        thread2.start();
        long finish=System.currentTimeMillis();
        System.out.println("multithread ile gecn süre: "+(finish-start));

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ;
    }


}
class sayac{
    //1.şahıs gibi düşünelim
    public String name;

    public sayac(String name) {
        this.name = name;
    }
    //method yazıyorum
    public void countMe(){
        for (int i=1;i<=10;i++){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i+" "+this.name);//sayma işlemini yapan obje
        }
    }

    }
class MultiThread extends Thread{
    public String name;

    public MultiThread(String name) {
        this.name = name;
    }

    public void countMe(){
        for (int i=1;i<=10;i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i+" "+this.name);//sayma işlemini yapan obje
        }
    }
    @Override
    public void run() {
        countMe();
    }
}

