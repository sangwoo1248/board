package io.github.sangwoo1248.board.controller;

import io.github.sangwoo1248.board.entity.Board;
import io.github.sangwoo1248.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardservice;

    @GetMapping("/board/write")
    public String boardWriteForm(){

        return "boardwrite";
    }

    @PostMapping("/board/writepro")
    public String boardWritePro(Board board) {

        System.out.println("제목:" + board.getTitle());
        System.out.println("내용:" + board.getContent());

        boardservice.write(board);
        return "";
    }

    @GetMapping("board/list")
    public String boardList(Model model) {
        model.addAttribute("list", boardservice.boardList());
        return "boardlist";
    }

    @GetMapping("/board/view") // localhost:8080/board/view?id=1
    public String boardView(Model model, Integer id) {

        model.addAttribute("board", boardservice.boardView(id));
        return "boardview";
    }

    @GetMapping("/board/delete") // localhost:8080/board/view?id=1
    public String boarDelete(Integer id) {

        boardservice.boardDelete(id);
        return "redirect:/board/list";
    }

    @GetMapping("/board/modify/{id}")
    public String boardModify(@PathVariable("id") Integer id,
                              Model model) {

        model.addAttribute("board", boardservice.boardView(id));

        return "boardmodify";
    }

    @PostMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable("id") Integer id, Board board) {

        Board boardTemp = boardservice.boardView(id);
        boardTemp.setTitle(board.getTitle());
        boardTemp.setContent(board.getContent());

        //boardservice.write(boardTemp, file);

        return "redirect:/board/list";

    }
}
