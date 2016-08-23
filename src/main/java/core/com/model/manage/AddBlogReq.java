package core.com.model.manage;

import core.com.model.BlogChannel;

import java.util.List;

/**
 * 前端请求 - 添加Blog
 *
 * Created by wangjianan on 16-8-17.
 */
public class AddBlogReq {
    private String name;
    private String message;
    private String type;
    private BlogChannel channel;
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

    public BlogChannel getChannel() {
        return channel;
    }

    public void setChannel(BlogChannel channel) {
        this.channel = channel;
    }

    public List<String> getMarks() {
        return marks;
    }

    public void setMarks(List<String> marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "AddBlogReq{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", channel=" + channel +
                ", marks=" + marks +
                '}';
    }
}
