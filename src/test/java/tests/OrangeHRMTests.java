package tests;

import java.util.Map;

import annotation.FrameworkAnnotation;
import enums.CategoryType;
import org.assertj.core.api.Assertions;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pages.OrangeHRMLoginPage;


public final class OrangeHRMTests extends BaseTest {


    private OrangeHRMTests() {}


    @Test
    @FrameworkAnnotation(author= {"Amuthan","Sachin"},
            category = {CategoryType.REGRESSION})
    public void loginLogoutTest(Map<String,String> data) {

        String title = new OrangeHRMLoginPage()
                .enterUserName(data.get("username")).enterPassWord(data.get("password")).clickLogin()
                .clickWelcome().clickLogout()
                .getTitle();
        Assertions.assertThat(title)
                .isEqualTo("OrangeHRM123");

    }

    @Test
    public void newTest(Map<String,String> data) {
        String title = new OrangeHRMLoginPage()
                .enterUserName(data.get("username")).enterPassWord(data.get("password")).clickLogin()
                .clickWelcome().clickLogout()
                .getTitle();
        throw new SkipException("skip");
		/*Assertions.assertThat(title)
			.isEqualTo("OrangeHRM");*/

    }
















}
