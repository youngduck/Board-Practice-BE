package hellospring.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import hellospring.demo.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hellospring.demo.dto.Board;
import hellospring.demo.dto.BoardA;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(value = "/Board")
public class BoardController {
    @Autowired
    BoardService boardService;

    // ANCHOR - 게시판 전체조회
    @GetMapping(value = "/List")
    public ResponseEntity<List<Board>> getAllBoardList() throws Exception {
        List<Board> result = boardService.getAllBoardList();

        return new ResponseEntity<List<Board>>(result, HttpStatus.OK);
    }

    // ANCHOR - 게시판 세부조회
    @GetMapping(value = "/Detail")
    public ResponseEntity<Board> getBoardById(@RequestParam(value = "id", required = true) Integer id)
            throws Exception {

        Board result = boardService.getBoardById(id);

        return new ResponseEntity<Board>(result, HttpStatus.OK);
    }

    // ANCHOR - 게시판 작성
    @PostMapping("")
    public ResponseEntity<?> createBoard(@RequestBody Board board) throws Exception {

        boardService.createBoard(board);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // ANCHOR - 게시판 수정
    @PutMapping("/{id}")
    public ResponseEntity<?> updateBoardById(@PathVariable Integer id, @RequestBody Board board) throws Exception {

        boardService.updateBoard(board);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // ANCHOR - 게시판 삭제
    @PutMapping(value = "/Detail")
    public ResponseEntity<?> deleteBoardById(@RequestParam(value = "id", required = true) Integer id) throws Exception {

        boardService.deleteBoard(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // ANCHOR 게시판 전체조회 + 게시판 갯수조회
    @GetMapping(value = "/Count")
    public ResponseEntity<BoardA> getBoardAll() throws Exception {

        Integer result = boardService.getBoardCount();
        List<Board> result2 = boardService.getAllBoardList();
        BoardA a = new BoardA(result2, result);

        return new ResponseEntity<BoardA>(a, HttpStatus.OK);
    }

}
