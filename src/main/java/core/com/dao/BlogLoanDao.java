package core.com.dao;


import core.com.model.BlogLoan;

import java.util.List;

/**
 *
 * Created by wangjianan on 16-8-18.
 */
public interface BlogLoanDao {

    int insert(BlogLoan blogLoan);

    List<BlogLoan> queryBlogLoan();

    int delete(String blogGid);

}
