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
package org.b3log.solo.event.ping;

import org.b3log.latke.Latkes;
import org.b3log.latke.event.AbstractEventListener;
import org.b3log.latke.event.Event;
import org.b3log.latke.event.EventException;
import org.b3log.latke.ioc.LatkeBeanManager;
import org.b3log.latke.ioc.Lifecycle;
import org.b3log.latke.logging.Level;
import org.b3log.latke.logging.Logger;
import org.b3log.latke.urlfetch.HTTPRequest;
import org.b3log.latke.urlfetch.URLFetchService;
import org.b3log.latke.urlfetch.URLFetchServiceFactory;
import org.b3log.solo.event.EventTypes;
import org.b3log.solo.model.Article;
import org.b3log.solo.model.Option;
import org.b3log.solo.service.PreferenceQueryService;
import org.json.JSONObject;

import java.net.URL;
import java.net.URLEncoder;

/**
 * This listener is responsible for pinging <a href="http://blogsearch.google.com">Google Blog Search Service</a>
 * asynchronously while adding an article.
 *
 * <li>
 * <a href="http://www.google.com/help/blogsearch/pinging_API.html">
 * About Google Blog Search Pinging Service API</a>
 * </li>
 *
 * @author <a href="http://88250.b3log.org">Liang Ding</a>
 * @version 1.0.0.5, Apr 15, 2018
 * @see UpdateArticleGoogleBlogSearchPinger
 * @since 0.3.1
 */
public final class AddArticleGoogleBlogSearchPinger extends AbstractEventListener<JSONObject> {

    /**
     * Logger.
     */
    private static final Logger LOGGER = Logger.getLogger(AddArticleGoogleBlogSearchPinger.class);

    /**
     * URL fetch service.
     */
    private static final URLFetchService URL_FETCH_SERVICE = URLFetchServiceFactory.getURLFetchService();

    /**
     * Gets the event type {@linkplain EventTypes#ADD_ARTICLE}.
     *
     * @return event type
     */
    @Override
    public String getEventType() {
        return EventTypes.ADD_ARTICLE;
    }

    @Override
    public void action(final Event<JSONObject> event) throws EventException {
        final JSONObject eventData = event.getData();

        String articleTitle = null;

        final LatkeBeanManager beanManager = Lifecycle.getBeanManager();
        final PreferenceQueryService preferenceQueryService = beanManager.getReference(PreferenceQueryService.class);

        try {
            final JSONObject article = eventData.getJSONObject(Article.ARTICLE);

            articleTitle = article.getString(Article.ARTICLE_TITLE);
            final JSONObject preference = preferenceQueryService.getPreference();
            final String blogTitle = preference.getString(Option.ID_C_BLOG_TITLE);

            if (Latkes.getServePath().contains("localhost")) {
                LOGGER.log(Level.TRACE, "Solo runs on local server, so should not ping " +
                                "Google Blog Search Service for the article[title={0}]",
                        article.getString(Article.ARTICLE_TITLE));
                return;
            }

            final String articlePermalink = Latkes.getServePath() + article.getString(Article.ARTICLE_PERMALINK);
            final String spec = "http://blogsearch.google.com/ping?name=" + URLEncoder.encode(blogTitle, "UTF-8") +
                    "&url=" + URLEncoder.encode(Latkes.getServePath(), "UTF-8") +
                    "&changesURL=" + URLEncoder.encode(articlePermalink, "UTF-8");

            LOGGER.log(Level.DEBUG, "Request Google Blog Search Service API[{0}] while adding an "
                    + "article[title=" + articleTitle + "]", spec);
            final HTTPRequest request = new HTTPRequest();
            request.setURL(new URL(spec));

            URL_FETCH_SERVICE.fetchAsync(request);
        } catch (final Exception e) {
            LOGGER.log(Level.ERROR, "Ping Google Blog Search Service fail while adding an article[title="
                    + articleTitle + "]", e);
        }
    }
}
