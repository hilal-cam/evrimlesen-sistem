# AI Pair Programming Günlüğü - Faz 3 (Ekstra Beyin Fırtınası)

**Tarih:** 10 Mayıs 2026  
**Süre:** 30 Dakika  
**AI Modeli:** Gemini  

### 1. Neler Konuştuk? (30 Dakikalık Teknik Tartışma)
Faz 3'ün kodlarını kendim yazıp bitirdikten sonra, tasarımın sağlamlığını test etmek için AI ile bir 30 dakika daha oturduk. Kodun dışındaki şu mimari senaryoları tartıştık:

* **"Ya kullanıcı son anda fikir değiştirirse?":** Strategy Pattern'i kurduk ama kullanıcı tam ödeme yapacakken "Vazgeçtim, öğrenci indirimini değil bayram indirimini kullanacağım" derse sistemin mimari olarak buna nasıl tepki vereceğini analiz ettik. AI burada sistemi çok ağırlaştıracak karmaşık yöntemler önerdi ama ben "Metodun içine bir kontrol koysak yeter, tasarımı gereksiz yormayalım" diyerek daha sade bir çözümde karar kıldım.
* **Stok Bildirimleri Sistemi Yavaşlatır mı?:** Observer Pattern ile ürün bittiğinde takipçilere haber veriyoruz. "Peki ya binlerce kişi takip ediyorsa ve sistem kilitlenirse?" konusunu açtım. AI ile bu bildirimlerin ana sistemi yormadan arka planda (asenkron) nasıl kurgulanabileceği üzerine fikir yürüttük.
* **Hataları Nasıl Engelleriz?:** Sisteme yanlışlıkla "boş" (null) bir indirim tanımlanması gibi hatalı durumlarda kodun çökmemesi için mimaride nasıl bir önlem alabileceğimizi tartıştık. AI yine çok uç ve zor örnekler verdi ama ben basit ve etkili bir hata yönetimiyle (Exception Handling) ilerlemenin daha doğru olduğunu savundum.

### 2. Kendi Yorumum

**AI olmasa bu kısım ne kadar sürerdi?** Kod yazmak bir şekilde halloluyor ama bu "Ya şöyle olursa?" dediğimiz uç durumları (edge cases) tek başıma düşünüp mantıklı bir karara bağlamam en az **2-3 saatimi** alırdı. AI ile bu beyin fırtınasını 30 dakikada sanki bir iş arkadaşımla tartışıyormuşum gibi hızlıca çözdük.

**AI beni nerede yanılttı?** AI bazen çok gaza geliyor. Küçücük ödev projesi için sanki Amazon'u yönetiyormuşuz gibi aşırı zor ve mimariyi çok karmaşıklaştıracak çözümler (AOP, Null Object Pattern vb.) önerdi. Bu noktada AI'nın sunduğu mimari önerilerin projenin kapsamını aşacağını fark ettim. "Dur bakalım, alt tarafı dönem ödevi yapıyoruz, kodu çorbaya çevirmeye gerek yok" diyerek onu daha basit ve "Temiz Kod" (Clean Code) prensiplerine ben çektim.

**AI'dan aldığım en büyük katkı ne?** En büyük katkısı, benim o an aklıma gelmeyen "Ya kullanıcı şunu yaparsa?" dediği o ters durumları bana hatırlatması oldu. Sayesinde proje sadece "çalışan" bir kod yığını değil; sağlam, mantıklı ve esnek bir mimari haline geldi. Ayrıca teknik terimleri (Open-Closed, Coupling vb.) yerli yerinde kullanarak projeyi savunmamda bana yardımcı oldu.
