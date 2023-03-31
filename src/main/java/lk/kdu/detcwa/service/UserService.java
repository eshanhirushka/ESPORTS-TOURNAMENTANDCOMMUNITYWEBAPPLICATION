package lk.kdu.detcwa.service;

import lk.kdu.detcwa.dto.UserDTO;

import java.util.List;

public interface UserService {

    boolean register(UserDTO userDTO);
    UserDTO findUName(String username);
    List<UserDTO> findAll();
}
