package generics.classes;
//generıc olarak PRIMITIVE data tipleri kullanılamaz..
public class GenericProduct <T>{
    //farklı data tipi kullanmak istiyorum bunun için T tipinde yani herhangi bir tipi alır
    //generıc olarak PRIMITIVE data tipleri kullanılamaz..non-primitive kullanılır(double yok mesala)
    /*
        E --> Element, collection gibi yapılarda kullanılır=eleman
        K --> Key=anahtar
        V --> Value=deger
        N --> Number=sayı
        T --> Type=tip
        S,U,V , vb --> 2., 3. ve 4. tipler için
         */
    //string yazmıyorumda T yazıyorum
    private T code;
    private String name;//bütün fieldlar generic tipte olmak zorunda değil

    //GETTER -SETTER
    public T getCode() {
        return code;
    }

    public void setCode(T code) {
        this.code = code;
    }


}
