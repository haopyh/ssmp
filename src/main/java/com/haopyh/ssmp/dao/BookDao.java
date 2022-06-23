package com.haopyh.ssmp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.haopyh.ssmp.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BookDao extends BaseMapper<Book> {

//    @Select("select * from books where id = #{id};")
//    Book getBookById(int id);

}
