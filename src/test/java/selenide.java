import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class selenide {

    @Test
    void ShootFineSelenide (){
        open("https://github.com/");
        $(By.name("q")).setValue("selenide").pressEnter();
        $("#js-pjax-container > div > div.col-12.col-md-9.float-left.px-2.pt-3.pt-md-0.codesearch-results > div > ul > li:nth-child(1)").shouldHave(Condition.text("selenide"));
    }
}
