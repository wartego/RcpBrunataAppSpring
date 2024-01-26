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

    public void loginAction(){


        WebDriver driver = new ChromeDriver();
        driver.get("https://rcp.brunata-zenner.pl/");
        driver.manage().window().maximize();
        System.out.println("Hello world!");

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
    }

    public void startWorkTime(LoginAndPasword loginAndPasword){
        this.loginAndPasword = loginAndPasword;
        loginAction();
        //

    }


    public void stopWorkTime(LoginAndPasword loginAndPasword){
        this.loginAndPasword = loginAndPasword;
        loginAction();
        //

    }
}
