package chess.controller;

import chess.dto.CreateGameDto;
import chess.dto.GameDto;
import chess.service.ChessService;
import common.constants.ResponseCode;
import common.dto.CommonResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GameController.class)
@DisplayName("GameController - 게임 API 엔드포인트")
class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ChessService chessService;

    @Test
    @DisplayName("POST /game/create 요청 시 ChessService.createGame()이 호출된다")
    void createGame_요청시_서비스가_호출된다() throws Exception {
        given(chessService.createGame(any(CreateGameDto.class)))
                .willReturn(new CommonResponseDto.Builder<GameDto>()
                        .status(ResponseCode.SUCCESS.getCode())
                        .message(ResponseCode.SUCCESS.getMessage())
                        .data(null)
                        .build());

        mockMvc.perform(post("/game/create"))
                .andExpect(status().isOk());

        verify(chessService).createGame(any(CreateGameDto.class));
    }

    @Test
    @DisplayName("GET /game/{id} 요청 시 ChessService.findGame()이 호출된다")
    void findGame_요청시_서비스가_호출된다() throws Exception {
        given(chessService.findGame(1)).willReturn(null);

        mockMvc.perform(get("/game/1"))
                .andExpect(status().isOk());

        verify(chessService).findGame(1);
    }

    @Test
    @DisplayName("POST /game/{id} 요청 시 200 응답을 반환한다")
    void playGame_요청시_200을_반환한다() throws Exception {
        mockMvc.perform(post("/game/1"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("GET /game/{id}에 문자열 id 전달 시 400 응답을 반환한다")
    void findGame_잘못된_타입의_id_전달시_400을_반환한다() throws Exception {
        mockMvc.perform(get("/game/invalid-id"))
                .andExpect(status().isBadRequest());
    }
}
