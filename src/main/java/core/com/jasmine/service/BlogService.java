package core.com.jasmine.service;

import core.com.jasmine.model.lend.*;

import java.util.List;

/**
 *
 * Created by wangjianan on 2016/2/17.
 */
public interface BlogService {

    BaseInfoResponse getIndexInfo();

    /**
     * 查询详细信息
     *
     * @param indexDetailReq
     * @return
     */
    IndexDetailResp getBlogDetail(IndexDetailReq indexDetailReq);

    /**
     * 分页查询
     *
     * @param indexInfoReq 参数
     * @return 返回详情
     */
    List<BlogInfo> queryInfoByLimit(IndexInfoReq indexInfoReq);

    /**
     * 查询blog数量
     *
     * @param indexInfoReq 参数
     * @return 返回详情
     */
    int queryInfoCount(IndexInfoReq indexInfoReq);

}
