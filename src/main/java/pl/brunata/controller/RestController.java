package pl.brunata.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.brunata.entity.LoginAndPasword;
import pl.brunata.entity.TypeEnum;
import pl.brunata.service.LoginActionService;

@RequiredArgsConstructor
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")

public class RestController {

    private final LoginActionService loginActionService;


    @PostMapping("/login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    public String loginAction(@RequestBody LoginAndPasword loginAndPasword){

        if(loginAndPasword.getTypeEnum() == TypeEnum.LOGIN){
            return loginActionService.startWorkTime(loginAndPasword);
        } else {
            return loginActionService.stopWorkTime(loginAndPasword);
        }
    }

    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String check(){
        return "HiHI";
    }


}
