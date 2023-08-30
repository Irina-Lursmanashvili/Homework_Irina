import Utils.ChromeRunner;
import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class buyProduct extends ChromeRunner {
    @Test
    public void methodthree(){
        $(".btn-cart").click();
        $(byText("კალათა ცარიელია")).shouldBe(Condition.visible);
        $("#search_list").setValue("computer").pressEnter();
        $(".add_to_cart",0).click();
        sleep(5000);
        $(".cart-count").click();
        $(".items").click();
        sleep(4000);
        $(byText("კალათა ცარიელია")).shouldBe(Condition.visible);
        sleep(3000);
    }

    @Test
    public void methodfour(){
        $(".btn-cart").click();
        $(byText("კალათა ცარიელია")).shouldBe(Condition.visible);
        $(byText("შენახული ნივთები")).click();
        $(byText("ვერ მოიძებნა")).shouldBe(Condition.visible);
        $("#search_list").setValue("computer").pressEnter();
        $(".add_to_cart",0).click();
        sleep(3000);
        $(".cart-count").click();
        $(".redButton").click();
        sleep(3000);
        $(byText("ვერ მოიძებნა")).shouldNotBe(Condition.appear);
        $(".cart-count").click();
        sleep(3000);
        $(byText("კალათა ცარიელია")).shouldBe(Condition.visible);
        $(byText("შენახული ნივთები")).click();
        $(".btn_round").click();
        $(byText("ვერ მოიძებნა")).shouldBe(Condition.visible);
    }

}
