package generics.classes;

import java.util.ArrayList;
import java.util.HashMap;

public class RunnerGenerıc {
    public static void main(String[] args) {
        //obje oluşturalım
        //generıc yapılarda hangi data tipini kullanacgımıza sonradan karar verebiliriz.
        //java 7 den sonra sag tarafta data tipini yazmaya gerek kalmadı.


        GenericProduct<String> book=new GenericProduct<>();
        book.setCode("advJava");
        String str=book.getCode();//CTE vermedi,CAST problemi çözüldü.
                                  //ClassCastExceptıon hatası almadık engelledi.

    GenericProduct<Integer> laptop=new GenericProduct<>();
    laptop.setCode(123);
    Integer integer= laptop.getCode();

            GenericProduct<String> phone=new GenericProduct<>();
            String str2=phone.getCode();
           // phone.setCode(123);//generics tür güvenliğini saglıyor,123 integer giremem
          // data tipine karar verdikten sonra integer giremem

    //GenericProduct<double> obje=new GenericProduct<double>();
    //sedece non primitive kullanılır

//book objesinde ınteger kullanmak istiyorsak sadece onu kullanabilirz book objesinden string kullanamayız...
        ArrayList<String> list=new ArrayList<>();//sadece string yazdıgımda integer giremem
        //list.add(123);

        HashMap<String,Integer> map=new HashMap<>();
        //listten farkı data tipi olarak iki tane belirtiyordum iki tane deger girebilirlim
        //1.ye string 2.ye ınteger girmek zorundayız..
        map.put("advjava",99);

        // ====================== ÇOK PARAMETRELİ CLASS =================================

        //parametreli bir contructor oluşturdugum
        // için bana fieldların degerlerimi set etmemi istiyor
        GenericClassTwoParam<Integer,String> mymap=new GenericClassTwoParam<>(11,"generıc");
        GenericClassTwoParam<Integer,Integer> mymap2=new GenericClassTwoParam<>(11,99);




















    }
}
