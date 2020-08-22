package com.THREAD.dayone;

import java.sql.ResultSet;

public interface Rowhandler<T> {
    T handle(ResultSet rs);
}
