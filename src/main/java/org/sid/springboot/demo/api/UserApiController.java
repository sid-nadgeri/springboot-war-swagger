package org.sid.springboot.demo.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.sid.springboot.demo.model.User;
import org.sid.springboot.demo.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-18T21:11:56.913+01:00")

@Controller
public class UserApiController implements UserApi {

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    UserRepository userRepository;

    @org.springframework.beans.factory.annotation.Autowired
    public UserApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.ofNullable(objectMapper);
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<List<User>> getAllUser() {
        final List<User> allUser = new ArrayList<User>();
        userRepository.findAll().forEach(u -> allUser.add(u));

        if(allUser != null) {
            return new ResponseEntity<List<User>>(allUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<User>>(allUser, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<User> getUserByName(String username) {
        User byUsername = userRepository.findByUsername(username);
        if(byUsername != null) {
            return new ResponseEntity<User>(byUsername, HttpStatus.OK);
        } else {
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Void> createUser(@Valid User body) {
        userRepository.save(body);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteUser(String username) {
        User byUsername = userRepository.findByUsername(username);
        userRepository.delete(byUsername);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
