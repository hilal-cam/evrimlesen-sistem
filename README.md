# EVRİMLEŞEN SİSTEM - Yazılım Tasarım Örüntüleri Ödevi

## Öğrenci Bilgileri
*   **Ad Soyad:** Hilal Çam
*   **Okul:** Konya Teknik Üniversitesi (KTÜN)
*   **Bölüm:** Yazılım Mühendisliği

---

## Konu Seçimi
**Seçilen Konu:** D - E-Ticaret Sepeti

## Seçim Gerekçesi
E-ticaret platformlarında bir ürünün onlarca farklı renk varyasyonu olması, hem kullanıcı arayüzünde hem de arka plan kodunda büyük bir karmaşa yaratmaktadır. Mevcut sistemlerde her renk ayrı bir ürün nesnesi gibi listelenmekte, bu da kodda yönetilemez if-else yığınlarına ve bellek israfına yol açmaktadır.

Bu projede şunları hedefliyorum:
1.  **Flyweight (Yapısal):** Aynı modelin farklı renklerini tek bir çatı altında toplayarak bellek verimliliği sağlamak.
2.  **Factory Method (Yaratımsal):** Nesne üretimini standartlaştırarak sepet sınıfını bu yükten kurtarmak.
3.  **Strategy (Davranışsal):** Varyasyon bazlı (renk, stok durumu vb.) esnek indirim mantıkları kurgulayarak sistemi genişletilebilir kılmak.

---

## Kullanılan Teknolojiler & Araçlar
*   **Dil:** Java
*   **Versiyon Kontrol:** GitHub
*   **Diyagramlar:** UML (PlantUML / Mermaid)
*   **Yapay Zeka:** Gemini (Pair Programming)

---

## Repository Yapısı
*   `src/`: Kaynak kodlar.
*   `docs/ai-log/`: Yapay zeka ile yapılan tasarım tartışmalarının kayıtları.
*   `docs/diagrams/`: Sistemin UML diyagramları.
*   `PROBLEMS.md`: Başlangıç kodundaki tasarım sorunlarının analizi.
*   `PATTERNS.md`: Uygulanan tasarım örüntülerinin detaylı dokümantasyonu.
