package com.inchessFitness.webApp.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {


    @Bean
    SecurityFilterChain defaultSecurityChain(HttpSecurity httpSecurity) throws Exception {


        httpSecurity.csrf((csrf) -> csrf.ignoringRequestMatchers("/saveMsg"))
                .authorizeHttpRequests((requests) ->{
            ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.requestMatchers("/","/index","/home")).denyAll();
            ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.requestMatchers("/services")).permitAll();
            ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.requestMatchers("/about-us")).permitAll();
            ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.requestMatchers("/class-details")).permitAll();
            ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.requestMatchers("/login/**")).permitAll();
            ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.requestMatchers("/assest/**")).permitAll();
            ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.requestMatchers("/displayDashboard/**")).authenticated();
            ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.requestMatchers("/contact/**")).permitAll();
            ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.requestMatchers("/saveMsg")).permitAll();
            ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.requestMatchers("/displayEnquiry/**")).permitAll();
            ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.requestMatchers("/displayTrainers/**")).permitAll();
            ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.requestMatchers("/addTrainers/**")).permitAll();
            ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.requestMatchers("/createTrainers/**")).permitAll();
            ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.requestMatchers("/displayClients/**")).permitAll();
            ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.requestMatchers("/addClients/**")).permitAll();
            ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.requestMatchers("/createClients/**")).permitAll();
            ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.requestMatchers("/displayRevenue/**")).permitAll();
            ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.requestMatchers("/deleteEnquiry/**")).permitAll();
            ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.requestMatchers("/deleteClients/**")).permitAll();
            ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.requestMatchers("/addClient/**")).permitAll();
            ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.requestMatchers("/createPopulatedClients/**")).permitAll();
            ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.requestMatchers("/team/**")).permitAll();
            ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.requestMatchers("/deleteTrainers/**")).permitAll();
            ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.requestMatchers("/generatePdf/**")).permitAll();
            ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.requestMatchers("/bmi/**")).permitAll();
            ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.requestMatchers("/generate/document/**")).permitAll();
            ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.requestMatchers("/calculateBmi/**")).permitAll();
            ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.requestMatchers("/bmr/**")).permitAll();
            ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.requestMatchers("/calculateBmr/**")).permitAll();
            ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.requestMatchers("/api/**")).permitAll();
            ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.requestMatchers("/trainers/**")).permitAll();



        });

        httpSecurity.csrf((csrf) -> csrf.ignoringRequestMatchers("/calculateBmi"));
        httpSecurity.csrf((csrf) -> csrf.ignoringRequestMatchers("/calculateBmr"));
        httpSecurity.csrf((csrf) -> csrf.ignoringRequestMatchers("/api"));
        httpSecurity.csrf((csrf) -> csrf.ignoringRequestMatchers("/createTrainers"));
        httpSecurity.csrf((csrf) -> csrf.ignoringRequestMatchers("/trainers/**"));


        httpSecurity.formLogin(loginConfigurer -> loginConfigurer
                        .loginPage("/login")
                        .defaultSuccessUrl("/displayDashboard").failureUrl("/login?error = true").permitAll())
                .logout(logoutConfigurer -> logoutConfigurer.logoutSuccessUrl("/login?logout=true")
                        .invalidateHttpSession(true).permitAll())
                .httpBasic(Customizer.withDefaults());
        return (SecurityFilterChain)httpSecurity.build();

    }


}
