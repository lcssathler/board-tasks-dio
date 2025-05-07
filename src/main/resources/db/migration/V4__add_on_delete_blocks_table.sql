ALTER TABLE blocks DROP FOREIGN KEY fk_block_card;

ALTER TABLE blocks
    ADD CONSTRAINT fk_block_card FOREIGN KEY (card_id) REFERENCES cards(id) ON DELETE CASCADE;
