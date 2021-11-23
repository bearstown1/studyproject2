package com.studyproject.controller;

import com.studyproject.dto.BoardDTO;
import com.studyproject.service.BoardService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class BoardController {

    @Resource(name = "defaultBoardService")
    private BoardService boardService;

    public List list() {
        List<BoardDTO> list = boardService.list();
        return null;
    }

    @RequestMapping(value = "/board/get", method = RequestMethod.GET)
    public BoardDTO board(Long oid) {
        BoardDTO boardDTO = boardService.board(oid);

        return boardDTO;
    }

    @RequestMapping(value="/board/add", method = RequestMethod.POST)
    public boolean insert(BoardDTO boardDTO) {
        boolean resultvalue = boardService.insert(boardDTO);

        return resultvalue;
    }

    @RequestMapping(value="/board/update", method = RequestMethod.POST)
    public boolean update(BoardDTO boardDTO) {
        boolean resultvalue = boardService.update(boardDTO);

        return resultvalue;
    }

    @RequestMapping(value = "/board/delete", method = RequestMethod.GET)
    public boolean delete(Long oid) {
        boolean resultvalue =  boardService.delete(oid);

        return resultvalue;
    }

}
