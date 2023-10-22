package generics.interfaces;

public class GenericInterfaceImpl<T> implements GenericInterface<T>{
    //1.SEÇENEK:Generic Interface i implemente eden class da generic olmalı
    //1.a--methodları override etmek zorundayız..

    @Override
    public void print(T value) {

    }

    @Override
    public T find() {
        return null;
    }

    @Override
    public String get(Integer x) {
        return null;
    }

}
