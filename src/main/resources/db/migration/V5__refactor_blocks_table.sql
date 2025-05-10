ALTER TABLE blocks
    MODIFY cause_block VARCHAR(255),
    MODIFY block_at TIMESTAMP,
    MODIFY cause_unblock VARCHAR(255),
    MODIFY unblock_at TIMESTAMP,
    DROP COLUMN is_blocked;

ALTER TABLE cards ADD COLUMN is_blocked BOOLEAN NOT NULL DEFAULT FALSE;



