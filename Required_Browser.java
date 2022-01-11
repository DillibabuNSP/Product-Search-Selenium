package Browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;



public class Required_Browser {
 public static WebDriver driver;
    public static void openDriver(String Browser,String url){

        String browserName=Browser;
        if(browserName.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver =new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.navigate().to(url);
        }else if(browserName.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver =new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.navigate().to(url);
        }else if(browserName.equals("edge")){
            WebDriverManager.edgedriver().setup();
            driver =new EdgeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.navigate().to(url);
        }

    }
    //To move on to the Next Page
    public void nextWebSite(String Url){

        driver.navigate().to(Url);

    }
    //To close the Web Driver
    public static void tear_Down(){
        driver.quit();
    }
}

