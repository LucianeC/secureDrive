CREATE SEQUENCE HORARIO_RESTRICAO_SEQ
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE TABLE TBL_HORARIO_RESTRICAO (
    ID INTEGER DEFAULT HORARIO_RESTRICAO_SEQ.NEXTVAL NOT NULL,
    INICIO TIME NOT NULL,
    FIM TIME NOT NULL,
    TIPO_VEICULO VARCHAR(50) NOT NULL,
    PRIMARY KEY (ID)
);
