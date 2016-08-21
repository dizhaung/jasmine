package core.com.service.manage.impl;

import core.com.dao.BlogLoanDao;
import core.com.model.BlogLoan;
import core.com.model.LightningResponse;
import core.com.model.manage.ManageIndexReq;
import core.com.service.manage.ManageIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wangjianan on 16-7-10.
 */
@Service
public class ManageIndexServiceImpl implements ManageIndexService {

    @Autowired
    private BlogLoanDao blogLoanDao;

    @Override
    public List<BlogLoan> queryBlogByType(ManageIndexReq manageIndexReq) {
        LightningResponse response = new LightningResponse();

        List<BlogLoan> blogLoanList = blogLoanDao.queryBlogLoan();

        return blogLoanList;
    }
}
