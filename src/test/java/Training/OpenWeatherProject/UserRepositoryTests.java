//package Training.OpenWeatherProject;
//
//import Training.OpenWeatherProject.entity.User;
//import Training.OpenWeatherProject.repositories.UserRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.annotation.Rollback;
//import static org.assertj.core.api.Assertions.assertThat;
//
//
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Rollback(false)
//public class UserRepositoryTests {
//    @Autowired
//    private UserRepository repo;
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Test
//    public void testCreateUser(){
//        User user = new User();
//        user.setEmail("admin@root.com");
//        user.setPassword("root");
//        user.setFirstName("admin");
//        user.setLastName("user");
//        user.setLat("35");
//        user.setLon("135");
//        user.setLocationName("Osaka, Japan");
//        user.setTemperature(1);
//        user.setWindSpeed(1);
//        user.setPressure(1);
//        user.setPrecipitation(1);
//        user.setDistance(1);
//        user.setTimeFormat(1);
//
//        User saveUser = repo.save(user);
//
//        User existUser = entityManager.find(User.class, saveUser.getId());
//
//        assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
//    }
//
//    @Test
//    public void testFindUserByEmail() {
//        String email = "hieunv@rikkeisoft.com";
//        User user = repo.findByEmail(email);
//
//        assertThat(user).isNotNull();
//    }
//
////    @Test
////    public void testWeatherAPI() {
////        UriComponents uriComponents = UriComponentsBuilder.newInstance()
////                .scheme("http").host("api.openweathermap.org/data/2.5/weather")
////                .path("").query("q={keyword}&appid={appid}").buildAndExpand("chicago","2a12b287f90d0e8e86a4b1a47cb4523c");
////        System.out.println(uriComponents);
////
////    }
//}
