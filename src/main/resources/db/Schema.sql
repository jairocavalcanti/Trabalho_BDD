CREATE TABLE eventos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    data DATE
);

CREATE TABLE participantes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    idade INT
);

CREATE TABLE evento_participante (
    id INT AUTO_INCREMENT PRIMARY KEY,
    evento_id BIGINT,
    participante_id BIGINT,
    FOREIGN KEY (evento_id) REFERENCES eventos(id),
    FOREIGN KEY (participante_id) REFERENCES participantes(id)
);

ALTER TABLE evento_participante
ADD CONSTRAINT unique_event_participante UNIQUE (evento_id, participante_id);