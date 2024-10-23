package com.crud.noOrm.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.noOrm.Modelo.Participante;
import com.crud.noOrm.Service.ParticipanteService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/participantes")
public class ParticipanteController {

    @Autowired
    private ParticipanteService participanteService;

    @GetMapping
    public List<Participante> getAllParticipantes() {
        return participanteService.findAll();
    }

    @PostMapping("/adicionar")
    public void addParticipante(@RequestBody Participante participante) {
        participanteService.save(participante);
    }

    @PutMapping("/atualizar/{participanteId}")
    public void put_participante(@PathVariable Long participanteId, @RequestBody Participante participante) {
        participanteService.update(participanteId, participante);
    }

    @DeleteMapping("/excluir/{participanteId}")
    public void excluir_participante(@PathVariable Long participanteId) {
        participanteService.exclude(participanteId);
    }

    @PostMapping("/adicionarNoevento/{eventoId}/{participanteId}")
    public void addParticipanteToEvento(@PathVariable Long eventoId, @PathVariable Long participanteId) {
        participanteService.addParticipanteToevento(eventoId, participanteId);
    }

    @GetMapping("/eventos-com-participantes")
    public ResponseEntity<List<Map<String, Object>>> getEventosComParticipantes() {
        List<Map<String, Object>> eventosComParticipantes = participanteService.getEventosComParticipantes();
        return ResponseEntity.ok(eventosComParticipantes);
    }

}
