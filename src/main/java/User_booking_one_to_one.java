import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.util.List;

public class User_booking_one_to_one {


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

        //Tap on the Book a session
        WebElement Book_a_session = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"Book a Session\"]")));
        Book_a_session.click();
        Thread.sleep(3000);

        //Tap on the 1:1 Session button
        WebElement one_Session = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"1:1 Sessions\"]")));
        one_Session.click();
        Thread.sleep(9000);

        //Tap on the first session
        WebElement First_session = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"ONE-ON-ONE\n" +
                "Free Session\n" +
                "Priyanka\n" +
                "Sleep Session\n" +
                "60 Min\n" +
                " - zoom\n" +
                "Free Session\n" +
                "Create\"]")));
        First_session.click();
        Thread.sleep(3000);



        //Tap on the Create button
        WebElement Create_button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"DD / MM / YYYY  00:00\"]")));
        Create_button.click();


        //Select the Date and Time
        WebElement Date_Time = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Friday, July 11, 2025\"]")));
        Date_Time.click();
        Thread.sleep(3000);

        //Tap on the Next button
        WebElement Next_button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Next\"]")));
        Next_button.click();
        Thread.sleep(3000);

        //Select the time

       // Select the first available time slot under "Slots Available"

        List<WebElement> timeSlots = driver.findElements(By.xpath(
                "//android.view.View[@content-desc and matches(@content-desc, '^[0-9]{2}:[0-9]{2}$')]"
        ));

        if (!timeSlots.isEmpty()) {
            timeSlots.get(0).click();
            System.out.println("Clicked on the first time slot: " + timeSlots.get(0).getAttribute("content-desc"));
        } else {
            System.out.println("No time slots found.");
        }

        //Tap on the Save button
        WebElement Save = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Save\"]")));
        Save.click();
        Thread.sleep(3000);

        //Tap on the Create Session
        WebElement Create_Session = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Create Session\"]")));
        Create_Session.click();
        Thread.sleep(3000);

        //Check box on terms and Privacy Policy
        WebElement Terms_checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.widget.CheckBox[1]")));
        Terms_checkbox.click();
        Thread.sleep(3000);

        //Check box withdrawal Policy
        WebElement withdrawal_Policy = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.widget.CheckBox[2]")));
        withdrawal_Policy.click();
        Thread.sleep(3000);

        //Tap on the Confirm and Pay
        WebElement Confirm_Pay = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Confirm and Pay $252\"]")));
        Confirm_Pay.click();
        Thread.sleep(3000);

        //Tap on the card number
        WebElement Card_number = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"Card number\"]")));
        Card_number.click();
        Card_number.sendKeys("4111 1111 1111 1111");
        Thread.sleep(3000);

        //Tap on the MM/YY
        WebElement MM_YY = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"MM / YY\"]")));
        MM_YY.click();
        MM_YY.sendKeys("07/25");
        Thread.sleep(3000);

        //Tap on the CVC
        WebElement CVC = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"CVC\"]")));
        CVC.click();
        CVC.sendKeys("123");
        Thread.sleep(3000);

        //Tap on the Pay_button
        WebElement Pay_Button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"Pay $252.00\"]")));
        Pay_Button.click();
        Thread.sleep(3000);

        //Tap on the View Booking
        WebElement View_Booking = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"View Bookings\"]")));
        View_Booking.click();


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
    }
}
