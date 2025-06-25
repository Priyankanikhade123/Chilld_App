import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Booking_one_to_one {

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
        Thread.sleep(6000);


        // Enter Email
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ScrollView/android.widget.ImageView[5]")));
        emailField.click();
        emailField.sendKeys("priyankanikhade@aladinntech.in");
        Thread.sleep(6000);


        // Enter Password
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ScrollView/android.widget.ImageView[6]")));
        passwordField.click();
        passwordField.sendKeys("Pass@123");
        Thread.sleep(3000);


        //  Click "Login" button
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@content-desc='Login'])[2]")));
        loginBtn.click();
        Thread.sleep(3000);

        //Click on Experts
        WebElement Experts_icon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"Experts\"]")));
        Experts_icon.click();
        Thread.sleep(3000);

        //Search for a Experts
        WebElement Search_for_Experts = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.view.View[1]")));
        Search_for_Experts.click();
        Thread.sleep(3000);

        //  Tap on the Searchbox
        WebElement Search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText")));
        Search.click();
        Thread.sleep(3000);


        // Tap on the seach for experts
        WebElement coach_Name = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText")));
        coach_Name.click();
        coach_Name.sendKeys("Priyanka");
        System.out.println("navigate to the search screen");
        Thread.sleep(3000);


        //Tap on the coach name
        WebElement Tap_coachName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"Priyanka\n" +
                "5.0\n" +
                "Systemisches Coaching, Sleep Coach, Positive Discipline Coach, Behavioral Coaching, Child Development Coach, Financial Planning for Parents Coach\n" +
                "Next Available:\"]")));
        Tap_coachName.click();
        Thread.sleep(3000);

        //Tap on the Book a Session
        WebElement Book_a_Session = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"Book a Session\"]")));
        Book_a_Session.click();
        Thread.sleep(3000);

        //Tap on the Create Session
        //WebElement Create_Session = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));

        List<WebElement> createButtons = driver.findElements(AppiumBy.accessibilityId(
                "GROUP SESSION\nFree Session\nPriyanka\nFree Group Session\n5 Min\n - 10 Seats -\nPP\n - zoom\nFree Group Session\nCreate"
        ));

// Print text of each element (optional)
        for (WebElement button : createButtons) {
            System.out.println(button.getText());
        }



    }
}
