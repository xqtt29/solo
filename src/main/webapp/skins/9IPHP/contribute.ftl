<#include "macro-head.ftl">
<!DOCTYPE html>
<html>
    <head>
        <@head title="${blogTitle}">
        <meta name="keywords" content="${metaKeywords},捐赠"/>
        <meta name="description" content="${metaDescription}捐赠"/>
        </@head>
    </head>
    <body>
        <#include "header.ftl">
        <div class="wrapper">
            <div class="main-wrap">
                <main class="other">
                    <div class="title">
                         <h2><i class="icon-link"></i>
                             &nbsp;微信</h2>
                    <img src="${staticServePath}/images/wx.png"/>
                    </div>
                    <hr/>
                    <div class="title">
                         <h2><i class="icon-link"></i>
                             &nbsp;支付宝</h2>
                    <img src="${staticServePath}/images/zfb.png"/>
                    </div>
                </main>
                <#include "side.ftl">
            </div>
        </div>
        <#include "footer.ftl">
    </body>
</html>
