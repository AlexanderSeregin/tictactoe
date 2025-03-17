package s21.domain.service;

import java.util.List;
import java.util.UUID;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import s21.datasource.model.ServiceReallyser;
import s21.datasource.repository.Repository;
import s21.domain.mapper.CurrentGameDatasourceDomainMapper;
import s21.domain.model.CurrentGame;
import s21.domain.model.GameField;

public class GameFieldLogic {
    private final ApplicationContext context = new AnnotationConfigApplicationContext("s21.di");

    CurrentGameDatasourceDomainMapper mapper = CurrentGameDatasourceDomainMapper.INSTANCE;

    public CurrentGame createNewGame() {
        CurrentGame game = new CurrentGame(new GameField());
        context.getBean(Repository.class)
               .saveGame(mapper.domainToDatasource(game));
        return game;
    }
    public CurrentGame updateFieldAndGetNextStep(CurrentGame newField) throws Exception {
        ServiceReallyser sr = context.getBean(ServiceReallyser.class);
        sr.setGame(mapper.domainToDatasource(newField));
        CurrentGame result = 
            new CurrentGame(newField.getUuid(), 
                            new GameField(sr.nextStep()));
        context.getBean(Repository.class)
               .updateGame(mapper.domainToDatasource(result));

        return result;
    } 
    public void deleteGame(UUID uuid) {
        context.getBean(Repository.class).deleteGame(uuid);
    }
    public List<UUID> getGamesList() {
        return context.getBean(Repository.class).getAllGamesUUID();
    }
}
