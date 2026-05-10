package src;

import java.util.ArrayList;
import java.util.List;

public class UrunTakip {
    private List<IStokGozlemcisi> gozlemciler = new ArrayList<>();

    public void aboneEkle(IStokGozlemcisi gozlemci) {
        gozlemciler.add(gozlemci);
    }

    public void stokGuncelle(String urunAdi, int stok) {
        System.out.println("\n[SİSTEM]: " + urunAdi + " stoğu güncellendi (" + stok + "). Abonelere haber veriliyor...");
        for (IStokGozlemcisi g : gozlemciler) {
            g.guncellemeAl(urunAdi, stok);
        }
    }
}
