# Produtora-Dublagem

## Integrantes do Projeto
[Ewerton Patrick Silva do Amaral (nºUSP: 10346975)](https://github.com/EwertonPSA), [Lucas Nobuyuki Takahashi (nºUSP: 10295670)](https://github.com/LucasNT), Marcelo Kiochi Hatanaka (nºUSP: 10295645) e [Rodrigo Mendes Andrade (nºUSP: 10262721)](https://github.com/skywardsc2).

## Detalhes importantes do projeto
Foi incluido um docker-composer e também um Dockerfile para rodar o postgres com todas as configuradas. As instruções para rodar a aplicação esta na sessão "Como rodar".

A aplicação foi desenvolvida na linguagem Java 8 e pode ser executada em qualquer sistema operacional com o Java 8 instalado. A base de dados foi construída originalmente utilizando-se o SGBD Oracle em um servidor da usp com scripts SQL, contudo buscando preservar os dados do servidor da usp o integrante [EwertonPSA](https://github.com/EwertonPSA) repassou a base de dados para o SGBD Postgresql executando a aplicação no localhost. As [DML (Dados_Produtora.sql)](https://github.com/EwertonPSA/Produtora-Dublagem/blob/master/Dados_Produtora.sql) e [DDL(Esquema_Produtora.sql)](https://github.com/EwertonPSA/Produtora-Dublagem/blob/master/Esquema_Produtora.sql) incluidas na base de dados postgresql se encontram no repositório. 

O sistema não se encontra totalmente completo devido a complexidade e o curto período de tempo que tivemos para o seu desenvolvimento, contudo a interface principal do software e algumas funcionalidades do sistema já funcionam (como busca de dubladores e detalhes de sessões de gravações)

## Descrição do projeto
A aplicação foi desenvolvida para gerenciar o sistema de dublagem de uma produtora de anime. 

####  Desenvolvimento do projeto
O projeto foi desenvolvido para a disciplina SCC0240 Bases de Dados-USP utilizando SGDB Oracle e envolveram 3 partes: 

1) Elaboração do projeto 
2) Criação do modelo relacional e modelo entidade-relacionamento 
3) Implementação do banco de dados em uma aplicação

Todas detalhes do projeto foram incluidos no [pdf](https://github.com/EwertonPSA/Produtora-Dublagem/blob/master/Banco%20de%20Dados%20-%20P3.pdf) desse repositório. 

## Como rodar

acesse a pasta raiz do projeto e execute no terminal:
```
docker-compose up -d
docker exec -i container-produtora psql -U postgres anime_produtora < Esquema_Produtora.sql
docker exec -i container-produtora psql -U postgres anime_produtora < Dados_Produtora.sql
```
Em seguida, rode a aplicação com o comando no terminal:
```
java -jar App.jar
```

## Observação
O programa foi desenvolvido na IDE Eclipse e para rodar aplicação na IDE é necessário incluir a biblioteca [JDBC Driver](https://jdbc.postgresql.org/download.html) no projeto.

## Imagens da Aplicação
<img src="https://raw.githubusercontent.com/EwertonPSA/Produtora-Dublagem/master/img/1.png" width="640" height="400" />
<img src="https://raw.githubusercontent.com/EwertonPSA/Produtora-Dublagem/master/img/2.png" width="640" height="400" />
<img src="https://raw.githubusercontent.com/EwertonPSA/Produtora-Dublagem/master/img/3.png" width="640" height="400" />
