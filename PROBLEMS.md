# Faz 0: Başlangıç Kodunun Analizi

Bu dosya, projenin ilk aşamasında tasarım örüntüleri kullanılmadan yazılan kodun eksikliklerini ve yol açtığı sorunları belgelemektedir.

## Gördüğüm Tasarım Sorunları
1) Enum Meselesi: Şimdi ben ürün özelliklerini (marka, renk, beden falan) enum yaptım ama yarın bir gün satıcı gelip "Ben ayakkabı satacağım" dese ya da yeni bir marka eklesek, mecburen gidip kodun içini açıp enumları güncellemem gerekecek. Yani sistem dışarıdan yeni bir şey eklemeye kapalı (Satici sınıfı içerisindeki yeniUrunOlustur metodu çalışmayacak), bu çok hantal bir yapı.

2) Spagetti Kod ve Bakım Zorluğu: AlisverisTutarHesapla metodunun içi tam bir if-else yığınına döndü. Yeni bir ürün eklense ve yeni bir kural (mesela "Turkuaz olanlar %5 indirimlidir") gelse, gidip o metodun içine bir else if daha çakmam lazım. Metot sürekli şişiyor; bir yerden sonra hata yaptığımda nerede olduğunu bulmam imkansız hale gelecek. Kodun okunabilirliği çok düşük.

3) Ödeme İşlemi Saçmalığı: Ödeme metodunda her karttan kafama göre +2 TL kesiyorum ama gerçek hayatta böyle değil ki; her bankanın, her kartın komisyonu farklı. Bu mantığı Musteri sınıfının içine gömmem de ayrı bir hata, müşterinin işi sepet tutmak, banka komisyonu hesaplamak değil.

4) Kargo Limitleri: Kargo 35 TL, sınır 450 TL diye kodun içine "çat" diye yazdım. Yarın bu limitler değişirse, oturup tek tek kodda bu rakamları aramaya başlayacağım. Bunların bir yerden dinamik gelmesi lazım.

5) Gereksiz Bağımlılık: Şu an indirim mantığı tamamen Musteri sınıfının içine hapsolmuş durumda. Yarın bir gün "Satıcılar için de bir kampanya yapalım" desek veya başka bir sınıfta bu indirimleri kullanmak istesek, mecburen bu kodları oraya kopyalayıp yapıştırmam gerekecek. İndirim mantığı bağımsız bir parça (modül) olmadığı için kodu başka yerde kullanamıyorum, her şey birbirine bağlı.


## AI' ın Gördüğü Sorunlar

# 🛠️ Mevcut Tasarım Sorunları ve Mimari Çözüm Önerileri
### 1. Single Responsibility Principle (SRP) İhlali
* **Sorun:** `Musteri` sınıfı; sepet yönetimi, fiyat hesaplama ve ödeme işlemleri gibi birden fazla sorumluluğu aynı anda üstlenmektedir.
* **👉 Çözüm:** **Service Layer + Strategy Pattern**. Fiyat hesaplama ve ödeme işlemleri kendi sorumluluk alanlarına sahip ayrı sınıflara taşınmalıdır.

### 2. If-Else Yoğunluğu (Karmaşık Fiyat Kuralları)
* **Sorun:** `AlisverisTutarHesapla` metodu çok sayıda `if-else` bloğu içermektedir ve yeni kurallar eklemeye (genişlemeye) kapalıdır.
* **👉 Çözüm:** **Strategy Pattern**. Her indirim veya fiyat kuralı (Renk, Marka, Üye Tipi vb.) bağımsız bir strateji sınıfı olarak tanımlanmalıdır.

### 3. Genişletilemeyen Ödeme Sistemi
* **Sorun:** Ödeme işlemleri kart tipine göre sabit (hard-coded) koşullar ve statik komisyonlar (+2 TL gibi) ile yönetilmektedir.
* **👉 Çözüm:** **Strategy Pattern**. Her ödeme yöntemi (Kredi Kartı, Havale, vb.) için ayrı sınıflar oluşturularak sistem genişletilebilir hale getirilmelidir.

### 4. Nesne Oluşturma Bağımlılığı (Tight Coupling)
* **Sorun:** `Kiyafet` nesneleri sınıflar içerisinde doğrudan `new` anahtar kelimesi ile oluşturulmaktadır. Bu durum sınıflar arası sıkı bağlılık yaratır.
* **👉 Çözüm:** **Factory Pattern**. Nesne oluşturma süreci merkezi bir "Factory" sınıfına devredilmelidir.

### 5. UI ve İş Mantığının Karışması
* **Sorun:** `Satici` sınıfı hem kullanıcıdan veri almakta hem de iş mantığını yürütmektedir.
* **👉 Çözüm:** **MVC (Model-View-Controller)**. Kullanıcı etkileşimleri (View) ve iş mantığı (Model) birbirinden tamamen ayrılmalıdır.

### 6. Sert Kodlanmış (Hardcoded) Değerler
* **Sorun:** Kargo ücreti ($35$) ve bedava kargo sınırı ($450$) gibi sabit değerler doğrudan metotların içine yazılmıştır.
* **👉 Çözüm:** **Configuration Object / Builder Pattern**. Bu değerler parametrik hale getirilmeli ve dışarıdan yönetilebilmelidir.

### 7. Zayıf Sepet Modeli (Anemic Domain Model)
* **Sorun:** Sepet yapısı sadece veri tutan pasif bir yapıdadır, kendi davranışlarını yönetmemektedir.
* **👉 Çözüm:** **Rich Domain Model / Composite Pattern**. Sepet sınıfı, toplam tutar hesaplama gibi kendi işlevlerini barındıran akıllı bir yapıya dönüştürülmelidir.

### 8. Primitive Obsession (Temel Tip Takıntısı)
* **Sorun:** Fiyat ve para bilgileri sadece `double` tipiyle temsil edilmektedir, bu da hassas hesaplamalarda ve iş kurallarında kısıtlılık yaratır.
* **👉 Çözüm:** **Value Object Pattern**. Para işlemleri ve birimleri için özel bir sınıf (örn: `Money`) kullanılmalıdır.

### 9. Yüksek Bağımlılık (Tight Coupling)
* **Sorun:** İndirim ve fiyatlandırma mantığı doğrudan `Musteri` sınıfına gömülüdür, bu mantık başka bir yerde tekrar kullanılamaz.
* **👉 Çözüm:** **Dependency Injection + Strategy Pattern**. Bağımlılıklar sınıfa dışarıdan enjekte edilerek modülerlik artırılmalıdır.

### 10. Open/Closed Principle (OCP) İhlali
* **Sorun:** Sisteme yeni bir özellik veya kural eklenirken mevcut çalışan kodun (kaynak kodun) değiştirilmesi gerekmektedir.
* **👉 Çözüm:** **Strategy + Factory Pattern**. Sistem, mevcut kodu bozmadan yeni özellikler eklenebilecek (Gelişime açık, değişime kapalı) şekilde yeniden tasarlanmalıdır.


## Ben Ne Gördüm, AI Ne Gördü? Aralarındaki Farklar?

| Sorun Alanı | Benim Tespitim | AI Analizi | Aradaki Fark ve Kazanım |
| :--- | :--- | :--- | :--- |
| **İndirim & Fiyat** | "if-else yapıları çok şişti, yeni kural gelince kod patlayacak." | **OCP (Open/Closed Principle) İhlali** | Ben kodun yazım ve bakım zorluğuna odaklanırken, AI sistemin **genişletilebilirliğine** odaklandı. |
| **Sınıf Yapısı** | "Müşteri sınıfı bankacı gibi davranıyor, komisyon hesaplıyor." | **SRP (Single Responsibility) İhlali** | Ben mantıksal bir görev karmaşası fark ettim, AI bunu **sorumlulukların ayrılması** prensibiyle tanımladı. |
| **Modülerlik** | "Kod başka yere taşınmıyor, kopyala-yapıştır yapıyorum." | **Tight Coupling (Sıkı Bağlılık)** | Ben tekrar kullanılabilirlik sorununu gördüm, AI bunu **bağımlılık yönetimi** eksiği olarak teşhis etti. |
| **Ürün Yönetimi** | "Enum yüzünden yeni ürün ekleyemiyorum, sistem hantal." | **Extensibility (Genişletilebilirlik)** | Ben dinamik veri eksikliğini fark ettim, AI bunun için **Factory Pattern** çözümünü önerdi. |
| **Sabit Değerler** | "Kargo ücretini ve limiti tek tek kodda arıyorum." | **Hardcoded Values & Configuration** | Ben bakım zahmetini gördüm, AI bunun bir **parametre yönetimi** sorunu olduğunu gösterdi. |

**Sonuç olarak:**
- Benim "saçma" bulduğum noktalar aslında birer **"Code Smell" (Kod Kokusu)** idi.
- AI bu kokuları profesyonel terimlerle (SRP, OCP, Coupling) adlandırdı.
- Faz 1'den itibaren bu teorik teşhisleri, **Strategy** ve **Factory** gibi tasarım desenleriyle pratik çözümlere dönüştüreceğim.
  
