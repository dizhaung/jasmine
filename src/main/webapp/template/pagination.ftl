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
                <#--如果当前页大于第一页，输出上一页导航-->
                <#if (curPage > 1) >
                    <#assign prePage = curPage-1>
                    <li>
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&lt;</span>
                        </a>
                    </li>
                </#if>
                <#--
                如果开始页大于1 (表示当前页和2的差值大于1)
                先输出"第一页的link"和"..."
                否则跳过
                然后由遍历的过程输出第一页的链接
                -->
                <#if (startPage > 1)>
                    <a href="/staff/queryStaffByOrg?orgId=${orgId!''}&pageNumber=1" class="page-item item-number" title="1">1</a>
                    <#if (startPage > 2)>
                        <span class="page-item item-ellipsis">...</span>
                    </#if>
                </#if>
                <#--开始输出页码导航-->
                <li>
                    <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li class="active"><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li>
                    <a href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
</#macro>