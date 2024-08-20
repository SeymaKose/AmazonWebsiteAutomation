Feature: Kullanıcı Login

  Scenario Outline: Geçerli Bilgiler ile Başarılı Login
    Given kullanıcı Amazon giriş sayfasındadır
    When ekranın sağ üstünde bulunan Giriş yap butonuna tıklar
    And geçerli bir kullanıcı adı "<kullanıcıAdı>" girer
    And Devam Et butonuna tıklar ve şifre girme sayfasına yönlendirilir
    And geçerli bir şifre "<şifre>" girer
    And Giriş yap butonuna tıklar
    Then ana sayfanın sağ üstünde kullanıcı hesabının adı "<kullanıcıHesapAdı>" gözükmelidir
    And tarayıcı kapanır

    Examples: 
      | kullanıcıAdı          | şifre   | kullanıcıHesapAdı |
      | sseymakkose@gmail.com | qBWk!iq | Şeyma             |
      | +905377743585         | qBWk!iq | Şeyma             |

  Scenario: Kayıtlı olmayan e-posta adresi ile Login
    Given kullanıcı Amazon giriş sayfasındadır
    When ekranın sağ üstünde bulunan Giriş yap butonuna tıklar
    And kayıtlı olmayan bir e-posta adresi girer
    And Devam Et butonuna tıklar
    Then kullanıcı "Bu e-posta adresiyle bir hesap bulamıyoruz" şeklinde hata mesajı görmelidir
    And tarayıcı kapanır

  Scenario: Kayıtlı olmayan telefon numarası ile Login
    Given kullanıcı Amazon giriş sayfasındadır
    When ekranın sağ üstünde bulunan Giriş yap butonuna tıklar
    And kayıtlı olmayan bir telefon numarası girer
    And Devam Et butonuna tıklar
    Then kullanıcı "Lütfen girdiğiniz numaranın doğru olup olmadığını kontrol edin" şeklinde hata mesajı görmelidir
    And tarayıcı kapanır

  Scenario: Yanlış formatta e-posta veya telefon numarası ile Login
    Given kullanıcı Amazon giriş sayfasındadır
    When ekranın sağ üstünde bulunan Giriş yap butonuna tıklar
    And yanlış formatta e-posta veya telefon numarası girer
    And Devam Et butonuna tıklar
    Then kullanıcı "Yanlış veya geçersiz e-posta adresi veya cep telefonu numarası" şeklinde uyarı mesajı görmelidir
    And tarayıcı kapanır

  Scenario: Boş e-posta veya telefon numarası ile Login
    Given kullanıcı Amazon giriş sayfasındadır
    When ekranın sağ üstünde bulunan Giriş yap butonuna tıklar
    And kullanıcı e-posta veya telefon numarası gireceği alanı boş bırakır
    And Devam Et butonuna tıklar
    Then "E-posta adresinizi veya cep telefonu numaranızı girin" şeklinde uyarı mesajı görmelidir
    And tarayıcı kapanır

  Scenario: Yanlış şifre ile Login
    Given kullanıcı Amazon giriş sayfasındadır
    When ekranın sağ üstünde bulunan Giriş yap butonuna tıklar
    And geçerli bir e-posta veya telefon numarasını girer
    And Devam Et butonuna tıklar ve şifre girme sayfasına yönlendirilir
    And yanlış şifre girer
    And Giriş yap butonuna tıklar
    Then kullanıcı "Şifreniz yanlış" şeklinde hata mesajı görmelidir
    And tarayıcı kapanır

  Scenario Outline: Boş şifre ile Login
    Given kullanıcı Amazon giriş sayfasındadır
    When ekranın sağ üstünde bulunan Giriş yap butonuna tıklar
    And geçerli bir e-posta veya telefon numarasını girer
    And Devam Et butonuna tıklar ve şifre girme sayfasına yönlendirilir
    And şifre alanını boş bırakır
    And Giriş yap butonuna tıklar
    Then kullanıcı "Şifrenizi girin" uyarı mesajını görmelidir
    And tarayıcı kapanır

  Scenario: Şifremi unuttum süreci - Şifre giriş sayfası üzerinden
    Given kullanıcı Amazon giriş sayfasındadır
    When ekranın sağ üstünde bulunan Giriş yap butonuna tıklar
    And geçerli bir e-posta veya telefon numarasını girer
    And Devam Et butonuna tıklar ve şifre girme sayfasına yönlendirilir
    And kullanıcı şifremi unuttum linkine tıklar
    Then kullanıcı şifre sıfırlama sayfasına yönlendirilir
    And tarayıcı kapanır

  Scenario: Şifremi unuttum süreci - Kullanıcı adı giriş sayfası üzerinden
    Given kullanıcı Amazon giriş sayfasındadır
    When ekranın sağ üstünde bulunan Giriş yap butonuna tıklar
    And giriş yap kutucuğunun altında bulunan Yardıma mı ihtiyacınız var? linkine tıklar
    And açılan listeden Şifremi unuttum linkine tıklar
    Then kullanıcı şifre sıfırlama sayfasına yönlendirilir
    And tarayıcı kapanır

  Scenario Outline: Giriş yapılacak kullanıcıyı değiştirme
    Given kullanıcı Amazon giriş sayfasındadır
    When ekranın sağ üstünde bulunan Giriş yap butonuna tıklar
    And geçerli bir kullanıcı adı "<kullanıcıAdı>" girer
    And Devam Et butonuna tıklar ve şifre girme sayfasına yönlendirilir
    And Değiştir yazısına tıklar
    And kullanıcı adı giriş sayfasına geri döndürülür
    And geçerli bir kullanıcı adı "<yeniKullanıcıAdı>" girer
    Then Devam Et butonuna tıklar ve şifre girme sayfasına yönlendirilir
    And tarayıcı kapanır

    Examples: 
      | kullanıcıAdı          | yeniKullanıcıAdı      |
      | sseymakkose@gmail.com | se@gmail.com          |
      | +905377743585         | sseymakkose@gmail.com |

#  Scenario: Oturumum açık kalsın
#    Given kullanıcı Amazon giriş sayfasındadır
#    When ekranın sağ üstünde bulunan Giriş yap butonuna tıklar
#    And geçerli bir e-posta veya telefon numarasını girer
#    And Devam Et butonuna tıklar ve şifre girme sayfasına yönlendirilir
#    And geçerli bir şifre "qBWk!iq" girer
#    And Oturumum açık kalsın checkboxını işaretler
#    And Giriş yap butonuna tıklar
#    And ana sayfanın sağ üstünde kullanıcı hesabının adı "Şeyma" gözükmelidir
#    And kullanıcı tarayıcı kapatır ve tekrar açar, amazon ana sayfasına yönlendirilir
#    Then ana sayfanın sağ üstünde kullanıcı hesabının adı "Şeyma" gözükmelidir
