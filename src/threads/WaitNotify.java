package threads;
/*Bir öğrencinin banka hesabı için para yatırma(deposit) ve çekme işlemleri(withdraw) için uygulama
        Hesapta para yoksa para yatırılması(bakiyenin artması) beklensin.
        Bakiye artınca(yeterli olunca) para çekme gerçekleşsin.*/
//wait-notify:threadler arasında iletişimi sağlar
public class WaitNotify {

    public static int balance=0;

    //para yatırma
    public synchronized void deposit(int amount){
        System.out.println(Thread.currentThread().getName()+" para yatırmak istiyor.");
        balance=balance+amount;
        System.out.println("Para yatırma işlemi başarılı. Mevcut bakiye : "+balance);
    }

    //para çekme
    public synchronized void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+" para çekmek istiyor.");
        if (balance==0 || balance<amount){
            System.out.println("Bakiye yetersiz!!! Mevcut bakiye : "+balance);
            System.out.println("Bakiyenin güncellenmesi bekleniyor.");

            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        if (balance>=amount){
            balance=balance-amount;
            System.out.println("Para çekme işlemi başarılı. Mevcut bakiye : "+balance);
        }else {
            System.out.println("Bakiye yetersiz!!! Mevcut bakiye : "+balance);
            System.out.println("Umudunu kaybetme...");
        }

    }

    public static void main(String[] args) {

        WaitNotify object=new WaitNotify();

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                object.withdraw(2000);
            }
        });
        thread1.setName("öğrenci");
        thread1.start();

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                object.deposit(3000);
            }
        });
        thread2.setName("veli");
        thread2.start();

    }


}










