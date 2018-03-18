import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



import java.util.concurrent.TimeUnit;

public class Selenium
{

    private WebDriver driver;

    @BeforeClass
    public void setUp()
    {

        driver = new ChromeDriver();                    //selecting browser Chrome
        driver.manage().window().maximize();            //maximizing window
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //waiting 15 seconds till the page loads

    }

   @Test(priority = 1)
   public void enteringDataToTheGoogleHomePage()
   {
       String baseUrl = "http://www.google.com";
       driver.get(baseUrl);     //opening Google home page

       String actualTitle = driver.getTitle();      //getting pages title
       String expectedTitle = "Google";
       String googleSearchField = "q";


       if (actualTitle.equals(expectedTitle))       //making sure that the title of the page is "Google"
       {
           System.out.println("The title is : " + actualTitle);     //if it is "Google" than printing it out

           WebElement searchField = driver.findElement(By.name(googleSearchField));     //selecting google sear field
           searchField.sendKeys("instagram");       //entering in search field "instagram"
           searchField.sendKeys(Keys.ENTER);                    // hitting ENTER button from keyboard

       }
       else
       {
           System.out.println("The title is not correct : " + actualTitle);     //the title is not correct
       }

   }

   @Test(priority = 2)
   public void assertingAndClickingTheInstagramLink()
   {

       String instagramLink = "Instagram";

       WebElement instagram = driver.findElement(By.linkText(instagramLink));  //finding the Instagram link page
       Assert.assertTrue(instagram.isDisplayed());  //making sure that the link page is there
       instagram.click();                           //clicking the Instagram link page

   }

   @Test(priority = 3)
   public void instagramLoginPage()
   {

       String loginButton = "Zaloguj się";
       String loginLink = "username";
       String passwordLink = "password";

       WebElement pressLoginButton = driver.findElement(By.linkText(loginButton));      //finding the "LogIn" button
       pressLoginButton.click();                                                        //clicking the "LogIn" button

       WebElement login = driver.findElement(By.name(loginLink));               //finding the "Username" field
       login.sendKeys("YourName");                                 //entering your username

       WebElement password = driver.findElement(By.name(passwordLink));         // finding the "Password" field
       password.sendKeys("YourPassword");                          // entering your password
       password.sendKeys(Keys.ENTER);                                           //hitting ENTER with the keyboard button


   }

   @Test(priority = 4)
   public void instagramLogedPage()
   {

       String instagramLogoLink = "Instagram";


       WebElement instagramLogo = driver.findElement(By.linkText(instagramLogoLink));       //finding the Instagram Logo

       if (instagramLogo.isDisplayed())                     //checking if the Instagram Logo is displayed
       {
           System.out.println("You have successfully logged to your instagram home page");
       }
       else
       {
           System.out.println("You haven't entered wrong credentials");
       }

   }



    @AfterClass
    public void tearDown() throws InterruptedException
    {

        Thread.sleep(5000);     //waiting 5 seconds

        if (driver != null)         //if driver is present
        {

            driver.quit();          //quit Chrome

        }

    }

}
