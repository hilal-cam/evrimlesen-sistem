import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

enum KartTipi {
	VISA, MASTERCARD, TROY 
	}
enum UyeTipi { 
	STANDART, GOLD, PREMİUM 
	}
enum KiyafetTipi {
	TISORT, GOMLEK, PANTOLON, ELBISE 
	}
enum Renk { 
	MAVI, YESIL, TURUNCU, KIRMIZI, KAHVERENGİ, SIYAH, BORDO, SARI 
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
}


class Satici {
    public String saticiAd;
    
    public Satici(String saticiAd) {
        this.saticiAd = saticiAd;
    }

   
    public Kiyafet yeniUrunOlustur() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Satıcı Ürün Giriş Paneli ---");
        
        System.out.print("Kıyafet Türü: ");
        String tip = scanner.next().toUpperCase();
        
        System.out.print("Renk: ");
        String renk = scanner.next().toUpperCase();
        
        System.out.print("Temel Satış Fiyatı: ");
        double fiyat = scanner.nextDouble();

        return new Kiyafet(
            KiyafetTipi.valueOf(tip),
            Renk.valueOf(renk),
            Marka.DEFACTO,
            KumasTipi.PAMUK,
            Beden.L,
            fiyat
        );
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
        if (k != null) {
            sepet.add(k);
            System.out.println(k.kiyafetTipi + " sepete eklendi.");
        }
    }

    
    public double AlisverisTutarHesapla() {
        double toplam = 0;
        double kargoUcreti = 35.0;

        for (Kiyafet k : sepet) {
            double urunFiyati = k.fiyat;

            if (k.renk == Renk.KIRMIZI) urunFiyati -= urunFiyati * 0.20;
            else if (k.renk == Renk.MAVI) urunFiyati -= urunFiyati * 0.10;

          
            if (uyeTipi == UyeTipi.GOLD) urunFiyati -= 25;
            else if (uyeTipi == UyeTipi.PREMİUM) urunFiyati -= 55;

            toplam += urunFiyati;
        }

        if (toplam > 450) kargoUcreti = 0;
        return toplam + kargoUcreti;
    }

    public void odemeIslemleri(KartTipi kart, double tutar) {

        System.out.println(kart + " ile " + tutar + " TL ödeme yapıldı. İşlem başarılı.");
    }
}


public class ShoppingCart {
    public static void main(String[] args) {
        Satici satici = new Satici("Hilal Mağazacılık");
        Musteri musteri = new Musteri("Hilal Çam", UyeTipi.PREMİUM);
        
  
        Kiyafet urun1 = satici.yeniUrunOlustur();
        musteri.sepeteEkle(urun1);
        
        double toplam = musteri.AlisverisTutarHesapla();
        System.out.println("Toplam Ödenecek: " + toplam);
        
        musteri.odemeIslemleri(KartTipi.VISA, toplam);
    }
}
