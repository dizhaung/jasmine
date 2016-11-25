package core.com.model.manage;

/**
 * Created by wangjianan on 16-11-24.
 */
public class UploadResponse {

    private int success;
    private String message;
    private String url;
    private String dialog_id;

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDialog_id() {
        return dialog_id;
    }

    public void setDialog_id(String dialog_id) {
        this.dialog_id = dialog_id;
    }

    @Override
    public String toString() {
        return "UploadResponse{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", url='" + url + '\'' +
                ", dialog_id='" + dialog_id + '\'' +
                '}';
    }
}
