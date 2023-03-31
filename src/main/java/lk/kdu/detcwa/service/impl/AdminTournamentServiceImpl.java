package lk.kdu.detcwa.service.impl;

import lk.kdu.detcwa.dto.AdminTouANDTouDTO;
import lk.kdu.detcwa.dto.AdminTournamentDTO;
import lk.kdu.detcwa.dto.TournamentDTO;
import lk.kdu.detcwa.entity.Admin;
import lk.kdu.detcwa.entity.AdminTournament;
import lk.kdu.detcwa.entity.Tournament;
import lk.kdu.detcwa.repository.AdminTournamentRepository;
import lk.kdu.detcwa.service.AdminTournamentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminTournamentServiceImpl implements AdminTournamentService {

    private AdminTournamentRepository adminTournamentRepository;

    public AdminTournamentServiceImpl(AdminTournamentRepository adminTournamentRepository) {
        this.adminTournamentRepository = adminTournamentRepository;
    }

    @Override
    public boolean add(AdminTournamentDTO adminTournamentDTO) {
        Tournament tournament = new Tournament();
        tournament.setTid(adminTournamentDTO.getAd_tid());
        Admin admin = new Admin();
        admin.setAid(adminTournamentDTO.getAd_aid());
        adminTournamentRepository.save(new AdminTournament(
                tournament,
                admin,
                adminTournamentDTO.getAd_join_type()
        ));
        return true;
    }

    @Override
    public boolean deleteRegisterTournament(int tid, int aid) {
        List<AdminTournament> adminTournaments = adminTournamentRepository.findAllAT(aid);
        if (adminTournaments==null){
            return false;
        }
        for (AdminTournament adminTournament:adminTournaments){
            if (adminTournament.getAd_tid().getTid() == tid && adminTournament.getAd_aid().getAid() == aid){
                adminTournamentRepository.deleteById(adminTournament.getAdid());
            }
        }
        return true;
    }

    @Override
    public boolean findUserJoinTournament(int tid, int aid) {
        return adminTournamentRepository.findUserJoinTournament(tid, aid)>0;
    }
}
