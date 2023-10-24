package generics.Tekrar.Bounding;

public class üstsınır<T extends Number>{
  private T[] arr;

    public üstsınır(T[] arr) {
        this.arr = arr;
    }


    public double getArr() {
        //içindeki elemanların toplamını bulacagım
        double sum=0;
        for (T t:this.arr){
            sum+=t.doubleValue();
        }
        double average=sum/this.arr.length;
        return average;
    }

    public static void main(String[] args) {
        Integer[] integers={1,2,5};
        Double[] doubles={1.2,5.6,88.2};
        String[] strings={"generıcs","üstten","sınırlandırılabilir"};

        üstsınır<Integer>obj1=new üstsınır<>(integers);
        System.out.println("obj1.getArr()= "+obj1.getArr());
        üstsınır<Double>obj3=new üstsınır<>(doubles);
       // üstsınır<String>obj2=new üstsınır<>(strings);

    }
}


