package s21.web.controller;

import java.util.List;
import java.util.UUID;

import s21.domain.service.GameFieldLogic;
import s21.web.mapper.CurrentGameDomainWebMapper;
import s21.web.model.CurrentGame;

public class DomainController {
    GameFieldLogic logic = new GameFieldLogic();

    CurrentGameDomainWebMapper mapper = CurrentGameDomainWebMapper.INSTANCE;

    public CurrentGame createNewGame() {
        return mapper.domainToWeb(logic.createNewGame());
    }
    public CurrentGame updateFieldAndGetNextStep(CurrentGame newField) throws Exception {
        return mapper.domainToWeb(logic.updateFieldAndGetNextStep(mapper.webToDomain(newField)));
    }
    public void deleteGame(UUID uuid) {
        logic.deleteGame(uuid);
    }
    public List<String> getGamesList() {
        return logic.getGamesList().stream().map(uuid -> uuid.toString()).toList();
    }
}
