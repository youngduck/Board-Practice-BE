package hellospring.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import hellospring.demo.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hellospring.demo.dto.Board;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping(value = "/Board")
public class BoardController {
    @Autowired
    BoardService boardService;

    @GetMapping(value = "/List")
    public ResponseEntity<List<Board>> getAllBoardList() {
        List<Board> result = boardService.getAllBoardList();

        return new ResponseEntity<List<Board>>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/Detail")
    public ResponseEntity<Board> getBoardById(@RequestParam(value = "id", required = true) Integer id) {

        Board result = boardService.getBoardById(id);

        return new ResponseEntity<Board>(result, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> createBoard(@RequestBody Board board) {

        if (!board.isValidTitle(board.getTITLE())) {
            return new ResponseEntity<>("ㅋㅋ", HttpStatus.BAD_REQUEST);
        }

        boardService.createBoard(board);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
