# Desafio-semana-2-SQS-sender

## Sobre a aplicação

O projeto consiste em enviar mensagens customizadas, seguindo um modelo de Fila Standard do serviço de SQS da AWS.

## Link para o consumer da aplicação

https://github.com/LucasRocha2308/Desafio-semana-2-SQS-consomer/tree/main

## Para criar a aplicação

mvn archetype:generate -DgroupId=br.com.sqs_sender -DartifactId=sqs_sender -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false

## Para rodar a aplicação

### De inicio coloque na suas variaveis de ambiente as seguintes informações

code ~/.bash_profile

export AWS_ACCESS_KEY="SUA_KEY"
export AWS_SECRET_KEY="SEU_SECRET"

source ~/.bash_profile

### Depois crie uma lista Standard no serviço de SQS da AWS

#### Para criar uma nova fila temos duas opções, a primeira direto pelo console da AWS e o outro pelo AWS CLI, falando sobre como fazer pela primeira forma temos:

Logar na AWS e procurar pelo serviço de SQS;
Na sequência devemos clicar em Create queue e selecionamos o tipo Standard;
Depois Digitamos o nome da fila (na aplicação colocamos fila-lucas);
Definir as configurações: de tempo definido em visibility timeout, delivey delay, receive message wait, maximum message;
Após definimos os tempos, escolhemos a policy;
Clicar em Create queue.

#### O proximo passo é enviar mensagens para a fila:

Clicamos na fila desejada depois em send and receive message;
Digitamos a mensagem desejada e damos um Send message;

#### Para ler mensagens da fila:

Clicamos na fila desejada e Send and receive message;
Depois em Poll for messages o Poll vai ser realizado, e depois as mensagens serão atualizadas e podemos clicar nelas na fila;
Ao clicar na mensagem desejada, abrirá uma caixa de diálogo informando o conteúdo da mensagem;

#### Para apagar mensagens da fila:

Clicamos na fila desejada e Send and receive message;
Depois clicamos em Poll for messages;
Marcamos o check da mensagem desejada;
Clicamos em delete;
Confirmamos o delete.

#### A segunda forma com AWS CLI devemos seguir  os passos:

obs: para usar o AWS CLI é necessario a sua instalação

AWS configure

AWS sqs create-queue --queue-name="fila-lucas" --region=us-east-1

AWS sqs list-queues # retorna filas existentes

AWS sqs send-message --message-body="Teste" --queue-url=https://sqs.us-east-1.amazonaws.com/839389132124/fila-lucas 

aws sqs receive-message --queue-url=https://sqs.us-east-1.amazonaws.com/839389132124/fila-lucas
aws sqs receive-message --queue-url=https://sqs.us-east-1.amazonaws.com/839389132124/fila-lucas --wait-time-seconds=20 # Long Polling economiza request

AWS sqs delete-message --queue-url=https://sqs.us-east-1.amazonaws.com/839389132124/fila-lucas  --receipt-handle=aqui vai o especifico receipt handle da mensagem

AWS sqs delete-queue --queue-url=https://sqs.us-east-1.amazonaws.com/839389132124/fila-lucas 

### Depois rode os comandos

./build.sh
./start.sh

