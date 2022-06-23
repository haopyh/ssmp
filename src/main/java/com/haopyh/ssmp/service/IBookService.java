package com.haopyh.ssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.haopyh.ssmp.domain.Book;

public interface IBookService extends IService<Book> {
    IPage<Book> getPage(int currentPage,int pageSize);

    IPage<Book> getPage(int currentPage, int pageSize, Book book);
}
