package com.haopyh.ssmp.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.haopyh.ssmp.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTest1 {
    
    @Autowired
    IBookService bookService;


    @Test
    void testGetById() {
        System.out.println(bookService.getById(1));
    }


    @Test
    void testGetPage() {
        IPage page = new Page(2, 5);
        bookService.page(page);
        page.getRecords().forEach(System.out::println);
        System.out.println("共几条记录 = = " + page.getTotal());
        System.out.println("当前页数 = " + page.getCurrent());
        System.out.println("共几页 = " + page.getPages());
        System.out.println("一页几条 = " + page.getSize());
    }

    @Test
    void testGetAll() {
        bookService.list().forEach(System.out::println);
    }

    @Test
    void testDeleteById() {
        Book book = new Book();
        book.setId(68);
        bookService.removeById(book);
    }

    @Test
    void testAddBoot() {
        Book book = new Book();
        book.setAuthor("test作者");
        book.setPrice(16.666);
        book.setSales(100);
        book.setTitle("测试图书");
        book.setStock(10);
        bookService.save(book);
    }


    @Test
    void testUpdateBookById() {
        Book book = new Book();
        book.setAuthor("test作者");
        book.setPrice(16.666);
        book.setSales(100);
        book.setTitle("测试图书");
        book.setStock(10);
        book.setId(68);
        bookService.updateById(book);
    }

    @Test
    void  testGetBookBy(){
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("title", "边城");
        bookService.list(queryWrapper).forEach(System.out::println);
    }


}
