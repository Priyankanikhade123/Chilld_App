import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;

public class User_account_create {
    public static void main(String[] args) throws Exception {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("RZCW716NCQK");
        options.setPlatformName("Android");
        options.setAppPackage("app.chilld.de");
        options.setAppActivity("app.chilld.de.MainActivity");
        options.setAutomationName("UiAutomator2");
        options.setNoReset(true);
        options.setUiautomator2ServerLaunchTimeout(Duration.ofSeconds(80));

        //  Ensure Appium server is running on port 4723
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Session started!");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        //  Click "Get Started"
        WebElement getStarted = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Get Started\"]")));
        getStarted.click();
        Thread.sleep(3000);

        // Enter Email
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ScrollView/android.widget.ImageView[5]")));
        emailField.click();
        emailField.sendKeys("priyankanikhade@aladinntech.in");

        Thread.sleep(3000);
        // Enter Password
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ScrollView/android.widget.ImageView[6]")));
        passwordField.click();
        passwordField.sendKeys("Pass@123");

        //  Click "Login" button
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@content-desc='Login'])[2]")));
        loginBtn.click();


        System.out.println("Login attempted!");
        Thread.sleep(3000);


        // Tap on the Chat icon
        WebElement Chart_icon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"Chat\"]")));
        Chart_icon.click();
        Thread.sleep(3000);

        //Tap on the search name icon
//        WebElement Search_Name = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[1]")));
//        Search_Name.click();
//        Search_Name.sendKeys("Priyanka");

        // Tap on the priyanka
        WebElement Priyanka = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"Priyanka\n" +
                "hi\n" +
                "7 days ago\"]")));
        Priyanka.click();
        System.out.println("click on the coach name");

        // Tap on the Type a message
        WebElement Type_Message = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText")));
        Type_Message.click();
        Type_Message.sendKeys("Hi");

        //Tap on the arrow
        WebElement Arrow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText/android.widget.Button[2]")));
        Arrow.click();

    }
}