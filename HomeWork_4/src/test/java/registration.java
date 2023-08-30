import Utils.ChromeRunner;
import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class registration extends ChromeRunner {
    @Test
    public void methodone(){
        $(byText("რეგისტრაცია")).click();
        $(byText("სწრაფი რეგისტრაცია")).shouldBe(Condition.visible);
        $("#firstName").setValue("Irina").shouldNot(Condition.empty);
        $("#lastName").setValue("Lursmanashvili").shouldNot(Condition.empty);
        $("#email").setValue("Irina.lursmanashvili.1@gmail.com").shouldNot(Condition.empty);
        $("#password").setValue("Irina0101").shouldNot(Condition.empty);
        $("#confirmPassword").setValue("Irina0101").shouldNot(Condition.empty);
        $("#singup").shouldBe(Condition.enabled);
        sleep(3000);
    }

    @Test
    public void methodtwo() {
        $(byText("რეგისტრაცია")).click();
        $(byText("სწრაფი რეგისტრაცია")).shouldBe(Condition.visible);
        $("#singup").shouldBe(Condition.disabled);
        $("#firstName").click();
        $("#lastName").click();
        $(".text-danger").shouldBe(Condition.visible);
        $("#lastName").click();
        $("#email").click();
        $(".text-danger", 1).shouldBe(Condition.visible);
        $("#email").setValue("Irina.ge").click();
        $(byText("ელ. ფოსტა სავალდებულოა")).shouldNotBe(Condition.disappear);
        $("#password").setValue("Irina").click();
        $(byText("პაროლი სავალდებულოა.")).shouldNotBe(Condition.disappear);
        $("#confirmPassword").setValue("Testing");
        $(byText("პაროლის გამეორება სავალდებულოა")).shouldNotBe(Condition.disappear);
        sleep(3000);
    }
}
