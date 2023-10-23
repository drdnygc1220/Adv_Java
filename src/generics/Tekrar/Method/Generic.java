package generics.Tekrar.Method;

import java.util.Arrays;

public class Generic {
    public static void main(String[] args) {
        //array için yapalım..
        Integer[] intArr={1,2,3,4,5};
        Double[] doubleArr={1.3,2.3};
        String[] stringArr={"java"," güzeldir"};//her biri için aynı meyhod oluşturmaktan kurtarır

        genericMethod(intArr);
        genericMethod(doubleArr);
        genericMethod(stringArr);
       //////
       // generic2(123,"java");

    }
    public static <T> void genericMethod(T[] arr){
        //lamba
        Arrays.stream(arr).forEach(System.out::print);
        System.out.println();

    }
    public static <S,U> void generic2(S[] arr,U[]value){
        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println(value);
        System.out.println();

    }

}

