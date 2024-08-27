#!/bin/bash

# Build da aplicação Angular
ng build --configuration production --verbose

# Transferência dos arquivos para a VPS
scp -r ./dist/productivity-hub-fe/* root@86.38.204.217:/var/www/productivity-hub/

# Reiniciar o Nginx na VPS (se necessário)
ssh root@86.38.204.217 "sudo systemctl restart nginx"
