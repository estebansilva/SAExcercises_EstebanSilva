package Clase2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

//Consultas:


public class PracticoClase2 {

    public WebDriver driver;

    @BeforeMethod

    public void setup(){

    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test

    public void searchLodging() throws InterruptedException {
        //variables
        driver.get("https://airbnb.com");

        //seteo de fechas

        String checkInDate = setActualDate();
        System.out.println(checkInDate);

        String checkOutDate = setOutDate();
        System.out.println(checkOutDate);



        String checkInDateXpath = "//*[@data-testid='datepicker-day-"+checkInDate+"']";
        String checkOutDateXpath = "//div[@data-testid='datepicker-day-"+checkOutDate+"']";

        //Inicio de script
        //Lugar
        Thread.sleep(1000);
        WebElement searchPlace = driver.findElement(By.xpath("//*[@placeholder = '¿A dónde vas?']"));
        searchPlace.sendKeys("Budapest");
        Thread.sleep(2000);
        //Fechas de Check In y Check Out
        WebElement checkInSection = driver.findElement(By.xpath("//*[@data-testid='structured-search-input-field-split-dates-0']"));
        checkInSection.click();


        WebElement checkInCalendarDate = driver.findElement((By.xpath(checkInDateXpath)));
        checkInCalendarDate.click();
        Thread.sleep(1000);

        /*WebElement checkOutSection = driver.findElement(By.xpath("//*[@data-testid='structured-search-input-field-split-dates-1']"));
        Thread.sleep(1000);
        checkOutSection.click();*/

        WebElement checkOutCalendarDate = driver.findElement(By.xpath(checkOutDateXpath));
        checkOutCalendarDate.click();

        //Cantidad de huespedes
        WebElement guestSection = driver.findElement(By.xpath("//*[@data-testid = 'structured-search-input-field-guests-button']"));
        guestSection.click();

        WebElement adultIncreaseButton = driver.findElement((By.xpath("//*[@data-testid='stepper-adults-increase-button']")));
        adultIncreaseButton.click();
        adultIncreaseButton.click();

        WebElement childrenIncreaseButton = driver.findElement(By.xpath("//*[@data-testid='stepper-children-increase-button']"));
        childrenIncreaseButton.click();

        WebElement infantIncreaseButton = driver.findElement((By.xpath("//*[@data-testid='stepper-infants-increase-button']")));
        infantIncreaseButton.click();
        Thread.sleep(1000);

        WebElement searchButton = driver.findElement(By.xpath("//button [@data-testid='structured-search-input-search-button']"));
        searchButton.click();


        WebElement sectionWithDateAndGuest = driver.findElement(By.xpath("//section//div[contains(text(),'3 huéspedes')]"));

        //Variables para los Asserts
        String checkInDateForAssert = setActualDateForAssert();
        System.out.println(checkInDateForAssert);

        String checkOutDateforAssert = setOutDateForAssert();
        System.out.println(checkOutDateforAssert);

        Assert.assertTrue(sectionWithDateAndGuest.getText().contains("3 huéspedes"),"No contiene la cantidad de huespedes o no se encontro la sección");

        Assert.assertTrue(sectionWithDateAndGuest.getText().contains(checkInDateForAssert),"Las fechas de check in no coinciden");
        Assert.assertTrue(sectionWithDateAndGuest.getText().contains(checkOutDateforAssert),"Las fechas de check out no coinciden");

        WebElement sectionWithDateAndGuest2 = driver.findElement(By.xpath("//section//h1[contains(text(),'Budapest')]"));
        Assert.assertTrue(sectionWithDateAndGuest2.getText().contains("Budapest"),"La ciudad no coincide");


       // driver.close();

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

