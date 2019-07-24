package com.searchBook.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class UserHistory
{
    @Id
    @GeneratedValue
    private long          sequence;
    private String        username;
    private String        keyword;
    @CreationTimestamp
    private LocalDateTime searchtime;

    // default fetch type = EAGER
    @ManyToOne
    @JoinColumn(name = "User")
    User                  user;
}
