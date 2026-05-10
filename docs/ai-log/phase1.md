## AI Ne Sordum?
Faz 0 kapsamında yazdığım alışveriş sepeti uygulamasında, Satici sınıfı içinde sürekli new anahtar kelimesiyle ürün oluşturuyorum. Bu durum sınıfları birbirine çok bağımlı hale getiriyor. Bu sorunu Factory Method tasarım örüntüsüyle nasıl çözeriz? Ayrıca kıyafetleri UstGiyim ve AltGiyim olarak ayırmak mantıklı mı, bana bu yapıya uygun bir kod mimarisi önerir misin?

## AI Ne Yanıtladı?
AI, nesne oluşturma mantığının Satici sınıfının görevi olmadığını, bunun için ayrı bir UrunFactory sınıfı kurmam gerektiğini belirtti. Bu sayede "Nesne Yaratma Sorumluluğunun Soyutlanması" (Abstraction of Instantiation) sağlanacağını açıkladı. Kıyafetleri alt sınıflara bölmenin ise Polimorfizm (Çok Biçimlilik) açısından faydalı olacağını; ileride sadece pantolonlara veya sadece tişörtlere özel indirim mantıkları eklediğimde ana kodun bozulmayacağını (Open/Closed Principle) vurguladı.

## Ben Ne Uyguladım? Neden Farklı/Aynı?
UrunFactory sınıfını kurdum ve AI tarafından önerilen mimariyi kullanarak Satici'nin bu fabrika üzerinden nesne almasını sağladım.

Neden Aynı?: Çünkü önerilen Factory Method yapısı, projenin bu fazdaki temel amacı olan "nesne yaratma sürecini soyutlama" ve "sıkı bağlılığı giderme" hedeflerini tam olarak karşılıyordu. Satici sınıfını somut ürün detaylarından kurtararak projenin bakımını kolaylaştırdığı için yapıda bir değişikliğe gitmedim.
