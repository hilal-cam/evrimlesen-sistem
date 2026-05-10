package src;

public class UstGiyim extends Kiyafet {
    public UstGiyim(String ad, double fiyat) {
        super(ad, fiyat);
    }
    
    @Override
    public String toString() {
        return "[Üst Giyim] " + getAd() + " - " + getFiyat() + " TL";
    }
}
