package demo;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplitoolsDemo {
    public static void main(String[] args) {

        //Use Chrome browser
        System.setProperty("webdriver.chrome.driver", "/Users/Will/Desktop/Workspace/Selenium/Framework1/src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Initialize the eyes SDK and set your private API key.
        Eyes eyes = new Eyes();

        // Set the API key from the env variable. Please read the "Important Note"
        // section above.
        eyes.setApiKey("es99NeTzaceL108MK111u8ouVGbu3106jWxDGJgxfL0eENN3yw110");

        try {


            // Start the test by setting AUT's name, window or the page name that's being tested, viewport width and height
            eyes.open(driver, "appName","windowName", new RectangleSize(600, 800));

            // Navigate the browser to the "ACME" demo app
            driver.get("https://demo.applitools.com");

            // Visual checkpoint #1.
            eyes.checkWindow("Login window");

            //🌟 Note: You can have multiple "checkWindow" to create multiple test steps within a test.🌟
            //For example, you may want to test errors in the login window after clicking a login button,
            //In that case, you may add the following before you call eyes.close().
            //This will create a test with two test steps.
            //driver.click("login");
            //eyes.checkWindow("Login Window Error");

            // End the test.
            eyes.close();

        } catch (Exception e) {
            System.out.println(e);
        } finally {

            // Close the browser.
            driver.quit();

            // If the test was aborted before eyes.close was called, ends the test as
            // aborted.
            eyes.abortIfNotClosed();

            // End main test
            System.exit(0);
        }

    }
}
