create table POLIZZA
(
    ID              int          not null AUTO_INCREMENT,
    NUMERO_POLIZZA  varchar(100) not null UNIQUE,
    ID_CONTRAENTE   int,
    CONTRAENTEUGUALEASSICURATO CHAR(1),
    ID_ASSICURATO1   int,
    ID_ASSICURATO2  int,
    ID_BENEFICIARIOVITA1 int,
    ID_BENEFICIARIOVITA2 int,
    ID_BENEFICIARIOVITA3 int,
    ID_BENEFICIARIOVITA4 int,
    ID_BENEFICIARIOVITA5 int,
    ID_BENEFICIARIOMORTE1 int,
    ID_BENEFICIARIOMORTE2 int,
    ID_BENEFICIARIOMORTE3 int,
    ID_BENEFICIARIOMORTE4 int,
    ID_BENEFICIARIOMORTE5 int,
    ID_FONDO        int,
    ID_PRODOTTO     int,
    PRIMARY KEY (ID)
);

create table ANAGRAFICA
(
    ID              int          not null AUTO_INCREMENT,
    CODICEFISCALE  varchar(16) not null UNIQUE,
    NOME   varchar(100),
    COGNOME   varchar(100),
    SESSO   varchar(1),
    COMUNEDIRESIDENZA    varchar(100),
    PROVINCIADIRESIDENZA   varchar(100),
    VIADIRESIDENZA   varchar(100),
    NUMEROCIVICODIRESIDENZA   varchar(100),
    PRIMARY KEY (ID)
);