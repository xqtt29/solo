<#macro head title>
<meta charset="utf-8" />
<title>${title}</title>
<#nested>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="author" content="${blogTitle?html}" />
<meta name="generator" content="zhuq" />
<meta name="owner" content="zhuq" />
<meta name="revised" content="${blogTitle?html}, ${year}" />
<meta name="copyright" content="xqtt29" />
<meta http-equiv="Window-target" content="_top" />
<link type="text/css" rel="stylesheet" href="${staticServePath}/skins/${skinDirName}/css/base${miniPostfix}.css?${staticResourceVersion}" charset="utf-8" />
<link href="${servePath}/blog-articles-rss.do" title="RSS" type="application/rss+xml" rel="alternate" />
<link rel="icon" type="image/png" href="${servePath}/favicon.png" />
${htmlHead}
</#macro>