package chess.controller;

import chess.dto.CreateGameDto;
import chess.dto.GameDto;
import chess.service.ChessService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<CreateGameDto> createGame() {



        return null;
    }

    @GetMapping("/{id}")
    public ModelAndView findGame(@PathVariable int id) {
        GameDto gameDto = chessService.findGame(id);

//        return ResponseUtil.createModelAndView(HTML_TEMPLATE_PATH, gameDto);

        return null;
    }

    @PostMapping("/{id}")
    public ModelAndView playGame(@PathVariable int id) {
//                                 @RequestBody MoveRoute moveRoute) {
//        chessService.playGame(id, new MoveEvent(moveRoute));
//        GameDto gameDto = chessService.findGame(id);
//        return ResponseUtil.createModelAndView(HTML_TEMPLATE_PATH, gameDto);
    return null;
    }
}
