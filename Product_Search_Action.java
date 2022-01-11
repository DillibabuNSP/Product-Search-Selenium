package UserAction;

import Browser.Required_Browser;
import ReusableFiles.Data;
import org.openqa.selenium.WebElement;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;


public class Product_Search_Action {

    public static boolean isElementPresent(WebElement locator){
        if(locator.isDisplayed()){
            System.out.println("WebElement is Displayed:-"+locator.getText());
            return true;
        }
        else{
            System.out.println("WebElement is not Displayed:-"+locator.getText());
            return false;
        }
    }

    public static String getPageTitle(){
        System.out.println(Required_Browser.driver.getTitle());
        return Required_Browser.driver.getTitle();

    }

    public static void enterValueInTextBox(WebElement locator, String enterText){
        if(isElementPresent(locator)){
            locator.sendKeys(enterText);
        }else {
            System.out.println("WebElement is not found "+locator.getText());
        }
    }
    //To click the button in the test pages
    public static void button(WebElement locator){
        if(isElementPresent((locator))){
            locator.click();
        }
    }


    public static void searchProduct(WebElement locator ){
        if(isElementPresent(locator)){
        System.out.println(locator.getText());
    }else{
            System.out.println("WebElement is not found "+locator.getText());
        }
    }

    public static void getPriceDetails(String productName,String productPrice){
        HashMap<Integer, String> Result= Data.getData(productName,productPrice);
        Set<Integer> allkeys = Result.keySet();
        ArrayList<Integer> array_list_values_product_prices = new ArrayList<Integer>(allkeys);

        //Sort the Prices in Array List using Collections class
        //this will sort in ascending order lowest at the top and highest at the bottom
        Collections.sort(array_list_values_product_prices);
        //Low price is
        int low_price = array_list_values_product_prices.get(0);

        System.out.println("Low Product Price is: " + low_price + " Product name is: " + Result.get(low_price));

    }
}