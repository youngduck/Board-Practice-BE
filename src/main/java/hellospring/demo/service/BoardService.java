package hellospring.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hellospring.demo.dao.BoardRepository;
import hellospring.demo.dto.Board;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    BoardRepository boardRepository;

    public List<Board> getAllBoardList() {
        return boardRepository.getAllBoardList();
    }

    public Board getBoardById(Integer id) {
        return boardRepository.getBoardById(id);
    }

    public void createBoard(Board board) {
        boardRepository.createBoard(board);
    }

}
