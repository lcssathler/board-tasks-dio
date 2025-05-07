ALTER TABLE cards DROP FOREIGN KEY fk_card_column;

ALTER TABLE cards
    ADD CONSTRAINT fk_card_column FOREIGN KEY (board_column_id) REFERENCES board_columns(id) ON DELETE CASCADE;