/*
 * Copyright 2022 LINE Corporation
 *
 * LINE Corporation licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.linecorp.armeria.server.annotation.decorator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

import com.linecorp.armeria.server.annotation.DecoratorFactory;

/**
 * Annotation for request timeout.
 * When applied to gRPC services, the timeout value set using {@link RequestTimeout} is only respected if
 * {@code GrpcServiceBuilder#useClientTimeoutHeader()} is disabled.
 */
@DecoratorFactory(RequestTimeoutDecoratorFunction.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
public @interface RequestTimeout {

    /**
     * Value of request timeout to set.
     */
    long value();

    /**
     * Time unit of request timeout to set.
     */
    TimeUnit unit() default TimeUnit.MILLISECONDS;
}
