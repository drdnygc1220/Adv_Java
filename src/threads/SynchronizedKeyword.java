package threads;

public class SynchronizedKeyword {
    public static void main(String[] args) {
        Brackets brackets=new Brackets();
        //task: 14 defa [ [ [ [ [ ] ] ] ] ] satırını yazdıralım
        //burada sorun ortak objeyi kullanmaları....
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

    }
}
class Brackets{
    //5 parantez acıp 5 parantez kapatmak istiyorum..
    //for ile yapacagız..
    public synchronized void generateBrackets(){
        for (int i=1;i<=10;i++){
            if (i<6){
                System.out.print("[ ");
            }else {
                System.out.print("] ");
            }
        }
        System.out.println(" - "+Thread.currentThread().getName());
    }

}