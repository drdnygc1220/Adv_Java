package generics.interfaces.example;
//database baglanacagım
public class AccountRepo implements Repository<Account>{//Account tipi belli oldugu için T yazmıyorum.
    @Override
    public void save(Account object) {//SAVE:kaydetme:ekle methodu
        //DataBase ye baglan
        //INSERT INTO

    }

    @Override
    public Account find() {//FİND:kayıtları getir
        return null;
    }
}
