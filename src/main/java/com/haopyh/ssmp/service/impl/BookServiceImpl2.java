package com.haopyh.ssmp.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.haopyh.ssmp.dao.BookDao;
import com.haopyh.ssmp.domain.Book;
import com.haopyh.ssmp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl2 implements BookService {

    @Autowired
    BookDao bookDao;

    @Override
    public Boolean save(Book book) {
        return bookDao.insert(book)>0;
    }

    @Override
    public Boolean updateById(Book book) {
        return bookDao.updateById(book)>0;
    }

    @Override
    public Boolean delete(Book book) {
        return bookDao.deleteById(book)>0;
    }

    @Override
    public Book getBookById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public List<Book> getAllBook() {
        return bookDao.selectList(null);
    }

    @Override
    public IPage<Book> selectPage(IPage page) {
        return bookDao.selectPage(page,null);
    }
}
