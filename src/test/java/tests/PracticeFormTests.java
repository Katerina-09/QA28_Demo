package tests;

import dto.Student;
import manager.AppManager;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

public class PracticeFormTests extends AppManager {


    @Test
    public void studentRegFormPositiveTest(){
        Student student = new Student("Pablo", "Poblito",
                "pablo@meas.com", "male", "0123456789",
                "12 Nov 2001", "Maths,Physiccs,Chemistry",
                "sport", "", "street 1",
                "NCR", "Delhi");
        new HomePage(getDriver()).clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        new PracticeFormPage(getDriver()).typePracticeForm(student);
    }
}