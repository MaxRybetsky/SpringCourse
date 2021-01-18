package com.max.controller;

import com.max.model.User;
import com.max.model.UserProfile;
import com.max.service.UserProfileService;
import com.max.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AppController {
    private UserService userService;

    private UserProfileService userProfileService;

    private MessageSource messageSource;

    @Autowired
    public AppController(UserService userService, UserProfileService userProfileService,
                         MessageSource messageSource) {
        this.userService = userService;
        this.userProfileService = userProfileService;
        this.messageSource = messageSource;
    }

    /**
     * This method will list all existing users.
     */
    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String listUsers(Model model) {
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "userlist";
    }

    /**
     * This method will provide the medium to add a new user.
     */
    @RequestMapping(value = "/newuser", method = RequestMethod.GET)
    public String newUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("edit", false);
        return "registration";
    }

    @RequestMapping(value = "/newuser", method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result,
                           Model model) {
        if (result.hasErrors()) {
            return "registration";
        }
        if (!userService.isUserSSOUnique(user.getId(), user.getSsoId())) {
            FieldError ssoError =
                    new FieldError("user", "ssoId",
                            messageSource.getMessage("non.unique.ssoId",
                                    new String[]{user.getSsoId()}, Locale.US));
            result.addError(ssoError);
            return "registration";
        }
        userService.saveUser(user);
        model.addAttribute("success", "User " + user.getFirstName() + " "
                + user.getSecondName() + " registered successfully");
        return "registrationsucess";
    }

    /**
     * This method will provide the medium to update an existing user.
     */
    @RequestMapping(value = {"/edit-user-{ssoId}"}, method = RequestMethod.GET)
    public String editUser(@PathVariable String ssoId, Model model) {
        User user = userService.findBySSO(ssoId);
        model.addAttribute("user", user);
        model.addAttribute("edit", true);
        return "registration";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * updating user in database. It also validates the user input
     */
    @RequestMapping(value = {"/edit-user-{ssoId}"}, method = RequestMethod.POST)
    public String updateUser(@PathVariable String ssoId, Model model,
                             @Valid User user, BindingResult result) {
        if(result.hasErrors()) {
            return "registration";
        }
        if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())) {
            FieldError ssoError = new FieldError("user", "ssoId",
                    messageSource.getMessage("non.unique.ssoId",
                            new String[] {user.getSsoId()}, Locale.US));
            result.addError(ssoError);
            return "registration";
        }
        userService.saveUser(user);
        model.addAttribute("success", "User " + user.getFirstName() + " "
                + user.getSecondName() + " updated successfully");
        return "registrationsucess";
    }

    /**
     * This method will delete an user by it's SSOID value.
     */
    @RequestMapping(value={"/delete-user-{ssoId}"}, method = RequestMethod.GET)
    public String deleteUser(@PathVariable String ssoId) {
        userService.deleteUserBySSO(ssoId);
        return "redirect:/list";
    }

    /**
     * This method will provide UserProfile list to views
     */
    @ModelAttribute("role")
    public List<UserProfile> initializeProfiles() {
        return userProfileService.findAll();
    }
}
