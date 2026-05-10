package src;

public class StokGozlemcisi implements IStokGozlemcisi {
    private String isim;

    public StokGozlemcisi(String isim) {
        this.isim = isim;
    }

    @Override
    public void guncellemeAl(String urunAdi, int yeniStok) {
        System.out.println(">>> BİLDİRİM [" + isim + "]: Beklediğiniz " + urunAdi + " stoğumuza girdi! Mevcut stok: " + yeniStok);
    }
}
