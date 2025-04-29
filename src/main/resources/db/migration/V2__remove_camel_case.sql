-- Renomeia as colunas da tabela boards para padrão snake_case
ALTER TABLE boards CHANGE initialColumn_id initial_column_id BIGINT NOT NULL UNIQUE;
ALTER TABLE boards CHANGE finalColumn_id final_column_id BIGINT NOT NULL UNIQUE;
ALTER TABLE boards CHANGE cancellationColumn_id cancellation_column_id BIGINT NOT NULL UNIQUE;

-- Renomeia as constraints estrangeiras relacionadas (opcional, para manter consistência)
ALTER TABLE boards DROP FOREIGN KEY fk_board_initial;
ALTER TABLE boards DROP FOREIGN KEY fk_board_final;
ALTER TABLE boards DROP FOREIGN KEY fk_board_cancellation;

ALTER TABLE boards
    ADD CONSTRAINT fk_board_initial FOREIGN KEY (initial_column_id) REFERENCES board_columns(id) ON DELETE CASCADE,
    ADD CONSTRAINT fk_board_final FOREIGN KEY (final_column_id) REFERENCES board_columns(id) ON DELETE CASCADE,
    ADD CONSTRAINT fk_board_cancellation FOREIGN KEY (cancellation_column_id) REFERENCES board_columns(id) ON DELETE CASCADE;
