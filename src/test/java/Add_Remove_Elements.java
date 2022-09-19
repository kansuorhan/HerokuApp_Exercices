import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Add_Remove_Elements {
     /*
    1-https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
    2- Add Element butonuna 10 kez basinız
    3- 10 kez Add element butonuna basıldığını test ediniz
    4 - Delete butonuna görünmeyene kadar basınız
    5- Delete butonunun görünmediğini test ediniz
    6- Sayfayı kapatınız
     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //1
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
    }

    @AfterClass
    public static void tearDown() throws Exception {
        //driver.close();
    }

    @Test
    public void test() throws Exception {
        //2
        WebElement addButton = driver.findElement(By.xpath("//*[@onclick='addElement()']"));

        int sayac = 0;
        while (sayac < 10) {
            addButton.click();
            sayac++;
        }

        Thread.sleep(1500);

        //3
        WebElement deleteButton = driver.findElement(By.xpath("//div[@id='elements']/button[10]"));

        int sayac2 = 0;
        while (sayac2<10) {
                deleteButton.click();
                sayac2++;
        }


        //4
        WebElement actualButton = driver.findElement(By.className("example"));
        String expectedButton = "Delete";

        Assert.assertFalse(actualButton.getText().contains(expectedButton));
    }

}
