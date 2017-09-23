package core.com.jasmine.service.impl;

import core.com.jasmine.dao.BlogLoanDao;
import core.com.jasmine.model.BlogLoanWithBLOBs;
import core.com.jasmine.model.LightningResponse;
import core.com.jasmine.model.manage.ManageIndexReq;
import core.com.jasmine.service.ManageIndexService;
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
    public List<BlogLoanWithBLOBs> queryBlogByType(ManageIndexReq manageIndexReq) {
        LightningResponse response = new LightningResponse();

        List<BlogLoanWithBLOBs> blogLoanList = blogLoanDao.queryBlogLoan(manageIndexReq.getChannelGid());

        return blogLoanList;
    }
}
