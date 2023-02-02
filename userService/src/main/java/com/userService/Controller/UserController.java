package com.userService.Controller;

import com.userService.Entity.Users;
import com.userService.Payload.ApiResponse;
import com.userService.Service.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;


    //create A User
    @PostMapping("/createANewUser")
    public ResponseEntity<Users> createAUser(@RequestBody Users users){
        try{
            Users userCreated=userService.saveOneUser(users);
            return new ResponseEntity<>(userCreated, HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //get A singleUser
    @GetMapping("getOneUser/{userId}")
    public ResponseEntity<Users> getAUser(@PathVariable String userId){

        try {
            Users usersFetchedFromDB=userService.giveAUser(userId);
            return new ResponseEntity<>(usersFetchedFromDB,HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //Get All users
    @GetMapping("/getAllTheUsers")
    public ResponseEntity<List<Users>> getAllUsers(){
        try{
            List<Users> allUsersInDataBases=userService.getAllUsers();
            return new ResponseEntity<>(allUsersInDataBases,HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
