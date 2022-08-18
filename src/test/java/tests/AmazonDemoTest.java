package tests;

import java.util.Map;

import annotation.FrameworkAnnotation;
import enums.CategoryType;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.AmazonHomePage;



public final class AmazonDemoTest extends BaseTest {


    private AmazonDemoTest() {}


    @Test
    @FrameworkAnnotation(author= {"Amuthan","Sachin"},
            category = {CategoryType.REGRESSION,CategoryType.MINIREGRESSION})
    public void amazonTest(Map<String,String> data) {

        String title =new AmazonHomePage().clickHamburger()
                .clickComputer()
                .clickOnSubMenuItem(data.get("menutext")).getTitle();
        Assertions.assertThat(title).isNotNull();
    }


}
