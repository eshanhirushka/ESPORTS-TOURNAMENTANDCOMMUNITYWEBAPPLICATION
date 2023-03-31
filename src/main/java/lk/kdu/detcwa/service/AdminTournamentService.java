package lk.kdu.detcwa.service;

import lk.kdu.detcwa.dto.AdminTournamentDTO;

public interface AdminTournamentService {

    boolean add(AdminTournamentDTO adminTournamentDTO);
    boolean deleteRegisterTournament(int tid,int aid);
    boolean findUserJoinTournament(int tid,int aid);

}
