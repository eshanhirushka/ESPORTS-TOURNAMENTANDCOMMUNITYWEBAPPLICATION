package lk.kdu.detcwa.service;

import lk.kdu.detcwa.dto.UserTournamentTeamCountDTO;
import lk.kdu.detcwa.dto.UserTournamentTeamDTO;

import java.util.List;

public interface UserTournamentTeamService {

    boolean add(UserTournamentTeamDTO userTournamentTeamDTO);
    List<UserTournamentTeamDTO> getCountAndTeam(int tid);
    List<UserTournamentTeamDTO> findTeamNameANDTeamID(int tid,String team);

}
