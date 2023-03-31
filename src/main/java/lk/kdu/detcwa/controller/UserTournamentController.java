package lk.kdu.detcwa.controller;

import lk.kdu.detcwa.dto.UserTournamentDTO;
import lk.kdu.detcwa.service.UserTournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/user_tournament")
@CrossOrigin
@RestController
public class UserTournamentController {

    @Autowired
    private UserTournamentService userTournamentService;

    @PostMapping
    @RequestMapping("/add")
    boolean add(@RequestBody UserTournamentDTO userTournamentDTO){
        return userTournamentService.add(userTournamentDTO);
    }

    @PostMapping
    @RequestMapping("/findUserJoinTournament")
    boolean findUserJoinTournament(@RequestParam("tid") int tid,@RequestParam("uid") int uid){
        return userTournamentService.findUserJoinTournament(tid, uid);
    }

    @PostMapping
    @RequestMapping("/deleteRegisterTournament")
    boolean deleteRegisterTournament(@RequestParam("tid") int tid,@RequestParam("uid") int uid){
        return userTournamentService.deleteRegisterTournament(tid,uid);
    }

    @GetMapping
    @RequestMapping("/findTouramentID")
    ResponseEntity<List<UserTournamentDTO>> findTouramentID(@RequestParam("tid") int tid){
        List<UserTournamentDTO> tournamentDTOS = userTournamentService.findTouramentID(tid);
        HttpStatus status = (tournamentDTOS != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<List<UserTournamentDTO>>(tournamentDTOS, status);
    }

}
