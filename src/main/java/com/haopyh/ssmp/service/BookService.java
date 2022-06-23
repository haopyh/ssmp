package com.haopyh.ssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.haopyh.ssmp.domain.Book;

import java.util.List;

public interface BookService {
    Boolean save(Book book);
    Boolean updateById(Book book);
    Boolean delete(Book book);
    Book getBookById(Integer id);
    List<Book> getAllBook();

    IPage<Book> selectPage(IPage page);
}
