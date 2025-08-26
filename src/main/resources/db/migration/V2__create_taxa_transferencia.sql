CREATE TABLE IF NOT EXISTS tb_taxas_dias_tranferencias(
	codigo_taxa_dia_tranferencia INT NOT NULL,
	nr_dia_de INT NOT NULL,
	nr_dia_ate INT NOT NULL,
	dc_taxa DECIMAL(19,2) NULL,
	dc_porcentagem DECIMAL(19,2) NULL,
	CONSTRAINT pk_tb_taxas_dias_tranferencias PRIMARY KEY (codigo_taxa_dia_tranferencia)
);