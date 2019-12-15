package com.ssm.core.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class TodoItem implements Serializable {
    /**
     * 代办事项ID
     */
    private Long todoItemId;

    /**
     * 属主用户
     */
    private Long userId;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 代办事项标题
     */
    private String todoItemTitle;

    /**
     * 待办事项内容
     */
    private String todoItemContent;

    /**
     * 优先级：LOW/MEDIUM/HIGH
     */
    private String priority;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    private Date creationDate;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    private Date lastUpdateDate;

    /**
     * 备注
     */
    private String comments;

    /**
     * 代办事项ID
     *
     * @return TODO_ITEM_ID 代办事项ID
     */
    public Long getTodoItemId() {
        return todoItemId;
    }

    /**
     * 代办事项ID
     *
     * @param todoItemId 代办事项ID
     */
    public void setTodoItemId(Long todoItemId) {
        this.todoItemId = todoItemId;
    }

    /**
     * 属主用户
     *
     * @return USER_ID 属主用户
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 属主用户
     *
     * @param userId 属主用户
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 代办事项标题
     *
     * @return TODO_ITEM_TITLE 代办事项标题
     */
    public String getTodoItemTitle() {
        return todoItemTitle;
    }

    /**
     * 代办事项标题
     *
     * @param todoItemTitle 代办事项标题
     */
    public void setTodoItemTitle(String todoItemTitle) {
        this.todoItemTitle = todoItemTitle == null ? null : todoItemTitle.trim();
    }

    /**
     * 待办事项内容
     *
     * @return TODO_ITEM_CONTENT 待办事项内容
     */
    public String getTodoItemContent() {
        return todoItemContent;
    }

    /**
     * 待办事项内容
     *
     * @param todoItemContent 待办事项内容
     */
    public void setTodoItemContent(String todoItemContent) {
        this.todoItemContent = todoItemContent == null ? null : todoItemContent.trim();
    }

    /**
     * 优先级：LOW/MEDIUM/HIGH
     *
     * @return PRIORITY 优先级：LOW/MEDIUM/HIGH
     */
    public String getPriority() {
        return priority;
    }

    /**
     * 优先级：LOW/MEDIUM/HIGH
     *
     * @param priority 优先级：LOW/MEDIUM/HIGH
     */
    public void setPriority(String priority) {
        this.priority = priority == null ? null : priority.trim();
    }

    /**
     * 创建时间
     *
     * @return CREATION_DATE 创建时间
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * 创建时间
     *
     * @param creationDate 创建时间
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * 更新时间
     *
     * @return LAST_UPDATE_DATE 更新时间
     */
    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    /**
     * 更新时间
     *
     * @param lastUpdateDate 更新时间
     */
    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    /**
     * 备注
     *
     * @return COMMENTS 备注
     */
    public String getComments() {
        return comments;
    }

    /**
     * 备注
     *
     * @param comments 备注
     */
    public void setComments(String comments) {


        this.comments = comments == null ? null : comments.trim();
    }

    public TodoItem() {
    }

    public TodoItem(Long userId, String todoItemTitle, String todoItemContent, String priority, Date creationDate, Date lastUpdateDate, String comments) {
        this.userId = userId;
        this.todoItemTitle = todoItemTitle;
        this.todoItemContent = todoItemContent;
        this.priority = priority;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.comments = comments;
    }
}