@echo off
echo Iniciando projeto de Agendamento em modo desenvolvimento...
echo.
echo Configurações:
echo - Porta: 8080
echo - Banco: H2 (memoria)
echo - Console H2: http://localhost:8080/h2-console
echo - API: http://localhost:8080/api/agendamentos
echo.
echo Pressione qualquer tecla para continuar...
pause >nul

mvn spring-boot:run -Dspring-boot.run.profiles=dev
