package pl.brunata.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class LoginAndPasword {

    private String login;
    private String password;
    private TypeEnum typeEnum;
}
