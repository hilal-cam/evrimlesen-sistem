package src;

public class AltGiyim extends Kiyafet {
    public AltGiyim(String ad, double fiyat) {
        super(ad, fiyat);
    }

    @Override
    public String toString() {
        return "[Alt Giyim] " + getAd() + " - " + getFiyat() + " TL";
    }
}
