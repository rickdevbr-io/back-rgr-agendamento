#!/bin/bash

echo "Iniciando projeto de Agendamento em modo desenvolvimento..."
echo ""
echo "Configurações:"
echo "- Porta: 8080"
echo "- Banco: H2 (memoria)"
echo "- Console H2: http://localhost:8080/h2-console"
echo "- API: http://localhost:8080/api/agendamentos"
echo ""

mvn spring-boot:run -Dspring-boot.run.profiles=dev
