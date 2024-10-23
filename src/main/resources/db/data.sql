SELECT e.nome AS evento_nome, p.nome AS participante_nome
FROM evento_participante ep
JOIN eventos e ON ep.evento_id = e.id
JOIN participantes p ON ep.participante_id = p.id
ORDER BY e.nome;

SELECT * FROM eventos;
SELECT * FROM participantes;