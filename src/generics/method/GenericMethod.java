package generics.method;


import java.lang.reflect.Array;
import java.util.Arrays;

public class GenericMethod {
    public static void main(String[] args) {

        //Arrayleri yazdırma methodu..to stringle yazdıyoruz normalde ama burada method üzerinden gidecegiz

        Integer[] intArr = {2, 3, 8, 99, 55};
        Double[] doubleArr = {1.3, 35.6, 99.9, 0.5};
        String[] stringArr = {"Java", "generics", "hayatımızı", "kolaylaştırır"};

        printArray(intArr);
        printArray(doubleArr);
        printArray(stringArr);
        //aynı methodu farklı data tipinde kullanmak için overloading etmemiz lazım...
        System.out.println("--------void generıc-------------");
        genericPrintArray(intArr);
        genericPrintArray(stringArr);
        genericPrintArray(doubleArr);
        System.out.println("----------T generıc--------------");
        System.out.println("getFirst(intArr) = "+getFirst(intArr));
        System.out.println("getFirst(stringArr) = "+getFirst(stringArr));
        System.out.println("---------------Two param---------------------");
        printArrayAndValue(intArr,"generic");//S:Integer U:String
        printArrayAndValue(stringArr,"harika");//S:String U:String


    }

    //arrayleri yazdırmak için method oluşturalım..
    public static void printArray(Integer[] arr) {
        Arrays.stream(arr).forEach(t -> System.out.print(t + " "));
        //stream:akışa döndürmek için..
        // foreach:akışın üzerinde geziyorum.
        System.out.println();

    }

    //overloading....3 METHODU AYRI AYRI YAPIYORUZ BUNU YAPMAMAK İÇİN GENERIC METHOD TANIMLAMAM  LAZIM
    public static void printArray(String[] arr) {
        Arrays.stream(arr).forEach(t -> System.out.print(t + " "));
        System.out.println();

    }

    public static void printArray(Double[] arr) {
        Arrays.stream(arr).forEach(t -> System.out.print(t + " "));
        System.out.println();

    }


    //GENERIC METHOD..
    //generıc oldugunu gösterebiilmek için voidden önce <T> KULLANIYORUZ
    public static <T> void genericPrintArray(T[] arr){//geriye bir deger döndürmeyen method
        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
    }

    //geriye sonuc döndüren method yazsın...

    public static <T> T getFirst(T[] arr){//void yerine T tipinde eleman demek için kullandık..
        T first=arr[0];
        return first;

    }

    //birden fazla parametre kullanacagız...
    public static <S,U> void printArrayAndValue(S[] arr,U value){

        //value=arr[0];....farklı data tipleri olabilir string basta yazıyorsa stringten devam etmeliisniz..

        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.print("-------------------"+value);
        System.out.println();//farklı harflerde aynı data tipi ve farklı data tipi kullanılabilir

    }

}
