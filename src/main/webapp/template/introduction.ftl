<!--

首页左边导航框

-->
<#macro introduction>
    <!-- menu -->
    <!--suppress ALL -->
<div class="app-aside hidden-xs bg-light" id="app-aside" style="position: fixed; height: 100%; ">
        <div class="aside-wrap" style="height: 100%; background-size: cover; background-image: url(http://og4nfuylr.bkt.clouddn.com/000X400.jpg)">
            <div class="navi-wrap">
                <!-- user -->
                <div class="clearfix hidden-xs text-center" id="aside-user">
                    <div class="dropdown wrapper">
                        <a href="/" class="img-circle">
                            <span class="thumb-lg w-auto-folded avatar m-t-sm">
                              <img src="../assets/image/wang.png" class="img-full">
                            </span>
                        </a>
                        <a href="/" data-toggle="dropdown" class="dropdown-toggle hidden-folded">
                            <span class="clear">
                              <span class="block m-t-sm">
                                <strong class="font-bold text-lt text-2x">佳楠的小站</strong>
                              </span>
                            </span>
                        </a>

                    </div>
                </div>
                <!-- / user -->

                <!-- nav -->
                <div class="clearfix hidden-xs text-center">
                <nav class="navi">
                    <ul class="nav">
                        <li>
                            <a href="/">
                                <span class="font-bold">首页</span>
                            </a>
                        </li>

                        <li>
                            <a href="/friend">
                                <span class="font-bold">友链</span>
                            </a>
                        </li>

                        <li>
                            <a href="/me">
                                <span class="font-bold">关于</span>
                            </a>
                        </li>
                    </ul>
                </nav>
                </div>
                <!-- nav -->

                <!-- help -->
                <div class="clearfix hidden-xs text-center">
                    <span class="fa-stack fa-lg">
                      <i class="fa fa-circle fa-stack-2x"></i>
                      <a title="facebook"><i class="fa fa-facebook fa-stack-1x fa-inverse"></i></a>
                    </span>
                    <span class="fa-stack fa-lg">
                      <i class="fa fa-circle fa-stack-2x"></i>
                      <a href="https://github.com/wangjianan1103" title="github"><i class="fa fa-github fa-stack-1x fa-inverse"></i></a>
                    </span>
                    <span class="fa-stack fa-lg" title="邮箱">
                      <i class="fa fa-circle fa-stack-2x"></i>
                      <a href="/weixin" title="微信"><i class="fa fa-weixin fa-stack-1x fa-inverse"></i></a>
                    </span>
                    <span class="fa-stack fa-lg">
                      <i class="fa fa-circle fa-stack-2x"></i>
                      <a href="mailto:wangjianan1103@163.com" title="邮箱"> <i class="fa fa-envelope fa-stack-1x fa-inverse"></i></a>
                    </span>
                </div>
            </div>
        </div>
    </div>
    <!-- / menu -->
</#macro>