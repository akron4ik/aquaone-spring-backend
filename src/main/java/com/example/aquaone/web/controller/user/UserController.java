package com.example.aquaone.web.controller.user;

import com.example.aquaone.LoggedUser;
import com.example.aquaone.View;
import com.example.aquaone.to.UserTo;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/user")
public class UserController extends AbstractUserController {

    @GetMapping
    public UserTo getCurrentUser(@AuthenticationPrincipal LoggedUser loggedUser) {
        UserTo userTo = loggedUser.getUserTo();
        return userTo;
    }

    @PutMapping
    public UserTo updateProfile(@Validated(View.Web.class) @RequestBody UserTo userTo,
                                @AuthenticationPrincipal LoggedUser loggedUser) {
        super.update(userTo, loggedUser.id());
        loggedUser.update(userTo);
        return loggedUser.getUserTo();
    }
}