package TestScript;

import Browser.Required_Browser;
import UserAction.Product_Search_Action;
import VerifySteps.Product_Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static Browser.Required_Browser.driver;

public class ProductDetails {
    @Test
    @Parameters({"Browser","url","Expected_Title","SearchBox","Key","Button",
                "ListCount","SearchName","titleLinks","productName","productPrice"})
    public void getProductDetails(String Browser,String url,String Expected_Title,
                                  String SearchBox,String Key,String Button,
                                  String ListCount,String SearchName,String titleLinks,
                                  String productName,String productPrice){

        Required_Browser.openDriver(Browser,url);
        if(Product_Verify.verifyPageTitle(Expected_Title)){
            WebElement searchBox=driver.findElement(By.xpath(SearchBox));
            Product_Search_Action.enterValueInTextBox(searchBox,Key);
            WebElement button=driver.findElement(By.xpath(Button));
            Product_Search_Action.button(button);
            WebElement resultCount=driver.findElement(By.xpath(ListCount));
            Product_Search_Action.searchProduct(resultCount);
            WebElement searchName= driver.findElement(By.xpath(SearchName));
            Product_Search_Action.searchProduct(searchName);
            Product_Verify.getAllProducts(titleLinks);
            Product_Search_Action.getPriceDetails(productName,productPrice);

        }else{
            System.out.println("The Page Title is incorrect ");
        }
        Required_Browser.tear_Down();
    }
}