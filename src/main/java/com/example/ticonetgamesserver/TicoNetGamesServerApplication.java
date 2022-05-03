package com.example.ticonetgamesserver;


import com.example.ticonetgamesserver.Utilities.JWTAuthorizationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@ServletComponentScan
@EnableMongoRepositories(basePackages = {"com.example.ticonetgamesserver.Repositories"})
@SpringBootApplication()
public class TicoNetGamesServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicoNetGamesServerApplication.class, args);
    }
    @EnableWebSecurity
    @Configuration
    class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
                    .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                    .authorizeRequests()
                    .antMatchers(HttpMethod.POST, "/AuthenticationServer").permitAll()
                    .antMatchers(HttpMethod.POST,"/Users/CreateUser").permitAll()
                    .antMatchers(HttpMethod.GET,"/Users").authenticated()
                    .antMatchers(HttpMethod.PUT,"Users/UpdateUser").authenticated()
                    .antMatchers(HttpMethod.DELETE,"/Users/{id}").authenticated()
                    .antMatchers(HttpMethod.GET,"/Games").permitAll()
                    .antMatchers(HttpMethod.POST,"/Games/CreateGame").authenticated()
                    .antMatchers(HttpMethod.PUT,"/Games/UpdateGame").authenticated()
                    .antMatchers(HttpMethod.DELETE,"/Games/{id}").authenticated()
                    .antMatchers(HttpMethod.GET,"/Shoppings/GetShopCart").authenticated()
                    .antMatchers(HttpMethod.POST,"/Shoppings/CreateShop").authenticated()
                    .antMatchers(HttpMethod.PUT,"/Shoppings/UpdateShopCart").authenticated()
                    .antMatchers(HttpMethod.DELETE,"/Shoppings/{id}").authenticated()
                    .antMatchers(HttpMethod.GET,"/GamesLibraryService/GetGamesLibrary").permitAll()
                    .antMatchers(HttpMethod.POST,"/GamesLibraryService/CreateGameLibrary").authenticated()
                    .antMatchers(HttpMethod.DELETE,"/GamesLibraryService/{id}").authenticated()

                    .anyRequest().permitAll();
        }
    }
}
