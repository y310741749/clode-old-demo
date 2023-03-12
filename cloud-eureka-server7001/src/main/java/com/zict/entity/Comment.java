package com.zict.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
@Builder
@Document
public class Comment {
    @Id
    private String id;
    @Field
    private String content; //吐槽内容
    private Date publishTime; //发布日期
    @Indexed
    private String userId; //发布人ID
    private String nickName; //昵称
    private LocalDateTime createTime; //评论的日期时间
    private Integer likeNum; //点赞数
    private Integer replyNum; //回复数
    private String state; //状态
    private String parentId; //上级ID
    private String articleId;
}
