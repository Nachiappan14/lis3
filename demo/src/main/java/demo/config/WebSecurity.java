//package demo.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//
//@EnableWebSecurity
//public class WebSecurity extends WebSecurityConfigurerAdapter {
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//       http.cors().and().csrf().disable().authorizeRequests()
//        .antMatchers("/").permitAll()
//        .antMatchers("/api/adduser").permitAll()
////        .antMatchers(HttpMethod.POST, "/login").permitAll()
////        .antMatchers(HttpMethod.POST,"/newuser/*").permitAll()
////        .antMatchers(HttpMethod.GET,"/master/*").permitAll()
////         .antMatchers(HttpMethod.GET,"/exploreCourse").permitAll()
//        .anyRequest().authenticated();
//    }
//}