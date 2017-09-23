package core.com.jasmine.model.manage;

import core.com.jasmine.model.BlogLoanWithBLOBs;

import java.util.List;

/**
 *
 * Created by wangjianan on 17-3-2.
 */
public class BlogLoanInfo {

    private BlogLoanWithBLOBs blogLoan;
    private List<String> markList;

    public BlogLoanWithBLOBs getBlogLoan() {
        return blogLoan;
    }

    public void setBlogLoan(BlogLoanWithBLOBs blogLoan) {
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
