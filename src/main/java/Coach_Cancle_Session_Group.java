import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Coach_Cancle_Session_Group {

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
        Thread.sleep(3000);

        //Tap on the Sessions
        WebElement Sessions_icon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"Sessions\"]")));
        Sessions_icon.click();
        Thread.sleep(3000);

        //Tap New_Requests Button
        WebElement New_Session_Button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@content-desc=\"New Requests\"])[2]")));
        New_Session_Button.click();
        System.out.println("New requests Button click");
        Thread.sleep(3000);

        //
        // Get all the sessions
        List<WebElement> sessions = driver.findElements(
                By.xpath("//android.view.View[contains(@content-desc,'Session')]")
                // Adjust the XPath to target all session elements
        );

        boolean cancelled = false;

        for (WebElement session : sessions) {
            try {
                // Find the cancel button inside the session
                WebElement cancelButton = session.findElement(
                        By.xpath(".//android.view.View[@content-desc='Cancel']")
                );

                // Check if the cancel button is displayed and enabled
                if (cancelButton.isDisplayed() && cancelButton.isEnabled()) {
                    cancelButton.click();
                    cancelled = true;
                    System.out.println("Session cancelled successfully.");
                    break;  // Exit the loop once cancellation is done
                }
            } catch (NoSuchElementException e) {
                // No cancel button in this session — skip to the next
                continue;
            }
        }

// Check if any session was successfully cancelled
        if (!cancelled) {
            System.out.println("No cancellable session found.");
        }



        // Get list of session cards accurately
        List<WebElement> sessionCards = driver.findElements(By.xpath(
                "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]//android.view.View[./android.view.View[contains(@content-desc, 'Session')]]"
        ));

// Click on the first session if available
        if (!sessionCards.isEmpty()) {
            sessionCards.get(0).click();
            System.out.println("Clicked on the first session card.");
        } else {
            System.out.println("No session cards found.");
        }
        Thread.sleep(3000);

        //Tap on the Cancel Button
        WebElement Cancel_Button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Cancel Session\"]")));
        Cancel_Button.click();
        System.out.println("Cancel Button");

        //Tap on the yes Button
        WebElement Yes_Button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"Yes\"]")));
        Yes_Button.click();
        System.out.println("Yes button");

    }
}
