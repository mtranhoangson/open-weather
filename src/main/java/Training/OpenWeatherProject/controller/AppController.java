package Training.OpenWeatherProject.controller;

import Training.OpenWeatherProject.entity.User;
import Training.OpenWeatherProject.models.Units;
import Training.OpenWeatherProject.repositories.UserRepository;
import Training.OpenWeatherProject.services.HomePageService;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class AppController {

    @Autowired
    private UserRepository repo;
    @Autowired
    HomePageService homePageService;

    @GetMapping("/")
    public String viewHomePage(Model model){

        // Get current user information
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userMail = auth.getName();
        User user = repo.findByEmail(userMail);

        // Update current user information
        if (user.getLat() == null) {
            user.setLat("35");
        }
        if (user.getLon() == null) {
            user.setLon("135");
        }
        if (user.getLocationName() == null) {
            user.setLocationName("Osaka");
        }
        if (user.getTemperature() == null) {
            user.setTemperature(1);
        }
        if (user.getWindSpeed() == null) {
            user.setWindSpeed(1);
        }
        if (user.getPressure() == null) {
            user.setPressure(1);
        }
        if (user.getPrecipitation() == null) {
            user.setPrecipitation(1);
        }
        if (user.getDistance() == null) {
            user.setDistance(1);
        }
        if (user.getTimeFormat() == null) {
            user.setTimeFormat(1);
        }
        repo.save(user);

        homePageService.process(model, user);

        Units units = new Units();
        model.addAttribute("units", units);

        model.addAttribute("currentUser", user);

        return "index";
    }

    @RequestMapping(value = "/searchLocation", method=RequestMethod.POST)
    public String searchLocation(
            @ModelAttribute(value="currentUser") User user,
            Model model
    ) {
        // Get current user information
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userMail = auth.getName();
        User saveUser = repo.findByEmail(userMail);
        saveUser.setLocationName(user.getLocationName());
        repo.save(saveUser);

        homePageService.process(model, user);
        model.addAttribute("currentUser", user);

        Units units = new Units();
        model.addAttribute("units", units);

        return "index";
    }

    @RequestMapping(value="/setting")
    public String settingPage(
            Model model,
            @ModelAttribute(value="currentUser") User user
    ) {
        Units units = new Units();
        model.addAttribute("units", units);

        model.addAttribute("currentUser", user);
        return "setting";
    }

    @RequestMapping(value = "/back", method=RequestMethod.POST)
    public String back(
        Model model,
        @ModelAttribute(value="currentUser") User user
    ) {
        Units units = new Units();
        model.addAttribute("units", units);

        // Get current user information
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userMail = auth.getName();
        User saveUser = repo.findByEmail(userMail);

        // Save setting information
        saveUser.setLon(user.getLon());
        saveUser.setLat(user.getLat());
        saveUser.setLocationName(user.getLocationName());
        saveUser.setTemperature(user.getTemperature());
        saveUser.setWindSpeed(user.getWindSpeed());
        saveUser.setPressure(user.getPressure());
        saveUser.setPrecipitation(user.getPrecipitation());
        saveUser.setDistance(user.getDistance());
        saveUser.setTimeFormat(user.getTimeFormat());
        repo.save(saveUser);

        homePageService.process(model, user);
        model.addAttribute("currentUser", user);

        return "index";
    }

    @GetMapping("/login")
    public String viewLoginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String showSignUpForm(Model model){
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/process_register")
    public String processRegistration(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        repo.save(user);
        return "register_success";
    }

    @GetMapping("/list_users")
    public String viewUserList(Model model) {
        List<User> listUsers = repo.findAll();
        model.addAttribute("listUsers", listUsers);
        return "users";
    }

}
