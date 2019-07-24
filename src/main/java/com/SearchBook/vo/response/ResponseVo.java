package com.searchBook.vo.response;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseVo
{
    private Meta                 meta;
    private ArrayList<Documents> documents;
}
