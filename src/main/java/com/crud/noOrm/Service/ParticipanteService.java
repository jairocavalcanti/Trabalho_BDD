package com.crud.noOrm.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.noOrm.Modelo.Participante;
import com.crud.noOrm.Repository.ParticipanteRepository;

@Service
public class ParticipanteService {

    @Autowired
    private ParticipanteRepository participanteRepository;

    public List<Participante> findAll() {
        return participanteRepository.findAll();
    }

    public void save(Participante participante) {
        participanteRepository.save(participante);
    }

    public void update(Long participanteId, Participante participante) {
        participanteRepository.update(participanteId, participante);
    }

    public void exclude(Long participanteId) {
        participanteRepository.exclude(participanteId);
    } 

    public void addParticipanteToevento(Long eventoId, Long participanteId){
        participanteRepository.addParticipanteToEvento(eventoId, participanteId);
    }

    public List<Map<String, Object>> getEventosComParticipantes() {
        return participanteRepository.findEventosComParticipantes();
    }
  
}
