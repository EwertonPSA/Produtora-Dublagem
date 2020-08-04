CREATE FUNCTION N_DIGIT(n_digitos int, valor bigint)
RETURNS boolean AS $$
BEGIN
	RETURN length(valor::text) <= n_digitos;
END;
$$ LANGUAGE plpgSQL;

CREATE FUNCTION N_DIGIT(n_digitos integer, valor integer)
RETURNS boolean as $$
BEGIN
	RETURN length(n_digitos::text) <= valor;
END;
$$ LANGUAGE plpgsql;

CREATE TABLE AgenciaDeDublagem(
    cnpj BIGINT CHECK(N_DIGIT(14,cnpj)=TRUE),
    nome VARCHAR(100),
    cep INTEGER,
    logradouro VARCHAR(100),
    complemento VARCHAR(150),
    numero INTEGER,	-- Numero do endereco
    email VARCHAR(100),
    telefone1 BIGINT CHECK(N_DIGIT(11,telefone1)=TRUE),
    telefone2 BIGINT CHECK(N_DIGIT(11,telefone2)=TRUE),
    CONSTRAINT PK_AgenciaDeDublagem PRIMARY KEY(cnpj)
);

CREATE TABLE Dublador(
    cpf BIGINT CHECK(N_DIGIT(11,cpf)=TRUE),
    nome VARCHAR(100),
    sexo CHAR(1),
    dataNascimento DATE,
    tipoDeVoz VARCHAR(20),
    agenciaDeDublagem INTEGER NOT NULL,
    CONSTRAINT PK_Dublador PRIMARY KEY(cpf),
    CONSTRAINT FK_Dublador_Agencia FOREIGN KEY(agenciaDeDublagem) REFERENCES AgenciaDeDublagem(cnpj) ON DELETE CASCADE,
    -- 'M' = Masculino, 'F' = Feminino e 'N' = Nao-binario
    CONSTRAINT DOM_Dublador_sexo CHECK(UPPER(sexo) IN ('M', 'F', 'N')),
    CONSTRAINT DOM_Dublador_tipoDeVoz CHECK(UPPER(tipoDeVoz) IN (
            'SOPRANO', 'MEZZO_SOPRANO', 'CONTRALTO', 'TENOR', 'BARITONO', 'BAIXO'
        ))
);

CREATE TABLE Diretor(
	cpf BIGINT CHECK(N_DIGIT(11,cpf)=TRUE),
	nome VARCHAR(100), 
	cep INTEGER,
	logradouro VARCHAR(100),
	complemento VARCHAR(150),
	numero INTEGER,--Numero do endereco
	email VARCHAR(100),
	telefone1 BIGINT CHECK(N_DIGIT(11,telefone1)=TRUE),
	telefone2 BIGINT CHECK(N_DIGIT(11,telefone2)=TRUE),
	CONSTRAINT PK_Diretor PRIMARY KEY(cpf)
);

CREATE TABLE TecnicoDeAudio(
	cpf BIGINT CHECK(N_DIGIT(11,cpf)=TRUE),
	nome VARCHAR(100),
	dataNascimento DATE,
	cep INTEGER,
	logradouro VARCHAR(100),
	complemento VARCHAR(150),
	numero INTEGER, --Numero do endereco
	email VARCHAR(100),
	telefone1 BIGINT CHECK(N_DIGIT(11,telefone1)=TRUE),
	telefone2 BIGINT CHECK(N_DIGIT(11,telefone1)=TRUE),
	CONSTRAINT PK_TecnicoDeAudio PRIMARY KEY(cpf)
);

CREATE TABLE SalaDeGravacao(
	numero INTEGER,
	numeroKits INTEGER CHECK(N_DIGIT(2,numeroKits)=TRUE),
	CONSTRAINT PK_SalaDeGravacao PRIMARY KEY(numero)
);

CREATE TABLE Anime(
	nome VARCHAR(100),
	ano INTEGER CHECK(N_DIGIT(4,ano)=TRUE),
	autor VARCHAR(100),
	numeroDeTemporadas INTEGER DEFAULT 1,
	CONSTRAINT PK_Anime PRIMARY KEY(nome)
);

CREATE TABLE Personagem(
	anime VARCHAR(100),
	nome VARCHAR(100),
	descricao VARCHAR(500),
	tipoDeVoz VARCHAR(20),
	CONSTRAINT PK_Personagem PRIMARY KEY(anime, nome),
	CONSTRAINT FK_Personagem FOREIGN KEY(anime) REFERENCES Anime(nome) ON DELETE CASCADE,
	CONSTRAINT DOM_Personagem_tipoDeVoz CHECK(UPPER(tipoDeVoz) IN (
            'SOPRANO', 'MEZZO_SOPRANO', 'CONTRALTO', 'TENOR', 'BARITONO', 'BAIXO'
        ))
);

CREATE TABLE Temporada(
	anime VARCHAR(100),
	numero INTEGER, --Numero da temporada
	dataInicial DATE,
	dataFinal DATE,
	diretor BIGINT,
	CONSTRAINT PK_Temporada PRIMARY KEY(anime, numero),
	CONSTRAINT FK_Temporada_Anime FOREIGN KEY(anime) REFERENCES Anime(nome) ON DELETE CASCADE,
	CONSTRAINT FK_Temporada_Diretor FOREIGN KEY(diretor) REFERENCES Diretor(cpf) ON DELETE SET NULL,
	CONSTRAINT CH_Temporada_data CHECK(dataFinal - dataInicial > 0)
);

-- Quando um Diretor eh removido da base, as temporadas que o mesmo dirigiu nao sao deletadas!
-- Data Final de exibicao da temporada deve ser posterior a Data Inicial
-----------------------------------------------------------
CREATE TABLE Episodio(
    anime VARCHAR(100) NOT NULL,
    temporada INTEGER NOT NULL,
    numero INTEGER NOT NULL,	-- Numero do episodio
    id_episodio INTEGER,
    titulo VARCHAR(100),
    duracao time DEFAULT '00:00:00',
    CONSTRAINT PK_Episodio PRIMARY KEY(id_episodio),
    CONSTRAINT SK_Episodio UNIQUE(anime, temporada, numero),
    CONSTRAINT FK_Episodio_Temporada FOREIGN KEY(anime, temporada) REFERENCES Temporada(anime, numero) ON DELETE CASCADE
);

CREATE TABLE Cena(
    episodio INTEGER,
    numero INTEGER,	-- Numero da cena
    duracao time DEFAULT '00:00:00',
    script BYTEA,
    estado VARCHAR(23) DEFAULT 'NAO GRAVADO',
    audio BYTEA,
    CONSTRAINT PK_Cena PRIMARY KEY(episodio, numero),
    CONSTRAINT FK_Cena_Episodio FOREIGN KEY(episodio) REFERENCES Episodio(id_episodio) ON DELETE CASCADE,
    CONSTRAINT DOM_Cena_estado CHECK(UPPER(estado) IN ('GRAVADO', 'NAO GRAVADO', 'NECESSITA DE REGRAVACAO'))
);

CREATE TABLE Interpreta(
    anime VARCHAR(100),
    personagem VARCHAR(100),
    dublador BIGINT CHECK(N_DIGIT(11,dublador)=TRUE),
    avaliacaoTotal INTEGER,
    nro_avaliacoes INTEGER,
    CONSTRAINT PK_Interpreta PRIMARY KEY(anime, personagem, dublador),
    CONSTRAINT FK_Interpreta_Personagem FOREIGN KEY(anime, personagem) REFERENCES Personagem(anime, nome) ON DELETE CASCADE,
    CONSTRAINT FK_Interpreta_Dublador FOREIGN KEY(dublador) REFERENCES Dublador(cpf) ON DELETE CASCADE,
    CONSTRAINT DOM_Interp_avaliacao CHECK (avaliacaoTotal between 1 and 10)
);
-- Avaliacao Total deve ser a media dos valores da coluna 'Avaliacao Parcial' de "Dubla"

CREATE TABLE Dubla(
    episodio INTEGER,
    anime VARCHAR(100),
    personagem VARCHAR(100),
    dublador BIGINT CHECK(N_DIGIT(11,dublador)=TRUE) NOT NULL,
    avaliacaoParcial INTEGER,
    CONSTRAINT PK_Dubla PRIMARY KEY(episodio, anime, personagem),
    CONSTRAINT FK_Dubla_Episodio FOREIGN KEY(episodio) REFERENCES Episodio(id_episodio) ON DELETE CASCADE,
    CONSTRAINT FK_Dubla_Personagem FOREIGN KEY(anime, personagem) REFERENCES Personagem(anime, nome) ON DELETE CASCADE,
    CONSTRAINT DOM_Dubla_avaliacao CHECK (avaliacaoParcial between 1 and 10)
);

CREATE TABLE SessaoDeGravacao(
    sala INTEGER,
    data_hora TIMESTAMP,
    tecnico BIGINT CHECK(N_DIGIT(11,tecnico)=TRUE) NOT NULL,
    horarioFinal TIMESTAMP,
    CONSTRAINT PK_SessaoDeGravacao PRIMARY KEY(sala, data_hora),
    CONSTRAINT SK_SessaoDeGravacao UNIQUE(data_hora, tecnico),
    CONSTRAINT FK_SessaoDeGravacao_Sala FOREIGN KEY(sala) REFERENCES SalaDeGravacao(numero) ON DELETE CASCADE,
    CONSTRAINT FK_SessaoDeGravacao_Tecnico FOREIGN KEY(tecnico) REFERENCES TecnicoDeAudio(cpf) ON DELETE CASCADE
);

CREATE TABLE Produz(
    sala INTEGER,
    data_hora TIMESTAMP,
    episodio INTEGER,
    cena INTEGER,
    CONSTRAINT PK_Produz PRIMARY KEY(sala, data_hora, episodio, cena),
    CONSTRAINT FK_Produz_Cena FOREIGN KEY(episodio, cena) REFERENCES Cena(episodio, numero) ON DELETE CASCADE,
    CONSTRAINT FK_Produz_Sessao FOREIGN KEY(sala, data_hora) REFERENCES SessaoDeGravacao(sala, data_hora) ON DELETE CASCADE
);

CREATE TABLE Participa(
    anime VARCHAR(100),
    personagem VARCHAR(100),
    episodio INTEGER,
    cena INTEGER,
    CONSTRAINT PK_Participa PRIMARY KEY(anime, personagem, episodio, cena),
    CONSTRAINT FK_Participa_Personagem FOREIGN KEY(anime, personagem) REFERENCES Personagem(anime, nome) ON DELETE CASCADE,
    CONSTRAINT FK_Participa_Cena FOREIGN KEY(episodio, cena) REFERENCES Cena(episodio, numero) ON DELETE CASCADE
);

