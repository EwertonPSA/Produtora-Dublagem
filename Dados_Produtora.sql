-- AgenciaDeDublagem = { CNPJ, Nome, CEP, Logradouro, Complemento, Numero, Email, Telefone1, Telefone2 }
INSERT INTO AgenciaDeDublagem VALUES(1000, 'Arigatou', 1, 'logradouro1', 'complemento1', 1, 'arigatou@gmail.br', 40028922, NULL);
INSERT INTO AgenciaDeDublagem VALUES(1001, 'Sayonara', 2, 'logradouro2', 'complemento2', 2, 'sayonara@gmail.br', 0800666, 08007777000);
INSERT INTO AgenciaDeDublagem VALUES(1002, 'Sushi', 3, NULL, NULL, 2, 'sushi@gmail.br', 123456, NULL);
INSERT INTO AgenciaDeDublagem VALUES(1003, 'Temaki', 3, NULL, NULL, NULL, 'temaki@gmail.br', NULL, NULL);

-- Dublador = { CPF, Nome, Sexo, Data de Nascimento, Tipo de Voz, CNPJ da Agencia de Dublagem }
INSERT INTO Dublador VALUES(1, 'Lucas', 'M', '1000/01/02', 'BAIXO', 1000);
INSERT INTO Dublador VALUES(2, 'Rodrigo', 'M', '0001/01/01', 'BARITONO', 1000);
INSERT INTO Dublador VALUES(3, 'Ewerton Patrick', 'M', '0001/01/02', 'BAIXO', 1001);
INSERT INTO Dublador VALUES(4, 'Paulo Renato', 'M', '1003/01/01', 'TENOR', 1001);
INSERT INTO Dublador VALUES(5, 'Luiz Miguel', 'M', '1003/01/01', 'CONTRALTO', 1002);
INSERT INTO Dublador VALUES(6, 'Ana Carolina', 'F', '1500/01/01', 'SOPRANO', 1002);
INSERT INTO Dublador VALUES(7, 'Marcelo', 'N', '1000/01/01', 'TENOR', 1003);
INSERT INTO Dublador VALUES(14, 'Marcelo Isaias', 'M', '1000/01/02', 'TENOR', 1003);

INSERT INTO Diretor(cpf, nome, email, cep) VALUES (8, 'Elaine', 'emaildaelaine@gmail.com', 3000);
INSERT INTO Diretor(cpf, nome, email, cep) VALUES (9, 'Denis', 'emaildodenis@gmail.com', 3001);
INSERT INTO Diretor(cpf, nome, email, cep) VALUES (10, 'Joao', 'emaildojoao@gmail.com', 3002);
INSERT INTO Diretor(cpf, nome, email, cep) VALUES (11, 'Maria', 'emaildamaria@gmail.com', 3003);

INSERT INTO TecnicoDeAudio(cpf, nome, dataNascimento, cep) VALUES (12, 'Audemir', '1900/01/03', 3004);
INSERT INTO TecnicoDeAudio(cpf, nome, dataNascimento, cep) VALUES (13, 'Audissom', '1930/01/03', 3005);

-- Sala de Gravacao = { Numero da Sala, Numero de Kits de Gravacao }
INSERT INTO SalaDeGravacao VALUES (1, 8);
INSERT INTO SalaDeGravacao VALUES (2, 10);

-- Anime = { Nome, Ano, Autor, Numero de Temporadas }
INSERT INTO Anime VALUES ('Boku no Hero College', 2016, 'Marcelo', 2);
INSERT INTO Anime VALUES ('Baitekita - Computer Science Adventure', 2019, 'Rodrigo', 1);
INSERT INTO Anime VALUES ('Binary Art Online', 2019, 'Marcelo', 1);
INSERT INTO Anime VALUES ('Dragon Ball', 2001, 'Akira Toriyama', 1);
INSERT INTO Anime VALUES ('Pokemon', 2001, 'Satoshi Tagiri', 1);


-- Personagem = { Anime, Nome, Descricao, Tipo de Voz }
INSERT INTO Personagem VALUES ('Boku no Hero College', 'Kiyoshi Hatanaka', 'Um transformer ford Ka', 'TENOR');
INSERT INTO Personagem VALUES ('Boku no Hero College', 'Nobuyuki Takahashi', 'Um cara bacana', 'BAIXO');
INSERT INTO Personagem VALUES ('Boku no Hero College', 'Shiruba do Amararu', 'Mais legal que Mendesu e Faineru, mais bacana que Nobuyuki e mais divertido que Di Mano Saraiba', 'BAIXO');
INSERT INTO Personagem VALUES ('Boku no Hero College', 'Mendesu Andorade', 'Um cara legal', 'BARITONO');
INSERT INTO Personagem VALUES ('Boku no Hero College', 'Di Mano Saraiba', 'Um cara divertido', 'CONTRALTO');
INSERT INTO Personagem VALUES ('Boku no Hero College', 'Camposu Barubosa', 'Um trem', 'TENOR');
INSERT INTO Personagem VALUES ('Boku no Hero College', 'Faineru Oribera', 'Uma moça legal', 'SOPRANO');
INSERT INTO Personagem VALUES ('Baitekita - Computer Science Adventure', 'Sushi', 'Arroz, peixe cru, algas e verduras', 'CONTRALTO');
INSERT INTO Personagem VALUES ('Binary Art Online', 'Temaki', 'Sushi em formato de sorvete casquinha', 'TENOR');
INSERT INTO Personagem VALUES ('Binary Art Online', 'Shoyu', 'Molho preto e salgado', 'BARITONO');
INSERT INTO Personagem VALUES ('Binary Art Online', 'Arigatou', 'Muito agradecido', 'BAIXO');
INSERT INTO Personagem VALUES ('Binary Art Online', 'Sayonara', 'Adeus', 'BARITONO');
INSERT INTO Personagem VALUES ('Dragon Ball', 'Goku', 'Seu poder eh de mais de 8 mil', 'TENOR');
INSERT INTO Personagem VALUES ('Pokemon', 'Pikachu', 'Personagem chocante', 'SOPRANO');

-- Temporada = { Anime, Numero da Temporada, Data Inicial, Data Final, CPF do Diretor }
 INSERT INTO Temporada VALUES('Boku no Hero College', 1, '2017/08/01', '2017/12/10', 8);
 INSERT INTO Temporada VALUES('Boku no Hero College', 2, '2018/02/01', '2018/05/10', 9);
 INSERT INTO Temporada VALUES('Baitekita - Computer Science Adventure', 1, '2017/03/01', '2017/06/30', 10);
 INSERT INTO Temporada VALUES('Binary Art Online', 1, '2017/03/01', '2017/06/30', 11);
 INSERT INTO Temporada VALUES('Dragon Ball', 1, '2001/07/05', '2001/12/10', 10);
 INSERT INTO Temporada VALUES('Pokemon', 1, '2001/07/05', '2001/12/10', 11);

-- Episodio = { Anime, Temporada, Numero do Episodio, ID do Episodio, Titulo, Duracao }
INSERT INTO Episodio VALUES('Boku no Hero College', 1, 1, 10005, 'Apocalipse: Back to College', '00:24:0'); 
INSERT INTO Episodio VALUES('Boku no Hero College', 1, 2, 10006, 'Catundas Nightmare', '00:24:0'); 
INSERT INTO Episodio VALUES('Boku no Hero College', 1, 3, 10007, 'Mellos Surprise', '00:24:0'); 
INSERT INTO Episodio VALUES('Boku no Hero College', 1, 4, 10008, 'Sasha no Tsukuyomi', '00:24:0'); 
INSERT INTO Episodio VALUES('Boku no Hero College', 1, 5, 10009, 'Its finally over... or is it?', '00:24:0'); 
INSERT INTO Episodio VALUES('Boku no Hero College', 2, 1, 10010, 'Summer is over!', '00:24:0'); 
INSERT INTO Episodio VALUES('Boku no Hero College', 2, 2, 10011, 'A New Enemy Appears: Peter Rivers!', '00:48:0'); 
INSERT INTO Episodio VALUES('Boku no Hero College', 2, 3, 10012, 'Kiyoshis Heartbreaking Smile!', '00:24:0'); 
INSERT INTO Episodio VALUES('Boku no Hero College', 2, 4, 10013, 'Crowded Bus! We hate going to Campus 2!', '00:24:0'); 
INSERT INTO Episodio VALUES('Boku no Hero College', 2, 5, 10014, 'Winter', '00:24:0'); 
INSERT INTO Episodio VALUES('Baitekita - Computer Science Adventure', 1, 10, 10000, 'Sushis Insight', '00:24:0'); 
INSERT INTO Episodio VALUES('Baitekita - Computer Science Adventure', 1, 2, 10001, 'The Real Prank - Calculus Test', '00:24:0'); 
INSERT INTO Episodio VALUES('Binary Art Online', 1, 1, 10002, NULL, '00:24:0'); 
INSERT INTO Episodio VALUES('Dragon Ball', 1, 1, 10003, NULL, '00:24:0'); 
INSERT INTO Episodio VALUES('Pokemon', 1, 1, 10004, NULL, '00:24:0'); 

-- Cena = { Episodio, Numero da Cena, Duracao, Script, Estado de Gravacao, Audio }

INSERT INTO Cena VALUES(10005, 1, '00:7:0', decode('416cf42c2067616c65726120646520636f77626f792120416cf42c2067616c657261206465207065e36f21','hex'), 
	'GRAVADO', decode('524946461870060057415645666d7420100000000100020044ac000010b102000400100064617461f46f0600fffff9fffafffefffafff9fffafffafff6fff7fffcfffcff','hex')); 
INSERT INTO Cena VALUES(10005, 2, '00:7:0', decode('4520656e74e36f20746f646f73207669766572616d2066656c697a657320706172612073656d7072652e','hex'), 
	'GRAVADO', decode('0aee0eeed5eed0eea5efabef8ff089f0c5f1c6f11bf317f398f496f441f639f6baf7c2f733f928f9a4faaafa1cfc15fc','hex')); 
INSERT INTO Cena VALUES(10005, 3, '00:7:0', NULL, 'GRAVADO', NULL);
INSERT INTO Cena VALUES(10006, 1, '00:7:0', NULL, 'GRAVADO', NULL);
INSERT INTO Cena VALUES(10006, 2, '00:7:0', NULL, 'GRAVADO', NULL);
INSERT INTO Cena VALUES(10006, 3, '00:7:0', NULL, 'GRAVADO', NULL); 
INSERT INTO Cena VALUES(10007, 1, '00:7:0', NULL, 'GRAVADO', NULL); 
INSERT INTO Cena VALUES(10007, 2, '00:7:0', NULL, 'GRAVADO', NULL); 
INSERT INTO Cena VALUES(10007, 3, '00:7:0', NULL, 'GRAVADO', NULL); 
INSERT INTO Cena VALUES(10008, 1, '00:7:0', NULL, 'GRAVADO', NULL); 
INSERT INTO Cena VALUES(10008, 2, '00:7:0', NULL, 'GRAVADO', NULL); 
INSERT INTO Cena VALUES(10008, 3, '00:7:0', NULL, 'GRAVADO', NULL); 
INSERT INTO Cena VALUES(10009, 1, '00:7:0', NULL, 'GRAVADO', NULL); 
INSERT INTO Cena VALUES(10009, 2, '00:7:0', NULL, 'GRAVADO', NULL); 
INSERT INTO Cena VALUES(10009, 3, '00:7:0', NULL, 'GRAVADO', NULL); 
INSERT INTO Cena VALUES(10010, 1, '00:7:0', NULL, 'GRAVADO', NULL); 
INSERT INTO Cena VALUES(10010, 2, '00:7:0', NULL, 'GRAVADO', NULL); 
INSERT INTO Cena VALUES(10010, 3, '00:7:0', NULL, 'GRAVADO', NULL); 
INSERT INTO Cena VALUES(10011, 1, '00:7:0', NULL, 'GRAVADO', NULL); 
INSERT INTO Cena VALUES(10011, 2, '00:7:0', NULL, 'GRAVADO', NULL); 
INSERT INTO Cena VALUES(10011, 3, '00:7:0', NULL, 'GRAVADO', NULL); 
INSERT INTO Cena VALUES(10012, 1, '00:7:0', NULL, 'GRAVADO', NULL); 
INSERT INTO Cena VALUES(10012, 2, '00:7:0', NULL, 'GRAVADO', NULL); 
INSERT INTO Cena VALUES(10012, 3, '00:7:0', NULL, 'GRAVADO', NULL); 
INSERT INTO Cena VALUES(10013, 1, '00:7:0', NULL, 'NECESSITA DE REGRAVACAO', NULL); 
INSERT INTO Cena VALUES(10013, 2, '00:7:0', NULL, 'NECESSITA DE REGRAVACAO', NULL); 
INSERT INTO Cena VALUES(10013, 3, '00:7:0', NULL, 'NAO GRAVADO', NULL); 
INSERT INTO Cena VALUES(10014, 1, '00:7:0', NULL, 'NAO GRAVADO', NULL); 
INSERT INTO Cena VALUES(10014, 2, '00:7:0', NULL, 'NAO GRAVADO', NULL); 
INSERT INTO Cena VALUES(10014, 3, '00:7:0', NULL, 'NAO GRAVADO', NULL); 
INSERT INTO Cena VALUES(10000, 1, '00:3:2', NULL, 'NAO GRAVADO', NULL); 
INSERT INTO Cena VALUES(10001, 1, '00:3:3', NULL, 'NAO GRAVADO', NULL); 
INSERT INTO Cena VALUES(10002, 1, '00:1:4', NULL, 'NECESSITA DE REGRAVACAO', NULL); 
INSERT INTO Cena VALUES(10003, 1, '00:5:0', NULL, 'NAO GRAVADO', NULL); 
INSERT INTO Cena VALUES(10004, 1, '00:1:0', NULL, 'NECESSITA DE REGRAVACAO', NULL); 
-- A soma da duracao das cenas de um episodio nao eh igual a duracao do episodio, pois o episodio
--  pode conter clipes de abertura e encerramento, dentro outros.

-- Interpreta = { Anime, Personagem, CPF do Dublador, Avaliacao Total, Nro de Avaliacoes }
INSERT INTO Interpreta VALUES('Boku no Hero College', 'Kiyoshi Hatanaka', 7, 10, 7);
INSERT INTO Interpreta VALUES('Boku no Hero College', 'Nobuyuki Takahashi', 1, 10, 6);
INSERT INTO Interpreta VALUES('Boku no Hero College', 'Mendesu Andorade', 2, 10, 6);
INSERT INTO Interpreta VALUES('Boku no Hero College', 'Shiruba do Amararu', 3, 10, 6);
INSERT INTO Interpreta VALUES('Boku no Hero College', 'Di Mano Saraiba', 5, 10, 5);
INSERT INTO Interpreta VALUES('Boku no Hero College', 'Camposu Barubosa', 4, 10, 4);
INSERT INTO Interpreta VALUES('Boku no Hero College', 'Faineru Oribera', 6, 10, 5);
INSERT INTO Interpreta VALUES('Boku no Hero College', 'Camposu Barubosa', 14, 8, 1);
INSERT INTO Interpreta VALUES('Baitekita - Computer Science Adventure', 'Sushi', 5, NULL, NULL);
INSERT INTO Interpreta VALUES('Binary Art Online', 'Temaki', 7, NULL, NULL);
INSERT INTO Interpreta VALUES('Dragon Ball', 'Goku', 4, NULL, NULL);
INSERT INTO Interpreta VALUES('Pokemon', 'Pikachu', 6, NULL, NULL);

-- Dubla = { ID do Episodio, Anime, Personagem, CPF do Dublador, Avaliacao Parcial }
-- Boku no Hero College
--  S01 E01
INSERT INTO Dubla VALUES(10005, 'Boku no Hero College', 'Nobuyuki Takahashi', 1, 10);
INSERT INTO Dubla VALUES(10005, 'Boku no Hero College', 'Kiyoshi Hatanaka', 7, 10);
INSERT INTO Dubla VALUES(10005, 'Boku no Hero College', 'Mendesu Andorade', 2, 10);
INSERT INTO Dubla VALUES(10005, 'Boku no Hero College', 'Shiruba do Amararu', 3, 10);
INSERT INTO Dubla VALUES(10005, 'Boku no Hero College', 'Di Mano Saraiba', 5, 10);
INSERT INTO Dubla VALUES(10005, 'Boku no Hero College', 'Camposu Barubosa', 4, 10);
INSERT INTO Dubla VALUES(10005, 'Boku no Hero College', 'Faineru Oribera', 6, 10);
--  E02, E03, E04
INSERT INTO Dubla VALUES(10006, 'Boku no Hero College', 'Mendesu Andorade', 2, 10);
INSERT INTO Dubla VALUES(10006, 'Boku no Hero College', 'Di Mano Saraiba', 5, 10);
INSERT INTO Dubla VALUES(10007, 'Boku no Hero College', 'Nobuyuki Takahashi', 1, 10);
INSERT INTO Dubla VALUES(10007, 'Boku no Hero College', 'Kiyoshi Hatanaka', 7, 10);
INSERT INTO Dubla VALUES(10008, 'Boku no Hero College', 'Shiruba do Amararu', 3, 10);
INSERT INTO Dubla VALUES(10008, 'Boku no Hero College', 'Faineru Oribera', 6, 10);
--  E05
INSERT INTO Dubla VALUES(10009, 'Boku no Hero College', 'Nobuyuki Takahashi', 1, 10);
INSERT INTO Dubla VALUES(10009, 'Boku no Hero College', 'Kiyoshi Hatanaka', 7, 10);
INSERT INTO Dubla VALUES(10009, 'Boku no Hero College', 'Mendesu Andorade', 2, 10);
INSERT INTO Dubla VALUES(10009, 'Boku no Hero College', 'Shiruba do Amararu', 3, 10);
INSERT INTO Dubla VALUES(10009, 'Boku no Hero College', 'Di Mano Saraiba', 5, 10);
INSERT INTO Dubla VALUES(10009, 'Boku no Hero College', 'Camposu Barubosa', 4, 10);
INSERT INTO Dubla VALUES(10009, 'Boku no Hero College', 'Faineru Oribera', 6, 10);
--  S02 E01
INSERT INTO Dubla VALUES(10010, 'Boku no Hero College', 'Nobuyuki Takahashi', 1, 10);
INSERT INTO Dubla VALUES(10010, 'Boku no Hero College', 'Kiyoshi Hatanaka', 7, 10);
INSERT INTO Dubla VALUES(10010, 'Boku no Hero College', 'Mendesu Andorade', 2, 10);
INSERT INTO Dubla VALUES(10010, 'Boku no Hero College', 'Shiruba do Amararu', 3, 10);
INSERT INTO Dubla VALUES(10010, 'Boku no Hero College', 'Di Mano Saraiba', 5, 10);
INSERT INTO Dubla VALUES(10010, 'Boku no Hero College', 'Camposu Barubosa', 4, 10);
INSERT INTO Dubla VALUES(10010, 'Boku no Hero College', 'Faineru Oribera', 6, 10);
--  E02, E03, E04
INSERT INTO Dubla VALUES(10011, 'Boku no Hero College', 'Kiyoshi Hatanaka', 7, 10);
INSERT INTO Dubla VALUES(10011, 'Boku no Hero College', 'Nobuyuki Takahashi', 1, 10);
INSERT INTO Dubla VALUES(10012, 'Boku no Hero College', 'Kiyoshi Hatanaka', 7, 10);
INSERT INTO Dubla VALUES(10012, 'Boku no Hero College', 'Mendesu Andorade', 2, 10);
INSERT INTO Dubla VALUES(10013, 'Boku no Hero College', 'Camposu Barubosa', 14, 9);
INSERT INTO Dubla VALUES(10013, 'Boku no Hero College', 'Shiruba do Amararu', 3, 10);
--  E05
INSERT INTO Dubla VALUES(10014, 'Boku no Hero College', 'Nobuyuki Takahashi', 1, 10);
INSERT INTO Dubla VALUES(10014, 'Boku no Hero College', 'Kiyoshi Hatanaka', 7, 10);
INSERT INTO Dubla VALUES(10014, 'Boku no Hero College', 'Mendesu Andorade', 2, 10);
INSERT INTO Dubla VALUES(10014, 'Boku no Hero College', 'Shiruba do Amararu', 3, 10);
INSERT INTO Dubla VALUES(10014, 'Boku no Hero College', 'Di Mano Saraiba', 5, 10);
INSERT INTO Dubla VALUES(10014, 'Boku no Hero College', 'Camposu Barubosa', 4, 10);
INSERT INTO Dubla VALUES(10014, 'Boku no Hero College', 'Faineru Oribera', 6, 10);
-- Outros Animes
INSERT INTO Dubla VALUES(10000, 'Baitekita - Computer Science Adventure', 'Sushi', 5, NULL);
INSERT INTO Dubla VALUES(10001, 'Baitekita - Computer Science Adventure', 'Sushi', 5, NULL);
INSERT INTO Dubla VALUES(10002, 'Binary Art Online', 'Temaki', 7, NULL);
INSERT INTO Dubla VALUES(10003, 'Dragon Ball', 'Goku', 4, NULL);
INSERT INTO Dubla VALUES(10004, 'Pokemon', 'Pikachu', 6, NULL);

-- Sessao de Gravacao = { Sala, Data/Hora de Inicio, CPF do Tecnico de Audio, Data/Hora de Fim }
-- Boku no Hero College
INSERT INTO SessaoDeGravacao VALUES(1, '2017/02/01 15:00:00', 12, '2017/02/01 18:00:00');

INSERT INTO SessaoDeGravacao VALUES(2, '2017/02/08 15:00:00', 12, '2017/02/08 18:00:00');

INSERT INTO SessaoDeGravacao VALUES(1, '2017/02/15 15:00:00', 12, '2017/02/15 18:00:00');

INSERT INTO SessaoDeGravacao VALUES(2, '2017/02/22 15:00:00', 12, '2017/02/22 18:00:00');

INSERT INTO SessaoDeGravacao VALUES(1, '2017/03/01 15:00:00', 12, '2017/03/01 18:00:00');

INSERT INTO SessaoDeGravacao VALUES(2, '2017/08/01 15:00:00', 12, '2017/08/01 18:00:00');

INSERT INTO SessaoDeGravacao VALUES(1, '2017/08/08 15:00:00', 13, '2017/08/08 18:00:00');

INSERT INTO SessaoDeGravacao VALUES(2, '2017/08/15 15:00:00', 13, '2017/08/15 18:00:00');

INSERT INTO SessaoDeGravacao VALUES(1, '2017/08/22 15:00:00', 13, '2017/08/22 18:00:00');

INSERT INTO SessaoDeGravacao VALUES(2, '2017/08/29 15:00:00', 13, '2017/08/29 18:00:00');

-- Outros Animes 
INSERT INTO SessaoDeGravacao VALUES(1, '2016/10/20 15:00:00', 13, '2016/10/20 16:00:00');

INSERT INTO SessaoDeGravacao VALUES(2, '2016/10/22 16:00:00', 13, '2016/10/22 18:00:00');

INSERT INTO SessaoDeGravacao VALUES(1, '2016/10/21 16:00:00', 13, '2016/10/21 18:00:00');

INSERT INTO SessaoDeGravacao VALUES(2, '2001/01/20 16:00:00', 13, '2001/01/20 18:00:00');

INSERT INTO SessaoDeGravacao VALUES(1, '2001/01/21 16:00:00', 12, '2001/01/21 18:00:00');


-- Produz = { Sala, Data/Hora de Inicio da Sessao, ID do Episodio, Cena}
-- Boku no Hero College
INSERT INTO Produz VALUES(1, '2017/02/01 15:00:00', 10005, 1); 
INSERT INTO Produz VALUES(1, '2017/02/01 15:00:00', 10005, 2); 
INSERT INTO Produz VALUES(1, '2017/02/01 15:00:00', 10005, 3); 
INSERT INTO Produz VALUES(2, '2017/02/08 15:00:00', 10006, 1); 
INSERT INTO Produz VALUES(2, '2017/02/08 15:00:00', 10006, 2); 
INSERT INTO Produz VALUES(2, '2017/02/08 15:00:00', 10006, 3); 
INSERT INTO Produz VALUES(1, '2017/02/15 15:00:00', 10007, 1); 
INSERT INTO Produz VALUES(1, '2017/02/15 15:00:00', 10007, 2); 
INSERT INTO Produz VALUES(1, '2017/02/15 15:00:00', 10007, 3); 
INSERT INTO Produz VALUES(2, '2017/02/22 15:00:00', 10008, 1); 
INSERT INTO Produz VALUES(2, '2017/02/22 15:00:00', 10008, 2); 
INSERT INTO Produz VALUES(2, '2017/02/22 15:00:00', 10008, 3); 
INSERT INTO Produz VALUES(1, '2017/03/01 15:00:00', 10009, 1); 
INSERT INTO Produz VALUES(1, '2017/03/01 15:00:00', 10009, 2); 
INSERT INTO Produz VALUES(1, '2017/03/01 15:00:00', 10009, 3); 
INSERT INTO Produz VALUES(2, '2017/08/01 15:00:00', 10010, 1); 
INSERT INTO Produz VALUES(2, '2017/08/01 15:00:00', 10010, 2); 
INSERT INTO Produz VALUES(2, '2017/08/01 15:00:00', 10010, 3); 
INSERT INTO Produz VALUES(1, '2017/08/08 15:00:00', 10011, 1); 
INSERT INTO Produz VALUES(1, '2017/08/08 15:00:00', 10011, 2); 
INSERT INTO Produz VALUES(1, '2017/08/08 15:00:00', 10011, 3); 
INSERT INTO Produz VALUES(2, '2017/08/15 15:00:00', 10012, 1); 
INSERT INTO Produz VALUES(2, '2017/08/15 15:00:00', 10012, 2); 
INSERT INTO Produz VALUES(2, '2017/08/15 15:00:00', 10012, 3); 
INSERT INTO Produz VALUES(1, '2017/08/22 15:00:00', 10013, 1); 
INSERT INTO Produz VALUES(1, '2017/08/22 15:00:00', 10013, 2); 
INSERT INTO Produz VALUES(1, '2017/08/22 15:00:00', 10013, 3); 
INSERT INTO Produz VALUES(2, '2017/08/29 15:00:00', 10014, 1); 
INSERT INTO Produz VALUES(2, '2017/08/29 15:00:00', 10014, 2); 
INSERT INTO Produz VALUES(2, '2017/08/29 15:00:00', 10014, 3); 
-- Outros Animes 
INSERT INTO Produz VALUES(1, '2016/10/20 15:00:00', 10000, 1); 
INSERT INTO Produz VALUES(2, '2016/10/22 16:00:00', 10001, 1); 
INSERT INTO Produz VALUES(1, '2016/10/21 16:00:00', 10002, 1); 
INSERT INTO Produz VALUES(2, '2001/01/20 16:00:00', 10003, 1); 
INSERT INTO Produz VALUES(1, '2001/01/21 16:00:00', 10004, 1); 
 
-- Participa = { Anime, Personagem, ID do Episodio, Cena }
-- Boku no Hero College
-- S01 E01
INSERT INTO Participa VALUES('Boku no Hero College', 'Nobuyuki Takahashi', 10005, 1);
INSERT INTO Participa VALUES('Boku no Hero College', 'Kiyoshi Hatanaka', 10005, 1);
INSERT INTO Participa VALUES('Boku no Hero College', 'Mendesu Andorade', 10005, 2);
INSERT INTO Participa VALUES('Boku no Hero College', 'Shiruba do Amararu', 10005, 2);
INSERT INTO Participa VALUES('Boku no Hero College', 'Di Mano Saraiba', 10005, 3);
INSERT INTO Participa VALUES('Boku no Hero College', 'Camposu Barubosa', 10005, 3);
INSERT INTO Participa VALUES('Boku no Hero College', 'Faineru Oribera', 10005, 3);
-- E02
INSERT INTO Participa VALUES('Boku no Hero College', 'Mendesu Andorade', 10006, 1);
INSERT INTO Participa VALUES('Boku no Hero College', 'Di Mano Saraiba', 10006, 2);
INSERT INTO Participa VALUES('Boku no Hero College', 'Mendesu Andorade', 10006, 3);
INSERT INTO Participa VALUES('Boku no Hero College', 'Di Mano Saraiba', 10006, 3);
-- E03
INSERT INTO Participa VALUES('Boku no Hero College', 'Nobuyuki Takahashi', 10007, 1);
INSERT INTO Participa VALUES('Boku no Hero College', 'Kiyoshi Hatanaka', 10007, 1);
INSERT INTO Participa VALUES('Boku no Hero College', 'Nobuyuki Takahashi', 10007, 2);
INSERT INTO Participa VALUES('Boku no Hero College', 'Kiyoshi Hatanaka', 10007, 3);
-- E04
INSERT INTO Participa VALUES('Boku no Hero College', 'Shiruba do Amararu', 10008, 1);
INSERT INTO Participa VALUES('Boku no Hero College', 'Faineru Oribera', 10008, 2);
INSERT INTO Participa VALUES('Boku no Hero College', 'Shiruba do Amararu', 10008, 2);
INSERT INTO Participa VALUES('Boku no Hero College', 'Faineru Oribera', 10008, 3);
-- E05
INSERT INTO Participa VALUES('Boku no Hero College', 'Nobuyuki Takahashi', 10009, 1);
INSERT INTO Participa VALUES('Boku no Hero College', 'Kiyoshi Hatanaka', 10009, 1);
INSERT INTO Participa VALUES('Boku no Hero College', 'Mendesu Andorade', 10009, 2);
INSERT INTO Participa VALUES('Boku no Hero College', 'Shiruba do Amararu', 10009, 2);
INSERT INTO Participa VALUES('Boku no Hero College', 'Di Mano Saraiba', 10009, 3);
INSERT INTO Participa VALUES('Boku no Hero College', 'Camposu Barubosa', 10009, 3);
INSERT INTO Participa VALUES('Boku no Hero College', 'Faineru Oribera', 10009, 3);
-- S02 E01
INSERT INTO Participa VALUES('Boku no Hero College', 'Nobuyuki Takahashi', 10010, 1);
INSERT INTO Participa VALUES('Boku no Hero College', 'Kiyoshi Hatanaka', 10010, 1);
INSERT INTO Participa VALUES('Boku no Hero College', 'Mendesu Andorade', 10010, 2);
INSERT INTO Participa VALUES('Boku no Hero College', 'Shiruba do Amararu', 10010, 2);
INSERT INTO Participa VALUES('Boku no Hero College', 'Di Mano Saraiba', 10010, 3);
INSERT INTO Participa VALUES('Boku no Hero College', 'Camposu Barubosa', 10010, 3);
INSERT INTO Participa VALUES('Boku no Hero College', 'Faineru Oribera', 10010, 3);
-- E02
INSERT INTO Participa VALUES('Boku no Hero College', 'Nobuyuki Takahashi', 10011, 1);
INSERT INTO Participa VALUES('Boku no Hero College', 'Kiyoshi Hatanaka', 10011, 1);
INSERT INTO Participa VALUES('Boku no Hero College', 'Nobuyuki Takahashi', 10011, 2);
INSERT INTO Participa VALUES('Boku no Hero College', 'Kiyoshi Hatanaka', 10011, 3);
-- E03
INSERT INTO Participa VALUES('Boku no Hero College', 'Kiyoshi Hatanaka', 10012, 1);
INSERT INTO Participa VALUES('Boku no Hero College', 'Mendesu Andorade', 10012, 1);
INSERT INTO Participa VALUES('Boku no Hero College', 'Mendesu Andorade', 10012, 2);
INSERT INTO Participa VALUES('Boku no Hero College', 'Kiyoshi Hatanaka', 10012, 3);
-- E04
INSERT INTO Participa VALUES('Boku no Hero College', 'Camposu Barubosa', 10013, 1);
INSERT INTO Participa VALUES('Boku no Hero College', 'Shiruba do Amararu', 10013, 2);
INSERT INTO Participa VALUES('Boku no Hero College', 'Camposu Barubosa', 10013, 3);
INSERT INTO Participa VALUES('Boku no Hero College', 'Shiruba do Amararu', 10013, 3);
-- E05
INSERT INTO Participa VALUES('Boku no Hero College', 'Nobuyuki Takahashi', 10014, 1);
INSERT INTO Participa VALUES('Boku no Hero College', 'Kiyoshi Hatanaka', 10014, 1);
INSERT INTO Participa VALUES('Boku no Hero College', 'Mendesu Andorade', 10014, 2);
INSERT INTO Participa VALUES('Boku no Hero College', 'Shiruba do Amararu', 10014, 2);
INSERT INTO Participa VALUES('Boku no Hero College', 'Di Mano Saraiba', 10014, 3);
INSERT INTO Participa VALUES('Boku no Hero College', 'Camposu Barubosa', 10014, 3);
INSERT INTO Participa VALUES('Boku no Hero College', 'Faineru Oribera', 10014, 3);
-- Outros Animes
INSERT INTO Participa VALUES('Baitekita - Computer Science Adventure', 'Sushi', 10000, 1);
INSERT INTO Participa VALUES('Baitekita - Computer Science Adventure', 'Sushi', 10001, 1);
INSERT INTO Participa VALUES('Binary Art Online', 'Temaki', 10002, 1);
INSERT INTO Participa VALUES('Dragon Ball', 'Goku', 10003, 1);
INSERT INTO Participa VALUES('Pokemon', 'Pikachu', 10004, 1);
