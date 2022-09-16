package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GomlekPage {

    By chooseinput= By.xpath("//*[@id=\"productList\"]/div[2]/div");
    public WebDriver driver;

    public GomlekPage(WebDriver driver){
        this.driver=driver;
    }

    public WebElement chooseinput(){
        return driver.findElement(chooseinput);
    }



}
