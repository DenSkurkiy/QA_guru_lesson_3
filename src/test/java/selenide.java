import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class selenide {

    @Test
    void ShootFineSelenide (){
        // Откройте страниц Selenide в Github
        Selenide.open("https://github.com/");
        $(By.name("q")).setValue("selenide").pressEnter();
        $(By.xpath("//*[@id=\"js-pjax-container\"]/div/div[3]/div/ul/li[1]/div[2]/div[1]/a")).click();
        // Перейдите в раздел Wiki проекта
        $(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[1]/nav/ul/li[5]/a")).click();
        //  Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $(By.id("wiki-pages-filter")).setValue("SoftAssertions").pressEnter();
        //$(By.className("Box-row"), 16).click();
        $(By.xpath("//*[@id=\"wiki-pages-box\"]/div/div[2]/ul/li[15]/strong/a")).click();
        // Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $(By.id("wiki-content")).shouldHave(text("JUnit5 extension"));


        Selenide.sleep(9000);

    }

    @Test
    void DragAndDrop(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        actions().moveToElement($("#column-a"))
                .clickAndHold()
                .moveToElement($("#column-b"),300,200).release().build().perform();

        $("#column-b").shouldHave(text("A"));
        $("#column-a").shouldHave(text("B"));

        Selenide.sleep(5000);


    }
}
