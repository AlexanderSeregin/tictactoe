package s21.web.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import s21.web.model.CurrentGame;
import s21.web.model.GameField;


@RestController
public class GameController {
    private final DomainController controller = new DomainController();

    @PostMapping("/game/{UUID}")
    public CurrentGame updateGameField(@PathVariable("UUID") String uuid, @RequestBody GameField field) throws Exception {
        try {
            return controller.updateFieldAndGetNextStep(new CurrentGame(UUID.fromString(uuid), field, null));
        } catch (Exception e) {
            return new CurrentGame(UUID.fromString(uuid), field, e.getMessage());
        }
    }
    @GetMapping("/game/newGame")
    public CurrentGame getNewGame() {
        return controller.createNewGame();
    }
    @DeleteMapping("/game/{UUID}")
    public void getNewGame(@PathVariable("UUID") String uuid) {
        controller.deleteGame(UUID.fromString(uuid));
    }
    @GetMapping("/")
    public String getHelloWorld() {
        return "Hello world!";
    }
    @GetMapping("/game/gamesList")
    public List<String> getMethodName() {
        return controller.getGamesList();
    }
    
}
