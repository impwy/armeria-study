/*
 * Copyright 2017 LINE Corporation
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

package com.linecorp.armeria.internal.common.grpc;

import com.linecorp.armeria.common.annotation.Nullable;

import io.grpc.Metadata;
import io.grpc.Status;

/**
 * A listener of gRPC {@link Status}s. Error or header events will be returned to gRPC business
 * logic through this listener. For clients the final response {@link Status} is also returned.
 */
@FunctionalInterface
public interface TransportStatusListener {

    default void transportReportHeaders(Metadata metadata) {}

    default void transportReportStatus(Status status) {
        transportReportStatus(status, null);
    }

    void transportReportStatus(Status status, @Nullable Metadata metadata);
}
