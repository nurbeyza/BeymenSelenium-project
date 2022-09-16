package Page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage {


    public WebDriver driver;
    public Homepage(WebDriver driver) {
        this.driver = driver;
    }
    By menuwoman= By.xpath("//*[@data-id=\"10006\"]");
    By searchinput=By.xpath("//*[@class=\"default-input o-header__search--input\"]");
    By searchinputclick=By.xpath("//*[@class=\"default-input o-header__search--input\"]");
    By searchinputsend=By.xpath("//*[@class=\"default-input o-header__search--input\"]");

   
    public WebElement menuwoman() {
        return driver.findElement(menuwoman);
    }

    public WebElement searchinput() {
        return driver.findElement(searchinput);
    }

    public WebElement searchinputclick() {
        return driver.findElement(searchinputclick);
    }

    public  WebElement searchinputsend(){
        return driver.findElement(searchinputsend);
    }
}
