package s21.datasource.model;

import java.util.UUID;

import lombok.Getter;

@Getter
public class CurrentGame {
    private final UUID uuid;
    private final GameField gameField;

    public CurrentGame(GameField gameField) {
        this.uuid = UUID.randomUUID();
        this.gameField = gameField;
    }
    public CurrentGame(UUID uuid, GameField gameField) {
        this.uuid = uuid;
        this.gameField = gameField;
    }
}
