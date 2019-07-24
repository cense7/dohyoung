package com.searchBook.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class PopularKeyword
{
    @Id
    private String query;
    private long   count;
}
