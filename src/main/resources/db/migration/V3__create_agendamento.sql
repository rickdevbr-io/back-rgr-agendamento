CREATE TABLE IF NOT EXISTS tb_agendamentos(
	codigo_agendamento VARCHAR(36) NOT NULL,
	codigo_status_agendamento INT NOT NULL,
	st_conta_origem VARCHAR(50) NOT NULL,
	st_conta_destino VARCHAR(50) NOT NULL,
	dc_valor DECIMAL(19,2) NOT NULL,
	dc_taxa DECIMAL(19,2) NOT NULL,
	ts_data_transferencia TIMESTAMP NOT NULL,
	ts_data_agendamento TIMESTAMP NOT NULL,
	CONSTRAINT pk_tb_agendamentos PRIMARY KEY (codigo_agendamento),
	CONSTRAINT fk_tb_agendamentos_tb_status_agendamentos FOREIGN KEY (codigo_status_agendamento) REFERENCES tb_status_agendamentos(codigo_status_agendamento)
);