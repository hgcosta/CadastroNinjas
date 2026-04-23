-- V2:  Migrations para adicionar a coluna de Ranking na tabela de cadastros

ALTER TABLE tb_cadastro
ADD COLUMN rank VARCHAR(255);