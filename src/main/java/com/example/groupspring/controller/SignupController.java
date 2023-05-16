package peter.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peter.student.model.Signup;
import peter.student.services.SignupInterface;
import peter.student.controller.StudentController;
@Controller

public class SignupController {
    @Autowired
    SignupInterface signupInterface;

//     @RequestMapping(method = RequestMethod.GET)
//     @GetMapping("/login-page")
//     public String home(Model model){
//         Signup signup=new Signup();
//         model.addAttribute("login",signup);
//         return "login";
//     }

    @GetMapping("/login-page")
    public String homepage(Model model){
        Signup signup=new Signup();
        model.addAttribute("login",signup);
       return "login";
    }

    @GetMapping("/Signup")
    public String registration(Model model){
        Signup signup=new Signup();
        model.addAttribute("signup",signup);
        return "Signup";
    }
@PostMapping("/registerAccount")
    public String saveAccount(@ModelAttribute("signup") Signup theSignup ) {
    Signup signup = signupInterface.saveAccount(theSignup);
    if (signup != null) {
        return "redirect:/login-page";
    } else {
        return "Signup";
    }
}

    @PostMapping("/authentication")
    public String userAuthentication(@RequestParam String email,@RequestParam String password){
          signupInterface.userCheck(email,password);
        if (signupInterface.userCheck(email,password)){
            return "redirect:/registration";
        }else {
            return "redirect:/login-page";
        }

    }

}
