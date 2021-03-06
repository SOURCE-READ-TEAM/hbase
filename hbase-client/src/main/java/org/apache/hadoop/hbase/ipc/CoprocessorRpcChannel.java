/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.hbase.ipc;

import org.apache.yetus.audience.InterfaceAudience;

import org.apache.hbase.thirdparty.com.google.protobuf.BlockingRpcChannel;
import org.apache.hbase.thirdparty.com.google.protobuf.RpcChannel;

/**
 * Base interface which provides clients with an RPC connection to call coprocessor endpoint
 * {@link org.apache.hbase.thirdparty.com.google.protobuf.Service}s.
 * <p/>
 * Note that clients should not use this class directly, except through
 * {@link org.apache.hadoop.hbase.client.Table#coprocessorService(byte[])}.
 * <p/>
 * @deprecated Please stop using this class again, as it is too low level, which is part of the rpc
 *             framework for HBase. Will be deleted in 4.0.0.
 */
@Deprecated
@InterfaceAudience.Public
public interface CoprocessorRpcChannel extends RpcChannel, BlockingRpcChannel {
}
// This Interface is part of our public, client-facing API!!!
// This belongs in client package but it is exposed in our public API so we cannot relocate.
