package com.agendamento.enums;

/**
 * Enum para os valores padrão dos status de agendamento
 * Baseado nos dados inseridos no script V4__Insert_status_agendamento.sql
 */
public enum StatusAgendamentoEnum {
    
    PENDENTE(1, "PENDENTE"),
    REALIZADA(2, "REALIZADA");

    private final Integer codigo;
    private final String nome;

    StatusAgendamentoEnum(Integer codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public static StatusAgendamentoEnum fromCodigo(Integer codigo) {
        for (StatusAgendamentoEnum status : values()) {
            if (status.getCodigo().equals(codigo)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Código de status inválido: " + codigo);
    }

    public static StatusAgendamentoEnum fromNome(String nome) {
        for (StatusAgendamentoEnum status : values()) {
            if (status.getNome().equalsIgnoreCase(nome)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Nome de status inválido: " + nome);
    }
}
