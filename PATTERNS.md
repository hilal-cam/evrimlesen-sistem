# Tasarım Örüntüleri Uygulama Günlüğü

Bu dosya, projenin ilerleyen fazlarında sisteme dahil edilecek olan tasarım örüntülerinin seçim gerekçelerini ve uygulama detaylarını içermektedir.

## Faz: 0
Şu anda herhangi bir tasarım örüntüsü kullanılmamıştır. Sistem "Spaghetti Code" yapısında, tüm mantığın tek bir sınıf ve metod içinde toplandığı bir haldedir.

## 1. Nesne Oluşturma Örüntüleri (Creational Patterns)
*  **Hedef:** İndirim stratejilerini veya farklı ürün tiplerini oluştururken esneklik sağlamak.
## 2. Yapısal Örüntüler (Structural Patterns)
*  **Hedef:** Farklı indirim türlerini veya ek hizmetleri (kargo, hediye paketi vb.) ana kodu bozmadan birbirine eklemek.
## 3. Davranışsal Örüntüler (Behavioral Patterns)
*  **Hedef:** Sepetteki indirim hesaplama mantığını (Strategy Pattern gibi) dinamik hale getirmek ve if-else yığınlarından kurtulmak.

## Faz: 1 - Factory Method Örüntüsü

Bu aşamada, sistemdeki nesne yaratma süreçlerini kontrol altına almak ve sınıflar arasındaki bağımlılığı (coupling) minimize etmek amacıyla **Factory Method** tasarım örüntüsü uygulanmıştır.

### 1. Uygulanan Örüntü: Factory Method
- **Problem:** Satici sınıfı, ürünleri oluştururken doğrudan new Kiyafet(...) söz dizimini kullanıyordu. Bu durum, satıcı sınıfının somut ürün detaylarına sıkı sıkıya bağlı kalmasına neden oluyor ve yeni ürün tipleri eklemeyi zorlaştırıyordu.
- **Çözüm:** UrunFactory sınıfı merkezi bir karar noktası olarak sisteme dahil edildi. Nesne oluşturma sorumluluğu bu sınıfa devredilerek Satici ve ShoppingCart sınıflarının somut sınıflardan (UstGiyim, AltGiyim) soyutlanması sağlandı.
- **Uygulama:** Fabrika yapısı, KiyafetTipi bilgisini analiz ederek arka planda doğru alt sınıfın (Örn: UstGiyim) örneğini oluşturur.

### 2. Sağlanan Teknik Avantajlar
- **Gevşek Bağlılık (Loose Coupling):** Üst seviye modüller, nesnelerin nasıl oluşturulduğuyla ilgilenmeyi bırakmıştır.
- **Bakım Kolaylığı:** Ürün oluşturma mantığında yapılacak bir değişiklik (örneğin yeni bir parametre eklenmesi) artık tüm kod tabanında değil, sadece UrunFactory içinde yapılacaktır.
- **Polimorfizm:** Tüm ürünler Kiyafet arayüzü/sınıfı üzerinden işleme alınarak kodun daha esnek olması sağlanmıştır.
