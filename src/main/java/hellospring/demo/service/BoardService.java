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

    // ANCHOR - 게시판 전체조회
    public List<Board> getAllBoardList() {
        return boardRepository.getAllBoardList();
    }

    // ANCHOR - 게시판 세부조회
    public Board getBoardById(Integer id) {
        return boardRepository.getBoardById(id);
    }

    // ANCHOR - 게시판 갯수조회
    public Integer getBoardCount() {
        return boardRepository.getBoardCount();
    }

    // ANCHOR - 게시판 작성
    public void createBoard(Board board) {
        boardRepository.createBoard(board);
    }

    // ANCHOR - 게시판 수정
    public void updateBoard(Board board) {
        boardRepository.updateBoard(board);
    }

    // ANCHOR - 게시판 삭제
    public void deleteBoard(Integer id) {
        boardRepository.deleteBoardById(id);
    }

}
