import com.google.common.collect.ImmutableMap;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class Booking_free_Session_userside {

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
        emailField.sendKeys("pratikshapatil@aladinnserver.in");
        Thread.sleep(3000);


        // Enter Password
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ScrollView/android.widget.ImageView[3]")));
        passwordField.click();
        passwordField.sendKeys("Pass@123");
        Thread.sleep(3000);


        //  Click "Login" button
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@content-desc=\"Login\"])[2]")));
        loginBtn.click();

        //Click on Experts
        WebElement Experts_icon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"Experts\"]")));
        Experts_icon.click();

        //Search for a Experts
        WebElement Search_for_Experts = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]")));
        Search_for_Experts.click();

        //click search
        WebElement Click_search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText")));
        Click_search.click();
        Click_search.sendKeys("Pratiksha Patil");

        //Tap on coach
        WebElement Coach = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"Pratiksha Patil\n" +
                "Next Available:\"]")));
        Coach.click();
        Thread.sleep(3000);

        //Book a session button
        WebElement Book_session_button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"Book a Session\"]")));
        Book_session_button.click();
        Thread.sleep(5000);

        //Tap on the 1:1 Session button
        WebElement one_Session = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"1:1 Sessions\"]")));
        one_Session.click();
        Thread.sleep(9000);


        //Tap on the Create button
        WebElement Create_button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"ONE-ON-ONE\n" +
                "Free Session\n" +
                "Pratiksha Patil\n" +
                "Sleep Second\n" +
                "60 Min\n" +
                " - zoom\n" +
                "Second Session\n" +
                "Create\"]")));
        Create_button.click();

        //Tap on the Date & Time
        WebElement date = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"DD / MM / YYYY  00:00\"]")));
        date.click();


        // Define your starting index based on Appium Inspector observation
        int dateStartIndex = 10;          // <-- Adjust if needed
        int timeSlotStartIndex = 25;      // <-- Adjust if needed

        boolean sessionBooked = false;

        for (int i = 0; i < 7; i++) {
            try {
                // Build dynamic XPath to click calendar date
                String dateXPath = "(//android.view.View)[" + (dateStartIndex + i) + "]";
                WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dateXPath)));
                dateElement.click();
                System.out.println("Clicked on date index: " + (dateStartIndex + i));

                // Click the 'Next' button
                WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//android.view.View[@content-desc='Next']")));
                nextButton.click();
                System.out.println("Clicked on 'Next'");

                // Try to find available time slot
                for (int j = 0; j < 5; j++) {
                    try {
                        String timeXPath = "(//android.view.View)[" + (timeSlotStartIndex + j) + "]";
                        WebElement timeSlot = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(timeXPath)));
                        timeSlot.click();
                        System.out.println("Selected time slot index: " + (timeSlotStartIndex + j));

                        // Click 'Save' button
                        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(
                                By.xpath("//android.view.View[@content-desc='Save']")));
                        saveButton.click();
                        System.out.println("Session booked successfully!");
                        sessionBooked = true;
                        break;

                    } catch (Exception e) {
                        System.out.println("Time slot not available at index: " + (timeSlotStartIndex + j));
                    }
                }

                if (sessionBooked) {
                    break;  // Exit the outer loop once session is booked
                }

            } catch (Exception e) {
                System.out.println("Date not clickable at index: " + (dateStartIndex + i));
            }
        }

        if (!sessionBooked) {
            System.out.println("No available session found in next 7 days.");
        }

        try {
            // Wait for and find all time slots using partial content-desc (09:00, 10:00, etc.)
            List<WebElement> timeSlots = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                    By.xpath("//android.view.View[contains(@content-desc, ':')]")
            ));

            if (!timeSlots.isEmpty()) {
                timeSlots.get(0).click();  // Select the first available time slot
                System.out.println("Selected time slot: " + timeSlots.get(0).getAttribute("content-desc"));

                // Wait for and click on 'Save' button
                WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//android.view.View[@content-desc='Save']")));
                saveButton.click();
                System.out.println("Clicked Save");
            } else {
                System.out.println("No time slots available.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


//        // Step 1: Click calendar box
//        WebElement dateBox = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//android.view.View[@content-desc='DD / MM / YYYY  00:00']")));
//        dateBox.click();
//
//// Step 2: Generate dynamic date/time
//        LocalDate futureDate = LocalDate.now().plusDays(1);
//        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd / MM / yyyy");
//        String formattedDate = futureDate.format(dateFormatter);
//        String timeSlot = "09:00";
//        String contentDesc = formattedDate + "  " + timeSlot;
//
//// Step 3: Scroll and click
//        try {
//            WebElement element = driver.findElement(By.xpath("//android.view.View[@content-desc='18 / 07 / 2025  09:00']"));
//            element.click();
//
//            System.out.println("Slot selected: " + contentDesc);
//        } catch (Exception e) {
//            System.out.println("Slot not found or not clickable: " + contentDesc);
//        }

//                // Tap on the Date & Time button
//                WebElement DateTime_button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"DD / MM / YYYY  00:00\"]")));
//                DateTime_button.click();
//                Thread.sleep(3000);
//
//                //Select date
//                WebElement Date = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Thursday, June 19, 2025\"]")));
//                Date.click();
//                Thread.sleep(3000);
//
//                //Tap on Next button
//                WebElement Next_button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Next\"]")));
//                Next_button.click();
//                Thread.sleep(3000);
//
//                //Select the time
//                WebElement Select_Time = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"09:00\"]")));
//                Select_Time.click();
//                Thread.sleep(3000);
//
//                //Save button
//                WebElement Save_Button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Save\"]")));
//                Save_Button.click();
//
//                //Tap on the Free Create Session
//                WebElement Free_Create_Session = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Free Create Session\"]")));
//                Free_Create_Session.click();




