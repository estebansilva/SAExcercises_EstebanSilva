package Clase4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class AirbnbFindByRefactor {

    public WebDriver driver;

    @BeforeMethod

    public void setup(){

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        PageFactory.initElements(driver, this);
    }

    //Web Elements
    @FindBy (xpath = "//*[@placeholder = '¿A dónde vas?']")
    public WebElement searchPlace;

    @FindBy (xpath = "//*[@data-testid='structured-search-input-field-split-dates-0']")
    public WebElement checkInSection;

    @FindBy (xpath = "//*[@data-testid = 'structured-search-input-field-guests-button']")
    public WebElement guestSection;

    @FindBy (xpath = "//*[@data-testid='stepper-adults-increase-button']")
    public WebElement adultIncreaseButton;

    @FindBy (xpath = "//*[@data-testid='stepper-children-increase-button']")
    public WebElement childrenIncreaseButton;

    @FindBy (xpath = "//*[@data-testid='stepper-infants-increase-button']")
    public WebElement infantIncreaseButton;

    @FindBy (xpath = "//button [@data-testid='structured-search-input-search-button']")
    public WebElement searchButton;

    @FindBy (xpath = "//section//div[contains(text(),'3 huéspedes')]")
    public WebElement sectionWithDateAndGuest;

    @FindBy (xpath = "//section//h1[contains(text(),'Budapest')]")
    public WebElement sectionWithPlace;


    @Test
    public void searchLodging() throws InterruptedException {
        //variables
        driver.get("https://airbnb.com");

        //Fechas
        String checkInDate = setActualDate();
        System.out.println(checkInDate);
        String checkOutDate = setOutDate();
        System.out.println(checkOutDate);

        String checkInDateXpath = "//*[@data-testid='datepicker-day-"+checkInDate+"']";
        String checkOutDateXpath = "//div[@data-testid='datepicker-day-"+checkOutDate+"']";

        //Inicio de script
        //Lugar
        Thread.sleep(2000);
        searchPlace.sendKeys("Budapest");
        Thread.sleep(2000);
        checkInSection.click();

        //Fechas de Check In y Check Out
        WebElement checkInCalendarDate = driver.findElement((By.xpath(checkInDateXpath)));
        checkInCalendarDate.click();
        Thread.sleep(1000);

        WebElement checkOutCalendarDate = driver.findElement(By.xpath(checkOutDateXpath));
        checkOutCalendarDate.click();

        //Cantidad de huespedes
        guestSection.click();
        adultIncreaseButton.click();
        adultIncreaseButton.click();
        childrenIncreaseButton.click();
        infantIncreaseButton.click();
        Thread.sleep(1000);
        searchButton.click();

        //Result Page
        //Variables para los Asserts
        String checkInDateForAssert = setActualDateForAssert();
        System.out.println(checkInDateForAssert);
        String checkOutDateforAssert = setOutDateForAssert();
        System.out.println(checkOutDateforAssert);

        Assert.assertTrue(sectionWithDateAndGuest.getText().contains("3 huéspedes"),"No contiene la cantidad de huespedes o no se encontro la sección");
        Assert.assertTrue(sectionWithDateAndGuest.getText().contains(checkInDateForAssert),"Las fechas de check in no coinciden");
        Assert.assertTrue(sectionWithDateAndGuest.getText().contains(checkOutDateforAssert),"Las fechas de check out no coinciden");


        Assert.assertTrue(sectionWithPlace.getText().contains("Budapest"),"La ciudad no coincide");

    }

    public static String setActualDate(){

        Date date = new Date();
        System.out.println(date);
        String formatActualDate = formatDateYYYYMMDD(date);
        return formatActualDate;

    }

    public static String setOutDate(){
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, 10);
        String formatCheckOutDate = formatDateYYYYMMDD(calendar.getTime());
        return formatCheckOutDate;

    }

    public static String setActualDateForAssert(){

        Date date = new Date();
        System.out.println(date);
        String formatActualDate = formatDateDDMON(date);
        return formatActualDate;

    }

    public static String setOutDateForAssert(){
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, 10);
        String formatCheckOutDate = formatDateDDMON(calendar.getTime());
        return formatCheckOutDate;

    }

    public static String formatDateYYYYMMDD (Date date){

        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");

        return sdf.format(date);
    }

    public static String formatDateDDMON (Date date){

        SimpleDateFormat sdf = new SimpleDateFormat("d MMM");

        return sdf.format(date);

    }
}
