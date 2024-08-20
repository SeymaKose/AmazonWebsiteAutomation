package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions {
	static WebDriver driver;
	
	@Given("kullanıcı Amazon giriş sayfasındadır")
	public void kullanıcı_amazon_giriş_sayfasındadır() throws InterruptedException {
	    driver = new ChromeDriver();
	    driver.get("https://www.amazon.com.tr/");
	    driver.manage().window().maximize();
	    Thread.sleep(2000);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@When("ekranın sağ üstünde bulunan Giriş yap butonuna tıklar")
	public void ekranın_sağ_üstünde_bulunan_giriş_yap_butonuna_tıklar() {
	    driver.findElement(By.xpath("//*[@id=\"nav-signin-tooltip\"]/a")).click();
	}

	@And("geçerli bir kullanıcı adı {string} girer")
	public void geçerli_bir_kullanıcı_adı_girer(String kullanıcıAdı) {
	    driver.findElement(By.id("ap_email")).sendKeys(kullanıcıAdı);
	}

	@And("Devam Et butonuna tıklar ve şifre girme sayfasına yönlendirilir")
	public void butonuna_tıklar_ve_şifre_girme_sayfasına_yönlendirilir() throws InterruptedException {
		driver.findElement(By.id("continue")).click();
		Thread.sleep(1000);
	}

	@And("geçerli bir şifre {string} girer")
	public void geçerli_bir_şifre_girer(String şifre) {
		driver.findElement(By.id("ap_password")).sendKeys(şifre);
	}

	@And("Giriş yap butonuna tıklar")
	public void butonuna_tıklar() {
	    driver.findElement(By.id("signInSubmit")).click();
	}

	@Then("ana sayfanın sağ üstünde kullanıcı hesabının adı {string} gözükmelidir")
	public void ana_sayfanın_sağ_üstünde_kullanıcı_hesabının_adı_gözükmelidir(String kullanıcıHesapAdı) {
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText().contains(kullanıcıHesapAdı);
	}
	
	@And("tarayıcı kapanır")
	public void tarayıcı_kapanır() {
		driver.quit();
	}
	
	@And("kayıtlı olmayan bir e-posta adresi girer")
	public void kayıtlı_olmayan_bir_e_posta_adresi_girer() {
	    driver.findElement(By.id("ap_email")).sendKeys("aksaray@gmail.com");
	}

	@And("Devam Et butonuna tıklar")
	public void devam_et_butonuna_tıklar() throws InterruptedException {
	    driver.findElement(By.id("continue")).click();
	    Thread.sleep(1000);
	}

	@Then("kullanıcı {string} şeklinde hata mesajı görmelidir")
	public void kullanıcı_şeklinde_hata_mesajı_görmelidir(String hataMesajı) throws InterruptedException {
	    driver.findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span")).getText().contains(hataMesajı);
	    Thread.sleep(1000);
	}
	
	@Then("kullanıcı {string} şeklinde uyarı mesajı görmelidir")
	public void kullanıcı_şeklinde_uyarı_mesajı_görmelidir(String uyarıMesajı) {
	    driver.findElement(By.xpath("//*[@id=\"auth-email-invalid-claim-alert\"]/div/div")).getText().contains(uyarıMesajı);
	}
	
	@Then("{string} şeklinde uyarı mesajı görmelidir")
	public void şeklinde_uyarı_mesajı_görmelidir(String uyarıMesajı) {
	    driver.findElement(By.xpath("//*[@id=\"auth-email-missing-alert\"]/div/div")).getText().contains(uyarıMesajı);
	}
	
	@Then("kullanıcı {string} uyarı mesajını görmelidir")
	public void kullanıcı_uyarı_mesajını_görmelidir(String uyarıMesajı) {
	    driver.findElement(By.xpath("//*[@id=\"auth-password-missing-alert\"]/div/div")).getText().contains(uyarıMesajı);
	}

	@And("kayıtlı olmayan bir telefon numarası girer")
	public void kayıtlı_olmayan_bir_telefon_numarası_girer() {
	    driver.findElement(By.id("ap_email")).sendKeys("+905000000000");
	}

	@And("yanlış formatta e-posta veya telefon numarası girer")
	public void yanlış_formatta_e_posta_veya_telefon_numarası_girer() {
	    driver.findElement(By.id("ap_email")).sendKeys("^%&%+");
	}

	@And("kullanıcı e-posta veya telefon numarası gireceği alanı boş bırakır")
	public void kullanıcı_e_posta_telefon_numarası_gireceği_alanı_boş_bırakır() {
	    driver.findElement(By.id("ap_email")).sendKeys("");
	}

	@And("yanlış şifre girer")
	public void yanlış_şifre_girer() {
	    driver.findElement(By.id("ap_password")).sendKeys("adhshds");
	}

	@And("şifre alanını boş bırakır")
	public void şifre_alanını_boş_bırakır() {
		driver.findElement(By.id("ap_password")).sendKeys("");
	}

	@And("kullanıcı şifremi unuttum linkine tıklar")
	public void kullanıcı_şifremi_unuttum_linkine_tıklar() {
	    driver.findElement(By.id("auth-fpp-link-bottom")).click();
	}

	@Then("kullanıcı şifre sıfırlama sayfasına yönlendirilir")
	public void kullanıcı_şifre_sıfırlama_sayfasına_yönlendirilir() {
	    assert driver.findElements(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div[1]/div/form/h1")).size()>0;
	}

	@And("giriş yap kutucuğunun altında bulunan Yardıma mı ihtiyacınız var? linkine tıklar")
	public void giriş_yap_kutucuğunun_altında_bulunan_yardıma_mı_ihtiyacınız_var_linkine_tıklar() {
	    driver.findElement(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div[2]/div[1]/form/div/div/div/div[3]/div/a")).click();
	}

	@And("açılan listeden Şifremi unuttum linkine tıklar")
	public void açılan_listeden_şifremi_unuttum_linkine_tıklar() {
		driver.findElement(By.id("auth-fpp-link-bottom")).click();
	}
	
	@And("Değiştir yazısına tıklar")
	public void değiştir_yazısına_tıklar() {
	    driver.findElement(By.id("ap_change_login_claim")).click();
	}

	@And("kullanıcı adı giriş sayfasına geri döndürülür")
	public void kullanıcı_adı_giriş_sayfasına_geri_döner() {
	    assert driver.findElements(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div[2]/div[1]/form/div/div/div/h1")).size()>0;
	}

	@And("geçerli bir e-posta veya telefon numarasını girer")
	public void geçerli_bir_e_posta_veya_telefon_numarasını_girer() {
	    driver.findElement(By.id("ap_email")).sendKeys("sseymakkose@gmail.com");
	}
	
	/*@And("Oturumum açık kalsın checkboxını işaretler")
	public void oturumum_açık_kalsın_checkboxını_işaretler() {
	    driver.findElement(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div[2]/div/form/div/div[2]/div/div/label/div/label/input")).click();
	}
	@And("kullanıcı tarayıcı tekrar açar ve amazon ana sayfasına yönlendirilir")
	public void kullanıcı_tarayıcı_tekrar_açar_ve_amazon_ana_sayfasına_yönlendirilir() {
	
	}*/
	
}
