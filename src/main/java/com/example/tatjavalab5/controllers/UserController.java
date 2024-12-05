package com.example.tatjavalab5.controllers;

import com.example.tatjavalab5.data.User;
import com.example.tatjavalab5.serivce.EstateService;
import com.example.tatjavalab5.serivce.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @PostMapping("/add")
    public String add(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String birthday,
            @RequestParam(required = false) String pid) {

        userService.addUser(new User(name, email, password, birthday, pid, 0.0));
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String editForm(@RequestParam Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "edit-user";
    }

    @PostMapping("/edit")
    public String edit(
            @RequestParam Long id,
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String birthday,
            @RequestParam(required = false) String pid,
            @RequestParam Double balance) {

        User updatedUser = userService.getUserById(id);
        updatedUser.setName(name);
        updatedUser.setMail(email);
        updatedUser.setPassword(password);
        updatedUser.setBirthday(LocalDate.parse(birthday));
        updatedUser.setPid(Integer.parseInt(pid));
        updatedUser.setBalance(balance);
        userService.updateUser(updatedUser);
        return "redirect:/users";
    }
}
