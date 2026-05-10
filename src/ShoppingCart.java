package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

enum KartTipi { 
	VISA, MASTERCARD, TROY 
}
enum UyeTipi {
	STANDART, GOLD, PREMIUM 
}
enum KiyafetTipi { 
	TISORT, GOMLEK, PANTOLON, ELBISE 
}
enum Renk {
	MAVI, YESIL, TURUNCU, KIRMIZI, KAHVERENGI, SIYAH, BORDO, SARI
}
enum Marka {
	DEFACTO, MAVI, KOTON, GUCCI 
}
enum KumasTipi {
	KETEN, PAMUK, VISKON, POLYESTER 
}
enum Beden {
	S, M, L, XL
}

class Kiyafet {
    public KiyafetTipi kiyafetTipi;
    public Renk renk;
    public Marka marka;
    public KumasTipi kumasTipi;
    public Beden beden;
    public double fiyat;

    public Kiyafet(KiyafetTipi kiyafetTipi, Renk renk, Marka marka, KumasTipi kumasTipi, Beden beden, double fiyat) {
        this.kiyafetTipi = kiyafetTipi;
        this.renk = renk;
        this.marka = marka;
        this.kumasTipi = kumasTipi;
        this.beden = beden;
        this.fiyat = fiyat;
    }
 //Decorator' ların çalışması için tanımlanan metot
	public double getFiyat() {
        return fiyat;
	}
}
// NOT: Yorum satırına aldığım sınıfları modüler olması için ayrı ayrı .java uzantılı dosyalarda tanımladım. Buraya yorum satırı olarak yazmamın nedeni projeyi tek bir bütün dosyada görebilmek.
/*
class UstGiyim extends Kiyafet {
    public UstGiyim(KiyafetTipi tip, Renk r, Marka m, KumasTipi k, Beden b, double f) {
        super(tip, r, m, k, b, f);
    }
    @Override
    public double getFiyat() { return fiyat; }
}
*/
/*
class AltGiyim extends Kiyafet {
    public AltGiyim(KiyafetTipi tip, Renk r, Marka m, KumasTipi k, Beden b, double f) {
        super(tip, r, m, k, b, f);
    }
    @Override
    public double getFiyat() { return fiyat; }
} 
*/

// --- TASARIM ÖRÜNTÜSÜ: FACTORY CLASS ---
/*
class UrunFactory {
    public static Kiyafet kiyafetOlustur(KiyafetTipi tip, Renk rnk, Marka mrk, KumasTipi kms, Beden bdn, double fyt) {
        return new Kiyafet(tip, rnk, mrk, kms, bdn, fyt);
    }
}
*/
/*
// [FAZ 2: DECORATOR PATTERN]
abstract class KiyafetDecorator extends Kiyafet {
    protected Kiyafet urun; // Sarmalanan ürün

    public KiyafetDecorator(Kiyafet urun) {
        super(urun.kiyafetTipi, urun.renk, urun.marka, urun.kumasTipi, urun.beden, urun.fiyat);
        this.urun = urun;
    }

    @Override
    public double getFiyat() {
        return urun.getFiyat();
    }
}

class HediyePaketiDecorator extends KiyafetDecorator {
    public HediyePaketiDecorator(Kiyafet urun) { super(urun); }
    @Override
    public double getFiyat() { return super.getFiyat() + 20.0; }
}



// [FAZ 2: ADAPTER PATTERN]
class DisOdemeServisi {
    public void servisOdemesi(String isim, double miktar) {
        System.out.println("Dış Servis: " + isim + " adına " + miktar + " TL tahsil edildi.");
    }
}

class OdemeAdapter {
    private DisOdemeServisi servis = new DisOdemeServisi();
    public void odemeYap(String isim, double tutar) {
        servis.servisOdemesi(isim, tutar);
    }
}
*/



class Satici {
    public String saticiAd;
    public Satici(String saticiAd) { this.saticiAd = saticiAd; }

    public Kiyafet yeniUrunOlustur() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Ürün Giriş Paneli (Faz 1) ---");
        
        System.out.print("Ürün Tipi (TISORT, GOMLEK...): ");
        KiyafetTipi tip = KiyafetTipi.valueOf(scanner.next().toUpperCase());
        
        System.out.print("Renk: ");
        Renk rnk = Renk.valueOf(scanner.next().toUpperCase());
        
        System.out.print("Marka: ");
        Marka mrk = Marka.valueOf(scanner.next().toUpperCase());
        
        System.out.print("Kumaş: ");
        KumasTipi kms = KumasTipi.valueOf(scanner.next().toUpperCase());
        
        System.out.print("Beden: ");
        Beden bdn = Beden.valueOf(scanner.next().toUpperCase());
        
        System.out.print("Fiyat: ");
        double fyt = scanner.nextDouble();
		
        return UrunFactory.kiyafetOlustur(tip, rnk, mrk, kms, bdn, fyt);
    }
}

class Musteri {
    public String musteriAd;
    public UyeTipi uyeTipi;
    public List<Kiyafet> sepet = new ArrayList<>();

    public Musteri(String musteriAd, UyeTipi uyeTipi) {
        this.musteriAd = musteriAd;
        this.uyeTipi = uyeTipi;
    }

    public void sepeteEkle(Kiyafet k) {
        if (k != null) sepet.add(k);
    }

    public double AlisverisTutarHesapla() {
        double toplam = 0;
        double kargoUcreti = 35.0;

        for (Kiyafet k : sepet) {
            double urunFiyati = k.getFiyat();
            // İş mantığı (fiyat hesaplamaları) Faz 0 ile aynı kalıyor
            if (k.marka == Marka.GUCCI) urunFiyati += 500; 
            else if (k.marka == Marka.MAVI) urunFiyati += 50;
            if (k.renk == Renk.KIRMIZI) urunFiyati *= 0.90;
            if (k.kumasTipi == KumasTipi.KETEN) urunFiyati += 30;
            if (k.beden == Beden.XL) urunFiyati += 10;
            if (k.kiyafetTipi == KiyafetTipi.ELBISE) urunFiyati *= 1.2;
            if (uyeTipi == UyeTipi.GOLD) urunFiyati -= 30;
            else if (uyeTipi == UyeTipi.PREMIUM) urunFiyati -= 70;

            toplam += urunFiyati;
        }

        if (toplam > 450) kargoUcreti = 0;
        return toplam + kargoUcreti;
    }

    public void odemeIslemleri(KartTipi kart, double tutar) {
        if (kart == KartTipi.VISA) tutar += 2;
        System.out.println(kart + " ile " + tutar + " TL ödendi.");
    }
}

public class ShoppingCart {
    public static void main(String[] args) {
        // 1. Hazırlık: Satıcı ve Müşteri nesneleri
        Satici satici = new Satici("Hilal Mağazacılık");
        Musteri musteri = new Musteri("Hilal Çam", UyeTipi.GOLD);
        
        // 2. Faz 1: Ürün Oluşturma (UrunFactory üzerinden)
        Kiyafet urun = satici.yeniUrunOlustur();
        
        // 3. Faz 2: Decorator Uygulama 
        // Yanda tanımladığın HediyePaketiDecorator sınıfını çağırıyoruz.
        Kiyafet hediyePaketliUrun = new HediyePaketiDecorator(urun);

        // Sepete süslenmiş ürünü ekle
        musteri.sepeteEkle(hediyePaketliUrun);
        
        // 4. Hesaplama ve Ödeme (Adapter kullanımı)
        double toplam = musteri.AlisverisTutarHesapla();
        
        System.out.println("\n--- Faz 2 İşlem Özeti ---");
        System.out.println("Ürün Tipi: " + urun.kiyafetTipi);
        System.out.println("Toplam Tutar (Süsleme Dahil): " + toplam + " TL");
        
        // Ödeme kısmı
        musteri.odemeIslemleri(KartTipi.TROY, toplam);
    }
}

