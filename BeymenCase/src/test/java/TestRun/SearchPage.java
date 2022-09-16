package TestRun;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.NoSuchElementException;
import java.io.File;
import jxl.read.biff.BiffException;
import java.io.IOException;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import org.testng.Assert;


@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SearchPage extends Basetest {

    static String price;
    static String info;

    @Test
    @Order(1)
    public void checkPage() throws InterruptedException {
        log.info("URL doğrulaması");
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://www.beymen.com/" );

    }


    @Test
    @Order(2)
    public void inputSearch() throws InterruptedException, BiffException, IOException {
        log.info("inputa şort parametresinin girilmesi");
        WebElement element=homePage.searchinput();
        element.click();

        Workbook workbook = Workbook.getWorkbook(new File((System.getProperty("user.dir") + "/src/test/resources/ürün1.xls")));
        Sheet sheet = workbook.getSheet(0);
        // Excel Dosyasının Hangi Sayfası İle Çalışacağımızı Seçelim.
        String product = sheet.getCell(0, 0).getContents();

        homePage.searchinputclick().click();



    }
    @Test
    @Order(3)
    public void clearInput(){
        log.info("Inputun temizlenmesi");
        homePage.searchinputclick().sendKeys(Keys.CONTROL+"a");
        homePage.searchinputclick().sendKeys(Keys.DELETE);
    }

    @Test
    @Order(3)
    public void sendinput() throws BiffException, IOException {

        log.info("Inputa gömlek parametresinin girilmesi");
        Workbook workbook = Workbook.getWorkbook(new File((System.getProperty("user.dir") + "/src/test/resources/ürün1.xls")));
        Sheet sheet = workbook.getSheet(0);
        // Excel Dosyasının Hangi Sayfası İle Çalışacağımızı Seçelim.
        String product = sheet.getCell(1, 0).getContents();

        homePage.searchinputsend().sendKeys(product);

        //Bu kısımda klavye üzerinden "enter" tuşuna basılmalıdır.
    }


    @Test
    @Order(4)
    public void chooseproduct() throws InterruptedException, IOException {
        log.info("Ürünün seçilmesi ve dosya.txt dosyasına yazılması");
        gomlekPage.chooseinput().click();

        price = productPage.price();
        info = productPage.info();


        File file = new File("dosya.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fileWriter = new FileWriter(file, false);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        bWriter.write(price);
        bWriter.write(info);
        bWriter.close();
    }


    @Test
    @Order(5)
    public void chooseSize() throws InterruptedException {
        log.info("Ürünün bedeninin seçilmesi ve sepete eklenmesi");
        productPage.sizeChoose().click();
        productPage.downScroll();

        productPage.addBasket().click();

        productPage.upScroll();
        Thread.sleep(5000);
        productPage.basketIcon().click();
    }



    @Test
    @Order(6)
    public void priceEqualsBasket() throws InterruptedException {
        log.info("Ürünün ücreti ve basket ücretinin karşılaştırılması");
        Assert.assertEquals(cartPage.cartPrice(), price);

    }

    @Test
    @Order(7)
    public void productIncrease() throws InterruptedException {

        log.info("Ürünün adeti artırılır ve kontrol edilir");
        String cartprice[] = price.split(" ");
        String cartprice2[] = cartprice[0].split(",");
        double priceone = Double.parseDouble(cartprice2[0]);

        cartPage.selectPiecedropdown().click();
        cartPage.pieceIncrease().click();
        Thread.sleep(1000);

        String basketprice[] = cartPage.cartPrice().split("0");
        String basketprice2[] = basketprice[0].split(",");
        double basketpricedouble = Double.parseDouble(basketprice2[0]);

        Assert.assertEquals(priceone * 2, basketpricedouble);
    }


    @Test
    @Order(8)
    public void emptybasket() throws InterruptedException {
        log.info("Sepet boşaltılır ve kontrol edilir");
        cartPage.emptyButton().click();
        Assert.assertEquals(cartPage.emptyInfo().getText(),"SEPETINIZDE ÜRÜN BULUNMAMAKTADIR");
    }

    @AfterAll
    public static void closedriver(){
        driver.quit();
    }

}


