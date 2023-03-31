package lk.kdu.detcwa.controller;

import lk.kdu.detcwa.dto.AdminTournamentDTO;
import lk.kdu.detcwa.service.AdminTournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/admin_tournament")
@CrossOrigin
@RestController
public class AdminTournamentController {

    @Autowired
    private AdminTournamentService adminTournamentService;

    @PostMapping
    @RequestMapping("/add")
    boolean add(@RequestBody AdminTournamentDTO adminTournamentDTO){
        return adminTournamentService.add(adminTournamentDTO);
    }

    @PostMapping
    @RequestMapping("/deleteRegisterTournament")
    boolean deleteRegisterTournament(@RequestParam("tid") int tid,@RequestParam("aid") int aid){
        return adminTournamentService.deleteRegisterTournament(tid,aid);
    }

    @PostMapping
    @RequestMapping("/findUserJoinTournament")
    boolean findUserJoinTournament(@RequestParam("tid") int tid,@RequestParam("aid") int aid){
        return adminTournamentService.findUserJoinTournament(tid, aid);
    }

}
