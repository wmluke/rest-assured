/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jayway.restassured.module.mockmvc.specification;

import java.security.Principal;

/**
 * Specify an authentication scheme to use when sending a request.
 */
public interface MockMvcAuthenticationSpecification {
    /**
     * Authenticate using the given principal. This method simply delegates to {@link org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder#principal(java.security.Principal)}.
     *
     * @param principal The principal to use.
     * @return The request specification
     * @see org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder#principal(java.security.Principal)
     */
    MockMvcRequestSpecification principal(Principal principal);

    /**
     * Authenticate using the given principal. The principal will be used like this:
     * <pre>
     * SecurityContextHolder.getContext().setAuthentication(new TestingAuthenticationToken(principal, ""));
     * </pre>
     * <p/>
     * <p>
     * <b>Note that this method require Spring Security to be on the classpath. Also note that if you use this method Rest Assured will NOT be thread-safe.</b>
     * </p>
     *
     * @param principal The principal to use.
     * @return The request specification
     */
    MockMvcRequestSpecification principal(Object principal);

    /**
     * Authenticate using the given principal and credentials. The principal and credentials will be used like this:
     * <pre>
     * SecurityContextHolder.getContext().setAuthentication(new TestingAuthenticationToken(principal, credentials, authorities));
     * </pre>
     * <p/>
     * <p>
     * <b>Note that this method require Spring Security to be on the classpath. Also note that if you use this method Rest Assured will NOT be thread-safe.</b>
     * </p>
     *
     * @param principal   The principal to use.
     * @param credentials The credentials to use
     * @param authorities Optional list of authorities
     * @return The request specification
     */
    MockMvcRequestSpecification principalWithCredentials(Object principal, Object credentials, String... authorities);

    /**
     * Authenticate using the given principal and credentials. The principal and credentials will be used like this:
     * <pre>
     * SecurityContextHolder.getContext().setAuthentication(authentication);
     * </pre>
     * This means that the supplied object must be an instance of <code>org.springframework.security.core.Authentication</code>.
     * <p>
     * <b>Note that this method require Spring Security to be on the classpath. Also note that if you use this method Rest Assured will NOT be thread-safe.</b>
     * </p>
     *
     * @param authentication the spring security authentication to use.
     * @return The request specification
     */
    MockMvcRequestSpecification authentication(Object authentication);

    /**
     * Explicitly state that you don't which to use any authentication in this request. This is useful only in cases where you've
     * specified a default authentication scheme and you wish to override it for a single request.
     *
     * @return The request specification
     */
    MockMvcRequestSpecification none();
}
