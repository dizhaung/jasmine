package core.com.model.manage;

/**
 * 前端请求 - 添加Blog
 *
 * Created by wangjianan on 16-8-17.
 */
public class AddBlogReq {
    private String name;
    private String message;

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

    @Override
    public String toString() {
        return "AddBlogReq{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
