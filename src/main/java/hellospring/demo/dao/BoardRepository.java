package hellospring.demo.dao;

import hellospring.demo.dto.Board;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BoardRepository {

    // ANCHOR - 게시판 전체조회
    List<Board> getAllBoardList();

    // ANCHOR - 게시판 세부조회
    Board getBoardById(@Param("id") Integer id);

    // ANCHOR - 게시판 갯수조회
    public Integer getBoardCount();

    // ANCHOR - 게시판 작성
    public void createBoard(Board board);

    // ANCHOR - 게시판 수정
    public void updateBoard(Board board);

    // ANCHOR - 게시판 삭제
    public void deleteBoardById(@Param("id") Integer id);
}
