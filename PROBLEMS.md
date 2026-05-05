# Faz 0: Başlangıç Kodunun Analizi

Bu dosya, projenin ilk aşamasında tasarım örüntüleri kullanılmadan yazılan kodun eksikliklerini ve yol açtığı sorunları belgelemektedir.

## Gördüğüm Tasarım Sorunları
1) Enum Meselesi: Şimdi ben ürün özelliklerini (marka, renk, beden falan) enum yaptım ama yarın bir gün satıcı gelip "Ben ayakkabı satacağım" dese ya da yeni bir marka eklesek, mecburen gidip kodun içini açıp enumları güncellemem gerekecek. Yani sistem dışarıdan yeni bir şey eklemeye kapalı (Satici sınıfı içerisindeki yeniUrunOlustur metodu çalışmayacak), bu çok hantal bir yapı.

2) Spagetti Kod ve Bakım Zorluğu: AlisverisTutarHesapla metodunun içi tam bir if-else yığınına döndü. Yeni bir ürün eklense ve yeni bir kural (mesela "Turkuaz olanlar %5 indirimlidir") gelse, gidip o metodun içine bir else if daha çakmam lazım. Metot sürekli şişiyor; bir yerden sonra hata yaptığımda nerede olduğunu bulmam imkansız hale gelecek. Kodun okunabilirliği çok düşük.

3) Ödeme İşlemi Saçmalığı: Ödeme metodunda her karttan kafama göre +2 TL kesiyorum ama gerçek hayatta böyle değil ki; her bankanın, her kartın komisyonu farklı. Bu mantığı Musteri sınıfının içine gömmem de ayrı bir hata, müşterinin işi sepet tutmak, banka komisyonu hesaplamak değil.

4) Kargo Limitleri: Kargo 35 TL, sınır 450 TL diye kodun içine "çat" diye yazdım. Yarın bu limitler değişirse, oturup tek tek kodda bu rakamları aramaya başlayacağım. Bunların bir yerden dinamik gelmesi lazım.

5) Gereksiz Bağımlılık: Şu an indirim mantığı tamamen Musteri sınıfının içine hapsolmuş durumda. Yarın bir gün "Satıcılar için de bir kampanya yapalım" desek veya başka bir sınıfta bu indirimleri kullanmak istesek, mecburen bu kodları oraya kopyalayıp yapıştırmam gerekecek. İndirim mantığı bağımsız bir parça (modül) olmadığı için kodu başka yerde kullanamıyorum, her şey birbirine bağlı.
