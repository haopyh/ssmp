package com.haopyh.ssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.haopyh.ssmp.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTest {
    
    @Autowired
    BookService bookService;


    @Test
    void testGetById() {
        System.out.println(bookService.getBookById(1));
    }


    @Test
    void testGetPage() {
        IPage page = new Page(2, 5);
        bookService.selectPage(page);
        page.getRecords().forEach(System.out::println);
        System.out.println("共几条记录 = = " + page.getTotal());
        System.out.println("当前页数 = " + page.getCurrent());
        System.out.println("共几页 = " + page.getPages());
        System.out.println("一页几条 = " + page.getSize());
    }

    @Test
    void testGetAll() {
        bookService.getAllBook().forEach(System.out::println);
    }

    @Test
    void testDeleteById() {
        Book book = new Book();
        book.setId(68);
        bookService.delete(book);
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


}
