package com.inchessFitness.webApp.config;


import com.inchessFitness.webApp.model.Clients;
import com.inchessFitness.webApp.model.Contact;
import com.inchessFitness.webApp.model.Trainers;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);

        HttpMethod[] theUnsupportedActions = {HttpMethod.DELETE,HttpMethod.POST,HttpMethod.PUT};

        //disable HTTP methods for Clients: PUT , POST and DELETE
        config.getExposureConfiguration()
                .forDomainType(Clients.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));

//        //disable HTTP methods for Trainers: PUT , POST and DELETE
//        config.getExposureConfiguration()
//                .forDomainType(Trainers.class)
//                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
//                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));

        //disable HTTP methods for Contact: PUT , POST and DELETE
        config.getExposureConfiguration()
                .forDomainType(Contact.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));

    }
}
































