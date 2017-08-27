<!-- 导航栏 -->
<#macro navbar>
    <!-- navbar -->
    <div class="app-header navbar">
        <!-- navbar header -->
        <div class="navbar-header bg-dark">
            <button class="pull-right visible-xs dk" data-toggle="show" data-target="navbar-collapse">
                <i class="glyphicon glyphicon-cog"></i>
            </button>
            <button class="pull-right visible-xs" data-toggle="off-screen" data-target="app-aside">
                <i class="glyphicon glyphicon-align-justify"></i>
            </button>
            <!-- brand -->
            <a href="/" class="navbar-brand text-lt">
                <i class="fa fa-btc"></i>
                <img src="../assets/image/logo.png" alt="." class="hide">
                <span class="hidden-folded m-l-xs">oopMind</span>
            </a>
            <!-- / brand -->
        </div>
        <!-- / navbar header -->

        <!-- navbar collapse -->
        <div class="collapse pos-rlt navbar-collapse box-shadow bg-white-only" id="navbar-collapse">
            <!-- buttons -->
            <div class="nav navbar-nav hidden-xs">
                <a class="btn no-shadow navbar-btn" data-toggle="class:app-aside-folded" data-target="menu_app">
                    <i class="fa fa-dedent fa-fw text"></i>
                    <i class="fa fa-indent fa-fw text-active"></i>
                </a>
            </div>
            <!-- / buttons -->

            <ul class="nav navbar-nav">
                <#list channelList as item>
                    <li>
                        <a href="/channel/${item.name}">${item.name}</a>
                    </li>
                </#list>

                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">留言板 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li><a href="#">One more separated link</a></li>
                    </ul>
                </li>
            </ul>

        </div>
        <!-- / navbar collapse -->
    </div>
    <!-- / navbar -->
</#macro>