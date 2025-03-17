package s21.web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import s21.web.model.CurrentGame;
import s21.web.model.GameField;

@Mapper
public interface CurrentGameDomainWebMapper {
    CurrentGameDomainWebMapper INSTANCE = Mappers.getMapper(CurrentGameDomainWebMapper.class);

    default s21.domain.model.CurrentGame webToDomain(CurrentGame web) {
        return
            new s21.domain.model.CurrentGame(
                web.uuid(), 
                new s21.domain.model.GameField(
                    web.gameField().gameField()));
    }
    default CurrentGame domainToWeb(s21.domain.model.CurrentGame domain) {
        return new CurrentGame(domain.getUuid(), new GameField(domain.getGameField().getGameField()), null);
    }
}
