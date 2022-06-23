package com.haopyh.ssmp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.haopyh.ssmp.domain.Book;
import com.haopyh.ssmp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/books")
public class BookController2 {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public List<Book> getAll() {
        return bookService.list();
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public IPage<Book> getPage(@PathVariable int currentPage, @PathVariable int pageSize) {
        System.out.println("currentPage = " + currentPage);
        System.out.println("pageSize = " + pageSize);
        return bookService.getPage(currentPage,pageSize);
    }

    @PostMapping
    public Boolean save(@RequestBody Book book) {
        return bookService.save(book);
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable int id) {
        return bookService.getById(id);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteById(@PathVariable int id) {
        return bookService.removeById(id);
    }

    @PutMapping("/{id}")
    public Boolean updateById(@RequestBody Book book) {
        return bookService.updateById(book);
    }

}
