package src;

public class OgrenciIndirimi implements IndirimStratejisi {
    @Override
    public double indirimUygula(double fiyat) {
        System.out.println("[STRATEJİ]: Öğrenci indirimi (50 TL) uygulandı.");
        return fiyat - 50.0;
    }
}
