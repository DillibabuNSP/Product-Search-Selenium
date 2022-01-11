package VerifySteps;


import UserAction.Product_Search_Action;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static Browser.Required_Browser.driver;

public class Product_Verify {
        //To verify the Title of the given WebPAge
        public static Boolean verifyPageTitle(String expectedTitle){

            String Present_Title = Product_Search_Action.getPageTitle();

            if (Present_Title.equals(expectedTitle)) {

                System.out.println("Expected title and actual title is equal");
                return true;
            }else {
                System.out.println("Expected title and actual title is not equal");
                return false;
            }
        }


    public static void getAllProducts(String titleLinks){
//Check point
        try{

            String PRODUCT="Dress";
            String expected_title = "Printed Dress";
            String actual_title = driver.getTitle();
            if(actual_title==expected_title){
                System.out.println("Product search Title is correct");
            }
            else{
                System.out.println("Product search Title is incorrect");
            }

            //Fetch all the links Title
            List<WebElement> collection_product =driver.findElements(By.xpath(titleLinks));

            for(int i = 0; i<collection_product.size();i++) {
                String productList = collection_product.get(i).getText();

                if ((productList.toLowerCase().contains(PRODUCT.toLowerCase()))==true){

                    System.out.println(PRODUCT +" is displayed on product title Product Title: " + productList);

                }else if((productList.toLowerCase().contains(PRODUCT.toLowerCase()))==false){
                    System.out.println(PRODUCT + " is not displayed on product title Product Title: " + productList);

                }
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

}