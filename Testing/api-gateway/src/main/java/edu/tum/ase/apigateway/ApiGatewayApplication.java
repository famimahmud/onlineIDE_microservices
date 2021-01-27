package edu.tum.ase.apigateway;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.tum.ase.apigateway.resttemplate.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;

@SpringBootApplication
@RestController
public class ApiGatewayApplication {

    private static final Logger log = LoggerFactory.getLogger(ApiGatewayApplication.class);
    @Autowired
    private OAuth2RestOperations restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @GetMapping("/authenticated")
    public boolean authenticated() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        if (authentication != null) {
            return authentication.getAuthorities().stream()
                    .noneMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ANONYMOUS"));
        }
        return false;
    }

	/*@Bean
	public RestTemplate restTemplate (RestTemplateBuilder builder){
		return builder.build();
	}*/

    //Erkennt Bean ohne Qualifier nicht?
    @Bean
    public OAuth2RestOperations restTemplate(@Qualifier("oauth2ClientContext") OAuth2ClientContext context) {
        ClientCredentialsResourceDetails details = new ClientCredentialsResourceDetails();
        return new OAuth2RestTemplate(details, context);
    }

    //@GetMapping("/search/{username}")
    @RequestMapping(path = "/search/{username}", method = RequestMethod.GET)
    public String search(@PathVariable String username) {
        String request = "https://gitlab.lrz.de/api/v4/search?scope=user" +
                "s&search=" + username;
        User[] userarr = restTemplate.getForObject(request, User[].class);
        if (userarr.length == 0) {
			return "No user found!";
        }

        User user = userarr[0];
	    //share(user.getUsername());

        //Todo: Add user to list of authorized users for project
        return "Succesfully added";
    }

    @RequestMapping(path = "/share", method = RequestMethod.POST)
    public String share(@RequestBody String username) {
        String request = "https://gitlab.lrz.de/api/v4/search?scope=users&search=" + username;
        User[] userarr = restTemplate.getForObject(request, User[].class);
        if (userarr.length == 0) {
            //TODO: Rückmeldung wäre gut
            return null;
        }
        User user = userarr[0];
        //Todo: Add user to list of authorized users for project
        return restTemplate.getForObject(request, String.class);
    }
}
