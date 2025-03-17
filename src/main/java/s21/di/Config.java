package s21.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import s21.datasource.model.ServiceReallyser;
import s21.datasource.repository.GameContainer;
import s21.datasource.repository.Repository;

@Configuration
public class Config {
    @Bean
    public GameContainer gameContainer() {
        return new GameContainer();
    }
    @Bean
    public Repository repository(GameContainer container) {
        return new Repository(container);
    }
    @Bean("prototype")
    public ServiceReallyser serviceReallyser(Repository repo) {
        return new ServiceReallyser(repo);
    }
}
