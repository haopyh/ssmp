package com.haopyh.ssmp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.haopyh.ssmp.dao.BookDao;
import com.haopyh.ssmp.domain.Book;
import com.haopyh.ssmp.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceImpl<BookDao,Book> implements IBookService {
    @Autowired
    BookDao bookDao;

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage<Book> page = new Page<>(currentPage, pageSize);
       bookDao.selectPage(page,null);
       return page;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book book) {
        IPage<Book> page = new Page<>(currentPage, pageSize);
        LambdaQueryWrapper<Book> lqw=new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(book.getTitle()),Book::getTitle,book.getTitle());
        lqw.like(Strings.isNotEmpty(book.getAuthor()),Book::getAuthor,book.getAuthor());
        lqw.like(book.getPrice()!=null,Book::getPrice,book.getPrice());
        lqw.like(book.getSales()!=null,Book::getSales,book.getSales());
        lqw.like(book.getStock()!=null,Book::getStock,book.getStock());
        bookDao.selectPage(page,lqw);
        return page;
    }
}
