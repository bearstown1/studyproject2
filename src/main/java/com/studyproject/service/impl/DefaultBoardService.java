package com.studyproject.service.impl;

import com.studyproject.dto.BoardDTO;
import com.studyproject.jpa.entity.BoardEntity;
import com.studyproject.jpa.repository.BoardRepository;
import com.studyproject.service.BoardService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("defaultBoardService")
public class DefaultBoardService implements BoardService {

    @Autowired
    public BoardRepository boardRepository;

    @Override
    public List<BoardDTO> list() {
        List<BoardEntity> boardEntities = boardRepository.findAll();

        return null;
    }

    @Override
    public BoardDTO board(Long oid) {
        System.out.println(oid);
        Optional<BoardEntity> Entity = boardRepository.findById(oid);

        BoardEntity boardEntity = Entity.get();

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        BoardDTO boardDTO = modelMapper.map(boardEntity, BoardDTO.class);

        return boardDTO;
    }

    @Override
    public boolean insert(BoardDTO boardDTO) {
        try {
            BoardEntity boardEntity = new BoardEntity(boardDTO.getTitle(), boardDTO.getContent());
            boardRepository.save(boardEntity);
        }catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean update(BoardDTO boardDTO) {
        try {
            BoardEntity boardEntity = new BoardEntity(boardDTO.getOid(),boardDTO.getTitle(), boardDTO.getContent());
            boardRepository.save(boardEntity);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Long oid) {
        try {
            boardRepository.deleteById(oid);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
