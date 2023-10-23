package enumtypes;

public enum PasswordStrenghtEnum {
    //enum tipleri nasıl belirlenir.
    //bir kere burada tanımlıyorum daha degiştirmiyorum..
    //GENELDE BÜYÜK HARFLE KULLANILIR..
    //2 yada daha fazla olursa birleşik yazılmalı.

    LOW(10),//0
    MEDIUM(30),//1
    HIGH(50);//2 //--int level yaptıktan sonra deger girebiliriz..

    private final int level;//2--field oluşturabiliyorum.yine private olmalı.aynı zamanda final olmalı
    //low değişkenin bir özelliğini belirlemek istiyorum:her biri için ayrı ayrı belirleyecgim..
    //parametreli constructor yada setter methoduyla deger atayabilirim..
    //fakat setter yaparsak başka bir sayfadada kullanıyorum ama buna izin vermiyor
    //parametrenin içinde constructor kısmında set edecegim

    //-----getter methddu
    //10 degerine ulaşabilmek için


    //get
    public int getLevel() {
        return level;
    }

    //const
    PasswordStrenghtEnum(int level) {//1---ERİŞİM TİPİNİ YAZMIYOR.kendisi zaten private
        this.level=level;
        //private başka classda kullanılmıyorsa neden yapıyoruz?
        //cevap:low degerini sayısal bir ifadeyle belirtmek istiyorum
        //field oluşturabiliyorum.yine private olmalı.aynı zamanda final olmalı
    }
}
