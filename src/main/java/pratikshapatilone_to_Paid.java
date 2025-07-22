import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class pratikshapatilone_to_Paid {


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

//            //Expert Registration button
//            WebElement Expert_Registration = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Expert Registration\"]")));
//            Expert_Registration.click();
//            Thread.sleep(3000);

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


        //Click on Experts
        WebElement Experts_icon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"Experts\"]")));
        Experts_icon.click();

        //Search for a Experts
        WebElement Search_for_Experts = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]")));
        Search_for_Experts.click();

        //click search
        WebElement Click_search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText")));
        Click_search.click();
        Click_search.sendKeys("Priyanka");

        //Tap on coach
        WebElement Coach = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"Priyanka\n" +
                "Next Available:\"]")));
        Coach.click();
        Thread.sleep(3000);

        //Book a session button
        WebElement Book_session_button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"Book a Session\"]")));
        Book_session_button.click();
        Thread.sleep(5000);

        //Tap on Create session
        WebElement Create_session = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"ONE-ON-ONE\n" +
                "Priyanka\n" +
                "Sleeping session1\n" +
                "60 Min\n" +
                " - $155\n" +
                " - zoom\n" +
                "One to One session sleeping coach\n" +
                "Create\"]")));
        Create_session.click();
        Thread.sleep(3000);

        // Tap the Date & Time field
        WebElement dateField = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.view.View[@content-desc=\"DD / MM / YYYY  00:00\"]")));
        dateField.click();
        Thread.sleep(2000);

        boolean slotFound = false;

        // Try for the next 7 days
        for (int i = 1; i <= 7; i++) {
            LocalDate currentDate = LocalDate.now().plusDays(i);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy", Locale.ENGLISH);
            String contentDescDate = currentDate.format(formatter);

            String dateXPath = "//android.view.View[@content-desc='" + contentDescDate + "']";
            System.out.println("Generated XPath: " + dateXPath);

            try {
                WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dateXPath)));
                dateElement.click();
                System.out.println("Clicked on date: " + contentDescDate);
                Thread.sleep(2000);

                WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//android.view.View[@content-desc='Next']")));
                nextButton.click();
                Thread.sleep(2000);

                // Collect all views after clicking Next
                List<WebElement> allViews = driver.findElements(By.xpath("//android.view.View"));

                // Filter only valid time slots like "09:00", "10:30", etc.
                List<WebElement> timeSlots = new java.util.ArrayList<>();
                for (WebElement el : allViews) {
                    String desc = el.getAttribute("content-desc");
                    if (desc != null && desc.matches("\\d{2}:\\d{2}")) {
                        timeSlots.add(el);
                    }
                }

                if (!timeSlots.isEmpty()) {
                    WebElement firstSlot = timeSlots.get(0);
                    firstSlot.click();
                    System.out.println("Booked slot: " + firstSlot.getAttribute("content-desc"));

                    // Click Save
                    WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(
                            By.xpath("//android.view.View[@content-desc='Save']")));
                    saveButton.click();

                    System.out.println("Session booked for: " + contentDescDate);
                    slotFound = true;
                    break;  // ✅ Exit loop if slot is booked
                } else {
                    System.out.println("No time slots found for: " + contentDescDate);
                }

            } catch (Exception e) {
                System.out.println("Date not found or slot selection failed for: " + contentDescDate);
            }
        }

        if (!slotFound) {
            System.out.println("No session slot available in next 7 days.");
        }

        //Tap on the Create Session
        WebElement create_Session = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Create Session\"]")));
        create_Session.click();
        Thread.sleep(2000);

        //Tap on the Terms
        WebElement Terms = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.widget.CheckBox[1]")));
        Terms.click();
        Thread.sleep(2000);

        //Tap on the Policy
        WebElement Policy = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.widget.CheckBox[2]")));
        Policy.click();
        Thread.sleep(2000);

        //Tap on the Confirm_button
        WebElement Confirm_button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Confirm and Pay $155\"]")));
        Confirm_button.click();
        Thread.sleep(2000);


//        //Tap on the Card_information
        WebElement cardNumberField = wait.until(ExpectedConditions.elementToBeClickable(
                By.className("android.widget.EditText")
        ));
        cardNumberField.click();
        cardNumberField.sendKeys("4111111111111111");
        Thread.sleep(2000);


        //Tap on the MM/YY
        WebElement expiryField = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.EditText[2]")
        ));
        expiryField.click();
        expiryField.sendKeys("07/25");


        WebElement CVC = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.EditText[3]")
        ));
        CVC.click();
        CVC.sendKeys("123");
        Thread.sleep(2000);


        //Tap on the Pay
        WebElement Pay = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"Pay $155.00\"]")));
        Pay.click();

        //Tap on the View Bookings
        WebElement View_Bookings = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"View Bookings\"]")));
        View_Bookings.click();




    }
}






