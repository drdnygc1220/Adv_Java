package generics.classes;

public class NonGenericProduct {
    //java5 den önce yapılan
    private Object code;//code fieldının data tipi Objectin tüm childları olabilir.
//code burada null

    //getter-setter


    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
        this.code = code;
    }
}

