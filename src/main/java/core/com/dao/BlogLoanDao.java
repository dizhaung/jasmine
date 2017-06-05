package core.com.dao;


import core.com.model.BlogLoan;
import core.com.model.BlogLoanWithBLOBs;

import java.util.List;

/**
 *
 * Created by wangjianan on 16-8-18.
 */
public interface BlogLoanDao {

    int insert(BlogLoanWithBLOBs blogLoan);

    List<BlogLoanWithBLOBs> queryBlogLoan(String channelGid);

    BlogLoan queryBlogLoanById(Integer id);

    List<BlogLoanWithBLOBs> queryBlogLoanByMarkOrChannel(String channelGid, String markGid);

    int delete(String blogGid);

    List<BlogLoan> queryBlogLoanOrder();

    BlogLoanWithBLOBs selectByGid(String gid);

    int updateBlogView(String blogGid);

    int updateBlogById(BlogLoanWithBLOBs blogLoan);

    List<BlogLoan> queryBlogLoan();

}
