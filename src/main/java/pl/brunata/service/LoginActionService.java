package pl.brunata.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;
import pl.brunata.entity.LoginAndPasword;

@Service
public class LoginActionService {

    private LoginAndPasword loginAndPasword;

    public String loginAction(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://rcp.brunata-zenner.pl/");
        driver.manage().window().maximize();

        WebElement element = driver.findElement(By.xpath("//*[@id=\"LogOnButton\"]/div"));
        element.click();

        WebElement loginField = driver.findElement(By.xpath("//*[@id=\"UserName\"]"));
        loginField.sendKeys(loginAndPasword.getLogin());
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"Password\"]"));
        passwordField.sendKeys(loginAndPasword.getPassword());

        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"AccountLogOn\"]/fieldset/p/input"));
        submitButton.click();

        WebElement employeeData = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[1]"));
        employeeData.click();

        WebElement table = driver.findElement(By.xpath("//*[@id=\"beginEndPartial\"]"));

        String text = table.getText();

        System.out.println(text);
        driver.close();
        return text;
    }

    public String startWorkTime(LoginAndPasword loginAndPasword){
        this.loginAndPasword = loginAndPasword;
        return loginAction();
        //

    }


    public String stopWorkTime(LoginAndPasword loginAndPasword){
        this.loginAndPasword = loginAndPasword;
        return loginAction();
        //
    }
}
