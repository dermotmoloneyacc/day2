package edu.acc.j2ee.hubbub;

public class Pager implements java.io.Serializable {
    private int pageSize;
    private int page;
    private int size;
    
    public Pager() {
    }
    
    public Pager(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize < 1)
            throw new IllegalArgumentException("Page size cannot be negative");
        this.pageSize = pageSize;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    @Override
    public String toString() {
        return String.format("Pager[pageSize=%d, page=%d, size=%d]",
                pageSize, page, size);
    }
    
    public void start() {
        page = 0;
    }
    
    public void end() {
        page = lastPage();
    }
    
    private int lastPage() {
        return size / pageSize;
    }
    
    public boolean getMore() {
        return page < lastPage();
    }
    
    public boolean getBack() {
        return page != 0;
    }
    
    public void next() {
        if (getMore())
            page++;
    }
    
    public void prev() {
        if (getBack())
            page--;
    }
}
