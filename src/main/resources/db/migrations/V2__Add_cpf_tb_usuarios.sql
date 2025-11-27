--V2: Migrations para adicionar a coluna de CPF na tabela de usuários

ALTER TABLE tb_usuarios
ADD COLUMN cpf VARCHAR(11) UNIQUE NOT NULL; --Garante que o cpf do usuário seja único e que tenham um cpf obrigatoriamente.