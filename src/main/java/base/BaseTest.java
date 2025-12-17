package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.HashMap;

public class BaseTest {

      public WebDriver driver;
      @BeforeMethod
      public void setup() throws InterruptedException {
          ChromeOptions options = new ChromeOptions();
          // Disable Chrome password save popups
          options.setExperimentalOption("prefs", new HashMap<String, Object>() {{
              put("credentials_enable_service", false);
              put("profile.password_manager_enabled", false);
          }});

          // Disable automation banners
          options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
          options.setExperimentalOption("useAutomationExtension", false);

          // Disable notifications just in case
          options.addArguments("--disable-notifications");
          options.addArguments("--disable-infobars");
          options.addArguments("--disable-popup-blocking");

          // 🎯 MOST IMPORTANT → no password popup in incognito
          options.addArguments("--incognito");

          driver = new ChromeDriver(options);
          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
          driver.get("https://www.saucedemo.com/");

      }
      @AfterMethod
      public void teardown(){
   //       driver.quit();
      }
}
