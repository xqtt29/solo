/*
 * Solo - A beautiful, simple, stable, fast Java blogging system.
 * Copyright (c) 2010-2018, b3log.org & hacpai.com
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package org.b3log.solo.processor;

import org.apache.commons.lang.StringUtils;
import org.b3log.latke.model.User;
import org.b3log.latke.service.ServiceException;
import org.b3log.solo.AbstractTestCase;
import org.b3log.solo.model.Article;
import org.b3log.solo.model.Common;
import org.b3log.solo.model.Page;
import org.b3log.solo.service.ArticleMgmtService;
import org.b3log.solo.service.InitService;
import org.b3log.solo.service.PageMgmtService;
import org.b3log.solo.service.UserQueryService;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {@link CommentProcessorTestCase} test case.
 *
 * @author <a href="http://88250.b3log.org">Liang Ding</a>
 * @version 1.0.0.2, Feb 13, 2018
 * @since 1.7.0
 */
@Test(suiteName = "processor")
public class CommentProcessorTestCase extends AbstractTestCase {

    /**
     * Init.
     *
     * @throws Exception exception
     */
    @Test
    public void init() throws Exception {
        final InitService initService = getInitService();

        final JSONObject requestJSONObject = new JSONObject();
        requestJSONObject.put(User.USER_EMAIL, "test@gmail.com");
        requestJSONObject.put(User.USER_NAME, "Admin");
        requestJSONObject.put(User.USER_PASSWORD, "pass");

        initService.init(requestJSONObject);

        final UserQueryService userQueryService = getUserQueryService();
        Assert.assertNotNull(userQueryService.getUserByEmail("test@gmail.com"));
    }

    /**
     * addPageComment.
     *
     * @throws Exception exception
     */
    @Test(dependsOnMethods = "init")
    public void addPageComment() throws Exception {
        final HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getServletContext()).thenReturn(mock(ServletContext.class));
        when(request.getRequestURI()).thenReturn("/add-page-comment.do");
        when(request.getMethod()).thenReturn("POST");

        CaptchaProcessor.CAPTCHA_ON = false;

        final JSONObject requestJSON = new JSONObject();
        requestJSON.put("captcha", "captcha123456");
        requestJSON.put("oId", addPage());
        requestJSON.put("commentName", "88250");
        requestJSON.put("commentEmail", "d@hacpai.com");
        requestJSON.put("commentURL", "https://hacpai.com");
        requestJSON.put("commentContent", "测试评论");

        final BufferedReader reader = new BufferedReader(new StringReader(requestJSON.toString()));
        when(request.getReader()).thenReturn(reader);

        final MockDispatcherServlet dispatcherServlet = new MockDispatcherServlet();
        dispatcherServlet.init();

        final StringWriter stringWriter = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(stringWriter);

        final HttpServletResponse response = mock(HttpServletResponse.class);
        when(response.getWriter()).thenReturn(printWriter);

        dispatcherServlet.service(request, response);

        final String content = stringWriter.toString();
        Assert.assertTrue(StringUtils.contains(content, "\"sc\":true"));
    }

    /**
     * addArticleComment.
     *
     * @throws Exception exception
     */
    @Test(dependsOnMethods = "init")
    public void addArticleComment() throws Exception {
        final HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getServletContext()).thenReturn(mock(ServletContext.class));
        when(request.getRequestURI()).thenReturn("/add-article-comment.do");
        when(request.getMethod()).thenReturn("POST");

        CaptchaProcessor.CAPTCHA_ON = false;

        final JSONObject requestJSON = new JSONObject();
        requestJSON.put("captcha", "captcha123456");
        requestJSON.put("oId", addArticle());
        requestJSON.put("commentName", "88250");
        requestJSON.put("commentEmail", "d@hacpai.com");
        requestJSON.put("commentURL", "https://hacpai.com");
        requestJSON.put("commentContent", "测试评论");

        final BufferedReader reader = new BufferedReader(new StringReader(requestJSON.toString()));
        when(request.getReader()).thenReturn(reader);

        final MockDispatcherServlet dispatcherServlet = new MockDispatcherServlet();
        dispatcherServlet.init();

        final StringWriter stringWriter = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(stringWriter);

        final HttpServletResponse response = mock(HttpServletResponse.class);
        when(response.getWriter()).thenReturn(printWriter);

        dispatcherServlet.service(request, response);

        final String content = stringWriter.toString();
        Assert.assertTrue(StringUtils.contains(content, "\"sc\":true"));
    }

    private String addPage() throws ServiceException {
        final PageMgmtService pageMgmtService = getPageMgmtService();

        final JSONObject requestJSONObject = new JSONObject();
        final JSONObject page = new JSONObject();
        requestJSONObject.put(Page.PAGE, page);

        page.put(Page.PAGE_CONTENT, "page1 content");
        page.put(Page.PAGE_PERMALINK, "page1 permalink");
        page.put(Page.PAGE_TITLE, "page1 title");
        page.put(Page.PAGE_COMMENTABLE, true);
        page.put(Page.PAGE_TYPE, "page");
        page.put(Page.PAGE_OPEN_TARGET, "_self");

        return pageMgmtService.addPage(requestJSONObject);
    }

    private String addArticle() throws Exception {
        final ArticleMgmtService articleMgmtService = getArticleMgmtService();

        final JSONObject requestJSONObject = new JSONObject();
        final JSONObject article = new JSONObject();
        requestJSONObject.put(Article.ARTICLE, article);

        article.put(Article.ARTICLE_AUTHOR_EMAIL, "test@gmail.com");
        article.put(Article.ARTICLE_TITLE, "article1 title");
        article.put(Article.ARTICLE_ABSTRACT, "article1 abstract");
        article.put(Article.ARTICLE_CONTENT, "article1 content");
        article.put(Article.ARTICLE_TAGS_REF, "tag1, tag2, tag3");
        article.put(Article.ARTICLE_PERMALINK, "article1 permalink");
        article.put(Article.ARTICLE_IS_PUBLISHED, true);
        article.put(Common.POST_TO_COMMUNITY, true);
        article.put(Article.ARTICLE_SIGN_ID, "1");
        article.put(Article.ARTICLE_COMMENTABLE, true);
        article.put(Article.ARTICLE_VIEW_PWD, "");

        return articleMgmtService.addArticle(requestJSONObject);
    }
}
