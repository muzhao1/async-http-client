/*
 * Copyright (c) 2014 AsyncHttpClient Project. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0,
 * and you may not use this file except in compliance with the Apache License Version 2.0.
 * You may obtain a copy of the Apache License Version 2.0 at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Apache License Version 2.0 is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */
package org.asynchttpclient.util;

public final class StringUtils {

    private static final ThreadLocal<StringBuilder> STRING_BUILDERS = new ThreadLocal<StringBuilder>() {
        protected StringBuilder initialValue() {
            return new StringBuilder(512);
        };
    };

    /**
     * BEWARE: MUSN'T APPEND TO ITSELF!
     * @return a pooled StringBuilder
     */
    public static StringBuilder stringBuilder() {
        StringBuilder sb = STRING_BUILDERS.get();
        sb.setLength(0);
        return sb;
    }
    
    private StringUtils() {
        // unused
    }
}
