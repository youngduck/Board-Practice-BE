package hellospring.demo.dao;

import hellospring.demo.dto.Board;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BoardRepository {
    List<Board> getAllBoardList();
    Board getBoardById(@Param("id") Integer id);
    public void createBoard(Board board);
}

