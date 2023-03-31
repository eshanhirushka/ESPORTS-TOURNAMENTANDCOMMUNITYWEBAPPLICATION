package lk.kdu.detcwa.service;

import lk.kdu.detcwa.dto.UserTournamentDTO;

import java.util.List;

public interface UserTournamentService {

    boolean add(UserTournamentDTO userTournamentDTO);
    boolean findUserJoinTournament(int tid,int uid);
    boolean deleteRegisterTournament(int tid,int uid);
    List<UserTournamentDTO> findTouramentID(int tid);
}
