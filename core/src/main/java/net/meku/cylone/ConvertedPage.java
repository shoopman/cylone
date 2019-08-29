package net.meku.cylone;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Created by LiangBin
 */
public class ConvertedPage<F> extends PageImpl<F> {
    
    private final Page originalPage;
    
    public ConvertedPage(Page originalPage, List<F> content) {
        super(content);
        this.originalPage = originalPage;
    }
    
    @Override
    public long getTotalElements() {
        return originalPage.getTotalElements();
    }
    
    @Override
    public int getTotalPages() {
        return originalPage.getTotalPages();
    }
    
    @Override
    public Sort getSort() {
        return originalPage.getSort();
    }
    
    @Override
    public Pageable previousPageable() {
        return originalPage.previousPageable();
    }
    
    @Override
    public Pageable nextPageable() {
        return originalPage.nextPageable();
    }
    
    @Override
    public int getNumberOfElements() {
        return originalPage.getNumberOfElements();
    }
    
    @Override
    public int getSize() {
        return originalPage.getSize();
    }
    
    @Override
    public int getNumber() {
        return originalPage.getNumber();
    }
    
}
