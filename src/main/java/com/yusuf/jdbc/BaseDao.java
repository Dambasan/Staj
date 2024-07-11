package com.yusuf.jdbc;

import java.sql.Connection;

public abstract class BaseDao {

    protected Connection connection;

    public BaseDao() {
        this.connection = ConnectionManager.getInstance().getConnection();
    }
}
