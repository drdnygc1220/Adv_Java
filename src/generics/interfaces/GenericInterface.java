package generics.interfaces;

import org.w3c.dom.ls.LSOutput;

public interface GenericInterface<T> {
    //sözleşme imzalıyorum.implement ettiğinde overıde etmek zorunda
    //void print(String value);//geriye deger döndürmeyen
   void print(T value);

   //String find();//geriye string tipinde deger döndüren..ama data tipini double alsın istiyorum
    T find();//artık karar vermek bize baglı..
    //methodlar aynıysa sadece data tipi degişecekse jenerıc yaparım.T tipinde dataları kullanacagım

    //geriye string döndüren içerinde integer döndüren olabilir
    String get(Integer x);
}
