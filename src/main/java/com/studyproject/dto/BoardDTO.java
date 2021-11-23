package com.studyproject.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class BoardDTO {
    public Long oid;

    public String title;

    public String content;
}
