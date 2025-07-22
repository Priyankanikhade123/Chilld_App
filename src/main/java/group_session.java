import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;

public class group_session {


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
        Thread.sleep(3000);

        // Enter Email
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ScrollView/android.widget.ImageView[2]")));
        emailField.click();
        emailField.sendKeys("priyankanikhade@aladinntech.in");
        Thread.sleep(3000);

        // Enter Password
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ScrollView/android.widget.ImageView[3]")));
        passwordField.click();
        passwordField.sendKeys("Pass@123");
        Thread.sleep(3000);

        //  Click "Login" button
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@content-desc=\"Login\"])[2]")));
        loginBtn.click();
        Thread.sleep(3000);

        //Tap on the Session icon
        WebElement Session_icon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"Sessions\"]")));
        Session_icon.click();
        Thread.sleep(3000);

        //Tap on the Add icon
        WebElement Add_icon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[4]")));
        Add_icon.click();
        Thread.sleep(3000);

        //Tap on the drop_down
        WebElement drop_down = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"One to One Sessions\"]")));
        drop_down.click();
        Thread.sleep(3000);

        //Tap on the group_session
        WebElement group_session = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"Group Sessions\"]")));
        group_session.click();
        Thread.sleep(3000);

        //Tap on the Session Title
        WebElement Session_Title = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.widget.EditText[1]")));
        Session_Title.click();
        Session_Title.sendKeys("Sleeping group0");
        Thread.sleep(3000);

        //Tap on the Price
        WebElement Price = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.widget.EditText[2]")));
        Price.click();
        Price.sendKeys("252");
        Thread.sleep(3000);

        //Tap on the Participants
//        WebElement Participants = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.SeekBar[@content-desc=\"44%\"]")));
//        Participants.click();
//        Thread.sleep(1000);


        //Participants
        WebElement Participants = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.SeekBar[@content-desc=\"0%\"]")));
        Participants.click();
        Thread.sleep(3000);


        //Tap on the Description
        WebElement Description = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.widget.EditText[3]")));
        Description.click();
        Description.sendKeys("group session sleeping coach");
        Thread.sleep(3000);

        //Tap on the Create Session
        WebElement Create_Session = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Create Session\"]")));
        Create_Session.click();
        Thread.sleep(3000);

        //Tap on the Profile
        WebElement Profile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"Profile\"]")));
        Profile.click();
        Thread.sleep(3000);

        //Tap on the Profile_Name
        WebElement Profile_Name = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Priyanka\n" +
                "Personal Balance:\n" +
                "$0\"]")));
        Profile_Name.click();
        Thread.sleep(3000);






    }
}

