package com.crud.noOrm.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.noOrm.Modelo.Evento;
import com.crud.noOrm.Service.EventoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<Evento> getAllEventos() {
        return eventoService.findAll();
    }

    @PostMapping("/adicionar")
    public void addEvento(@RequestBody Evento evento) {
        eventoService.save(evento);
    }

    // metodo de alteração aqui (coceirinha na cabeça em man pqp)
    @PutMapping("/atualizar/{eventoId}")
    public void updateEvento(@PathVariable Long eventoId , @RequestBody Evento evento) {
        eventoService.update(eventoId,evento);
    }

    @DeleteMapping("/excluir/{eventoId}")
    public void exclude(@PathVariable Long eventoId) {
        eventoService.exclude(eventoId);
    }

}
