package generics.Tekrar.Interface;

public class GenericInterface <T> implements Interface<T> {
    @Override
    public void print(T value) {

    }

    @Override
    public String find() {
        return null;
    }
}
class genericİkinciYol implements Interface<String>{
    @Override
    public void print(String value) {

    }

    @Override
    public String find() {
        return null;
    }
}