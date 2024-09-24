import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class SearchUtils {

    // Öneri listesinden rastgele bir seçeneğe tıkla
    public static void clickRandomSearchResult(WebDriver driver) {
        List<WebElement> searchResults = driver.findElements(By.xpath("//div[@role='listbox']"));

        if (!searchResults.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(searchResults.size());
            searchResults.get(randomIndex).click();
        } else {
            System.out.println("Arama sonuçları bulunamadı.");
        }
    }

    // Ürünler sayfasından rastgele bir ürüne tıkla
    public static void clickRandomSearchProduct(WebDriver driver) {
        // Rastgele bir ürüne tıkla
        List<WebElement> productResults = driver.findElements(By.xpath("//li [@class=\"productListContent-zAP0Y5msy8OHn5z7T_K_\"]"));

        if (!productResults.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(productResults.size());
            productResults.get(randomIndex).click();

            // Yeni sekmeye geçiş yap
            String currentWindow = driver.getWindowHandle();
            Set<String> allWindows = driver.getWindowHandles();

            for (String window : allWindows) {
                if (!window.equals(currentWindow)) {
                    driver.switchTo().window(window);
                }
            }

        } else {
            System.out.println("Ürünler bulunamadı.");
        }
    }

}
