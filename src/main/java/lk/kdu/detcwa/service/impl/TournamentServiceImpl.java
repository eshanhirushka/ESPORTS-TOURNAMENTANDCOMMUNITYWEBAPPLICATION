package lk.kdu.detcwa.service.impl;

import lk.kdu.detcwa.dto.TournamentDTO;
import lk.kdu.detcwa.entity.AdminTournament;
import lk.kdu.detcwa.entity.Tournament;
import lk.kdu.detcwa.entity.UserTournament;
import lk.kdu.detcwa.repository.AdminTournamentRepository;
import lk.kdu.detcwa.repository.TournamentRepository;
import lk.kdu.detcwa.repository.UserTournamentRepository;
import lk.kdu.detcwa.service.TournamentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TournamentServiceImpl implements TournamentService {

    private TournamentRepository tournamentRepository;
    private AdminTournamentRepository adminTournamentRepository;
    private UserTournamentRepository userTournamentRepository;

    public TournamentServiceImpl(TournamentRepository tournamentRepository, AdminTournamentRepository adminTournamentRepository, UserTournamentRepository userTournamentRepository) {
        this.tournamentRepository = tournamentRepository;
        this.adminTournamentRepository = adminTournamentRepository;
        this.userTournamentRepository = userTournamentRepository;
    }

    @Override
    public boolean add(TournamentDTO tournamentDTO) {
        tournamentRepository.save(new Tournament(
                tournamentDTO.getT_name(),
                tournamentDTO.getT_type_schedule(),
                tournamentDTO.getT_reg_start(),
                tournamentDTO.getT_reg_end(),
                tournamentDTO.getT_start_date(),
                tournamentDTO.getT_end_date(),
                tournamentDTO.getT_type(),
                tournamentDTO.getT_sport(),
                tournamentDTO.getT_status()
        ));
        return true;
    }

    @Override
    public List<TournamentDTO> findAllStatus(String t_status) {
        List<Tournament> tournamentList = tournamentRepository.findAllStatus(t_status);
        List<TournamentDTO> tournamentDTOList = new ArrayList<>();
        for (Tournament tournament : tournamentList) {
            tournamentDTOList.add(
                    new TournamentDTO(
                            tournament.getTid(),
                            tournament.getT_name(),
                            tournament.getT_type_schedule(),
                            tournament.getT_reg_start(),
                            tournament.getT_reg_end(),
                            tournament.getT_start_date(),
                            tournament.getT_end_date(),
                            tournament.getT_type(),
                            tournament.getT_sport(),
                            tournament.getT_status()
                    )
            );
        }
        return tournamentDTOList;
    }

//    @Override
//    public List<TournamentDTO> findAllStatusAID(int aid, String t_status) {
//        List<TournamentDTO> adminTouANDTouDTOArrayList = new ArrayList<>();
//        List<Tournament> tournamentList = tournamentRepository.findAllStatus(t_status);
//        List<AdminTournament> adminTournamentList = adminTournamentRepository.findAllAT(aid);
//        for (Tournament tournament : tournamentList) {
//            adminTouANDTouDTOArrayList.add(
//                    new TournamentDTO(
//                            tournament.getTid(),
//                            tournament.getT_name(),
//                            tournament.getT_type_schedule(),
//                            tournament.getT_reg_start(),
//                            tournament.getT_reg_end(),
//                            tournament.getT_start_date(),
//                            tournament.getT_end_date(),
//                            tournament.getT_type(),
//                            tournament.getT_sport(),
//                            tournament.getT_status()
//                    )
//            );
//        }
//        return adminTouANDTouDTOArrayList;
//    }

    @Override
    public List<TournamentDTO> findAllStatusAIDJOIN(int aid, String t_status) {
        List<AdminTournament> adminTournamentList = adminTournamentRepository.findAllAT(aid);
        List<Tournament> tournamentList = tournamentRepository.findAllStatus(t_status);
        List<TournamentDTO> adminTouANDTouDTOArrayList = new ArrayList<>();
        for (Tournament tournament : tournamentList) {
            for (AdminTournament adminTournament : adminTournamentList) {
                if (tournament.getTid() == adminTournament.getAd_tid().getTid()) {
                    adminTouANDTouDTOArrayList.add(
                            new TournamentDTO(
                                    tournament.getTid(),
                                    tournament.getT_name(),
                                    tournament.getT_type_schedule(),
                                    tournament.getT_reg_start(),
                                    tournament.getT_reg_end(),
                                    tournament.getT_start_date(),
                                    tournament.getT_end_date(),
                                    tournament.getT_type(),
                                    tournament.getT_sport(),
                                    tournament.getT_status()
                            )
                    );
                }
            }
        }
        return adminTouANDTouDTOArrayList;
    }

    @Override
    public boolean updateStatus(int tid, String t_status) {
        Optional<Tournament> tournament = tournamentRepository.findById(tid);
        if (tournament == null) {
            return false;
        }
        tournament.get().setT_status(t_status);
        return true;
    }

    @Override
    public List<TournamentDTO> findAllStatusUID(int uid, String t_status) {
        List<TournamentDTO> adminTouANDTouDTOArrayList = new ArrayList<>();
        List<Tournament> tournamentList = tournamentRepository.findAllStatus(t_status);
        List<UserTournament> userTournamentList = userTournamentRepository.findAllUT(uid);
        for (Tournament tournament : tournamentList) {
            for (UserTournament userTournament : userTournamentList) {
                if (tournament.getTid() == userTournament.getUt_tid().getTid()) {
                    adminTouANDTouDTOArrayList.add(
                            new TournamentDTO(
                                    tournament.getTid(),
                                    tournament.getT_name(),
                                    tournament.getT_type_schedule(),
                                    tournament.getT_reg_start(),
                                    tournament.getT_reg_end(),
                                    tournament.getT_start_date(),
                                    tournament.getT_end_date(),
                                    tournament.getT_type(),
                                    tournament.getT_sport(),
                                    tournament.getT_status()
                            )
                    );
                }
            }
        }
        return adminTouANDTouDTOArrayList;
    }

    @Override
    public TournamentDTO findByID(int tid) {
        Optional<Tournament> optionalTournament = tournamentRepository.findById(tid);

        return new TournamentDTO(
                optionalTournament.get().getTid(),
                optionalTournament.get().getT_name(),
                optionalTournament.get().getT_type_schedule(),
                optionalTournament.get().getT_reg_start(),
                optionalTournament.get().getT_reg_end(),
                optionalTournament.get().getT_start_date(),
                optionalTournament.get().getT_end_date(),
                optionalTournament.get().getT_type(),
                optionalTournament.get().getT_sport(),
                optionalTournament.get().getT_status()
        );
    }
}
