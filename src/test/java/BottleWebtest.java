import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class BottleWebtest {

        @Test
        public void BottlesTest() {

            System.setProperty("webdriver.chrome.driver", "c:\\program files\\google\\chrome\\application\\chromedriver.exe");

            WebDriver driver = new ChromeDriver();

            try {

                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                driver.manage().window().maximize();

                driver.get("https://99-bottles-of-beer.net/lyrics.html");

                WebElement guestbook = driver.findElement(By.xpath("//a[contains(@href,\"/guestbookv2.html\")]"));
                String GB = guestbook.getText();
                Assert.assertEquals(GB, "GUESTBOOK");

                WebElement noMoreBottles = driver.findElement(By.xpath("//p[last()-0]"));
                String bottle = noMoreBottles.getText();

                Assert.assertEquals(bottle, "No more bottles of beer on the wall, no more bottles of beer.\n" +
                        "Go to the store and buy some more, 99 bottles of beer on the wall.");

                WebElement title = driver.findElement(By.xpath("//body/div//h1"));
                String txtTitle = title.getText();

                Assert.assertEquals(txtTitle, "99 Bottles of Beer");

                WebElement language = driver.findElement(By.xpath("//div[@id='footer']//a[@href='/search.html']"));
                String lang = language.getText();

                Assert.assertEquals(lang, "Search Languages");

            } finally {
                driver.quit();
            }

        }
    }

