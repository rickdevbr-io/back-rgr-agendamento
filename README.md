# Sistema de Agendamento

Projeto de sistema de agendamento desenvolvido com Java 11, Spring Boot, Flyway e H2.

## 🚀 Tecnologias Utilizadas

- **Java 11**
- **Spring Boot 2.7.18**
- **Spring Data JPA**
- **Flyway** (Migrações de banco de dados)
- **H2 Database** (Banco em memória)
- **Maven**

## 📋 Pré-requisitos

- Java 11 ou superior
- Maven 3.6+
- IDE de sua preferência (IntelliJ IDEA, Eclipse, VS Code)

## 🛠️ Como Executar

### 1. Clone o repositório
```bash
git clone <url-do-repositorio>
cd back-rgr-agendamento
```

### 2. Execute o projeto
```bash
mvn spring-boot:run
```

### 3. Acesse a aplicação
- **API REST**: http://localhost:8080/api/agendamentos
- **Console H2**: http://localhost:8080/h2-console
  - JDBC URL: `jdbc:h2:mem:agendamentodb`
  - Username: `sa`
  - Password: (deixe em branco)

## 📚 Endpoints da API

### Agendamentos

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/api/agendamentos` | Lista todos os agendamentos |
| GET | `/api/agendamentos/{id}` | Busca agendamento por ID |
| GET | `/api/agendamentos/status/{status}` | Busca por status |
| GET | `/api/agendamentos/periodo?dataInicio=X&dataFim=Y` | Busca por período |
| GET | `/api/agendamentos/busca?termo=X` | Busca por título ou descrição |
| POST | `/api/agendamentos` | Cria novo agendamento |
| PUT | `/api/agendamentos/{id}` | Atualiza agendamento |
| DELETE | `/api/agendamentos/{id}` | Remove agendamento |
| PATCH | `/api/agendamentos/{id}/status?status=X` | Altera status |
| GET | `/api/agendamentos/health` | Verifica saúde da API |

### Status Disponíveis
- `AGENDADO`
- `EM_ANDAMENTO`
- `CONCLUIDO`
- `CANCELADO`
- `REMARCADO`

## 🗄️ Estrutura do Banco

### Tabela: agendamentos
- `id` - Identificador único (AUTO_INCREMENT)
- `titulo` - Título do agendamento (obrigatório)
- `descricao` - Descrição detalhada
- `data_hora_inicio` - Data e hora de início (obrigatório)
- `data_hora_fim` - Data e hora de fim (obrigatório)
- `status` - Status atual do agendamento
- `criado_em` - Data de criação
- `atualizado_em` - Data da última atualização

## 📁 Estrutura do Projeto

```
src/
├── main/
│   ├── java/com/agendamento/
│   │   ├── AgendamentoApplication.java
│   │   ├── controller/
│   │   │   └── AgendamentoController.java
│   │   ├── service/
│   │   │   └── AgendamentoService.java
│   │   ├── repository/
│   │   │   └── AgendamentoRepository.java
│   │   ├── model/
│   │   │   ├── Agendamento.java
│   │   │   └── StatusAgendamento.java
│   │   └── exception/
│   │       └── GlobalExceptionHandler.java
│   └── resources/
│       ├── application.yml
│       └── db/migration/
│           ├── V1__Create_agendamento_table.sql
│           └── V2__Insert_sample_data.sql
└── test/
    └── java/com/agendamento/
        └── AgendamentoApplicationTests.java
```

## 🔧 Configurações

### application.yml
- **Porta**: 8080
- **Banco**: H2 em memória
- **Flyway**: Habilitado com validação
- **Logs**: SQL e Flyway habilitados

### Flyway
- **Localização**: `classpath:db/migration`
- **Baseline**: Habilitado
- **Validação**: Habilitada

## 🧪 Testes

Execute os testes com:
```bash
mvn test
```

## 📝 Exemplo de Uso

### Criar um agendamento
```bash
curl -X POST http://localhost:8080/api/agendamentos \
  -H "Content-Type: application/json" \
  -d '{
    "titulo": "Reunião de Projeto",
    "descricao": "Discussão sobre o desenvolvimento",
    "dataHoraInicio": "2024-01-20T10:00:00",
    "dataHoraFim": "2024-01-20T11:00:00"
  }'
```

### Listar todos os agendamentos
```bash
curl http://localhost:8080/api/agendamentos
```

## 🚀 Funcionalidades

- ✅ CRUD completo de agendamentos
- ✅ Validação de conflitos de horário
- ✅ Busca por diferentes critérios
- ✅ Controle de status
- ✅ Tratamento de exceções global
- ✅ Migrações automáticas com Flyway
- ✅ Banco H2 em memória para desenvolvimento

## 🤝 Contribuição

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.
