# Produtora-Dublagem

## Integrantes do Projeto
Ewerton Patrick Silva do Amaral (nºUSP: 10346975), Lucas Nobuyuki Takahashi (nºUSP: 10295670), Marcelo Kiochi Hatanaka (nºUSP: 10295645) e Rodrigo Mendes Andrade (nºUSP: 10262721)

## Detalhes importantes sobre o projeto
A aplicação foi desenvolvida na linguagem Java 8 e pode ser executada em qualquer sistema operacional com o Java 8 instalado. A base de dados foi construída originalmente utilizando-se o SGBD Oracle em um servidor da usp com scripts SQL, contudo buscando preservar os dados do servidor da usp o integrante @EwertonPSA repassou a base de dados para o SGBD Postgresql executando a aplicação no localhost. As [DML (arquivo Dados_Produtora.sql)](https://github.com/EwertonPSA/Produtora-Dublagem/blob/master/Dados_Produtora.sql) e [DDL(arquivo Esquema_Produtora.sql)](https://github.com/EwertonPSA/Produtora-Dublagem/blob/master/Esquema_Produtora.sql) incluidas na base de dados postgresql se encontram no repositório.

## Descrição do projeto
A aplicação foi desenvolvida para gerenciar o sistema de dublagem de uma produtora de anime. O sistema não se encontra totalmente completo devido a complexidade e o curto período de tempo que tivemos para o seu desenvolvimento, contudo a interface principal do software e algumas funcionalidades do sistema já funcionam (como busca de dubladores e detalhes de sessões de gravações)

####  Desenvolvimento do projeto
O projeto foi desenvolvido para a disciplina SCC0240 Bases de Dados-USP utilizando SGDB Oracle e envolveram 3 partes: 

1) Elaboração do projeto 
2) Criação do modelo relacional e modelo entidade-relacionamento 
3) Implementação do banco de dados em uma aplicação

Todas detalhes do projeto foram incluidos no [pdf](https://github.com/EwertonPSA/Produtora-Dublagem/blob/master/Banco%20de%20Dados%20-%20P3.pdf) desse repositório. 

## Detalhes de execução
Tendo o banco de dados configurado, a execução desta aplicação pode ser feita a partir do executável [App.jar](https://github.com/EwertonPSA/Produtora-Dublagem/blob/master/App.jar) .
Atualmente o banco de dados Postgresql precisa ser configurado em um servidor local, com senha "postgres" e banco de dados chamado "anime_produtora". O banco de dado pode ser totalmente criado/restaurado a partir do backup [backup_baseDeDados_anime_produtora.sql](https://github.com/EwertonPSA/Produtora-Dublagem/blob/master/backup_baseDeDados_anime_produtora.sql) fornecido nesse repositorio. 

## Observação
O programa foi desenvolvido na IDE Eclipse e para rodar aplicação na IDE é necessário incluir a biblioteca [JDBC Driver](https://jdbc.postgresql.org/download.html) no projeto.

## Aplicação
<img src="https://raw.githubusercontent.com/EwertonPSA/Produtora-Dublagem/master/img/1.png" width="640" height="400" />
<img src="https://raw.githubusercontent.com/EwertonPSA/Produtora-Dublagem/master/img/2.png" width="640" height="400" />
<img src="https://raw.githubusercontent.com/EwertonPSA/Produtora-Dublagem/master/img/3.png" width="640" height="400" />
<img src="https://raw.githubusercontent.com/EwertonPSA/Produtora-Dublagem/master/img/4.png" width="640" height="400" />
