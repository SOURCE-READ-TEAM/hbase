/**
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
package org.apache.hadoop.hbase.replication;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.util.ReflectionUtils;
import org.apache.hadoop.hbase.zookeeper.ZKWatcher;
import org.apache.yetus.audience.InterfaceAudience;

/**
 * A factory class for instantiating replication objects that deal with replication state.
 */
@InterfaceAudience.Private
public final class ReplicationFactory {

  public static final String REPLICATION_TRACKER_IMPL = "hbase.replication.tracker.impl";

  private ReplicationFactory() {
  }

  public static ReplicationPeers getReplicationPeers(ZKWatcher zk, Configuration conf) {
    return new ReplicationPeers(zk, conf);
  }

  public static ReplicationTracker getReplicationTracker(ReplicationTrackerParams params) {
    Class<? extends ReplicationTracker> clazz = params.conf().getClass(REPLICATION_TRACKER_IMPL,
      ZKReplicationTracker.class, ReplicationTracker.class);
    return ReflectionUtils.newInstance(clazz, params);
  }
}
