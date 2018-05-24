<#include "macro-head.ftl">
<!DOCTYPE html>
<html>
    <head>
        <@head title="${blogTitle}">
        <meta name="keywords" content="${metaKeywords},${archiveLabel}"/>
        <meta name="description" content="${metaDescription},${archiveLabel}"/>
        </@head>
    </head>
    <body>
        <#include "header.ftl">
        <div class="wrapper">
            <div class="main-wrap">
                <main class="other">
                    <div style="float: left; padding:100px 0 0 100px">
                    <div class="title">
                         <h2><i class="icon-link"></i>
                             &nbsp;微信</h2>
                    </div>
                    <img src="${staticServePath}/images/wx.png"/>
                    </div>
                    <div style="float: right; padding:100px 100px 0 0">
                    <div class="title">
                         <h2><i class="icon-link"></i>
                             &nbsp;支付宝</h2>
                    </div>
                    <img src="${staticServePath}/images/zfb.png"/>
                    </div>
                </main>
                <#include "side.ftl">
            </div>
        </div>
        <#include "footer.ftl">
    </body>
</html>
