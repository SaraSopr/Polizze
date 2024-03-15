create table POLIZZA
(
    ID              int          not null AUTO_INCREMENT,
    NUMERO_POLIZZA  varchar(100) not null UNIQUE,
    ID_CONTRAENTE   int,
    ID_ASSICURATO   int,
    ID_BENEFICIARIO int,
    PRIMARY KEY (ID)
);