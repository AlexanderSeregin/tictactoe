package s21.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import s21.domain.model.CurrentGame;
import s21.domain.model.GameField;

@Mapper
public interface CurrentGameWebDomainMapper {
    CurrentGameWebDomainMapper INSTANCE = Mappers.getMapper(CurrentGameWebDomainMapper.class);

    default s21.web.model.CurrentGame domainToWeb(CurrentGame domain) {
        return
            new s21.web.model.CurrentGame(
                domain.getUuid(), 
                new s21.web.model.GameField(
                    domain.getGameField().getGameField()), 
                null);
    }
    default CurrentGame webToDomain(s21.web.model.CurrentGame web) {
        return new CurrentGame(web.uuid(), new GameField(web.gameField().gameField()));
    }
}
