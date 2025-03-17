package s21.web.model;

import java.util.UUID;

public record CurrentGame (
    UUID uuid,
    GameField gameField,
    String error
) {}
