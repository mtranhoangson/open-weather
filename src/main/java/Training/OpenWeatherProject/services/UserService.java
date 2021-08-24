package Training.OpenWeatherProject.services;

import Training.OpenWeatherProject.entity.User;
import Training.OpenWeatherProject.models.CustomUserDetails;
import Training.OpenWeatherProject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.text.MessageFormat;

public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(MessageFormat.format("User with email {0} cannot be found.", email));
        } else {
            return new CustomUserDetails(user);
        }
    }
}
