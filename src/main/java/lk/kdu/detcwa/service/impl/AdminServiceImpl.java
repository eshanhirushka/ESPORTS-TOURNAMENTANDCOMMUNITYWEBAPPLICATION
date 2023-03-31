package lk.kdu.detcwa.service.impl;

import lk.kdu.detcwa.dto.AdminDTO;
import lk.kdu.detcwa.entity.Admin;
import lk.kdu.detcwa.entity.AdminTournament;
import lk.kdu.detcwa.repository.AdminRepository;
import lk.kdu.detcwa.repository.AdminTournamentRepository;
import lk.kdu.detcwa.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    private AdminRepository adminRepository;
    private AdminTournamentRepository adminTournamentRepository;

    public AdminServiceImpl(AdminRepository adminRepository, AdminTournamentRepository adminTournamentRepository) {
        this.adminRepository = adminRepository;
        this.adminTournamentRepository = adminTournamentRepository;
    }

    @Override
    public boolean register(AdminDTO adminDTO) {
        adminRepository.save(new Admin(
                adminDTO.getA_name(),
                adminDTO.getA_u_name(),
                adminDTO.getA_password(),
                adminDTO.getA_url(),
                adminDTO.getA_rank(),
                adminDTO.getA_role()
        ));
        return true;
    }

    @Override
    public AdminDTO findUName(String username) {
        Admin admin = adminRepository.findUName(username);
        if (admin == null){
            return null;
        }
        return new AdminDTO(
                admin.getAid(),
                admin.getA_name(),
                admin.getA_u_name(),
                admin.getA_password(),
                admin.getA_url(),
                admin.getA_rank(),
                admin.getA_role()
        );
    }

    @Override
    public List<AdminDTO> findAll() {
        List<Admin> adminList = adminRepository.findAll();
        List<AdminDTO> adminDTOList = new ArrayList<>();
        for (Admin admin : adminList) {
            adminDTOList.add(
                    new AdminDTO(
                            admin.getAid(),
                            admin.getA_name(),
                            admin.getA_u_name(),
                            admin.getA_password(),
                            admin.getA_url(),
                            admin.getA_rank(),
                            admin.getA_role()
                    )
            );
        }
        return adminDTOList;
    }

    @Override
    public AdminDTO findUNameCasterLogIn(String username) {
        Admin admin = adminRepository.findUName(username);
        if (admin == null){
            return null;
        }

//         = adminTournamentRepository.findAllAT(admin.getAid());
//
//        AdminDTO adminDTO = new AdminDTO(
//                admin.getAid(),
//                admin.getA_name(),
//                admin.getA_u_name(),
//                admin.getA_password(),
//                admin.getA_url(),
//                admin.getA_rank(),
//                admin.getA_role()
//        );

        return null;
    }
}
