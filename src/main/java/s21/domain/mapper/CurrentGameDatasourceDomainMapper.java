package s21.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import s21.domain.model.CurrentGame;
import s21.domain.model.GameField;

@Mapper
public interface CurrentGameDatasourceDomainMapper {
    CurrentGameDatasourceDomainMapper INSTANCE = Mappers.getMapper(CurrentGameDatasourceDomainMapper.class);

    default s21.datasource.model.CurrentGame domainToDatasource(CurrentGame domain) {
        return
            new s21.datasource.model.CurrentGame(
                domain.getUuid(), 
                new s21.datasource.model.GameField(
                    domain.getGameField().getGameField()));
    }
    default CurrentGame datasourceToDomain(s21.datasource.model.CurrentGame datasource) {
        return new CurrentGame(datasource.getUuid(), new GameField(datasource.getGameField().getGameField()));
    }
}