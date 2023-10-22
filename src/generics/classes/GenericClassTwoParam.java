package generics.classes;

public class GenericClassTwoParam<S,U> {

    //KEY,VALUE KULLANACAKSAK K,V harflerini kullanabiliriz..
    //2,3 ve daha fazla generıc class oluşturacaksak S,U,V harflerini öncelikli kullanıyoruz..

    //2 farklı data tipi
    private S field;
    private U value;

    //getter-setter ulaşmak için
//parametreli constructor yapalım bu sefer


    public GenericClassTwoParam(S field, U value) {
        this.field = field;
        this.value = value;
    }

    public S getField() {
        return field;
    }

    public void setField(S field) {
        this.field = field;
    }

    public U getValue() {
        return value;
    }

    public void setValue(U value) {
        this.value = value;
    }
}
