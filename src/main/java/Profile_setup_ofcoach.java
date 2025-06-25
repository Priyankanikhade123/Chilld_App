import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;

public class Profile_setup_ofcoach {

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

//         // Click "Get Started"
        WebElement getStarted = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Get Started\"]")));
        getStarted.click();
        Thread.sleep(3000);


        //Expert Registration button
        WebElement Expert_Registration = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Expert Registration\"]")));
        Expert_Registration.click();

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
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@content-desc=\"Login\"])[2]")));
        loginBtn.click();


        System.out.println("Login attempted!");
        Thread.sleep(3000);

        // Navigate to the Professional Details
        //Tap on the Specialty
        WebElement Systemisches_Coaching = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@content-desc=\"Systemisches Coaching\"])[2]")));
        Systemisches_Coaching.click();

        //Tap on the Add Certification
        WebElement Add_Certification = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Add Certification\"]")));
        Add_Certification.click();

        //Tap on the Name of the Institute
        WebElement Name_of_the_Institute = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.widget.EditText[1]")));
        Name_of_the_Institute.sendKeys("DY Institute");

        //Tap on the Certification Topic
        WebElement Certification_Topic = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.widget.EditText[2]")));
        Certification_Topic.sendKeys("Systemisches Coaching");

        //Choose a file By Tapping the Browse File
        WebElement Select_the_file = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Browse File\"]")));
        Select_the_file.click();
        Thread.sleep(3000);


        //Tap on the img
        // Find the file input element
        WebElement uploadElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("uploadFile")));

        // Provide the full path to the file you want to upload
        uploadElement.sendKeys("(//android.widget.ImageView[@resource-id=\"com.google.android.documentsui:id/icon_thumb\"])[1]");
        Thread.sleep(3000);



        // (Optional) Save button the form or click the upload button
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("s//android.view.View[@content-desc=\"Save\"]")));
        Thread.sleep(3000);
        saveButton.click();

        // Bio(optional)
        WebElement Bio = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView[2]/android.widget.EditText[2]")));
        Bio.sendKeys("it coach profile setup");
        Thread.sleep(3000);

        // Tap on the Next Button
        WebElement Next_button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@content-desc=\"Next\"])[2]")));
        Next_button.click();
        Thread.sleep(3000);

        //Tap on the Address
        WebElement Address = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.widget.ImageView[2]")));
        Address.sendKeys("Pune");
        Thread.sleep(3000);

        //Tap on the Next button
        WebElement Next_Button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Next\"]")));
        Next_Button.click();

        //Availability & Scheduling screen continue button
        WebElement Continue_Button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Continue\"]")));
        Continue_Button.click();

        //Review & Confirm "Confirm & Sign Up" button
        WebElement Confirm_Sign_Up = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Confirm & Sign Up\"]")));
        Confirm_Sign_Up.click();






    }

}
