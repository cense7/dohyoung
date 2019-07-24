package com.searchBook.vo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Meta
{
    /*
     * "meta": {
     * "is_end": true,
     * "pageable_count": 9,
     * "total_count": 10
     * },
     */
    private boolean is_end;
    private int     pageable_count;
    private int     total_count;

}
