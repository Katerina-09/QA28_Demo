package experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Exceptions {
    public static void main(String[] args) {
        String[]strArray = {"str1", "str2", "str3"};
       // System.out.println(strArray[2]);
        uncheckedExceptions(strArray);
        try {
            pause();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private static void uncheckedExceptions(String[]strArray){
        try {


            for (int i = 0; i < 5; i++) {
                System.out.println(strArray[i]);
            }
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            System.out.println("created exception");
        }
        System.out.println("ok");
    }
    private static void pause() throws InterruptedException {
        checkedException();
        System.out.println("pause 3 sec");
    }

    private static void checkedException() throws InterruptedException {
        Thread.sleep(3000);
    }
    WebDriver driver = new ChromeDriver();
    @Test
    public void selectorsHomePage(){
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        hideBanner();
        hideFooter();
        WebElement imgTools = driver.findElement(
                By.cssSelector("img[src='/images/Toolsqa.jpg']"));
        System.out.println(imgTools.getTagName());

        WebElement divElements = driver.findElement(
                By.cssSelector("div[class='avatar mx-auto white']"));
        divElements.click();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    @Test
    public void selectorsElementsPage(){
        driver.get("https://demoqa.com/elements");
        driver.manage().window().maximize();
        hideBanner();
        WebElement texBox = driver.findElement(By.id("item-0"));
        System.out.println(texBox.getAttribute("class"));
        WebElement checkBox = driver.findElement(By.cssSelector("li[id='item-1']"));
        checkBox.click();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    @Test
    public void selectorsRadioButtonPage(){
        driver.get("https://demoqa.com/radio-button");
        driver.manage().window().maximize();
        hideBanner();
        hideFooter();
        //WebElement radioButtonYes = driver.findElement(By.cssSelector("label[for='yesRadio']"));
        WebElement radioButtonYes = driver
                .findElement(By.xpath("//label[@for='yesRadio']"));
        radioButtonYes.click();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }

    private void hideBanner(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('#fixedban').style.display='none'");
    }
    private void hideFooter(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('footer').style.display='none'");
    }
}
