package com.paikhantko.mvptest.ui.main;

import com.paikhantko.mvptest.data.model.api.Row;

import java.util.List;

public interface MainView {
    void displayData(List<Row> rows);
    void updateTotalPages(long totalPages);
    void showToast(String message);
}
