package io.swagger.api;

import io.swagger.model.UserModel;
import io.swagger.repository.UserRepository;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-10-13T12:32:13.695655691Z[GMT]")
@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class UsersApiController implements UsersApi {

    private static final Logger log = LoggerFactory.getLogger(UsersApiController.class);
    private final HttpServletRequest request;

    private final UserRepository userRepository;


    @Autowired
    public UsersApiController(HttpServletRequest request, UserRepository userRepository) {
        this.request = request;
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserModel>> usersGet() {

                List<UserModel> userModels = userRepository.findAll();
                if(userModels != null){
                    return new ResponseEntity<>(userModels, HttpStatus.OK);
                }
                else {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/users/{id}")
    public ResponseEntity<UserModel> usersIdDelete(@Parameter(in = ParameterIn.PATH, description = "ID of user", required=true, schema=@Schema()) @PathVariable("id") String id
    ) {
        try {
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error("Couldn't delete user with ID: " + id, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserModel> usersIdGet(@Parameter(in = ParameterIn.PATH, description = "ID of user", required=true, schema=@Schema()) @PathVariable("id") String id
    ) {
        try {
            Optional<UserModel> user = userRepository.findById(id);

            return user.map(userModel -> new ResponseEntity<>(userModel, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            log.error("Couldn't fetch user with ID: " + id, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/users/{id}")
    public ResponseEntity<UserModel> usersIdPatch(@Parameter(in = ParameterIn.PATH, description = "ID of user", required=true, schema=@Schema()) @PathVariable("id") String id
            ,@Parameter(in = ParameterIn.DEFAULT, description = "data to update user-informations", required=true, schema=@Schema()) @Valid @RequestBody UserModel body
    ) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/users/{id}")
    public ResponseEntity<UserModel> usersIdPut(@Parameter(in = ParameterIn.PATH, description = "ID of user", required=true, schema=@Schema()) @PathVariable("id") String id
            , @Parameter(in = ParameterIn.DEFAULT, description = "data to update user-informations", required=true, schema=@Schema()) @Valid @RequestBody UserModel body
    ) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/users")
    public ResponseEntity<UserModel> usersPost(@Parameter(in = ParameterIn.DEFAULT, description = "data of the new user", schema=@Schema()) @Valid @RequestBody UserModel body    ) {
        try {
            UserModel newUser = userRepository.save(body);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Couldn't create user", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
