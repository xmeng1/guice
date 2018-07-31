/**
 * Copyright (C) 2007 Google Inc.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.inject.servlet;

import com.google.inject.Injector;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;

/**
 * Helper class, that can perform injection to filters and servlets
 *
 * @author Igor Petruk (igor.petrouk@gmail.com)
 */
class ServletInjector {

    private final static String INJECTOR_NAME = GuiceServletContextListener.INJECTOR_NAME;

    private static void injectToObject(ServletContext servletContext, Object o) {
        Injector injector = (Injector) servletContext.getAttribute(INJECTOR_NAME);
        injector.injectMembers(o);
    }

    public static void injectToServlet(ServletContext servletContext, Servlet servlet) {
        injectToObject(servletContext, servlet);
    }

    public static void injectToFilter(ServletContext servletContext, Filter filter) {
        injectToObject(servletContext, filter);
    }

}