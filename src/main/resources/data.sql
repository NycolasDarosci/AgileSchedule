INSERT INTO USER (nome, email, senha, ativo) VALUES ('nomeuser1', 'emailuser1', 'senha não criptografada', true);
INSERT INTO TIPOUSER (descricao) VALUES ('comum');
INSERT INTO TIPOUSER (idUser, idTipoUser) VALUES (1, 1);