package generics.bounding;

import generics.classes.GenericProduct;

import java.util.ArrayList;
import java.util.List;


//SUPER:Parentı temsil eder..
//wildcard:joker veya bilinmeyen data tipi demek:sembol ?
public class GenericWithWildcard {
    public static void main(String[] args) {

        List<Integer> integerList=new ArrayList<>();
        List<Double> doubleList=new ArrayList<>();
        List<String> stringList=new ArrayList<>();
        List<Object> objectList=new ArrayList<>();
        List<Number> numberList=new ArrayList<>();
        System.out.println();
        System.out.println("-----------------ALTTAN SINIRLAMA---------------------------");
        //methodları cagırıyorum...
        addElements(integerList);
        System.out.println(integerList);
        addElements(numberList);
        System.out.println(numberList);
        addElements(objectList);
        System.out.println(objectList);
        //addElements(stringList);
        //addElements(doubleList);
        System.out.println();
        System.out.println("----------------ÜSTTEN SINIRLAMA=number ve ogulları-------------");
        multiplyByTwo(integerList);
        multiplyByTwo(doubleList);
       // multiplyByTwo(stringList);//number ve ogulları
       // multiplyByTwo(objectList);//üste numbera kadar gidebilir daha üste gidemez
        System.out.println();
        System.out.println("--------------List<?>-------------------------------------");
        //hepsini kabul ediyor...
        printElements(integerList);
        printElements(stringList);
        printElements(doubleList);
        printElements(numberList);
        printElements(objectList);
        System.out.println();
        System.out.println("------------------List<OBJECT>-----------------------------");
        printElementsByObject(objectList);
      // printElementsByObject(stringList);//list<object>-->list<string> parentı degildir..

       // ------------------------sadece listte yapılmıyor--------------------
        //Burada biz oluşturuyoruz generıc yapıyı kullanırken dogrudan tipini demek yerine;
        //altan veya üstten sınırlandırabilirz

        GenericProduct<? super Integer> product=new GenericProduct();
        //product.setCode("java");
        product.setCode(111);//kabul etti





    }
//--------ALTTAN SORGULUMA-------------------
    /*SORU 1:Integer ve ıntegrın parentları ile tanımlayan
    listeye 1 den 10 kadar sayıları ekleyen bir method yazalım.. */

    //ınteger,number,object tipinde listeye ekleyebilirim...
    public static void addElements(List<? super Integer>list){//Integer ve üstü olsun diyoruz.
        //parametre olarak liste alacakki elemanları ekleyecek
        for(int i=1;i<=10;i++) {
            list.add(i);

        }
    }
//-----------------ÜSTTEN SINIRLAMA-------------------------
    public static void multiplyByTwo(List<? extends Number> list){
        //wildcard gıcık:tamamen bilinmeyen demek girdiğimiz deger sayı da olsa;
        // EKLEME,YAZMA işlemine izin vermez.// list.add(11);//list.add("java")
        //wildcard::Sadece OKUMA ya izin veriyor yada ;
        //data tipinden bagımsız methodlara izin verir.örneğin:remove,size
       // list.add(null);//null degeri olmadıgı için izin veriyor

        list.stream().map(t->2*t.intValue()).forEach(t-> System.out.print(t+" "));
        //t degerini bilmediğimiz için direk carpma işlemi yapmaz integer yapmam lazım
        //t yi number olarak kabul ediyor o yüzden int(oglunu) kullanıyoruz..


    }

    //-----------------wildcard dogrudan da yazdırabiliriz-----------------
    public static void printElements(List<?>list){
        //list.stream().forEach(t-> System.out.println(t+" "));
        //foreach ile yapalım bu sefer
        //listi gezecegiz ama hangi data tipiyle?=object ve altı
        for (Object o:list) {
            System.out.print(o);//o=12 yada o=java olur burada

        }

    }
//NOT: List<T> ile List<?> aynı degildir...T:bilinen,?:bilinmiyor
public static void printElementsByObject(List<Object> list){
    list.add(11);
    list.add("java");

    //list.stream().forEach(t-> System.out.print(t+" "));
    for (Object o:list){
        System.out.print(o);
    }

}

}
