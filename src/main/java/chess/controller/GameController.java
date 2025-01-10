package chess.controller;

import chess.dto.CreateGameDto;
import chess.service.ChessService;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/game")
public class GameController {

    private final ChessService chessService;

    public GameController(ChessService chessService) {
        this.chessService = chessService;
    }

    @PostMapping("/create")
    public CreateGameDto createGame() {
        return chessService.createGame();
    }

    @GetMapping("/{id}")
    public ModelAndView findGame(@PathVariable int id) {
        GameDto gameDto = chessService.findGame(id);

        return ResponseUtil.createModelAndView(HTML_TEMPLATE_PATH, gameDto);
    }

    @PostMapping("/{id}")
    public ModelAndView playGame(@PathVariable int id,
                                 @RequestBody MoveRoute moveRoute) {
        chessService.playGame(id, new MoveEvent(moveRoute));
        GameDto gameDto = chessService.findGame(id);
        return ResponseUtil.createModelAndView(HTML_TEMPLATE_PATH, gameDto);
    }
}
