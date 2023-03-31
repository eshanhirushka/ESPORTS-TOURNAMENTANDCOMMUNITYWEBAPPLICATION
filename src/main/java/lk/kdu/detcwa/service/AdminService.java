package lk.kdu.detcwa.service;

import lk.kdu.detcwa.dto.AdminDTO;

import java.util.List;

public interface AdminService {

    boolean register(AdminDTO athleteDTO);
    AdminDTO findUName(String username);
    List<AdminDTO> findAll();
    AdminDTO findUNameCasterLogIn(String username);
}
