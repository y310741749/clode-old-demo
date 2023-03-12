package com.zict.service;

import com.zict.dao.CommentDao;
import com.zict.entity.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceTest {

    @Autowired
    private CommentDao commentDao;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void testFileList() {
        List<Comment> all = commentDao.findAll();
        all.forEach(System.out::println);
    }

    @Test
    public void saveOne() {
        Comment comment = Comment.builder()
                .id("2")
                .articleId("10000")
                .content("测试添加的数据")
                .createTime(LocalDateTime.now())
                .userId("1003")
                .nickName("凯撒大帝")
                .state("1")
                .likeNum(0)
                .replyNum(0)
                .build();
        Comment save = commentDao.save(comment);
        System.out.println("插入成功");
    }

    @Test
    public void testTemplete() {
        Query query = new Query();
        query.addCriteria(Criteria.where("parentId").is(null));
        Update update = new Update();
        update.set("likeNum",10);
        mongoTemplate.updateFirst(query, update, Comment.class);
        List<Comment> comments = mongoTemplate.find(query, Comment.class);
        comments.forEach(System.out::println);
    }
}