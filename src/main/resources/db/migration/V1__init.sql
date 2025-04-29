CREATE TABLE boards (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,

    initialColumn_id BIGINT UNIQUE,
    finalColumn_id BIGINT UNIQUE,
    cancellationColumn_id BIGINT UNIQUE
);

CREATE TABLE board_columns (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    column_type VARCHAR(31) NOT NULL,
    board_id BIGINT,
    ordering INT
);

CREATE TABLE cards (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(500) NOT NULL,
    date_creation TIMESTAMP,
    board_column_id BIGINT
);

CREATE TABLE blocks (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    cause_block VARCHAR(255) NOT NULL,
    block_at TIMESTAMP NOT NULL,
    cause_unblock VARCHAR(255) NOT NULL,
    unblock_at TIMESTAMP NOT NULL,
    is_blocked BOOLEAN NOT NULL DEFAULT FALSE,
    card_id BIGINT
);

ALTER TABLE boards
    ADD CONSTRAINT fk_board_initial FOREIGN KEY (initialColumn_id) REFERENCES board_columns(id) ON DELETE CASCADE,
    ADD CONSTRAINT fk_board_final FOREIGN KEY (finalColumn_id) REFERENCES board_columns(id) ON DELETE CASCADE,
    ADD CONSTRAINT fk_board_cancellation FOREIGN KEY (cancellationColumn_id) REFERENCES board_columns(id) ON DELETE CASCADE;

ALTER TABLE board_columns
    ADD CONSTRAINT fk_board_column_board FOREIGN KEY (board_id) REFERENCES boards(id);

ALTER TABLE cards
    ADD CONSTRAINT fk_card_column FOREIGN KEY (board_column_id) REFERENCES board_columns(id);

ALTER TABLE blocks
    ADD CONSTRAINT fk_block_card FOREIGN KEY (card_id) REFERENCES cards(id);
