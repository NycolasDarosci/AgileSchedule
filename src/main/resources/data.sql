INSERT INTO Perfil (descricao) VALUES ('ADM'), ('Cliente');
INSERT INTO User (nome, email, senha, ativo) VALUES ('Exemplo1', 'exemplo@compasso.com.br', 'senha não criptografada', true);
INSERT INTO User_Has_Perfil (user_id, perfil_id) VALUES (1, 1);
