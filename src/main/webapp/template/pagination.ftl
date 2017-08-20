<#macro pagination pageIndex pageCount>
    <#assign curPage = pageIndex>
    <#assign pageCount = pageCount>

    <#-- 开始页 : 求最大值(当前页和2的差值 , 1) -->
    <#if ((curPage - 2) > 1)>
        <#assign startPage = (curPage - 2)>
    <#else>
        <#assign startPage = 1>
    </#if>

    <#-- 结束页 : 求最小值(开始页+4, 总页数) -->
    <#if ((startPage + 4) < pageCount)>
        <#assign endPage = (startPage + 4)>
    <#else>
        <#assign endPage = pageCount>
    </#if>

    <div class="center-block" style="width:300px;">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <#--
                如果开始页大于1 (表示当前页和2的差值大于1)
                先输出"第一页的link"和"..."
                否则跳过
                然后由遍历的过程输出第一页的链接
                -->
                <#if (startPage > 1)>
                    <li>
                        <a href="${path}?page=1" aria-label="Previous" title="首页">
                            <span aria-hidden="true">&laquo</span>
                        </a>
                    </li>
                </#if>

                <#--如果当前页大于第一页，输出上一页导航-->
                <#if (curPage > 1) >
                    <#assign prePage = curPage-1>
                    <li>
                        <a href="${path}?page=${prePage}" aria-label="Previous" title="上一页">
                            <span aria-hidden="true">&lt;</span>
                        </a>
                    </li>
                </#if>

                <#--
                遍历输出开始页到结束页的链接
                如果是当前页，页码没有链接并且有自己的样式
                -->
                <#if (startPage <= endPage)>
                    <#list startPage..endPage as page>
                        <li class="<#if curPage == page>active</#if>">
                            <a href="${path}?page=${page}" aria-label="Previous" title="${page}">
                                <span aria-hidden="true">${page}</span>
                            </a>
                        </li>
                    </#list>
                </#if>

                <#--如果当前页小于总页数，输出下一页导航-->
                <#if (curPage < pageCount)>
                    <#assign nextPage = curPage+1>
                    <li>
                        <a href="${path}?page=${nextPage}" aria-label="Previous" title="下一页">
                            <span aria-hidden="true">&gt;</span>
                        </a>
                    </li>
                </#if>


                <#--
                如果endPage < pageCount   (表示结束页是startPage + 8，否则endPage = pageCount)
                    1.先判断是否小于最后一页的前一页,如果是先输出"..."，否则跳过
                    2.单独输出最后一页
                否则跳过
                    实质上在上面的遍历的过程中已经输出了最后一页的链接
                -->
                <#if (endPage < pageCount)>
                    <li>
                        <a href="${path}?page=${pageCount}" aria-label="Previous" title="尾页">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </#if>
                <#--结束输出页码导航-->
            </ul>
        </nav>
    </div>
</#macro>