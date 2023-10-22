package threads;

import java.nio.file.LinkOption;

public class Multithreading01 {
    public static void main(String[] args) {
        //TASK:1 den 10 kadar 2 defa yazdırma işlemi yapacağız..
        //obje oluşturuyorum
        //BURADA thread kullanmadık.......

        //obje almadan suanki mevcut anını döndür
        long start=System.currentTimeMillis();//başlangıc anına degişken atadım
        Counter counter1=new Counter("JACK");
        Counter counter2=new Counter("HARRY");
        counter1.countMe();
        counter2.countMe();
        long finish=System.currentTimeMillis();//bitiş anına değişken atadım
        System.out.println("Thread kullanmadan gecen süre : "+(finish-start));

        //Burada THREAD kullandık........
        //2.objede Thread oluşturalımmm...
        long start1=System.currentTimeMillis();
        System.out.println("--------------Multithreading-------------------");
        CounterWithMultiThread counter3=new CounterWithMultiThread("BETTY");
        CounterWithMultiThread counter4=new CounterWithMultiThread("WİLMA");
        counter3.start();
        counter4.start();


        //counter3 işini bitirene kadar bekle.=JOIN
        //JOIN=HANGİ THREAD(MAİN)İÇİNDE ÇAĞRILMIŞSA BU THREADİ COUNTER3 İŞNİ BİTİRİNE KADAR BEKLER..
        try {
            counter3.join();//COUNTER3 İŞNİ BİTİRİNE KADAR BEKLER
            counter4.join();//COUNTER4 İŞNİ BİTİRİNE KADAR BEKLER
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long finish1=System.currentTimeMillis();
        System.out.println("Multithreading ile gecen süre: "+(finish1-start1));

    }
}

//yeni class oluşturyorum sayac isminde
class Counter{
    //field ekleme
    public String name;

    //param.const
    public Counter(String name){
        this.name=name;//bu olmazsa null cıkar

    }
    //1 den 10 kadar yazdırma methodu olsun
    public void countMe(){//objeye bagımlı bir method static degil sayma işlemi yapan obje de lazım
        for (int i=1;i<=10;i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i+" - "+this.name);//sayma işlemi yapan obje de lazım
        }
    }
}

class CounterWithMultiThread extends Thread {//thread oluşturmam için extends etmem gerekiyor ama bu yetmez
    // run methodunu da yapmam gerekiyor...run methodun içinde methodu cagırdık...

    public String name;

    //param const
    public CounterWithMultiThread(String name) {
        this.name = name;
    }
    //run methoduna threadin görevi
    public void run(){//run olmazsa hata da vermez...
        countMe();
    }

    //1 den 10 a kadar sayıları yazdırma
    public void countMe() {

        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i + " - " + this.name);
        }
    }
}