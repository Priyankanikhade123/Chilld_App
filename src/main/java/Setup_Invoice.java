import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;

public class Setup_Invoice {

    public static void main(String[] args) throws Exception {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("RZCW716NCQK");
        options.setPlatformName("Android");
        options.setAppPackage("app.chilld.de");
        options.setAppActivity("app.chilld.de.MainActivity");
        options.setAutomationName("UiAutomator2");
        options.setNoReset(true);
        options.setUiautomator2ServerLaunchTimeout(Duration.ofSeconds(60));

        //  Ensure Appium server is running on port 4723
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Session started!");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        //  Click "Get Started"
        WebElement getStarted = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Get Started\"]")));
        getStarted.click();
        Thread.sleep(3000);


        //Expert Registration button
        WebElement Expert_Registration = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Expert Registration\"]")));
        Expert_Registration.click();

        // Enter Email
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ScrollView/android.widget.ImageView[5]")));
        emailField.click();
        emailField.sendKeys("priyanka.nikhade11@gmail.com");
        Thread.sleep(3000);

        // Enter Password
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ScrollView/android.widget.ImageView[6]")));
        passwordField.click();
        passwordField.sendKeys("Pass@123");

        //  Click "Login" button
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@content-desc=\"Login\"])[2]")));
        loginBtn.click();


        System.out.println("Login attempted!");
        Thread.sleep(3000);

        //Tap on the Profile icon
        WebElement Profile_icon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"Profile\"]")));
        Profile_icon.click();
        Thread.sleep(3000);

        //Tap on the Invoice Setup
        WebElement Invoice_Setup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"Invoice Setup\"]")));
        Invoice_Setup.click();
        Thread.sleep(3000);

        //Tap on the Address
        WebElement Address = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.widget.ImageView[3]")));
        Address.click();
        Address.sendKeys("Anna Muller 10115 Berlin, Germany");
        System.out.println("Enter Address");
        Thread.sleep(3000);

        //Tap on Email Id
        WebElement Email_Id = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.widget.ImageView[4]")));
        Email_Id.click();
        Email_Id.sendKeys("priyanka.nikhade11@gmail.com");
        System.out.println("Enter Email Id");
        Thread.sleep(3000);

        //Tap on the Websit
        WebElement Websit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.widget.EditText[1]")));
        Websit.click();
        Websit.sendKeys("https://www.google.com");
        System.out.println("Enter Websit");
        Thread.sleep(3000);

        //Select the country code number
        WebElement Country_code = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"\uD83C\uDDFA\uD83C\uDDF8\n" +
                "+1\"]")));
        Country_code.click();

        // Tap on the Search country
        WebElement Search_country = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText")));
        Search_country.click();
        Country_code.sendKeys("Germany");

        //Tap on the Germany drop-down
        WebElement Germany = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"\uD83C\uDDE9\uD83C\uDDEA\n" +
                "Germany\n" +
                "+49\"]")));
        Country_code.click();
        System.out.println("Enter country code");
        Thread.sleep(3000);

        //Tap on the Search country
        WebElement Search_country1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText")));
        Search_country1.click();

        //Enter the Country name
        WebElement Country_Name = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText")));
        Country_Name.sendKeys("Germany");

        //  Tap on the country Name
        WebElement Country_Name2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"\uD83C\uDDE9\uD83C\uDDEA\n" +
                "Germany\n" +
                "+49\"]")));
        Country_Name2.click();

        // Tap on the Account owner Name
        WebElement Account_owner_Name = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.widget.EditText[2]")));
        Account_owner_Name.sendKeys("Priyanka");

        // Tap on the Bank Name
        WebElement Bank_Name = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.widget.EditText[3]")));
        Bank_Name.sendKeys("DZ Bank");

        // Tap on the Bank Address
        WebElement Bank_Address = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.widget.EditText[4]")));
        Bank_Address.sendKeys("Taunusanlage 12,60325 Frankfurt an main Germany");

        // Tap on the IBAN
        WebElement IBAN = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.widget.EditText[5]")));
        IBAN.sendKeys("De89 3704 0044 0532 0130 00");

        // Tap on the BIC
        WebElement BIC = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.widget.EditText[6]")));
        BIC.sendKeys("DEUTDEBB555");

        // Tap on the Tax Office
        WebElement Tax_Office = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.widget.EditText[7]")));
        Tax_Office.sendKeys("Finanzamamt Berlin Mitte");

        // Tap on the Tax Number
        WebElement Tax_Number = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.widget.EditText[8]")));
        Tax_Number.sendKeys("5123081508150");

        // Tap on the Save Button
        WebElement Save_Button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Save\"]")));
        Save_Button.click();

        // need to execut and check all running as per need
    }
}
