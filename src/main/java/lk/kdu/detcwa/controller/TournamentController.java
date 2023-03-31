package lk.kdu.detcwa.controller;

import lk.kdu.detcwa.dto.TournamentDTO;
import lk.kdu.detcwa.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/tournament")
@CrossOrigin
@RestController
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @PostMapping
    @RequestMapping("/add")
    boolean add(@RequestBody TournamentDTO tournamentDTO){
        return tournamentService.add(tournamentDTO);
    }

    @GetMapping
    @RequestMapping("/findAllStatus")
    ResponseEntity<List<TournamentDTO>> findAllStatus(@RequestParam("t_status") String t_status){
        List<TournamentDTO> tournamentDTOS = tournamentService.findAllStatus(t_status);
        HttpStatus status = (tournamentDTOS != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<List<TournamentDTO>>(tournamentDTOS, status);
    }

    @GetMapping
    @RequestMapping("/findByID")
    ResponseEntity<TournamentDTO> findByID(@RequestParam("tid") int tid){
        TournamentDTO adminTouANDTouDTOS = tournamentService.findByID(tid);
        HttpStatus status = (adminTouANDTouDTOS != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<TournamentDTO>(adminTouANDTouDTOS, status);
    }

    @GetMapping
    @RequestMapping("/findAllStatusAIDJOIN")
    ResponseEntity<List<TournamentDTO>> findAllStatusAIDJOIN(@RequestParam("aid") int aid, @RequestParam("t_status") String t_status){
        List<TournamentDTO> adminTouANDTouDTOS = tournamentService.findAllStatusAIDJOIN(aid,t_status);
        HttpStatus status = (adminTouANDTouDTOS != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<List<TournamentDTO>>(adminTouANDTouDTOS, status);
    }

    @PostMapping
    @RequestMapping("/updateStatus")
    boolean updateStatus(@RequestParam("tid") int tid,@RequestParam("t_status") String t_status){
        return tournamentService.updateStatus(tid,t_status);
    }

    @GetMapping
    @RequestMapping("/findAllStatusUID")
    ResponseEntity<List<TournamentDTO>> findAllStatusUID(@RequestParam("uid") int uid, @RequestParam("t_status") String t_status){
        List<TournamentDTO> adminTouANDTouDTOS = tournamentService.findAllStatusUID(uid,t_status);
        HttpStatus status = (adminTouANDTouDTOS != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<List<TournamentDTO>>(adminTouANDTouDTOS, status);
    }

}
