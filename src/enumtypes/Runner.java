package enumtypes;
   /*
    enum ile sınırlı sayıda sabit değişkenler tanımlarız.
    Değişken isimleri(genellikle büyük harflerle ) virgülle ayrılarak
    listelenir. Default olarak static ve finaldır. Değişken isimleri birlikte
    ayrıca özellik/ler eklemek istersek private final tipinde field tanımlayabiliriz.
    Bu fieldın değeri paametreli constructor ile set edilir. Bu fieldın okunabilmesi için
    getter metodu oluşturulur.
     */

import static enumtypes.PasswordStrengthConstant.*;

public class Runner {
    public static void main(String[] args) {
        printPasswordStrenght("LOW");
        printPasswordStrenght("MEDIUM");
        printPasswordStrenght("HIGH");
        printPasswordStrenght("high");//mesaj yazılmadı..CTE yok,RTE yok..
        //------------ENUM-------------------
        //enum:bu problemi ortadan kaldırır.
        //sınırlı sayıda sabit değişkenler oluşturur.
        //"==" ve "equal()" aynı sonucu verir.
        //Varsayılan olarak static ve finaldır.
        //enum constructorları her zaman "private" dır.(sabit olmasından kaynaklı)
        //public enum day{

        System.out.println("--------------ENUM-------------------");
        printMessageByEnum(PasswordStrenghtEnum.LOW);
        printMessageByEnum(PasswordStrenghtEnum.MEDIUM);
        printMessageByEnum(PasswordStrenghtEnum.HIGH);


    }

    //şifrenin güç seviyesini yazdıran method:FİNAL SABİT
    public static void printPasswordStrenght(String strenght){
        if(strenght.equals(LOW)){
            System.out.println("Password gücünüz düşüktür!!!!");
        } else if (strenght.equals(MEDIUM)) {
            System.out.println("Password gücünüz orta seviyededir...");
        } else if (strenght.equals(HIGH)) {
            System.out.println("Password gücünüz yüksektir:) ");

        }

    }

//enumla method
public static void printMessageByEnum(PasswordStrenghtEnum strength){

    if (strength.equals(PasswordStrenghtEnum.LOW)){
        System.out.println("Password gücünüz düşüktür!!!");
        //LEVELİNE ULAŞMAK İÇİN
        System.out.println("Seviyesi: "+strength.getLevel());

    } else if (strength.equals(PasswordStrenghtEnum.MEDIUM)) {
        System.out.println("Password gücünüz orta seviyededir!!!");
        System.out.println("Seviyesi: "+strength.getLevel());

    } else if (strength.equals(PasswordStrenghtEnum.HIGH)) {
        System.out.println("Password gücünüz yüksektir....");
        System.out.println("Seviyesi: "+strength.getLevel());

    }
    //ENUM METHODLARI: getlevel,name,ordinal
    //ENUM İSMİN:NAME  görmek istiyorum..
    System.out.println("Enum ismi: "+strength.name());
    //SIRA NUMARASINA ULAŞMAK:ORDİNAL..
    //if (strength.ordinal()==0) kullanılabilir ama readible değil .
    System.out.println("Enum sırası: "+strength.ordinal());

}



}
