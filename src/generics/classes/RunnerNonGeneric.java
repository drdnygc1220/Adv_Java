package generics.classes;

public class RunnerNonGeneric {
    //generic içermeyen class
    public static void main(String[] args) {

        //2 farklı obje: book,laptop

        NonGenericProduct book=new NonGenericProduct();
        //null olan code ekleme yaptık
        book.setCode("advjava");//code değerini String ile set ettik

        NonGenericProduct laptop=new NonGenericProduct();
        laptop.setCode(123);//code değerini int ile set ettik

        //string degişken tanımladık bu değişkene kitabımızın kod degerini getirecgim
       //farklı data tiplerinde cast problemi alırız..
        String str= (String) book.getCode();//CTE-->CAST problemi
        System.out.println(str);

        //biz kendimiz cast ettik
        String str2= (String) laptop.getCode();//CTE-->CAST problemi
        System.out.println(str2);

        //asagıda string yaptık ama yine hata aldım-
        // hatalı cast edersek bu hatayı alırız-ClassCastException
    }
}
