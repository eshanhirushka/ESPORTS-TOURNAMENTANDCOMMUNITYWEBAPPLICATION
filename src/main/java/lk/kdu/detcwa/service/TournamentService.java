package lk.kdu.detcwa.service;

import lk.kdu.detcwa.dto.TournamentDTO;

import java.util.List;

public interface TournamentService {

    boolean add(TournamentDTO tournamentDTO);
    List<TournamentDTO> findAllStatus(String t_status);
//    List<TournamentDTO> findAllStatusAID(int aid, String t_status);
    List<TournamentDTO> findAllStatusAIDJOIN(int aid, String t_status);
    boolean updateStatus(int tid,String t_status);
    List<TournamentDTO> findAllStatusUID(int uid, String t_status);
    TournamentDTO findByID(int tid);

}
