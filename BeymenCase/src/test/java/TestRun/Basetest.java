package TestRun;

import Connection.ConfigReader;
import Connection.Driver;
import Page.CartPage;
import Page.GomlekPage;
import Page.ProductPage;



import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import Page.Homepage;

public class Basetest {

    public static Homepage homePage;
    public static WebDriver driver;
    public static GomlekPage gomlekPage;
    public static ProductPage productPage;
    public static CartPage cartPage;


    @BeforeAll
    public static void setup() {
        driver = Driver.initialize_Driver(ConfigReader.initialize_Properties().get("browser").toString());
        homePage = new Homepage(driver);
        gomlekPage=new GomlekPage(driver);
        productPage=new ProductPage(driver);
        cartPage=new CartPage(driver);

    }


    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();

        }

    }
}
