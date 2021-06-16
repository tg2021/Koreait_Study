package com.koreait.spring2.vo;

import lombok.Data;

@Data
public class InsertEntity {
    private int location_cd;
    private ApartmentInfoEntity[] arr;
}
