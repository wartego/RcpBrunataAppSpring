package pl.brunata.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.brunata.entity.LoginAndPasword;
import pl.brunata.entity.TypeEnum;
import pl.brunata.service.LoginActionService;

@RequiredArgsConstructor
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")

public class RestController {

    private final LoginActionService loginActionService;
    @PostMapping("/login")
    void loginAction(@RequestBody LoginAndPasword loginAndPasword){
        if(loginAndPasword.getTypeEnum() == TypeEnum.LOGIN){
            loginActionService.startWorkTime(loginAndPasword);
        } else {
            loginActionService.stopWorkTime(loginAndPasword);
        }
    }


}
