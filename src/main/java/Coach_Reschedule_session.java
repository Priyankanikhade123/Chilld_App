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

public class Coach_Reschedule_session {

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

        // Enter Email
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ScrollView/android.widget.ImageView[5]")));
        emailField.click();
        emailField.sendKeys("priyankanikhade@aladinntech.in");
        Thread.sleep(3000);

        // Enter Password
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ScrollView/android.widget.ImageView[6]")));
        passwordField.click();
        passwordField.sendKeys("Pass@123");
        Thread.sleep(3000);

        //  Click "Login" button
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@content-desc=\"Login\"])[2]")));
        loginBtn.click();
        Thread.sleep(3000);

        //Tap on the Sessions
        WebElement Sessions_icon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"Sessions\"]")));
        Sessions_icon.click();
        Thread.sleep(3000);

        // Tap on the new Requests
        WebElement New_Requests = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@content-desc=\"New Requests\"])[2]")));
        New_Requests.click();
        System.out.println("Click on the New Requests button");
        Thread.sleep(5000);





//
//        //Tap on the First Session
//        // Locate the parent element using accessibility id
//        WebElement parent = driver.findElement(AppiumBy.accessibilityId("June 2025\n23\nMON\n19\nTHU\n19\nTHU"));
//
//
//        // Get all child elements
//        List<WebElement> sessions = parent.findElements(By.className("android.view.View"));
//
//        // Click the first one
//        sessions.get(0).click();

        // Wait for session cards to be present - click the first one
        List<WebElement> sessionCards = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//android.view.View[contains(@content-desc, 'Today One To One Session')]")
        ));

        if (!sessionCards.isEmpty()) {
            sessionCards.get(0).click();
            System.out.println("Clicked on the first session card successfully.");
        } else {
            System.out.println("No session cards found.");
        }








        //Tap on the Reschedule button
        WebElement Reschedule_Button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Reschedule\"]")));
        Reschedule_Button.click();
        System.out.println("Click on the reschedule button");
        Thread.sleep(3000);



        // Step 1: Select next date
        List<WebElement> dates = driver.findElements(By.xpath("//android.view.View[contains(@content-desc, 'June')]"));
        if (dates.size() > 1) {
            dates.get(1).click(); // skip today's date, pick the next
            System.out.println("Next date selected: " + dates.get(1).getAttribute("content-desc"));
        } else {
            System.out.println("No next date found.");

        }

// Step 2: Tap "Next"
        WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.view.View[@content-desc='Next']")));
        nextBtn.click();
        Thread.sleep(3000);

// Step 3: Choose first available time slot
        List<WebElement> slots = driver.findElements(By.xpath("//android.view.View[contains(@content-desc, ':')]"));
        if (!slots.isEmpty()) {
            slots.get(0).click();
            System.out.println("Time slot selected: " + slots.get(0).getAttribute("content-desc"));
        } else {
            System.out.println("No time slots found.");
            Thread.sleep(3000);
        }

// Step 4: Tap "Save"
        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.view.View[@content-desc='Save']")));
        saveBtn.click();
        System.out.println("Date and time saved.");
        Thread.sleep(3000);





























//        //Tap on the Date & Time box
//        WebElement Date_Time_Box = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"25 / 06 / 2025 09:00\"]")));
//        Date_Time_Box.click();
//        System.out.println("Tap on the Date & Time Box");
//        System.out.println("Click on the Date text box");
//        Thread.sleep(3000);
//
//        //Tap on the Select the Date & Time
//        WebElement Date_time = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Tuesday, June 24, 2025\"]")));
//        Date_time.click();
//        Thread.sleep(3000);
//
//        //Tap on the Next button
//        WebElement Next_Button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Next\"]")));
//        Next_Button.click();
//        Thread.sleep(3000);
//
//        //Choose Slot time
//        WebElement Slot_time = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"09:35\"]")));
//        Slot_time.click();
//        Thread.sleep(3000);

        //Tap on the Save Button
        WebElement Save_Button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Save\"]")));
        Save_Button.click();
        Thread.sleep(3000);





    }
}
