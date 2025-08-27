# Sistema de Agendamento de Transferências Bancárias

Sistema para agendamento de transferências bancárias com cálculo automático de taxas baseado no prazo de agendamento. Desenvolvido com Java 11, Spring Boot, Flyway e H2.

## 🚀 Tecnologias Utilizadas

- **Java 11**
- **Spring Boot 2.7.18**
- **Spring Data JPA**
- **Flyway** (Migrações de banco de dados)
- **H2 Database** (Banco em memória)
- **Maven**
- **Lombok**

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
- **API REST**: http://localhost:8080/api/v1
- **Console H2**: http://localhost:8080/h2-console
  - JDBC URL: `jdbc:h2:mem:agendamentodb`
  - Username: `sa`
  - Password: (deixe em branco)

## 📚 Endpoints da API

### Agendamentos (`/api/v1/agendamento`)

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/api/v1/agendamento` | Lista todos os agendamentos |
| POST | `/api/v1/agendamento` | Cria novo agendamento de transferência |

### Taxas de Transferência (`/api/v1/taxa-transferencia`)

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/api/v1/taxa-transferencia` | Lista todas as taxas de transferência |
| POST | `/api/v1/taxa-transferencia/calcular` | Calcula taxa para um agendamento |

## 🗄️ Estrutura do Banco

### Tabela: `tb_status_agendamentos`
- `codigo_status_agendamento` - Código do status (INT, PK)
- `st_nome` - Nome do status (VARCHAR(50))

**Status disponíveis:**
- `1` - PENDENTE
- `2` - REALIZADA

### Tabela: `tb_taxas_dias_tranferencias`
- `codigo_taxa_dia_tranferencia` - Código da taxa (INT, PK)
- `nr_dia_de` - Dia inicial do período (INT)
- `nr_dia_ate` - Dia final do período (INT)
- `dc_taxa` - Taxa fixa (DECIMAL(19,2))
- `dc_porcentagem` - Taxa percentual (DECIMAL(19,2))

**Períodos e taxas:**
- **0 dias**: Taxa fixa R$ 3,00 + 2,50%
- **1-10 dias**: Taxa fixa R$ 12,00 + 0%
- **11-20 dias**: Taxa fixa R$ 0,00 + 8,20%
- **21-30 dias**: Taxa fixa R$ 0,00 + 6,90%
- **31-40 dias**: Taxa fixa R$ 0,00 + 4,70%
- **41-50 dias**: Taxa fixa R$ 0,00 + 1,70%

### Tabela: `tb_agendamentos`
- `codigo_agendamento` - Código único do agendamento (VARCHAR(36), PK)
- `codigo_status_agendamento` - Código do status (INT, FK)
- `st_conta_origem` - Conta de origem (VARCHAR(50))
- `st_conta_destino` - Conta de destino (VARCHAR(50))
- `dc_valor` - Valor da transferência (DECIMAL(19,2))
- `dc_taxa` - Taxa aplicada (DECIMAL(19,2))
- `ts_data_transferencia` - Data da transferência (TIMESTAMP)
- `ts_data_agendamento` - Data do agendamento (TIMESTAMP)

## 📁 Estrutura do Projeto

```
src/
├── main/
│   ├── java/com/agendamento/
│   │   ├── AgendamentoApplication.java
│   │   ├── controller/
│   │   │   ├── AgendamentoController.java
│   │   │   └── TaxaTransferenciaController.java
│   │   ├── service/
│   │   │   ├── AgendamentoService.java
│   │   │   └── TaxaTransferenciaService.java
│   │   ├── repository/
│   │   │   ├── AgendamentoRepository.java
│   │   │   ├── StatusAgendamentoRepository.java
│   │   │   └── TaxaTransferenciaRepository.java
│   │   ├── model/
│   │   │   ├── AgendamentoModel.java
│   │   │   ├── StatusAgendamentoModel.java
│   │   │   └── TaxaTransferenciaModel.java
│   │   ├── facade/
│   │   │   └── TransferenciaFacade.java
│   │   ├── mapper/
│   │   │   ├── AgendamentoMapper.java
│   │   │   └── TaxaTransferenciaMapper.java
│   │   ├── dtos/
│   │   │   ├── request/
│   │   │   │   └── CriarAgendamentoDtoPostReq.java
│   │   │   └── response/
│   │   │       ├── AgendamentoDtoGetRes.java
│   │   │       ├── CriarAgendamentoDtoPostRes.java
│   │   │       ├── TaxasTransferenciaDtoGetRes.java
│   │   │       └── CalcularTaxaTransferenciaDtoPostRes.java
│   │   ├── enums/
│   │   │   └── StatusAgendamentoEnum.java
│   │   └── exception/
│   │       └── GlobalExceptionHandler.java
│   └── resources/
│       ├── application.yml
│       └── db/migration/
│           ├── V1__create_status_agendamento.sql
│           ├── V2__create_taxa_transferencia.sql
│           ├── V3__create_agendamento.sql
│           ├── V4__Insert_status_agendamento.sql
│           └── V5__Insert_taxa_transferencia.sql
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

## 📝 Exemplos de Uso

### Criar um agendamento de transferência
```bash
curl -X POST http://localhost:8080/api/v1/agendamento \
  -H "Content-Type: application/json" \
  -d '{
    "contaOrigem": "12345-6",
    "contaDestino": "65432-1",
    "valor": 100.00,
    "dataTransferencia": "2025-09-26T10:00:00",
    "dataAgendamento": "2025-08-26T17:10:00"
  }'
```

### Listar todos os agendamentos
```bash
curl http://localhost:8080/api/v1/agendamento
```

### Listar taxas de transferência
```bash
curl http://localhost:8080/api/v1/taxa-transferencia
```

### Calcular taxa para um agendamento
```bash
curl -X POST http://localhost:8080/api/v1/taxa-transferencia/calcular \
  -H "Content-Type: application/json" \
  -d '{
    "contaOrigem": "12345-6",
    "contaDestino": "65432-1",
    "valor": 100.00,
    "dataTransferencia": "2025-09-26T10:00:00",
    "dataAgendamento": "2025-08-26T17:10:00"
  }'
```

## 🚀 Funcionalidades

- ✅ **Agendamento de transferências** com cálculo automático de taxas
- ✅ **Cálculo de taxas** baseado no prazo de agendamento (0-50 dias)
- ✅ **Validações automáticas** de dados de entrada
- ✅ **Tratamento de exceções** global e estruturado
- ✅ **Migrações automáticas** com Flyway
- ✅ **Banco H2** em memória para desenvolvimento
- ✅ **API REST** completa para agendamentos e taxas
- ✅ **Validação de regras de negócio** (máximo 50 dias)

## 🔍 Regras de Negócio

1. **Prazo máximo**: Transferências podem ser agendadas até 50 dias no futuro
2. **Cálculo de taxas**: Combinação de taxa fixa + taxa percentual baseada no prazo
3. **Validações**: Contas obrigatórias, valor positivo, datas válidas
4. **Status**: PENDENTE (criação) → REALIZADA (execução)

## 🏗️ Arquitetura e Padrões de Projeto

### **Arquitetura MVC (Model-View-Controller)**

O projeto segue a arquitetura MVC adaptada para APIs REST:

- **Model (Modelo)**: Representa a camada de dados e regras de negócio
  - `AgendamentoModel`, `StatusAgendamentoModel`, `TaxaTransferenciaModel`
  - Anotados com JPA para persistência no banco de dados
  - Contêm as entidades de negócio e suas relações

- **View (Visão)**: Representada pelos DTOs de resposta da API
  - `AgendamentoDtoGetRes`, `CriarAgendamentoDtoPostRes`
  - `TaxasTransferenciaDtoGetRes`, `CalcularTaxaTransferenciaDtoPostRes`
  - Definem como os dados são apresentados ao cliente

- **Controller (Controlador)**: Gerencia as requisições HTTP e validações
  - `AgendamentoController`, `TaxaTransferenciaController`
  - Recebem requisições, validam dados e delegam para a camada de negócio
  - Retornam respostas HTTP apropriadas

### **Design Pattern Facade**

O projeto utiliza o **Facade Pattern** através da classe `TransferenciaFacade`:

```java
@Service
public class TransferenciaFacade {
    
    @Autowired
    private AgendamentoService agendamentoService;
    
    @Autowired
    private TaxaTransferenciaService taxaTransferenciaService;
    
    public CriarAgendamentoDtoPostRes criarAgendamento(CriarAgendamentoDtoPostReq dto) {
        // Lógica complexa de cálculo de taxas
        // Orquestração de múltiplos serviços
        // Retorna resultado simplificado
    }
}
```

**Benefícios do Facade Pattern:**
- ✅ **Simplifica interfaces**: O controller só precisa conhecer o Facade
- ✅ **Encapsula complexidade**: Lógica de cálculo de taxas fica isolada
- ✅ **Reduz acoplamento**: Services podem ser alterados sem afetar controllers
- ✅ **Facilita testes**: Pode-se mockar apenas o Facade para testar controllers

### **Princípios SOLID**

O projeto implementa os princípios SOLID da Programação Orientada a Objetos:

#### **1. Single Responsibility Principle (SRP)**
- **Controller**: Responsável apenas por receber requisições HTTP e retornar respostas
- **Service**: Responsável pela lógica de negócio específica de cada domínio
- **Repository**: Responsável apenas pelo acesso aos dados
- **Facade**: Responsável pela orquestração de múltiplos serviços

#### **2. Open/Closed Principle (OCP)**
- **Extensível**: Novos tipos de agendamento podem ser adicionados sem modificar código existente
- **Fechado para modificação**: Alterações em regras de negócio não afetam a estrutura da API

#### **3. Liskov Substitution Principle (LSP)**
- **Interfaces consistentes**: Diferentes implementações de service podem ser substituídas
- **Contratos respeitados**: Todos os services seguem a mesma interface de contrato

#### **4. Interface Segregation Principle (ISP)**
- **Interfaces específicas**: Cada service tem responsabilidades bem definidas
- **Sem dependências desnecessárias**: Controllers não dependem de interfaces que não utilizam

#### **5. Dependency Inversion Principle (DIP)**
- **Inversão de controle**: Dependências são injetadas via `@Autowired`
- **Abstrações**: Controllers dependem de abstrações (Facade) não de implementações concretas
- **Testabilidade**: Facilita a criação de mocks para testes unitários

### **Estrutura em Camadas**

```
┌─────────────────────────────────────┐
│           Controllers               │ ← Camada de apresentação
│  (Agendamento, TaxaTransferencia)  │
├─────────────────────────────────────┤
│              Facade                 │ ← Camada de orquestração
│        (TransferenciaFacade)       │
├─────────────────────────────────────┤
│             Services                │ ← Camada de negócio
│  (Agendamento, TaxaTransferencia)  │
├─────────────────────────────────────┤
│            Repositories             │ ← Camada de acesso a dados
│  (Agendamento, Status, Taxa)       │
├─────────────────────────────────────┤
│              Models                 │ ← Camada de entidades
│  (Agendamento, Status, Taxa)       │
└─────────────────────────────────────┘
```

**Fluxo de dados:**
1. **Controller** recebe requisição HTTP
2. **Facade** orquestra a lógica de negócio
3. **Services** executam regras específicas
4. **Repositories** acessam o banco de dados
5. **Models** representam as entidades persistidas

## 🤝 Contribuição

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.
