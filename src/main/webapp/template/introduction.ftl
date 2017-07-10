<!--

首页左边导航框

-->
<#macro introduction>
    <!-- menu -->
    <div class="app-aside hidden-xs bg-dark" id="app-aside" style="position: fixed; height: 100%; ">
        <div class="aside-wrap" style="height: 100%; background-size: cover; background-image: url(http://og4nfuylr.bkt.clouddn.com/1000X400.jpg)">
            <div class="navi-wrap">
                <!-- user -->
                <div class="clearfix hidden-xs text-center" id="aside-user">
                    <div class="dropdown wrapper">
                        <a>
                            <span class="thumb-lg w-auto-folded avatar m-t-sm">
                              <img src="../assets/image/wang.png" class="img-full" alt="...">
                            </span>
                        </a>
                        <a href="#" data-toggle="dropdown" class="dropdown-toggle hidden-folded">
                            <span class="clear">
                              <span class="block m-t-sm">
                                <strong class="font-bold text-lt">WangJiaNan</strong>
                                <b class="caret"></b>
                              </span>
                              <span class="text-muted text-xs block">程序猿</span>
                            </span>
                        </a>
                        <!-- 展示个人信息 -->
                        <ul class="dropdown-menu animated fadeInRight w hidden-folded">
                            <li class="wrapper b-b m-b-sm bg-info m-t-n-xs">
                                <span class="arrow top hidden-folded arrow-info"></span>
                                <div>
                                    <p>300mb of 500mb used</p>
                                </div>
                            </li>
                            <li>
                                <a>Settings</a>
                            </li>
                            <li>
                                <a>
                                    <span class="badge bg-danger pull-right">3</span>
                                    Notifications
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a>Logout</a>
                            </li>
                        </ul>
                        <!-- / dropdown -->
                    </div>
                </div>
                <!-- / user -->

                <!-- nav -->
                <nav class="navi">
                    <ul class="nav">
                        <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                            <span>导航</span>
                        </li>
                        <li>
                            <a href="" class="auto">
                                <span class="pull-right text-muted">
                                    <i class="fa fa-fw fa-angle-right text"></i>
                                    <i class="fa fa-fw fa-angle-down text-active"></i>
                                </span>
                                <i class="glyphicon glyphicon-stats icon text-primary-dker"></i>
                                <span class="font-bold">仪表盘</span>
                            </a>
                            <ul class="nav nav-sub dk">
                                <li class="nav-sub-header">
                                    <a href>
                                        <span>仪表盘</span>
                                    </a>
                                </li>
                                <li>
                                    <a>
                                        <span>Dashboard v1</span>
                                    </a>
                                </li>
                                <li>
                                    <a>
                                        <b class="label bg-info pull-right">N</b>
                                        <span>Dashboard v2</span>
                                    </a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="/friend">
                                <i class="glyphicon glyphicon-briefcase icon text-info-lter"></i>
                                <span class="font-bold">友链</span>
                            </a>
                        </li>
                    </ul>
                </nav>
                <!-- nav -->
            </div>
        </div>
    </div>
    <!-- / menu -->
</#macro>