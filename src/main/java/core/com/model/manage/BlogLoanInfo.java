package core.com.model.manage;

import core.com.model.BlogLoan;

import java.util.List;

/**
 *
 * Created by wangjianan on 17-3-2.
 */
public class BlogLoanInfo {

    private BlogLoan blogLoan;
    private List<String> markList;

    public BlogLoan getBlogLoan() {
        return blogLoan;
    }

    public void setBlogLoan(BlogLoan blogLoan) {
        this.blogLoan = blogLoan;
    }

    public List<String> getMarkList() {
        return markList;
    }

    public void setMarkList(List<String> markList) {
        this.markList = markList;
    }

    @Override
    public String toString() {
        return "BlogLoanInfo{" +
                "blogLoan=" + blogLoan +
                ", markList=" + markList +
                '}';
    }
}
