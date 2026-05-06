package src;

public class UrunFactory {
    public static Kiyafet kiyafetOlustur(String tip, String ad, double fiyat) {
        if (tip == null) return null;
        
        if (tip.equalsIgnoreCase("UST")) {
            return new UstGiyim(ad, fiyat);
        } else if (tip.equalsIgnoreCase("ALT")) {
            return new AltGiyim(ad, fiyat);
        }
        return new Kiyafet(ad, fiyat);
    }
}
