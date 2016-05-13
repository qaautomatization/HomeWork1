import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by pavlo.harkavii on 5/12/2016.
 * **********************************************
 Test Case to Automate (TILL THAT driver.navigate().refresh();)
 http://www.seleniumframework.com/Practiceform/
 Write positive test case which tests “CONTACT US” form submission
 Write 2-3 negative test cases for the same form
 Automate those test cases
 Upload your test script on GitHub till Wednesday evening
 */

    // READ ME FIRST
    // 1. Open this class inside IntelIGIdea
    // 2. Download Selenium Client & WebDriver Language Bindings for Java from http://www.seleniumhq.org/download/ and unpacked it
    // 3. Download ChromeDriver for your systems from http://chromedriver.storage.googleapis.com/index.html?path=2.21/ and unpacked it
    // 4. Create External folder near ProjectFolder and put Selen&ChromeDriver thither
    // 5. Add SeleniumFolder&SeleniumLibSubfolder to Libraries inside IntelIGIdea

public class HW1ContactUsFormSubmission {

    public static void main (String[] Args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "F:\\YPernerovskyySeleniumPart1\\External\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.seleniumframework.com/Practiceform/");
        driver.navigate().refresh();
        Thread.sleep(3000);
        driver.navigate().refresh();

        String name="Paul";
        String email="pavlo.harkavyii@globallogic.com";
        String wrongEmail="pavlo.harkavii.globallogic.com";
        String telephone="0988273679";
        String wrongTelephone="I will not tell !";
        String country="Ukraine";
        String company="GL";
        String message="Big messageeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee";

        String formErrorContentName="* This field is required";
        String formErrorPartialContentEmail="* Invalid email address";
        String formErrorPartialContentTelephone="* Invalid phone number";
        String formSuccessContent="Feedback has been sent to the administrator";

        WebElement nameInput=driver.findElement(By.name("name"));
        WebElement emailInput=driver.findElement(By.xpath("//input[@class='validate[required,custom[email]]']"));
        WebElement telephoneInput=driver.findElement(By.name("telephone"));
        WebElement countryInput=driver.findElement(By.name("country"));
        WebElement companyInput=driver.findElement(By.name("company"));
        WebElement companyTextarea=driver.findElement(By.name("message"));
        WebElement submitButton=driver.findElement(By.linkText("Submit"));
        WebElement clearIcon=driver.findElement(By.className("clear-form"));




        //First Test of JuniorTester without JUnit OR testng
        Thread.sleep(2000);
        System.out.println("1) Positive Test Started! Try fill Name Email Telephone Fields as Correct");
        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        telephoneInput.sendKeys(telephone);
        submitButton.click();
        Thread.sleep(3000);
        if (driver.findElement(By.className("formErrorContent")).getText().equals(formSuccessContent)) {
            System.out.println("1) Positive Test Passed! Name Email Telephone Fields is Correct and we see EXP.RESULT: Feedback has been sent to the administrator");
        }
        else {
            System.out.println("1) Test Fails");
        }
        clearIcon.click();



        //Second Test of JuniorTester without JUnit OR testng
        Thread.sleep(2000);
        System.out.println("2) Negative Test Started! Try fill WRONG Email and  Name Telephone as Correct ");
        nameInput.sendKeys(name);
        emailInput.sendKeys(wrongEmail);
        telephoneInput.sendKeys(telephone);
        submitButton.click();
        Thread.sleep(1000);
        if (driver.findElement(By.className("formErrorContent")).getText().equals(formErrorPartialContentEmail)) {
            System.out.println("2) Negative Test Passed! Attempt of typing WRONG Email when Name Telephone is Correct give title with EXP.RESULT: * Invalid email address");
        }
        else {
            System.out.println("2) Test Fails");
        }
        clearIcon.click();




        //Third Test of JuniorTester without JUnit OR testng
        Thread.sleep(2000);
        System.out.println("3) Negative Test Started! Try fill WRONG Telephone and Name Email as Correct ");
        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        telephoneInput.sendKeys(wrongTelephone);
        submitButton.click();
        Thread.sleep(1000);
        if (driver.findElement(By.className("formErrorContent")).getText().equals(formErrorPartialContentTelephone)) {
            System.out.println("3) Negative Test Passed! Attempt of typing WRONG Telephone when Name Email is Correct give title with EXP.RESULT: * Invalid phone number");
        }
        else {
            System.out.println("3) Test Fails");
        }
        clearIcon.click();




        //Forth Test of JuniorTester without JUnit OR testng
        Thread.sleep(2000);
        System.out.println("4) Negative Test Started! Try fill WRONG Name and Telephone  Email as Correct ");
        nameInput.sendKeys();
        emailInput.sendKeys(email);
        telephoneInput.sendKeys(telephone);
        countryInput.sendKeys(country);
        companyInput.sendKeys(company);
        companyTextarea.sendKeys(message);
        submitButton.click();
        Thread.sleep(1000);
        if (driver.findElement(By.className("formErrorContent")).getText().equals(formErrorContentName)) {
            System.out.println("4) Negative Test Passed! Attempt of typing WRONG Name when Telephone Email is Correct give title with EXP.RESULT: * This field is required");
        }
        else {
            System.out.println("4) Test Fails");
        }
        clearIcon.click();



        driver.quit();
        }
    }

