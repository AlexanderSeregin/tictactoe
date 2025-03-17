package s21.datasource.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import s21.datasource.model.CurrentGame;

@Getter
@RequiredArgsConstructor
public class Repository {
    private final GameContainer container;

    public void saveGame(CurrentGame game) {
        if(container.getGames().putIfAbsent(game.getUuid(), game) != null)
            container.getGames().replace(game.getUuid(), game);
    }
    public CurrentGame getGame(UUID uuid) {
        return container.getGames().get(uuid);
    }
    public void updateGame(CurrentGame game) {
        if(container.getGames().get(game.getUuid()) != null) 
            container.getGames().replace(game.getUuid(), game);
    }
    public void deleteGame(UUID uuid) {
        if(container.getGames().get(uuid) != null) container.getGames().remove(uuid);
    }
    public List<UUID> getAllGamesUUID() {
        List<UUID> result = new ArrayList<>(container.getGames().size());
        for(Map.Entry<UUID, CurrentGame> map : container.getGames().entrySet())
            result.add(map.getKey());
        return result;
    }
}
