package enumtypes.TEKRAR;

public enum Enum {
    //tipi final olmalı
    //enum class acmalıyız..
    //enum degerlerinin arasına virgüllü yazılıyor noktalı virgül sadece sonda.
    LOW(10),
    MEDIUM(20),
    HIGH(30);

    //2.kısım
    private final int level;

    public int getLevel() {
        return level;
    }
    //1.kısım
    Enum(int level){
        this.level=level;
    }
}
