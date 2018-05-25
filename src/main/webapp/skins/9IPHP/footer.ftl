<footer class="footer fn-clear">
    <!--注释皮肤
    &copy; ${year}
    ${footerContent}
    <a href="${servePath}">${blogTitle}</a>  &nbsp;   • &nbsp;
    <a href="https://solo.b3log.org" target="_blank">Solo</a> ${version}  <br/>

    Powered by <a href="https://b3log.org" target="_blank">B3log</a> 开源 &nbsp;
    <span class="ft-warn">&heartsuit;</span>
    Theme <a rel="friend" href="https://github.com/b3log/solo-skins" target="_blank">9IPHP</a> by <a href="https://github.com/9IPHP/9IPHP" target="_blank">9IPHP</a> & <a href="http://vanessa.b3log.org" target="_blank">Vanessa</a>
    -->
    <!--增加自己的底部-->
    <font color="#ff4d3a">&copy; ${year}</font>
    <font color="#ff4d3a">${footerContent}</font>
    <a href="${servePath}">${blogTitle}</a>  &nbsp;   • &nbsp;<a href="https://github.com/xqtt29/solo" target="_blank">本站源码</a>&nbsp;   • &nbsp;
    <font color="#ff4d3a">湘ICP备17007011号-1</font> &nbsp; • &nbsp;
    <a href="${loginURL}">
        <i class="icon-login"></i> 后台通道
    </a>&nbsp; • &nbsp;
    <script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_1273781196'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s19.cnzz.com/z_stat.php%3Fid%3D1273781196%26show%3Dpic' type='text/javascript'%3E%3C/script%3E"));</script>
</footer>
<div class="icon-up" onclick="Util.goTop()"></div>

<script type="text/javascript" src="${staticServePath}/js/lib/jquery/jquery.min.js" charset="utf-8"></script>
<script type="text/javascript" src="${staticServePath}/js/common${miniPostfix}.js?${staticResourceVersion}" charset="utf-8"></script>
<script type="text/javascript" src="${staticServePath}/skins/${skinDirName}/js/common${miniPostfix}.js?${staticResourceVersion}" charset="utf-8"></script>
<script type="text/javascript">
    var latkeConfig = {
        "servePath": "${servePath}",
        "staticServePath": "${staticServePath}",
        "isLoggedIn": "${isLoggedIn?string}",
        "userName": "${userName}"
    };

    var Label = {
        "skinDirName": "${skinDirName}",
        "em00Label": "${em00Label}",
        "em01Label": "${em01Label}",
        "em02Label": "${em02Label}",
        "em03Label": "${em03Label}",
        "em04Label": "${em04Label}",
        "em05Label": "${em05Label}",
        "em06Label": "${em06Label}",
        "em07Label": "${em07Label}",
        "em08Label": "${em08Label}",
        "em09Label": "${em09Label}",
        "em10Label": "${em10Label}",
        "em11Label": "${em11Label}",
        "em12Label": "${em12Label}",
        "em13Label": "${em13Label}",
        "em14Label": "${em14Label}"
    };

    Util.parseMarkdown('content-reset');
</script>
${plugins}
