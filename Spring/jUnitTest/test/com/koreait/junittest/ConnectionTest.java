package com.koreait.junittest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ConnectionTest {

    @Test
    void getConn() {
        assertNotNull(Query.getConn());
    }
}
