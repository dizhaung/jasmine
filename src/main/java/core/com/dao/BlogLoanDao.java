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

    List<BlogLoan> queryBlogLoanByMarkOrChannelLimit(String channelGid, String markGid, Integer pageIndex, Integer pageSize);

    int delete(String blogGid);

    List<BlogLoan> queryBlogLoanOrder();

    BlogLoanWithBLOBs selectByGid(String gid);

    BlogLoanWithBLOBs selectById(Integer id);

    int updateBlogView(Integer blogId);

    int updateBlogById(BlogLoanWithBLOBs blogLoan);

    List<BlogLoan> queryBlogLoan();

}
