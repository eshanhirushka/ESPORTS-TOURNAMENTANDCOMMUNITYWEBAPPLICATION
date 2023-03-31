package lk.kdu.detcwa.service.impl;

import lk.kdu.detcwa.dto.UserTournamentDTO;
import lk.kdu.detcwa.entity.Tournament;
import lk.kdu.detcwa.entity.User;
import lk.kdu.detcwa.entity.UserTournament;
import lk.kdu.detcwa.repository.UserTournamentRepository;
import lk.kdu.detcwa.service.UserTournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserTournamentServiceImpl implements UserTournamentService {

    private UserTournamentRepository userTournamentRepository;

    @Autowired
    public UserTournamentServiceImpl(UserTournamentRepository userTournamentRepository) {
        this.userTournamentRepository = userTournamentRepository;
    }

    @Override
    public boolean add(UserTournamentDTO userTournamentDTO) {
        User user = new User();
        user.setUid(userTournamentDTO.getUt_uid());
        Tournament tournament = new Tournament();
        tournament.setTid(userTournamentDTO.getUt_tid());
        userTournamentRepository.save(new UserTournament(
                user,
                tournament,
                userTournamentDTO.getUt_join_type(),
                userTournamentDTO.getUt_team(),
                userTournamentDTO.getUt_role(),
                userTournamentDTO.getUt_rank()
        ));
        return true;
    }

    @Override
    public boolean findUserJoinTournament(int tid, int uid) {
        return userTournamentRepository.findUserJoinTournament(tid, uid)>0;
    }

    @Override
    public boolean deleteRegisterTournament(int tid, int uid) {
        List<UserTournament> userTournaments = userTournamentRepository.findAllUT(uid);
        if (userTournaments==null){
            return false;
        }
        for (UserTournament userTournament:userTournaments){
            if (userTournament.getUt_tid().getTid() == tid && userTournament.getUt_uid().getUid() == uid){
                userTournamentRepository.deleteById(userTournament.getUtid());
            }
        }
        return true;
    }

    @Override
    public List<UserTournamentDTO> findTouramentID(int tid) {
        List<UserTournamentDTO> userTournamentDTOS = new ArrayList<>();
        List<UserTournament> tournamentList = userTournamentRepository.findTouramentID(tid);
        for (UserTournament userTournament: tournamentList) {
            userTournamentDTOS.add(new UserTournamentDTO(
                    userTournament.getUtid(),
                    userTournament.getUt_uid().getUid(),
                    userTournament.getUt_tid().getTid(),
                    userTournament.getUt_join_type(),
                    userTournament.getUt_team(),
                    userTournament.getUt_role(),
                    userTournament.getUt_rank(),
                    userTournament.getUt_uid().getU_u_name(),
                    userTournament.getUt_uid().getU_role(),
                    userTournament.getUt_uid().getU_rank()
            ));
        }
        return userTournamentDTOS;
    }
}
