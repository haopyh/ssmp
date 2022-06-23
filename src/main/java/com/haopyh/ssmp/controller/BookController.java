package com.haopyh.ssmp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.haopyh.ssmp.controller.utils.R;
import com.haopyh.ssmp.domain.Book;
import com.haopyh.ssmp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll() {
        return new R(true, bookService.list());
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, Book book) {
//        System.out.println("currentPage = " + currentPage);
//        System.out.println("pageSize = " + pageSize);
        System.out.println(book);
        IPage<Book> page = bookService.getPage(currentPage, pageSize, book);
        if (currentPage > page.getPages()) {
            page = bookService.getPage((int) page.getPages(), pageSize, book);
        }
        return new R(true, page);
    }

    @PostMapping
    public R save(@RequestBody Book book) {
        return new R(bookService.save(book));
    }

    @GetMapping("/{id}")
    public R getById(@PathVariable int id) {
        return new R(true, bookService.getById(id));
    }

    @DeleteMapping("/{id}")
    public R deleteById(@PathVariable int id) {
        return new R(bookService.removeById(id));
    }

    @PutMapping("/{id}")
    public R updateById(@RequestBody Book book) {
        return new R(bookService.updateById(book));
    }

}
