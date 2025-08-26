CREATE TABLE IF NOT EXISTS tb_status_agendamentos(
	codigo_status_agendamento INT NOT NULL,
	st_nome VARCHAR(50) NOT NULL,
	CONSTRAINT pk_tb_status_agendamentos PRIMARY KEY (codigo_status_agendamento)
);