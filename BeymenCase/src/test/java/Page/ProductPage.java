package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

//*[@id="sizes"]/div/span[1]
public class ProductPage {

    public WebDriver driver;

    public ProductPage(WebDriver driver){
        this.driver=driver;
    }

    By sizechoose= By.xpath("//*[@id=\"sizes\"]/div/span[1]");
    By addbasket=By.xpath("//*[@id=\"addBasket\"]");
    By gotoBasket=By.xpath("//*[@class=\"m-notification__button btn\"]");
    By price=By.xpath("//*[@id=\"priceNew\"]");
    By info=By.xpath("//*[@class=\"o-productDetail__description\"]");
    By basketIcon=By.xpath("//*[@class=\"o-header__userInfo--item bwi-cart-o -cart\"]");

    public WebElement sizeChoose(){
        return driver.findElement(sizechoose);
    }

    public WebElement addBasket(){
        return driver.findElement(addbasket);
    }

    public WebElement gotoBasket(){
        return driver.findElement(gotoBasket);
    }

    public WebElement basketIcon(){
        return driver.findElement(basketIcon);
    }
    public void downScroll() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");
    }

    public void upScroll() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-500)", "");
    }
    public String price(){
        return driver.findElement(price).getText();
    }

    public String info(){
        return driver.findElement(info).getText();
    }



}
