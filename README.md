# health_GPT
Integrando Spring com Chat GPT para gerar dietas e treinos de acordo com as informações enviadas. Deploy feito na AWS, em uma instância EC2 rodando com Docker.

# Para testar o endpoint

curl --location 'https://apihealthgpt-production.up.railway.app/api/v1/diet' \
--header 'Content-Type: application/json' \
--data '{
    "idade": 21,
    "peso": 120.0,
    "altura": 1.73,
    "objetivo": "Emagrecimento"
}'
