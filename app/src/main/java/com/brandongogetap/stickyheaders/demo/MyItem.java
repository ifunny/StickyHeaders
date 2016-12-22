package com.brandongogetap.stickyheaders.demo;

import com.brandongogetap.stickyheaders.exposed.Item;

/**
 * Created by kolobchanin on 22.12.16.
 */

public class MyItem extends Item {

    public String title;
    public String message;
    protected boolean isHeader;

    MyItem(String title, String message) {
        this.title = title;
        this.message = message;
        isHeader = false;
    }

    @Override
    public boolean isHeader() {
        return isHeader;
    }

    @Override
    public void setIsHeader(boolean isHeader) {
        this.isHeader = isHeader;
    }
}
