INSERT INTO Perfil (descricao) VALUES ('ADM'), ('Cliente');
INSERT INTO User (nome, email, senha, ativo, token_email) VALUES ('Exemplo1', 'exemplo@compasso.com.br', '$2a$10$AgixDE.kkkwk0jLJx4DZ7evvxmhmChxx/GVmdkmGv4o8EMxwI821u', true, '139h1231');
INSERT INTO User_Has_Perfil (user_id, perfil_id) VALUES (1, 1);
