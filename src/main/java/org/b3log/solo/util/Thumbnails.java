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
package org.b3log.solo.util;

import org.b3log.latke.util.MD5;

/**
 * Thumbnail utilities.
 * <p>
 * By using <a href="http://gravatar.com">Gravatar</a> for user thumbnail.
 * </p>
 *
 * @author <a href="http://88250.b3log.org">Liang Ding</a>
 * @version 1.1.0.1, Mar 11, 2018
 * @since 0.6.1
 */
public final class Thumbnails {

    /**
     * Gets the Gravatar URL for the specified email with the specified size.
     *
     * @param email the specified email
     * @param size  the specified size
     * @return the Gravatar URL
     */
    public static String getGravatarURL(final String email, final String size) {
        return Solos.GRAVATAR + MD5.hash(email) + "?s=" + size;
    }

    /**
     * Private constructor.
     */
    private Thumbnails() {
    }
}
