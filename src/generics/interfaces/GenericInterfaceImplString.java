package generics.interfaces;

public class GenericInterfaceImplString implements GenericInterface<String>{
    //2.SEÇENEK:Generic Interface i implemente ederken data tipine karar verilmeli
    //burada 2 tane T kullanmıyoruz karar verdik çünkü
    //Burada data tipine biz karar verdik methodlarımızda T yerine String karar vermiş olduk..





    @Override
    public void print(String value) {

    }

    @Override
    public String find() {
        return null;
    }

    @Override
    public String get(Integer x) {
        return null;
    }
}
