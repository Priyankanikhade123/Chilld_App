import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Group_Session_Booking {

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
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ScrollView/android.widget.ImageView[2]")));
        emailField.click();
        emailField.sendKeys("priyanka.nikhade11@gmail.com");
        Thread.sleep(6000);


        // Enter Password
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ScrollView/android.widget.ImageView[3]")));
        passwordField.click();
        passwordField.sendKeys("Pass@123");
        Thread.sleep(3000);


        //  Click "Login" button
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@content-desc='Login'])[2]")));
        loginBtn.click();
        Thread.sleep(4000);

        //Click on Experts
        WebElement Experts_icon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"Experts\"]")));
        Experts_icon.click();
        Thread.sleep(3000);

        //Tap on the View All button
        WebElement View_All = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"View All\"]")));
        View_All.click();
        Thread.sleep(3000);

        //Tap on the any coach
        WebElement Any_Coach = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"Priyanka\n" +
                "Next Available:\"]")));
        Any_Coach.click();
        Thread.sleep(3000);

        //Tap on the Book group session
        WebElement Book_a_session = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"Book a Session\"]")));
        Book_a_session.click();
        Thread.sleep(3000);

//        //Select the first session from the My Session screen
//        WebElement first_session = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@content-desc=\"ONE-ON-ONE\n" +
//                "Free Session\n" +
//                "Priyanka\n" +
//                "Sleep Session\n" +
//                "60 Min\n" +
//                " - zoom\n" +
//                "Free Session\n" +
//                "Create\"])[1]")));
//        first_session.click();

//        // Wait for and click the first session card on "All Sessions by Priyanka"
//        WebElement firstSession = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("(//android.view.View[contains(@content-desc, 'ONE-ON-ONE') and contains(@content-desc, 'Priyanka')])[1]")
//        ));
//        firstSession.click();



        // Find all matching session cards
        List<WebElement> sessionCards = driver.findElements(By.xpath(
                "//android.view.View[contains(@content-desc, 'Free Session') and contains(@content-desc, 'Priyanka')]"
        ));

// Click the 4th session if it exists
        int indexToClick = 3; // zero-based index
        if (sessionCards.size() > indexToClick) {
            WebElement targetSession = sessionCards.get(indexToClick);

            // Scroll to the element using JavaScript or Android actions
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", targetSession);

            // Wait until it's clickable
            wait.until(ExpectedConditions.elementToBeClickable(targetSession));

            // Debug output
            System.out.println("Target session: " + targetSession.getAttribute("content-desc"));

            // Click it
            targetSession.click();
        } else {
            System.out.println("Less than 4 matching sessions found.");
        }

        //Select date & Time box
        WebElement Date_Time = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"DD / MM / YYYY  00:00\"]")));
        Date_Time.click();

        //Select the date
        WebElement Date = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Friday, July 25, 2025\"]")));
        Date.click();

        //Select the Next button
        WebElement Next_button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Next\"]")));
        Next_button.click();

        //Select time slot
        WebElement time = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"10:30\"]")));
        time.click();

        //Save button
        WebElement Save_button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Save\"]")));
        Save_button.click();

        //tap on the Create Session
        WebElement Create_Session = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Create Session\"]")));
        Create_Session.click();

        //checkbox first check
        WebElement First_Check = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.widget.CheckBox[1]")));
        First_Check.click();

        //checkbox second check
        WebElement Second_checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.widget.CheckBox[2]")));
        Second_checkbox.click();

        //Click on the Confirm
        WebElement Confirm_button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Confirm and Pay $555\"]")));
        Confirm_button.click();

        //Click on the Card number
        WebElement Card_number = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"Card number\"]")));
        Card_number.click();
        Card_number.sendKeys("4111 1111 1111 1111");

        //Click on the MM/YY
        WebElement MMYY = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"MM / YY\"]")));
        MMYY.click();
        MMYY.sendKeys("07/25");

        //Click on the CVC
        WebElement CVC = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"CVC\"]")));
        CVC.click();
        CVC.sendKeys("123");

        //Click on the Pay
        WebElement Pay = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"Pay $555.00\"]")));
        Pay.click();

        //Tap on the View Bookings
        WebElement View_Booking = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"View Bookings\"]")));
        View_Booking.click();



    }
}
