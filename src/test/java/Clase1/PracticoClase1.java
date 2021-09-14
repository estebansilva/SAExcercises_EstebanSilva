package Clase1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//Consultas

/*
1- Porque usan driver.get() en vez de driver.navigate()
2- En el ejercico 5 no logro que me tome las siguientes funciones //*[text()='Inicia sesión']
lo maximo que pude llegar a acotar es de la siguiente manera //span[@class='bui-button__text' and contains(text(),'Inicia sesión')]
Encontre otra forma que trae solo uno pero me quedan dudas //* [@class='bui-button__text' and normalize-space()='Inicia sesión']
3- Al ingresar al sitio observe que me cambia el país y los textos son distintos, hay alguna forma de considerar esto cuando armamos los scripts?? (Comparando por el origen pais)
4- Ej5: ¿Si realizo el Assert donde no se encuentra el botón antes, es necesario hacer el trycatch cuando hacemos el click en el botón?
5- Ejercicios de Get Attribute, si realizo (eachdiv.getAttribute("id") != null) recupera todos los div y usando "" recupera los 5. ¿Porque?
6- Ejercicio get attribute trae el siguiente <img class="header-aux-image" src="https://mundomac.com/wp-content/themes/electro-child/assets/img/cabezal.png">
que no tiene el atributo ALT  66 Vs 65 en la página
//https://stackoverflow.com/questions/6828362/difference-between-string-isempty-and-string-equals/6828386
7- Ver el comentario en ejercicioprofesor
 */





public class PracticoClase1 {

    public WebDriver driver;

    @BeforeMethod
    public void setup(){

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void ejercicio1A(){

        driver.get("https://www.facebook.com");
        //WebElement fakeElement = driver.findElement(By.className("qqqqqq"));
        // Esta búsqueda va a fallar dado que el className no existe.
    }
    @Test
    public void ejercicio1B(){

        driver.get("https://www.facebook.com");
        List<WebElement> fakeList = driver.findElements(By.className("qqqqqq"));
        //El metodo no falla dado que no encuentra ningún elemento pero la lista queda con el valor Null
        //Para mejorar la calidad del test se puede agregar Asserts que validen si la lista tiene contenido.
        //Para detectar si la lista esta vacia se puede usar el método isEmpty (fakeList.isEmpty) o preguntar por el tamaño (fakeList.size())
    }

    @Test
    public void ejercicio2(){

        driver.get("https://www.facebook.com");
        List<WebElement> listH112 = driver.findElements((By.tagName("h112")));
        //Esto no arroja excepción dado que queda en null
        Assert.assertFalse(listH112.isEmpty(),"La lista esta vacía");
    }

    @Test
    public void ejercicio3(){

        driver.get("https://www.facebook.com");
        List<WebElement> listH1 = driver.findElements(By.tagName("h1"));
        Assert.assertFalse(listH1.isEmpty(), "La lista esta vacía");

    }

    @Test
    public void ejercicio4(){

        driver.get("https://www.booking.com");
        List<WebElement> h2List = driver.findElements(By.tagName("h2"));
        Assert.assertTrue(h2List.isEmpty()==false, "La lista esta vacia");

        Boolean findFlag = false;

        for (WebElement elementH2 : h2List) {
            System.out.println("--->" + elementH2.getText());
            if (elementH2.getText().equals("Conecta con gente viajera")){//(elementH2.getText()=="Conecta con gente viajera")
                findFlag = true;
                break;
            }
        }

        Assert.assertTrue(findFlag,"El h2 con el texto conecta con gente viajera no se encuentra en el sitio");
    }

    @Test
    public void ejercicio5(){
        //Variables
        WebElement iniciarSesionBtn;
        String txtBtn = "Iniciar sesión";

        driver.get("https://www.booking.com");
        iniciarSesionBtn = SearchLgnBtn(txtBtn);


        try {
            iniciarSesionBtn.click();

        }catch (Exception e) {
            Assert.assertTrue(false, "El botón no se ha encontrado en el sitio");
        }


    }
    //Respuestas ejercicio 5.
    //El test se hace fallar mediante un assert que valide las condiciones.
    // Va a fallar porque no va encontrar el botón. Se puede verificar agregando nuevamente iniciarSesionBtn.click(); debajo del mismo

    @Test
    public void ejercicio6(){
       //Ver clase WebDriverUtilities
    }

    @Test
    public void ejercicio7(){

        WebDriverUtilities utilitiesDriver = new WebDriverUtilities();
        String className = "NombreClase";

        List<WebElement> finalList = utilitiesDriver.searchElementsByClassnName(driver, className);

    }

    @Test
    public void ejercicioBusquedasAnidadas1(){

       driver.get("https://netflix.com");
       List<WebElement>  formsList = driver.findElements(By.tagName("form"));

       Assert.assertFalse(formsList.isEmpty(), "No existen forms en la página");

       for (WebElement eachform : formsList){
           System.out.println("Form ---> " + eachform.getAttribute("class"));

           List<WebElement> listH3 = eachform.findElements(By.tagName("h3"));

            for (WebElement eachList : listH3){
                System.out.println("H3 ---->" + eachList.getText());
            }
       }
    }



    @Test
    public void ejercicioBusquedasAnidadas2(){

        driver.get("https://www.apple.com");

        List<WebElement> divList = driver.findElements(By.tagName("div"));
        Assert.assertFalse(divList.isEmpty(), "La lista de DIV esta vacía");

        int divsWithId = 0;

        for (WebElement eachdiv : divList){

            if (eachdiv.getAttribute("id") != ""){
                System.out.println(eachdiv.getAttribute("id"));
                divsWithId ++;
            }
        }

        System.out.println("La cantidad de div con ID es" + " " + divsWithId);
    }

    @Test
    public void ejercicioBusquedasAnidadas3(){
        int divCount= 1;

        driver.get("https://www.bbc.com");

        List<WebElement> divList = driver.findElements(By.tagName("div"));
        Assert.assertFalse(divList.isEmpty(), "La lista de DIV esta vacía");

        for (WebElement eachDiv : divList){

            List<WebElement> paragraphList = eachDiv.findElements(By.tagName("p"));
            System.out.println("Div number " + divCount + " " + eachDiv.getAttribute("id"));


            int paragraphCount = 1;
            for (WebElement eachParagraph : paragraphList){
                System.out.println("In div " +divCount +" Paragraph " + paragraphCount + " Texto: " + eachParagraph.getText());
                paragraphCount++;
            }
            divCount++;
        }
    }

    @Test
    public void ejercicioGetAttribute1(){

        driver.get("https://mundomac.com");

        List<WebElement> listImg = driver.findElements(By.tagName("img"));
        Assert.assertFalse(listImg.isEmpty(), "La lista esta vacia");
        int countAltWithOutText = 0;
        int countAltWithText = 0;
        for(WebElement eachImg : listImg){

            if (eachImg.getAttribute("alt") != "" ){
                System.out.println(eachImg.getAttribute("alt"));
                countAltWithText++;
                //eachImg.getAttribute("alt") == ""
                //eachImg.getAttribute("alt").isEmpty()== true

            }else { countAltWithOutText++;}

        }
        System.out.println("La cantidad de IMG con texto son "+ countAltWithText);
        System.out.println("La cantidad de IMG sin texto alternativo son " + countAltWithOutText);
        //driver.close();
    }

    @Test
    public void ejercicioGetAttribute2(){

        driver.get("https://mundomac.com");
        boolean sameClassName = true;
        List<WebElement> listBtn = driver.findElements(By.tagName("button"));
        Assert.assertFalse(listBtn.isEmpty(), "La lista de botones esta vacía");

        for (WebElement eachBtn : listBtn){

            if(eachBtn.getAttribute("class") == "btn btn-default"){

            }else{
                sameClassName=false;
                break;
            }
        }

        Assert.assertTrue(sameClassName, "Los botones no tienen la misma clase");

    }

    @Test
    public void ejercicioGetAttribute3() {
        //Tampoco me da lo mismo que hacer en el sitio //li//a recupera 510
        driver.get("https://mundomac.com");
        int linkCount = 0;

        List<WebElement> listOfLi = driver.findElements(By.tagName("li"));

        for (WebElement eachLi : listOfLi) {

            List<WebElement> aList = eachLi.findElements(By.tagName("a"));

            for (WebElement eachA : aList) {
                try {
                    if (eachA.getAttribute("href").isEmpty()) {

                    }else {
                        System.out.println("----> " + eachA.getAttribute("href"));
                        linkCount++;
                    }
                } catch(Exception e) {
                    System.out.println("---> no hay href");
                    linkCount++;}

            }
        }
        System.out.println(linkCount);
        driver.close();
    }

    /*@Test
    public void ejercicioprofe(){

        //En esta resolución solo recupera los Li que estén dentro de los UL y además solo el primer tag A de las li.¿Esta bien?
        driver.get("https://mundomac.com");

        List<WebElement> ulList = driver.findElements(By.tagName("ul"));
        int cont = 0;
        for (WebElement ul : ulList){
            List<WebElement>  lis = ul.findElements(By.tagName("li"));

            for (WebElement li : lis){
                try {
                    WebElement link = li.findElement(By.tagName("a"));
                    System.out.println(link.getAttribute("href"));

                }catch (Exception e){
                    System.out.println("Elemento sin href");
                    cont++;
                }
            }
        }
        System.out.println(cont);
    }*/

    @Test
    public void ejercicioGetAttribute4(){

        driver.get("https://mundomac.com");

        List<WebElement> imgList = driver.findElements(By.tagName("img"));
        List<WebElement> imgWithOutAlt = new ArrayList<>();
        List<WebElement> imgWithAlt = new ArrayList<>();
        int countImg = 0;
        for(WebElement eachImg : imgList){
            if(eachImg.getAttribute("alt").isEmpty()){
                System.out.println("No tiene alt, su src es " + eachImg.getAttribute("src"));
                imgWithOutAlt.add(eachImg);
                countImg++;
            }else{
                imgWithAlt.add(eachImg);
                System.out.println(eachImg.getAttribute("alt"));
                countImg++;
            }

            /*try{

                if(eachImg.getAttribute("alt").isEmpty()){

                }else{
                    imgWithAlt.add(eachImg);
                    System.out.println(eachImg.getAttribute("alt"));
                    countImg++;
                }

            }catch(Exception e){
                System.out.println("No tiene alt, su src es " + eachImg.getAttribute("src"));
                imgWithOutAlt.add(eachImg);

            }*/

        }
        System.out.println(countImg);
        driver.close();

    }


    //Metodos externos
    public WebElement SearchLgnBtn(String txtBtn) {

        List<WebElement> btnList = driver.findElements(By.className("bui-button__text"));

        for (WebElement btns : btnList){
            System.out.println("--->" + btns.getText());

            if(btns.getText().equals(txtBtn)){
                return(btns);
            }
        }
        return null;
    }


}
