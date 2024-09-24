import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class StepImplementation {
    WebDriver driver;

    @Step("Hepsiburada sitesine git")
    public void hepsiburadaSitesineGit() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.hepsiburada.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        Thread.sleep(2000);


    }

 //   @Step("Giriş yap sayfasına yönlendir")
    //   public void girisYapSayfasinaGit() throws InterruptedException {

    //    Actions actions = new Actions(driver);

        // Giriş yap menüsünü bul
    //     WebElement girisYapMenu = driver.findElement(By.xpath("//*[@data-test-id='account']"));  // Giriş yap menüsünün ID'si

    //      Thread.sleep(2000);

        // Fareyi giriş yap menüsünün üzerine getir
    //     actions.moveToElement(girisYapMenu).perform();

    //    Thread.sleep(2000);

        // Giriş yap butonunu bul ve tıkla
    //      WebElement girisYapButonu = driver.findElement(By.xpath("//a[@id=\"login\" and @title=\"Giriş yap\"]"));  // Giriş yap butonunun Xpath'i
    //      actions.moveToElement(girisYapButonu).click().perform();

    //     Thread.sleep(2000);

    //   }


   @Step("Kullanıcı bilgilerini gir")
    public void kullaniciBilgileriniGir() throws InterruptedException {
        // E-posta alanını bul ve e-posta adresini gir
        WebElement emailField = driver.findElement(By.xpath("//input[@id=\"txtUserName\"]"));  // E-posta alanının ID'si
        emailField.sendKeys("iibrahimarpacii@gmail.com");

        // Şifre alanını bul ve şifreyi gir
        WebElement passwordField = driver.findElement(By.xpath("//input[@id=\"txtPassword\"]"));  // Şifre alanının ID'si
        passwordField.sendKeys("Ibrahim5.");


        // Giriş butonuna tıklama
        WebElement loginButton = driver.findElement(By.id("btnLogin"));  // Giriş butonunun ID'si
        loginButton.click();

       Thread.sleep(2000);

    }


    @Step("Aramaya <query> yaz ve ara")
   public void aramaYap(String query) throws InterruptedException {
           driver.findElement(By.xpath("//div[@aria-label=\"Site İçi Arama\"]")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@type=\"search\"]")).sendKeys(query);
Thread.sleep(4000);
    }


    @Step("Ürünlerden rastgele birine tıkla")
    public void urundenRastgeleBirineTikla() throws InterruptedException {
            SearchUtils.clickRandomSearchResult(driver);
        Thread.sleep(2000);

    }


    @Step("Ürün detayına git")
    public void urunDetayinaGit() throws InterruptedException {
       SearchUtils.clickRandomSearchProduct(driver);
Thread.sleep(2000);
    }
    @Step("Sepete ekle")
    public void sepeteEkle() throws InterruptedException {
        WebElement sepeteEkleButton = driver.findElement(By.xpath("//*[@data-test-id=\"addToCart\"]")) ; // Sepete ekle butonunun ID'si
        sepeteEkleButton.click();
        Thread.sleep(3000);

    }
    

    @Step("Sepete git ve ödemeye kadar devam et")
    public void sepeteGitVeOdemeyeKadarDevamEt() throws InterruptedException {
        // Sepet ikonuna tıklama
        WebElement sepetIcon = driver.findElement(By.xpath("//button[@type=\"button\" and text()=\"Sepete git\"]"));  // Sepet ikonunun xpath'i
        sepetIcon.click();
        Thread.sleep(2000);
        // Ödeme sayfasına gitme
        WebElement odemeyeGitButton = driver.findElement(By.xpath("//button[@id=\"continue_step_btn\"]"));  // Ödeme sayfasına yönlendirme butonunun xpath'i
        odemeyeGitButton.click();

        Thread.sleep(2000);
    }

}

 