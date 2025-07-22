import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

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
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ScrollView/android.widget.ImageView[2]")));
        emailField.click();
        emailField.sendKeys("priyanka.nikhade11@gmail.com");
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

        //Tap on the Sessions
        WebElement Sessions_icon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"Sessions\"]")));
        Sessions_icon.click();
        Thread.sleep(3000);

        // Tap on the new Requests
        WebElement New_Requests = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@content-desc=\"New Requests\"])[2]")));
        New_Requests.click();
        System.out.println("Click on the New Requests button");
        Thread.sleep(5000);

        //Tap on the first session
        WebElement First_session = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@content-desc=\"ONE-ON-ONE\n" +
                "New Request\n" +
                "Priyanka\n" +
                "Reschedule\n" +
                "60 Min\n" +
                " - $535\n" +
                " - zoom\n" +
                "July 18, 2025, 9:00 AM\n" +
                "It Is One To One Session\"])[2]")));
        First_session.click();


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

        // Wait for session cards that contain 'GROUP SESSION' in content-desc
        List<WebElement> sessionCards = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//android.view.View[contains(@content-desc, 'GROUP SESSION')]")
        ));

        if (!sessionCards.isEmpty()) {
            sessionCards.get(0).click();
            System.out.println("Clicked on the first GROUP SESSION card successfully.");
        } else {
            System.out.println("No GROUP SESSION cards found.");
        }


        //Tap on the Reschedule button
        WebElement Reschedule_Button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Reschedule\"]")));
        Reschedule_Button.click();
        System.out.println("Click on the reschedule button");
        Thread.sleep(3000);




        //Tap on the Date & Time button
        WebElement dateTimeBox = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.view.View[contains(@content-desc, '/ 2025')]")
        ));
        dateTimeBox.click();
        System.out.println("Clicked on dynamic Date & Time textbox");


        // Get tomorrow's date
        LocalDate tomorrow = LocalDate.now().plusDays(1);

// Format as per your app (e.g., "30", "31", etc.)
        String day = String.valueOf(tomorrow.getDayOfMonth());

// XPath to find the date by text (only the number in calendar grid)
        String xpath = "//android.view.View[@content-desc='" + day + "']";

// Click on the date
        WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        dateElement.click();
        System.out.println("Clicked on date: " + day);

// Click on the "Next" button
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@text='Next']")));
        nextButton.click();
        System.out.println("Clicked on Next button");



        //Replacement of code of Date and time

        // Step 1: Calculate the date to be selected (e.g., today + 1 day)
        LocalDate desiredDate = LocalDate.now().plusDays(1); // for tomorrow
        DateTimeFormatter accessibilityFormatter = DateTimeFormatter.ofPattern("Monday, june 30, 2025", Locale.ENGLISH); // Monday, June 30, 2025
        String formattedDate = desiredDate.format(accessibilityFormatter);

        System.out.println("Selecting date: " + formattedDate);

// Step 2: Find and click the desired date element using accessibility ID
        WebElement dateElement1 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId(formattedDate)));
        dateElement.click();
        System.out.println("Date selected.");

// Step 3: Click on "Next"
        WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@text='Next']")));
        nextBtn.click();
        System.out.println("Next clicked");

// Step 4: Wait for slot list and select first one
        List<WebElement> slots = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//android.view.View[contains(@content-desc, ':00')]")
        ));

        if (!slots.isEmpty()) {
            slots.get(0).click(); // You can choose based on your logic
            System.out.println("Slot selected: " + slots.get(0).getAttribute("content-desc"));
        } else {
            throw new Exception("No available time slots found!");
        }

// Step 5: Click Save
        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@text='Save']")));
        saveBtn.click();
        System.out.println("Save clicked");

//
//// Step 2: Tap "Next"
//        WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//android.view.View[@content-desc='Next']")));
//        nextBtn.click();
//        Thread.sleep(3000);
//
//// Step 3: Choose first available time slot
//        List<WebElement> slots = driver.findElements(By.xpath("//android.view.View[contains(@content-desc, ':')]"));
//        if (!slots.isEmpty()) {
//            slots.get(0).click();
//            System.out.println("Time slot selected: " + slots.get(0).getAttribute("content-desc"));
//        } else {
//            System.out.println("No time slots found.");
//            Thread.sleep(3000);
//        }
//
//// Step 4: Tap "Save"
//        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//android.view.View[@content-desc='Save']")));
//        saveBtn.click();
//        System.out.println("Date and time saved.");
//        Thread.sleep(3000);


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

//        //Tap on the Save Button
//        WebElement Save_Button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Save\"]")));
//        Save_Button.click();
//        Thread.sleep(3000);


    }
}

