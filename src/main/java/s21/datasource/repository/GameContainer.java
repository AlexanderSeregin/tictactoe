package s21.datasource.repository;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import lombok.Getter;
import s21.datasource.model.CurrentGame;

@Getter
public class GameContainer {
    private final Map<UUID, CurrentGame> games = new ConcurrentHashMap<>();
}
