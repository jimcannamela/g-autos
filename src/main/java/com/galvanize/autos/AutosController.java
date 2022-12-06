package com.galvanize.autos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autos")
public class AutosController {
    private final AutosRepository autosRepository;

    public AutosController(AutosRepository autosRepository) {
        this.autosRepository = autosRepository;
    }

    @GetMapping
    public List<Automobile> getAutomobiles() {
        return autosRepository.findAll();
    }

    @GetMapping("/{id}")
    public Automobile getAutomobile(@PathVariable Long id) {
        return autosRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Automobile createAutomobile(@RequestBody Automobile automobile) {
        return autosRepository.save(automobile);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAutomobile(@PathVariable Long id) {
        Automobile automobile = getAutomobile(id);
        if (automobile == null) {
            return ResponseEntity.badRequest().body(String.format("Automobile %s not found", id));
        }
        autosRepository.delete(automobile);
        return ResponseEntity.accepted().body(String.format("Automobile %s deleted", id));
    }
}
