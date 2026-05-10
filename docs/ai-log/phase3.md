# AI Pair Programming - Faz 3 (Beyin Fırtınası)

**Tarih:** 10 Mayıs 2026  
**Süre:** 30 Dakika  
**AI Modeli:** Gemini  

### 1. Ne Tartıştık ve Süreç Nasıl İlerledi?
Faz 3'ün kodlarını kendim yazıp bitirdikten sonra, tasarımın sağlamlığını ve mantık hatalarını denetlemek için AI ile 30 dakikalık bir seans yaptık. Süreç şu şekilde ilerledi:

* **Kullanıcı Kararları ve Mimari Esneklik:** Strategy Pattern'i kurduğum yapıda, kullanıcının çalışma anında indirim türünü değiştirmesi durumunda sistemin nasıl tepki vereceğini tartıştık. AI çok karmaşık çözümler sundu ama ben sistem performansını korumak için daha sade bir kontrol mekanizmasında karar kıldım.
* **Observer ve Performans Analizi:** Stok güncellendiğinde tetiklenen bildirimlerin sistemi kilitleyip kilitlemeyeceği üzerine kafa yorduk. Binlerce takipçi olması durumunda bu işlemin asenkron bir yapıda kurgulanması gerektiği üzerine fikir alışverişi yaptık.
* **Hata Yönetimi Senaryoları:** Sisteme "null" bir indirim tanımlanması gibi hatalı durumlarda kodun çökmemesi için mimaride nasıl bir önlem alabileceğimizi tartıştık. AI'nın önerdiği uç örnekler yerine, projenin okunabilirliğini bozmayacak temel hata yönetimi stratejileri üzerinde durduk.

### 2. Değerlendirme

**AI olmadan bu faz ne kadar sürerdi?**
Faz 3 kapsamında hem Strategy hem de Observer örüntülerini birbirine entegre etmek, hata kontrollerini planlamak ve tüm bu süreci dökümante etmek tek başıma kalsaydım en az **10-12 saatimi** alırdı. Özellikle mimari doğruluğu teyit etmek için yapacağım araştırma ve UML hazırlama süreci AI ile yapılan bu kritik oturumu sayesinde çok daha hızlı ve kaliteli tamamlandı.

**AI beni nerede yanılttı?**
AI bazen çok gaza gelerek ödev projesinin kapsamını aşan, sanki çok büyük bir kurumsal sistemi (Amazon vb.) yönetiyormuşuz gibi aşırı karmaşık mimari çözümler (AOP, Null Object Pattern vb.) önerdi. Bu noktada önerilen yapıların kodu gereksiz yere karıştıracağını fark ettim. "Kodu çorbaya çevirmeye gerek yok" diyerek onu daha basit ve "Temiz Kod" prensiplerine uygun çözümlere ben yönlendirdim.
