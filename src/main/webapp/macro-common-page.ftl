<#macro commonPage title>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="initial-scale=1.0,user-scalable=no,maximum-scale=1,width=device-width">
    <meta name="viewport" content="initial-scale=1.0,user-scalable=no,maximum-scale=1" media="(device-height: 568px)">
    <meta name="robots" content="none"/>
    <title><#if blogTitle??>${blogTitle} - </#if>${title}</title>
    <link type="text/css" rel="stylesheet"
          href="${staticServePath}/css/default-init${miniPostfix}.css?${staticResourceVersion}" charset="utf-8"/>
    <link rel="icon" type="image/png" href="${staticServePath}/favicon.png"/>
    <link rel="apple-touch-icon" href="${staticServePath}/favicon.png">
</head>
<body>
<div class="wrap">
    <div class="content">
        <div class="logo">
            <!-- 修改为本站链接 -->
            <a href="https://www.xqtt29.com" target="_blank">
                <img width="128" border="0" alt="Solo" title="Solo" src="${staticServePath}/images/logo.png"/>
            </a>
        </div>
        <div class="main">
            <#nested >
        </div>
        <span class="clear"></span>
    </div>
</div>
<div class="footerWrapper">
    <div class="footer" style="text-align:center;padding:30px 0;padding-top:30px">
        <!-- 修改为本站底部 
        Powered by <a href="https://b3log.org" target="_blank">B3log 开源</a> • <a href="https://hacpai.com/tag/Solo" target="_blank">Solo</a> ${version}
        -->
        <a href="https://github.com/xqtt29/solo" target="_blank"><font color="#ff4d3a">本站源码</font></a>&nbsp;   • &nbsp;
        <font color="#ff4d3a">湘ICP备17007011号-1</font>
    </div>
</div>
</body>
</html>
</#macro>
