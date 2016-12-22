package com.brandongogetap.stickyheaders.exposed;

/**
 * Marker class used in {@link com.brandongogetap.stickyheaders.StickyLayoutManager}
 *
 * This should be set on any RecyclerView data item and mark his as header through methods of this class
 */
abstract public class Item {

    public abstract boolean isHeader();
    public abstract void setIsHeader(boolean isHeader);

}
