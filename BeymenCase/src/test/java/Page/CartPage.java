package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    public WebDriver driver;
    public CartPage(WebDriver driver){
        this.driver=driver;
    }

    By cartprice= By.xpath("//*[@class=\"m-orderSummary__item -grandTotal\"]/span[2]");
    By piecedropdown=By.xpath("//*[@id=\"quantitySelect0-key-0\"]");
    By pieceIncrease=By.xpath("//*[@id=\"quantitySelect0-key-0\"]/option[2]");
    By emptyButton=By.xpath("//*[@id=\"removeCartItemBtn0-key-0\"]");
    By emptyInfo=By.xpath("//*[@class=\"m-empty__messageTitle\" and text()=\"Sepetinizde Ürün Bulunmamaktadır\" ]");

    public String cartPrice(){

        return driver.findElement(cartprice).getText();
    }

    public WebElement selectPiecedropdown(){
        return driver.findElement(piecedropdown);
    }


    public WebElement pieceIncrease(){
        return driver.findElement(pieceIncrease);
    }

    public WebElement emptyButton(){
        return driver.findElement(emptyButton);
    }

    public WebElement emptyInfo(){
        return driver.findElement(emptyInfo);
    }
}
