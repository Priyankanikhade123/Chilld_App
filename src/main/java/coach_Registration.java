import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;

public class coach_Registration {

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

        //Create Account Button
        WebElement Create_Account_button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Create Account\"]")));
        Create_Account_button.click();
        Thread.sleep(3000);

        //Full Name
        WebElement Full_Name = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.widget.ImageView[5]")));
        Full_Name.sendKeys("Coach");
        Thread.sleep(3000);

        //Email Address
        WebElement Email_Address = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.widget.ImageView[4]")));
        Email_Address.sendKeys("dqad322@gmail.com");
        Thread.sleep(3000);

        //Phone Number
        WebElement Phone_Number = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText")));
        Phone_Number.sendKeys("444475575");
        Thread.sleep(3000);

        //Password
        WebElement Password = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.widget.ImageView[2]")));
        Password.sendKeys("Pass@123");
        Thread.sleep(3000);

        //Confirm Password
        WebElement Confirm_Password = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.widget.ImageView[4]")));
        Confirm_Password.sendKeys("Pass@123");
        Thread.sleep(3000);

        //Checkbox
        WebElement Checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.CheckBox")));
        Checkbox.click();
        Thread.sleep(3000);

        //SignUp button
        WebElement SignUp_button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Sign Up\"]")));
        SignUp_button.click();






    }
}
