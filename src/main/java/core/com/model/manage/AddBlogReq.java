package core.com.model.manage;

import core.com.model.BlogChannel;

import java.util.List;

/**
 * 前端请求 - 添加 修改 Blog
 *
 * Created by wangjianan on 16-8-17.
 */
public class AddBlogReq {
    private Integer id;
    private String name;
    private String message;
    private String markdownContent;
    private String type;
    private String channel;
    private List<String> marks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getMarks() {
        return marks;
    }

    public void setMarks(List<String> marks) {
        this.marks = marks;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarkdownContent() {
        return markdownContent;
    }

    public void setMarkdownContent(String markdownContent) {
        this.markdownContent = markdownContent;
    }

    @Override
    public String toString() {
        return "AddBlogReq{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", message='" + message + '\'' +
                ", markdownContent='" + markdownContent + '\'' +
                ", type='" + type + '\'' +
                ", channel='" + channel + '\'' +
                ", marks=" + marks +
                '}';
    }
}
