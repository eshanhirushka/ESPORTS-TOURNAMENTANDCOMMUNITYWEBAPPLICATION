package lk.kdu.detcwa.controller;

import lk.kdu.detcwa.dto.UserTournamentTeamDTO;
import lk.kdu.detcwa.service.UserTournamentTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/user_tournament_team")
@CrossOrigin
@RestController
public class UserTournamentTeamController {

    @Autowired
    private UserTournamentTeamService userTournamentTeamService;

    @PostMapping
    @RequestMapping("/add")
    boolean register(@RequestBody UserTournamentTeamDTO userTournamentTeamDTO){
        return userTournamentTeamService.add(userTournamentTeamDTO);
    }

    @GetMapping
    @RequestMapping("/getCountAndTeam")
    ResponseEntity<List<UserTournamentTeamDTO>> getCountAndTeam(@RequestParam("tid") int tid){
        List<UserTournamentTeamDTO> tournamentDTOS = userTournamentTeamService.getCountAndTeam(tid);
        HttpStatus status = (tournamentDTOS != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<List<UserTournamentTeamDTO>>(tournamentDTOS, status);
    }

    @GetMapping
    @RequestMapping("/findTeamNameANDTeamID")
    ResponseEntity<List<UserTournamentTeamDTO>> findTeamNameANDTeamID(@RequestParam("tid") int tid,@RequestParam("team")String team){
        List<UserTournamentTeamDTO> tournamentDTOS = userTournamentTeamService.findTeamNameANDTeamID(tid,team);
        HttpStatus status = (tournamentDTOS != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<List<UserTournamentTeamDTO>>(tournamentDTOS, status);
    }


}
