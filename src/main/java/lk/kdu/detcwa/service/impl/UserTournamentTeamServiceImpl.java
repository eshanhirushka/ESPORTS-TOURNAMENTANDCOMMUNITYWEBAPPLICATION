package lk.kdu.detcwa.service.impl;

import lk.kdu.detcwa.dto.UserTournamentTeamCountDTO;
import lk.kdu.detcwa.dto.UserTournamentTeamDTO;
import lk.kdu.detcwa.entity.Tournament;
import lk.kdu.detcwa.entity.User;
import lk.kdu.detcwa.entity.UserTournament;
import lk.kdu.detcwa.entity.UserTournamentTeam;
import lk.kdu.detcwa.repository.UserTournamentTeamRepository;
import lk.kdu.detcwa.service.UserTournamentTeamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserTournamentTeamServiceImpl implements UserTournamentTeamService {

    private UserTournamentTeamRepository userTournamentTeamRepository;

    public UserTournamentTeamServiceImpl(UserTournamentTeamRepository userTournamentTeamRepository) {
        this.userTournamentTeamRepository = userTournamentTeamRepository;
    }

    @Override
    public boolean add(UserTournamentTeamDTO userTournamentTeamDTO) {
        UserTournamentTeam regData = userTournamentTeamRepository.findRegData(
                userTournamentTeamDTO.getUtt_utid(),
                userTournamentTeamDTO.getUtt_ut_uid(),
                userTournamentTeamDTO.getUtt_ut_tid(),
                userTournamentTeamDTO.getUtt_ut_team()
        );
        if (regData!=null){
            return true;
        }

        Tournament tournament = new Tournament();
        tournament.setTid(userTournamentTeamDTO.getUtt_ut_tid());
        User user = new User();
        user.setUid(userTournamentTeamDTO.getUtt_ut_uid());
        UserTournament userTournament = new UserTournament();
        userTournament.setUtid(userTournamentTeamDTO.getUtt_utid());

        userTournamentTeamRepository.save(new UserTournamentTeam(
                userTournament,
                user,
                tournament,
                userTournamentTeamDTO.getUtt_ut_join_type(),
                userTournamentTeamDTO.getUtt_ut_team(),
                userTournamentTeamDTO.getUtt_ut_role(),
                userTournamentTeamDTO.getUtt_ut_rank(),
                userTournamentTeamDTO.getUtt_ut_u_name(),
                userTournamentTeamDTO.getUtt_ut_u_role(),
                userTournamentTeamDTO.getUtt_ut_u_rank()
        ));
        return true;
    }

    @Override
    public List<UserTournamentTeamDTO> getCountAndTeam(int tid) {
        List<UserTournamentTeamDTO> userTournamentTeamDTOS = new ArrayList<>();
        List<UserTournamentTeam> userTournaments = userTournamentTeamRepository.getCountAndTeam(tid);
        for (UserTournamentTeam userTournament:userTournaments){
            userTournamentTeamDTOS.add(new UserTournamentTeamDTO(
                    userTournament.getUttid(),
                    userTournament.getUtt_utid().getUtid(),
                    userTournament.getUtt_ut_uid().getUid(),
                    userTournament.getUtt_ut_tid().getTid(),
                    userTournament.getUtt_ut_join_type(),
                    userTournament.getUtt_ut_team(),
                    userTournament.getUtt_ut_role(),
                    userTournament.getUtt_ut_rank(),
                    userTournament.getUtt_ut_u_name(),
                    userTournament.getUtt_ut_u_role(),
                    userTournament.getUtt_ut_u_rank()
            ));
        }
        return userTournamentTeamDTOS;
    }

    @Override
    public List<UserTournamentTeamDTO> findTeamNameANDTeamID(int tid, String team) {
        System.out.println("TID : "+tid+" | "+"TEAM : "+team);
        List<UserTournamentTeamDTO> userTournamentTeamDTOS = new ArrayList<>();
        List<UserTournamentTeam> userTournaments = userTournamentTeamRepository.findTeamNameANDTeamID(tid,team);
        for (UserTournamentTeam userTournament:userTournaments){
            userTournamentTeamDTOS.add(new UserTournamentTeamDTO(
                    userTournament.getUttid(),
                    userTournament.getUtt_utid().getUtid(),
                    userTournament.getUtt_ut_uid().getUid(),
                    userTournament.getUtt_ut_tid().getTid(),
                    userTournament.getUtt_ut_join_type(),
                    userTournament.getUtt_ut_team(),
                    userTournament.getUtt_ut_role(),
                    userTournament.getUtt_ut_rank(),
                    userTournament.getUtt_ut_u_name(),
                    userTournament.getUtt_ut_u_role(),
                    userTournament.getUtt_ut_u_rank()
            ));
        }
        return userTournamentTeamDTOS;
    }
}
