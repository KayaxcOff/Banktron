# 🏦 Banktron - JavaFX Banking Application

Banktron, JavaFX kullanılarak geliştirilmiş modern bir bankacılık uygulamasıdır. Kullanıcıların hesap oluşturma, giriş yapma ve temel bankacılık işlemlerini gerçekleştirmelerine olanak tanır.

## 📋 Özellikler

### ✅ Mevcut Özellikler
- **Kullanıcı Kayıt Sistemi**: Yeni hesap oluşturma
- **Güvenli Giriş**: Kullanıcı adı ve şifre ile kimlik doğrulama
- **Para Yatırma**: Hesaba para ekleme
- **Para Çekme**: Hesaptan para çıkarma (bakiye kontrolü ile)
- **Bakiye Görüntüleme**: Anlık bakiye takibi
- **JSON Veri Depolama**: Kullanıcı verilerinin yerel dosyada saklanması

### 🚧 Geliştirme Aşamasında
- **Para Transfer Sistemi**: Kullanıcılar arası para transferi
- **SQLite Veritabanı Entegrasyonu**: JSON'dan SQLite'a geçiş
- **Gelişmiş UI/UX**: Modern arayüz tasarımı
- **İşlem Geçmişi**: Yapılan işlemlerin kaydı
- **Şifre Şifreleme**: Güvenlik artırımı

## 🛠️ Teknolojiler

- **Java 11+**
- **JavaFX 17+**
- **Maven** - Proje yönetimi
- **Gson** - JSON işlemleri
- **SQLite** (Planlanıyor)

## 📁 Proje Yapısı

```
banktron/
├── src/main/java/org/example/banktron/
│   ├── App.java                          # Ana uygulama sınıfı
│   ├── controller/
│   │   ├── MainViewController.java       # Ana ekran kontrolcüsü
│   │   ├── SignInController.java         # Giriş ekranı kontrolcüsü
│   │   ├── SignUpController.java         # Kayıt ekranı kontrolcüsü
│   │   └── SignViewController.java       # İlk ekran kontrolcüsü
│   └── func/
│       ├── BankTransactions.java         # Bankacılık işlemleri
│       ├── CheckSign.java               # Kimlik doğrulama
│       └── User.java                    # Kullanıcı modeli
├── src/main/resources/
│   └── org/example/banktron/
│       ├── hello-view.fxml              # Ana FXML dosyası
│       └── fxml/                        # Diğer FXML dosyaları
├── banktron.json                        # Kullanıcı verileri (otomatik oluşur)
├── pom.xml                              # Maven konfigürasyonu
└── README.md                            # Bu dosya
```

## 🚀 Kurulum ve Çalıştırma

### Gereksinimler
- Java 11 veya üzeri
- Maven 3.6+
- JavaFX 17+ (Maven dependency olarak dahil)

### Adımlar

1. **Projeyi klonlayın:**
```bash
git clone https://github.com/[kullanıcı-adınız]/banktron.git
cd banktron
```

2. **Bağımlılıkları yükleyin:**
```bash
mvn clean install
```

3. **Uygulamayı çalıştırın:**
```bash
mvn javafx:run
```

### IDE ile Çalıştırma
- **IntelliJ IDEA**: Run > Run 'App'
- **Eclipse**: Run As > Java Application
- **VS Code**: Java Extension Pack ile çalıştırın

## 📱 Kullanım

### İlk Kullanım
1. Uygulamayı başlattığınızda karşılama ekranını göreceksiniz
2. "Sign Up" ile yeni hesap oluşturun
3. Kullanıcı adı ve şifre belirleyin
4. "Sign In" ile giriş yapın

### Bankacılık İşlemleri
- **Para Yatırma**: Miktar girin ve "Deposit" butonuna tıklayın
- **Para Çekme**: Çekmek istediğiniz miktarı girin (bakiyenizi aşamaz)
- **Bakiye Kontrolü**: Ana ekranda güncel bakiyenizi görebilirsiniz

## 🐛 Bilinen Sorunlar ve Çözümler

### Yaygın Hatalar

1. **"FXML dosyası bulunamadı" hatası:**
   - Maven ile projeyi yeniden build edin: `mvn clean compile`

2. **JavaFX modül hatası:**
   - JDK'nızın JavaFX içerdiğinden emin olun veya Maven dependency'lerini kontrol edin

3. **JSON dosya yazma hatası:**
   - Uygulamanın çalıştığı dizinde yazma yetkisi olduğundan emin olun

### Çözüm Önerileri
- IDE'nizi yeniden başlatın
- Maven cache'i temizleyin: `mvn clean`
- Java version compatibility kontrol edin

## 🔧 Geliştirme Planı

### Kısa Vadeli (v1.1)
- [x] Temel CRUD işlemleri
- [ ] Transfer özelliği
- [ ] UI iyileştirmeleri
- [ ] Input validation

### Orta Vadeli (v1.2)
- [ ] SQLite entegrasyonu
- [ ] Şifre hashleme
- [ ] İşlem geçmişi
- [ ] Kullanıcı profil yönetimi

### Uzun Vadeli (v2.0)
- [ ] Multi-currency desteği
- [ ] Faiz hesaplama
- [ ] Kredi/borç takibi
- [ ] Grafik raporlama

## 🤝 Katkıda Bulunma

Katkılarınızı memnuniyetle karşılıyoruz! Katkıda bulunmak için:

1. Bu repository'yi fork edin
2. Feature branch oluşturun (`git checkout -b feature/amazing-feature`)
3. Değişikliklerinizi commit edin (`git commit -m 'Add amazing feature'`)
4. Branch'inizi push edin (`git push origin feature/amazing-feature`)
5. Pull Request oluşturun

### Kod Standartları
- Java naming conventions'ları takip edin
- JavaDoc yorumları ekleyin
- Unit testler yazın
- Commit mesajlarını açıklayıcı yapın

## 👨‍💻 Geliştirici

**[Adınız]**
- GitHub: [@KayaxcOff](https://github.com/KayaxcOff)
- Email: [e-mail](mailto:muham123cak@gmail.com)

## 📞 İletişim ve Destek

- **Issues**: GitHub Issues sayfasını kullanın
- **Email**: Sorularınız için [e-mail](mailto:muham123cak@gmail.com)
- **Discussions**: GitHub Discussions'da tartışmalara katılın

## 🔄 Sürüm Geçmişi

### v1.0.0 (Mevcut)
- ✅ Temel kullanıcı kayıt/giriş sistemi
- ✅ Para yatırma/çekme işlemleri
- ✅ JSON veri depolama
- ✅ JavaFX UI

### v0.9.0 (Beta)
- 🐛 Sign-up hataları düzeltildi
- 🔧 Input validation eklendi
- 💫 UI iyileştirmeleri

---

## 🙏 Teşekkürler

Bu projeyi kullandığınız ve katkıda bulunduğunuz için teşekkür ederiz!

**⭐ Projeyi beğendiyseniz yıldız vermeyi unutmayın!**
