package core.com.exception;

/**
 * Created by wangjianan on 16-7-10.
 */
public class CoreException extends RuntimeException {

    private String code;
    private String error;

    public CoreException(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "CoreException{" +
                "code='" + code + '\'' +
                ", error='" + error + '\'' +
                '}';
    }
}
