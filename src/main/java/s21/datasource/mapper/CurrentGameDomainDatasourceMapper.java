package s21.datasource.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import s21.datasource.model.CurrentGame;
import s21.datasource.model.GameField;

@Mapper
public interface CurrentGameDomainDatasourceMapper {
    CurrentGameDomainDatasourceMapper INSTANCE = Mappers.getMapper(CurrentGameDomainDatasourceMapper.class);

    default s21.domain.model.CurrentGame datasourceToDomain(CurrentGame domain) {
        return
            new s21.domain.model.CurrentGame(
                domain.getUuid(), 
                new s21.domain.model.GameField(
                    domain.getGameField().getGameField()));
    }
    default CurrentGame domainToDatasource(s21.domain.model.CurrentGame domain) {
        return new CurrentGame(domain.getUuid(), new GameField(domain.getGameField().getGameField()));
    }
}
