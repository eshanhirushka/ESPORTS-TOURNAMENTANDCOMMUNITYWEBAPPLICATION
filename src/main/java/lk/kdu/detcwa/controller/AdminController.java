package lk.kdu.detcwa.controller;

import lk.kdu.detcwa.dto.AdminDTO;
import lk.kdu.detcwa.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/admin")
@CrossOrigin
@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    @RequestMapping("/add")
    boolean register(@RequestBody AdminDTO adminDTO){
        return adminService.register(adminDTO);
    }

    @GetMapping
    @RequestMapping("/findUName")
    ResponseEntity<AdminDTO> findUName(@RequestParam("u_name") String u_name){
        AdminDTO adminDTO = adminService.findUName(u_name);
        HttpStatus status = (adminDTO != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<AdminDTO>(adminDTO, status);
    }

    @GetMapping
    @RequestMapping("/findAll")
    ResponseEntity<List<AdminDTO>> findAll(){
        List<AdminDTO> adminDTO = adminService.findAll();
        HttpStatus status = (adminDTO != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<List<AdminDTO>>(adminDTO, status);
    }

}
