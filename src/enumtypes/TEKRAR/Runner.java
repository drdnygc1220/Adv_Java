package enumtypes.TEKRAR;

public class Runner {
    public static void main(String[] args) {
      password(Enum.LOW);
      password(Enum.HIGH);
      password(Enum.MEDIUM);

    }

    //enumla
    public static void password(Enum kuvvet){
        if (kuvvet.equals(Enum.LOW)){
            System.out.println("password gücünüz düşüktür");
            //seviye de görmek için
            System.out.println("seviyesi:"+kuvvet.getLevel());
        } else if (kuvvet.equals(Enum.HIGH)) {
            System.out.println("password gücünüz yüksektir");
            System.out.println("seviye:"+kuvvet.getLevel());
        } else if (kuvvet.equals(Enum.MEDIUM)) {
            System.out.println("password gücünüz orta seviyededir");
            System.out.println("seviyesi:"+kuvvet.getLevel());

        }
        System.out.println("enum ismi:"+kuvvet.name());
        System.out.println("enum sırası:"+kuvvet.ordinal());
    }
}
