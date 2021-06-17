package com.koreait.junittest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueryTest {

    @BeforeAll
    public static void beforeAll() {
        Query.createTable();
    }

    @AfterAll
    public static void afterAll() {
        Query.dropTable();
    }

    @BeforeEach
    public void beforeEach() {
        Query.boardDelete(0);

        BoardVO vo1 = new BoardVO();
        vo1.setBtitle("A");
        vo1.setBcontent("abc");
        Query.boardInsert(vo1);

        BoardVO vo2 = new BoardVO();
        vo2.setBtitle("B");
        vo2.setBcontent("cde");
        Query.boardInsert(vo2);
    }

    @Test
    public void testA() {
        BoardVO vo1 = Query.getBoardDetail(1);
        assertEquals(vo1.getBtitle(),"A");
        assertEquals(vo1.getBcontent(), "abc");

        BoardVO vo2 = Query.getBoardDetail(2);
        assertEquals(vo2.getBtitle(),"B");
        assertEquals(vo2.getBcontent(), "cde");
    }

    @Test
    public void testB() {
        BoardVO vo3 = new BoardVO();
        BoardVO vo4 = new BoardVO();

    }

    @Test
    public void testC() {

    }
}
