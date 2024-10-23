package com.crud.noOrm.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.crud.noOrm.Modelo.Evento;
import com.crud.noOrm.Repository.EventoRepository;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Evento> findAll() {
        return eventoRepository.findAll();
    }

    public void save(Evento evento) {
        eventoRepository.save(evento);
    }

    public void update(Long eventoId, Evento evento) {
        eventoRepository.update(eventoId,evento);
    }

    public void exclude(Long eventoId) {
        eventoRepository.exclude(eventoId);
    }

    public int getQuantidadeParticipantes(Long eventoID) {
        String sql = "SELECT COUNT(*) FROM evento_participante WHERE evento_id = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, eventoID);
    }

}
