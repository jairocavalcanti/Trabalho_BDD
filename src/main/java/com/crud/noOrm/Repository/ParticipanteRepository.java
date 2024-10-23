package com.crud.noOrm.Repository;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.crud.noOrm.Modelo.Participante;

@Repository
public class ParticipanteRepository {

    private final JdbcTemplate jdbcTemplate;

    public ParticipanteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Participante> findAll() {
        String sql = "SELECT * FROM participantes";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Participante.class));
    }

    public void save(Participante participante) {
        String sql = "INSERT INTO  participantes (nome,idade) VALUES(?,?)";
        jdbcTemplate.update(sql, participante.getNome(), participante.getIdade());
    }

    public void update(Long participanteid, Participante participante) {
        String sql = "UPDATE participantes SET nome = ?, idade = ? WHERE id = ?";
        jdbcTemplate.update(sql, participante.getNome(), participante.getIdade(), participanteid);
    }

    public void exclude(Long participanteid) {
        String sqlDeleteFromEventoParticipante = "DELETE FROM evento_participante WHERE participante_id = ?";
        jdbcTemplate.update(sqlDeleteFromEventoParticipante, participanteid);
        
        String sql = "DELETE FROM participantes WHERE id = ?";
        jdbcTemplate.update(sql, participanteid);
    }

    public void addParticipanteToEvento(Long eventoId, Long participanteId) {
        String sql = "INSERT INTO evento_participante (evento_id, participante_id) VALUES (?, ?)";
        try {
            jdbcTemplate.update(sql, eventoId, participanteId);
        } catch (DuplicateKeyException e) {
            System.out.println("O participante já está associado a este evento.");
        }
    }

    public List<Map<String, Object>> findEventosComParticipantes() {
        String sql = "SELECT e.nome AS evento_nome, p.nome AS participante_nome " +
                     "FROM evento_participante ep " +
                     "JOIN eventos e ON ep.evento_id = e.id " +
                     "JOIN participantes p ON ep.participante_id = p.id " +
                     "ORDER BY e.nome";
    
        return jdbcTemplate.queryForList(sql);
    }

}
