package com.haopyh.ssmp.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.haopyh.ssmp.domain.Book;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookdaoTest {

    @Autowired
    BookDao bookDao;

//    @Test
//    void testGetById(){
//        System.out.println(bookDao.getBookById(1));
//    }

    @Test
    void testGetById() {
        System.out.println(bookDao.selectById(1));
    }


    @Test
    void testGetPage() {
        IPage page = new Page(2, 5);
        bookDao.selectPage(page, null);
        page.getRecords().forEach(System.out::println);
        System.out.println("共几条记录 = = " + page.getTotal());
        System.out.println("当前页数 = " + page.getCurrent());
        System.out.println("共几页 = " + page.getPages());
        System.out.println("一页几条 = " + page.getSize());
    }

    @Test
    void testGetAll() {
        bookDao.selectList(null).forEach(System.out::println);
    }

    @Test
    void testDeleteById() {
        Book book = new Book();
        book.setId(68);
        bookDao.deleteById(book);
    }

    @Test
    void testAddBoot() {
        Book book = new Book();
        book.setAuthor("test作者");
        book.setPrice(16.666);
        book.setSales(100);
        book.setTitle("测试图书");
        book.setStock(10);
        bookDao.insert(book);
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
        bookDao.updateById(book);
    }

    @Test
    void testGetBy() {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("title", "边城");
        bookDao.selectList(queryWrapper).forEach(System.out::println);
    }

    @Test
    void  testGetBookBy1(){
        Book book=new Book();
        book.setTitle("边城");
        IPage<Book> page = new Page<>(1, 10);
        LambdaQueryWrapper<Book> lqw=new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(book.getTitle()),Book::getTitle,book.getTitle());
        lqw.like(Strings.isNotEmpty(book.getAuthor()),Book::getAuthor,book.getAuthor());
        lqw.like(book.getPrice()!=null,Book::getPrice,book.getPrice());
        lqw.like(book.getSales()!=null,Book::getSales,book.getSales());
        lqw.like(book.getStock()!=null,Book::getStock,book.getStock());
        bookDao.selectPage(page,lqw).getRecords().forEach(System.out::println);
    }

    @Test
    void testGetBy2() {
        String title = null;
        title = "边城";
        LambdaQueryWrapper<Book> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//        if (title != null) {lambdaQueryWrapper.eq(Book::getTitle, title);}
        lambdaQueryWrapper.eq(title!=null,Book::getTitle, title);
        bookDao.selectList(lambdaQueryWrapper).forEach(System.out::println);
    }
}
