package lk.kdu.detcwa.service.impl;

import lk.kdu.detcwa.dto.UserDTO;
import lk.kdu.detcwa.entity.User;
import lk.kdu.detcwa.repository.UserRepository;
import lk.kdu.detcwa.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean register(UserDTO userDTO) {
        userRepository.save(new User(
                userDTO.getU_name(),
                userDTO.getU_u_name(),
                userDTO.getU_password(),
                userDTO.getU_url(),
                userDTO.getU_rank(),
                userDTO.getU_role()
        ));
        return true;
    }

    @Override
    public UserDTO findUName(String username) {
        User user = userRepository.findUName(username);
        if (user == null){
            return null;
        }
        return new UserDTO(
                user.getUid(),
                user.getU_name(),
                user.getU_u_name(),
                user.getU_password(),
                user.getU_url(),
                user.getU_rank(),
                user.getU_role()
        );
    }

    @Override
    public List<UserDTO> findAll() {
        List<User> userList = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : userList) {
            userDTOList.add(
                    new UserDTO(
                            user.getUid(),
                            user.getU_name(),
                            user.getU_u_name(),
                            user.getU_password(),
                            user.getU_url(),
                            user.getU_rank(),
                            user.getU_role()
                    )
            );
        }
        return userDTOList;
    }
}
