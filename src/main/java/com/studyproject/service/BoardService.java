package com.studyproject.service;

import com.studyproject.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    public List<BoardDTO> list();

    public BoardDTO board(Long oid);

    public boolean insert(BoardDTO boardDTO);

    public boolean update(BoardDTO boardDTO);

    public boolean delete(Long oid);
}
