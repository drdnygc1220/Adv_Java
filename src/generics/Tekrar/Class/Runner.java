package generics.Tekrar.Class;

import generics.classes.GenericProduct;

import java.util.ArrayList;
import java.util.HashMap;

public class Runner {
    public static void main(String[] args) {
        GenericProduct<String>kitap=new GenericProduct<>();
        kitap.setCode("java");
        String str= kitap.getCode();
        GenericProduct<Integer>laptop=new GenericProduct<>();
        laptop.setCode(123);
        Integer integer= laptop.getCode();

        ArrayList<String>list=new ArrayList<>();
        list.add("java");

        HashMap<String,Integer>map=new HashMap<>();
        map.put("java",123);

        //--------GENERİCTWO---------
        GenericTwo<Integer,String> maps=new GenericTwo<>(11,"java");
        GenericTwo<String,String>map2=new GenericTwo<>("java","güzeldir..");
    }

}
