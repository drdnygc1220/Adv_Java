package generics.Tekrar.Bounding;

import java.util.ArrayList;
import java.util.List;

public class Wldcrd {
    static class WildCard {
        public static void main(String[] args) {
            List<Integer> integerList=new ArrayList<>();
            List<String>stringList=new ArrayList<>();
            List<Double>doubleList=new ArrayList<>();
            List<Object>objectList=new ArrayList<>();
            List<Number>numberList=new ArrayList<>();
            System.out.println("--------------------------");
            //forda ekledikten sonra sout yapıyoruz..
            addelements(integerList);
            System.out.println(integerList);
            addelements(objectList);
            System.out.println(objectList);
            addelements(numberList);
            System.out.println(numberList);
            //addelements(doubleList);
            // addelements(stringList);
            System.out.println("--------------------------------");
            üstsınır(integerList);
            üstsınır(doubleList);
            üstsınır(numberList);
           // üstsınır(objectList);
            //üstsınır(stringList);
            System.out.println("-------------------------------");
            wilcard(integerList);
            wilcard(stringList);
            wilcard(doubleList);
            wilcard(objectList);
            wilcard(numberList);
        }

        //alttan sınırlama
        //1 den 10 kadar sayı ekle
        public static void addelements(List<? super Integer> liste){
            for (int i=1;i<=10;i++){
                liste.add(i);
            }

        }
        //üstten sınırlama
        public static  void üstsınır(List<? extends Number> liste2){
            liste2.stream().map(t->2*t.intValue()).forEach(t-> System.out.print(t+" "));

        }
        //wilcard dogrudan kullanım
        public static void wilcard(List<?>liste3){
            //wilcard kullanımı sakıncalı hangi data tipini kullanacagımızı bilmiyoruz
            //for içinde object alıyoruz ki hepsini kapsasın.
            for (Object o:liste3){
                System.out.println(o);
            }

        }
    }
}
