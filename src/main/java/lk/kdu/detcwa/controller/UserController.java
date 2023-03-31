package lk.kdu.detcwa.controller;

import lk.kdu.detcwa.dto.UserDTO;
import lk.kdu.detcwa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/user")
@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @RequestMapping("/add")
    boolean register(@RequestBody UserDTO userDTO){
        return userService.register(userDTO);
    }

    @GetMapping
    @RequestMapping("/findUName")
    ResponseEntity<UserDTO> findUName(@RequestParam("u_name") String u_name){
        UserDTO userDTO = userService.findUName(u_name);
        HttpStatus status = (userDTO != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<UserDTO>(userDTO, status);
    }

    @GetMapping
    @RequestMapping("/findAll")
    ResponseEntity<List<UserDTO>> findAll(){
        List<UserDTO> userDTO = userService.findAll();
        HttpStatus status = (userDTO != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<List<UserDTO>>(userDTO, status);
    }

}
