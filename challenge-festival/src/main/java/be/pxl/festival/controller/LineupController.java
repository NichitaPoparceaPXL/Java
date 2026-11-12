package be.pxl.festival.controller;

import be.pxl.festival.model.Act;
import be.pxl.festival.model.FestivalDay;
import be.pxl.festival.service.LineupService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/acts")
public class LineupController {

    private final LineupService lineupService;

    public LineupController(LineupService lineupService) {
        this.lineupService = lineupService;
    }

    @GetMapping
    public List<Act> findAll(@RequestParam(required = false)FestivalDay day) {
        return lineupService.findAll(String.valueOf(day));
    }

    @GetMapping("/{id}")
    public Act getOne(@PathVariable Long id) {
        return lineupService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Act create(@RequestBody Act act){
        return service.create(act);
    }
}
