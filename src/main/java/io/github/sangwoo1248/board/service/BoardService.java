package io.github.sangwoo1248.board.service;

import io.github.sangwoo1248.board.entity.Board;
import io.github.sangwoo1248.board.repository.Boardrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private Boardrepository boardrepository;

    //글 작성
    public void write(Board board){

        boardrepository.save(board);
    }

    //게시물 리스트
    public List<Board> boardList() {
        return boardrepository.findAll();
    }

    //게시글 보기
    public Board boardView(Integer id) {

        return boardrepository.findById(id).get();
    }

    //게시글 삭제
    public void boardDelete(Integer id){
        boardrepository.deleteById(id);
    }

    // 게시글 리스트 처리
//    public Page<Board> boardList(Pageable pageable) {
//
//        return boardRepository.findAll(pageable);
//    }

}
