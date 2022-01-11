package ReusableFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

import static Browser.Required_Browser.driver;


public class Data {
    public static HashMap<Integer, String> getData(String productName,String productPrice){
        List<WebElement> list_of_products = driver.findElements(By.xpath(productName));
        List<WebElement> list_of_products_price = driver.findElements(By.xpath(productPrice));

        String product_name;
        String product_price;
        int productprice;

    HashMap<Integer, String> map_final_products = new HashMap<Integer,String>();
        for(int i=0;i<list_of_products.size()-10;i++) {
        product_name = list_of_products.get(i).getText();//Iterate and fetch product name
        product_price = list_of_products_price.get(i).getText();//Iterate and fetch product price

        product_price = product_price.replaceAll("[^0-9]", "");//Replace anything wil space other than numbers
        productprice = Integer.parseInt(product_price);//Convert to Integer
        map_final_products.put(productprice,product_name);//Add product and price in HashMap

    }return map_final_products;
}
}