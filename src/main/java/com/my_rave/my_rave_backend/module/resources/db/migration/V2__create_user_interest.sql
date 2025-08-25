CREATE TABLE interesses (
    id UUID PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL
);

INSERT INTO interesses (id, nome) VALUES
    (gen_random_uuid(), 'Música'),
    (gen_random_uuid(), 'Esportes'),
    (gen_random_uuid(), 'Tecnologia'),
    (gen_random_uuid(), 'Viagens'),
    (gen_random_uuid(), 'Cinema');