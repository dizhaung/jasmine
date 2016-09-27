package core.com.model.lend;

import core.com.model.BlogLoan;

/**
 * Created by wangjianan on 16-9-27.
 */
public class IndexDetailResp {

    private BlogLoan blogLoan;

    public BlogLoan getBlogLoan() {
        return blogLoan;
    }

    public void setBlogLoan(BlogLoan blogLoan) {
        this.blogLoan = blogLoan;
    }

    @Override
    public String toString() {
        return "IndexDetailResp{" +
                "blogLoan=" + blogLoan +
                '}';
    }
}
