package generics.Tekrar.Class;

public class GenericTwo <S,U>{
    private S key;
    private U value;

    public GenericTwo(S key, U value) {
        this.key = key;
        this.value = value;
    }

    public S getKey() {
        return key;
    }

    public void setKey(S key) {
        this.key = key;
    }

    public U getValue() {
        return value;
    }

    public void setValue(U value) {
        this.value = value;
    }
}
