import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;

public class Profile_setup {

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


//        Enter Email
//        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ScrollView/android.widget.ImageView[5]")));
//        emailField.click();
//        emailField.sendKeys("priyankanikhade@aladinntech.in");
//
//        Thread.sleep(3000);
//        // Enter Password (replace with actual locator for password field)
//        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ScrollView/android.widget.ImageView[6]")));
//        passwordField.click();
//        passwordField.sendKeys("Pass@123");

//        //  Click "Login" button
//        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@content-desc='Login'])[2]")));
//        loginBtn.click();

        // Child's Name
        WebElement ChildNmae = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[8]/android.view.View[8]/android.view.View/android.view.View/android.widget.EditText")));
        ChildNmae.sendKeys("Priya");

        //Select DOB
        WebElement SelectDOB = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.widget.ImageView[@content-desc=\"01/01/2000\"])[2]")));
        SelectDOB.sendKeys("01/01/2000");

        //Next button
        WebElement Next_button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@content-desc=\"Next\"])[2]")));
        Next_button.click();

        //Address
        WebElement Address = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.widget.ImageView[2]")));
        Address.sendKeys("Pune");

        //Location & Preference
        WebElement Nextbt2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Next\"]")));
        Nextbt2.click();

        //Interests
        WebElement Sleep_Issues = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Sleep Issues\"]")));
        Sleep_Issues.click();

        //Nextbt
        WebElement Nextbt3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Next\"]")));
        Nextbt3.click();

        //Review & Confirm
        WebElement Confirm_SignUp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@content-desc=\"Confirm & Sign Up\"])[2]")));
        Confirm_SignUp.click();

        //Welcome to chilld
        WebElement Go_to_Dashboard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Go to Dashboard\"]")));
        Go_to_Dashboard.click();
    }
}
