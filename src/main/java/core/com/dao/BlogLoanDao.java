package core.com.dao;


import core.com.model.BlogLoan;

import java.util.List;

/**
 *
 * Created by wangjianan on 16-8-18.
 */
public interface BlogLoanDao {

    int insert(BlogLoan blogLoan);

    List<BlogLoan> queryBlogLoan(String channelGid);

    BlogLoan queryBlogLoanById(Integer id);

    List<BlogLoan> queryBlogLoanByMarkOrChannel(String channelGid, String markGid);

    int delete(String blogGid);

    List<BlogLoan> queryBlogLoanOrder();

    BlogLoan selectByGid(String gid);

    int updateBlogView(String blogGid);

    int updateBlogById(BlogLoan blogLoan);

}
