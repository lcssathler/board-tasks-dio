CREATE TABLE boards (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE board_columns (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    column_type VARCHAR(31) NOT NULL,
    board_id BIGINT,
    order_column INT,
    CONSTRAINT fk_board_column_board FOREIGN KEY (board_id) REFERENCES boards(id),
    CONSTRAINT unique_board_id UNIQUE (board_id) -- Adicionando UNIQUE corretamente
);

CREATE TABLE cards (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(500) NOT NULL,
    date_creation TIMESTAMP,
    board_column_id BIGINT,
    CONSTRAINT fk_card_column FOREIGN KEY (board_column_id) REFERENCES board_columns(id)
);

CREATE TABLE blocks (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    cause_block VARCHAR(255) NOT NULL,
    block_at TIMESTAMP NOT NULL,
    cause_unblock VARCHAR(255) NOT NULL,
    unblock_at TIMESTAMP NOT NULL,
    is_blocked BOOLEAN NOT NULL DEFAULT FALSE,
    card_id BIGINT,
    CONSTRAINT fk_block_card FOREIGN KEY (card_id) REFERENCES cards(id)
);
