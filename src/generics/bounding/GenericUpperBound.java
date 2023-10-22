package generics.bounding;
//bounding:sınırlayıcı
//upper:üst
public class GenericUpperBound<T extends Number> {//sınırladık
    //parametre olarak aldıgımız data tipini üstten sınırlandırabiliriz.
    //bu sınıfta matematiksel işlem yapacaksam number classının kendisi ve alt sınıfları kullanılsın.
    //number classının alt classları:
    // int,short,byte,float,double,long,number clasın kendiside.Bu yüzden <T extends Number> yazıyoruz

    private T[] numberArray;//set edebilmek için constructor yapalım

    //parametreli const
    public GenericUpperBound(T[] numberArray) {
        this.numberArray = numberArray;
    }

    //numberArray içindeki elemanların ortalamasını bulalım
    public double getAverage() {
        double sum = 0;

        //arrayın içindeki toplamak için foreach kullanıyoruz,dolaşıcak
        for (T t : this.numberArray) {
            //sum+=t;//double degere toplamak için t degerini de double yapmam gerekir
            sum += t.doubleValue();

        }
        double average=sum/this.numberArray.length;
        return average;
    }

    //sınırlandırarak bu classı nasıl kullanacgız..
    //main methodunu burada oluşturacgız az örnek oldugu için
    public static void main(String[] args) {
        Integer[] integers={1,2,5};
        Double[] doubles={1.2,5.6,88.2};
        String[] strings={"generıcs","üstten","sınırlandırılabilir"};

        //getAverage methodunu kullanmak istiyorum bir tane obje oluşturalım..
        //Generıc oldugu için data tipini belirlemek zorundayız
        GenericUpperBound<Integer> obj1=new GenericUpperBound<>(integers);
        System.out.println("obj1.getAverage()= "+obj1.getAverage());

        //GenericUpperBound<String> obj2=new GenericUpperBound<>(strings);
        //bunu kabul etmiyor çünkü sınırladık..
        // GenericUpperBound<Double> obj2=new GenericUpperBound<>(integers);
        //bunu da kabul etmedi double yazıp integrs alamayız..

        GenericUpperBound<Double> obj2=new GenericUpperBound<>(doubles);
        System.out.println("obj2.getAverage()= "+obj2.getAverage());


    }






}
