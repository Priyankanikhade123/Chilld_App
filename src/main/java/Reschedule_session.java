import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class Reschedule_session {

    public static void main(String[] args) throws Exception {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("RZCW716NCQK");
        options.setPlatformName("Android");
        options.setAppPackage("app.chilld.de");
        options.setAppActivity("app.chilld.de.MainActivity");
        options.setAutomationName("UiAutomator2");
        options.setNoReset(true);
        options.setUiautomator2ServerLaunchTimeout(Duration.ofSeconds(60));

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Session started!");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        // Click "Get Started"
        WebElement getStarted = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Get Started\"]")));
        getStarted.click();
        Thread.sleep(3000);

        // Click "Expert Registration"
        WebElement Expert_Registration = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Expert Registration\"]")));
        Expert_Registration.click();

        // Enter email
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ScrollView/android.widget.ImageView[5]")));
        emailField.click();
        emailField.sendKeys("priyanka.nikhade11@gmail.com");
        Thread.sleep(3000);

        // Enter password
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ScrollView/android.widget.ImageView[6]")));
        passwordField.click();
        passwordField.sendKeys("Pass@123");
        Thread.sleep(3000);

        // Click "Login"
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@content-desc=\"Login\"])[2]")));
        loginBtn.click();
        Thread.sleep(3000);

        // Tap "Sessions" tab
        WebElement Sessions_icon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"Sessions\"]")));
        Sessions_icon.click();
        Thread.sleep(3000);

        // Tap "Confirmed" tab
        WebElement Confirmed_button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@content-desc=\"Confirmed\"])[2]")));
        Confirmed_button.click();
        System.out.println("Confirmed button");
        Thread.sleep(3000);

        // Get first session card from the confirmed list
        List<WebElement> sessionCards = driver.findElements(By.xpath(
                "//android.view.View[@content-desc and .//android.view.View[contains(@content-desc, 'Session')]]"
        ));

        if (!sessionCards.isEmpty()) {
            sessionCards.get(0).click();
            System.out.println("Clicked on the first session card.");
        } else {
            System.out.println("No session cards found.");
            driver.quit();
            return;
        }

        Thread.sleep(3000);

        // Scroll (if needed) and click "Reschedule"
        try {
            // Scroll down (optional - in case Reschedule button is off-screen)
            JavascriptExecutor js = (JavascriptExecutor) driver;
            HashMap<String, Object> scrollObject = new HashMap<>();
            scrollObject.put("direction", "down");
            js.executeScript("mobile: scroll", scrollObject);

            // Now try clicking the button
            WebElement rescheduleBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[contains(@content-desc, 'Reschedule')]")
            ));
            rescheduleBtn.click();
            System.out.println("Reschedule button clicked.");
        } catch (TimeoutException e) {
            System.out.println("Reschedule button not found or not clickable.");
        }

        Thread.sleep(3000);

            // Tap on the Reschedule button
            WebElement Reschedule_button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Reschedule\"]")));
            Reschedule_button.click();
            System.out.println("Reschedule Button ");


        }
    }
