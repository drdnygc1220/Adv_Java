package threads;
/*Bir öğrencinin banka hesabı için para yatırma(deposit) ve çekme işlemleri(withdraw) için uygulama
        Hesapta para yoksa para yatırılması(bakiyenin artması) beklensin.
        Bakiye artınca(yeterli olunca) para çekme gerçekleşsin.*/
//wait-notify:threadler arasında iletişimi sağlar
public class WaitInterrupt {

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
                wait();//ınterrupt methodu nbeklemekte olan thread1 işini kesintiye ugratır.
            } catch (InterruptedException e) {
                // System.out.println(e.getMessage());
                System.out.println("beklemeye gerek kalmadı");

                //hendıl ediyorum
                //cath kısmına attıgı için işleme devam et diyorum avantaja cevirmek için
                //ama istersem yukarıdaki mesajı verip if kısmını dışarı alabilirim.
                if (balance>=amount){
                    balance=balance-amount;
                    System.out.println("Para çekme işlemi başarılı. Mevcut bakiye : "+balance);
                }else {
                    System.out.println("Bakiye yetersiz!!! Mevcut bakiye : "+balance);
                    System.out.println("Umudunu kaybetme...");
                }

            }
        }


    }

    public static void main(String[] args) {

        WaitInterrupt object=new WaitInterrupt();


        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                //çekilen para
                object.withdraw(2000);
            }
        });
        thread1.setName("tüketici");
        thread1.start();


        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                //yatırılan para
                object.deposit(3000);
                //Thread1 işini kes sonlandır diyor.
                thread1.interrupt();
            }
        });
        thread2.setName("üretici");
        thread2.start();

    }



}










