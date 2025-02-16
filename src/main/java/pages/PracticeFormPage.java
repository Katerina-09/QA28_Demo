package pages;

import dto.Student;
import enums.Gender;
import enums.Hobbies;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PracticeFormPage extends BasePage {
    public PracticeFormPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver
                , 10), this);
    }

    //@FindBy(xpath = "//input[@id='firstName']")
    @FindBy(id = "firstName")
    WebElement fieldName;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement fieldLastName;
    @FindBy(id = "userEmail")
    WebElement fieldEmail;
    @FindBy(xpath = "//input[@placeholder='Mobile Number']")
    WebElement fieldMobile;
    @FindBy(id = "dateOfBirthInput")
    WebElement fieldDateOfBirth;
    @FindBy(id = "currentAddress")
    WebElement fieldAddress;
    @FindBy(xpath = "//input[@id='subjectsInput']")
    WebElement fieldSubject;

    public void typePracticeForm(Student student) {
        hideBanner();
        hideFooter();
        fieldName.sendKeys(student.getName());
        fieldLastName.sendKeys(student.getLastName());
        fieldEmail.sendKeys(student.getEmail());
        typeGender(student.getGender());
        fieldMobile.sendKeys(student.getMobile());
        //fieldDateOfBirth.sendKeys(student.getDateOfBirth());
        typeDateOfBirth(student.getDateOfBirth());
        typeSubjects(student.getSubject());
        typeHobbies(student.getHobbies());
        fieldAddress.sendKeys(student.getAddress());
    }

    private void typeDateOfBirth(String dateOfBirth) {
        fieldDateOfBirth.click();
        String operationSystem = System.getProperty("os.name");
        System.out.println(operationSystem);
        if (operationSystem.startsWith("Win"))
            fieldDateOfBirth.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        else if (operationSystem.startsWith("Mac"))
            fieldDateOfBirth.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        fieldDateOfBirth.sendKeys(dateOfBirth);
        fieldDateOfBirth.sendKeys(Keys.ENTER);
    }

    private void typeGender(Gender gender) {
        WebElement btnGender = driver.findElement(By.xpath(gender.getLocator()));
        btnGender.click();
    }

    private void typeSubjects(String subjects) {
        fieldSubject.click();
        String[] arr = subjects.split(",");
        for (String s : arr) {
            fieldSubject.sendKeys(s);
            fieldSubject.sendKeys(Keys.ENTER);
        }
    }

    private void typeHobbies(List<Hobbies> hobbies) {
        for (Hobbies h : hobbies) {
            switch (h) {
                case MUSIC:
                    driver.findElement(By.xpath(h.getLocator())).click();
                    break;
                case SPORTS:
                    driver.findElement(By.xpath(h.getLocator())).click();
                    break;
                case READING:
                    driver.findElement(By.xpath(h.getLocator())).click();
                    break;
            }
        }
    }
}
