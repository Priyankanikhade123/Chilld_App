import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;

public class Booking_Group_Session extends User_login
{


  @Before
          public void status1() throws MalformedURLException, InterruptedException {
      setup();

  }
  @Test
          public void status2() throws InterruptedException {

      System.out.println("Using driver in status2(): " + driver);

      if (driver == null) {
          throw new RuntimeException("Driver is NULL. Setup failed.");

      }



        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));


        // Click on the Experts icon
      WebElement Experts = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"Experts\"]")));
      Experts.click();

      //  Tap on the Searchbox
      WebElement Search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.view.View[1]")));
      Search.click();

      // Tap on the seach for experts
      WebElement coach_Name = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText")));
      coach_Name.click();
      coach_Name.sendKeys("Priyanka");
      System.out.println("navigate to the search screen");


      //Tap on the coach name
      WebElement Tap_coachName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"Priyanka\n" +
              "5.0\n" +
              "Systemisches Coaching, Sleep Coach, Positive Discipline Coach, Behavioral Coaching, Child Development Coach, Financial Planning for Parents Coach\n" +
              "Next Available:\"]")));
      Tap_coachName.click();

      //scroll the mobile screen

      //Tap on the Available Sessions
      WebElement Free_Group_Session = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"Free Group Session\n" +
              "June 18, 2025, 10:57 AM\n" +
              "5 Min\n" +
              "Free Session\"]")));
      Free_Group_Session.click();

      //Tap on the Date & Time
      WebElement Date_Time = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"DD / MM / YYYY  00:00\"]")));
      Date_Time.click();

      //Tap on the any select date
      WebElement Select_Date = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Tuesday, June 24, 2025\"]")));
      Select_Date.click();

      //Tap on the Next button
      WebElement Next_button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Next\"]")));
      Next_button.click();

      //Tap on the Solts Available
      WebElement Solts_Available = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"09:00\"]")));
      Solts_Available.click();

      //Tap on the save button
      WebElement Save_Available = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Save\"]")));
      Save_Available.click();

      //Tap on the Free Create Session button
      WebElement Free_Create_Session_button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"Free Create Session\"]")));
      Free_Create_Session_button.click();

      //Tap on the View Bookings button
      WebElement View_Booking = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc=\"View Bookings\"]")));
      View_Booking.click();



    }

}
