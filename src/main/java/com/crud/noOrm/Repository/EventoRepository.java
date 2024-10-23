package com.crud.noOrm.Repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.crud.noOrm.Modelo.Evento;

@Repository
public class EventoRepository {

    // @Autowired
    private final JdbcTemplate jdbcTemplate;

    public EventoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Evento> findAll() {
        String sql = "SELECT * FROM eventos";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Evento.class));
    }

    public void exclude(Long eventoId) {
        String sqlDeleteFromEventoParticipante = "DELETE FROM evento_participante WHERE evento_id = ?";
        jdbcTemplate.update(sqlDeleteFromEventoParticipante, eventoId);

        String sql = "DELETE FROM eventos WHERE id = ?";
        jdbcTemplate.update(sql, eventoId);
    }

    // a ordem dos atributos deve corresponder com a query!!
    public void update(Long eventoId, Evento evento) {
        String sql = "UPDATE eventos SET nome = ?, data = ? WHERE id = ?";
        jdbcTemplate.update(sql, evento.getNome(), evento.getData(), eventoId);
    }

    public void save(Evento evento) {
        String sql = "INSERT INTO eventos (nome, data) VALUES(?, ?)";
        jdbcTemplate.update(sql, evento.getNome(), evento.getData());
    }

}
