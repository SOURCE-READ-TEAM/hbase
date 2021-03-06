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
package org.apache.hadoop.hbase.client;

import static org.junit.Assert.assertEquals;

import java.util.List;
import org.apache.hadoop.hbase.HBaseClassTestRule;
import org.apache.hadoop.hbase.HBaseTestingUtil;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.testclassification.MediumTests;
import org.apache.hadoop.hbase.testclassification.MiscTests;
import org.apache.hadoop.hbase.zookeeper.ZKWatcher;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({ MiscTests.class, MediumTests.class })
public class TestCleanupMetaReplica extends MetaWithReplicasTestBase {

  @ClassRule
  public static final HBaseClassTestRule CLASS_RULE =
    HBaseClassTestRule.forClass(TestCleanupMetaReplica.class);

  @BeforeClass
  public static void setUp() throws Exception {
    startCluster();
  }

  @Test
  public void testReplicaCleanup() throws Exception {
    ZKWatcher zkw = TEST_UTIL.getZooKeeperWatcher();
    List<String> metaReplicaZnodes = zkw.getMetaReplicaNodes();
    assertEquals(3, metaReplicaZnodes.size());
    HBaseTestingUtil.setReplicas(TEST_UTIL.getAdmin(), TableName.META_TABLE_NAME, 1);
    metaReplicaZnodes = zkw.getMetaReplicaNodes();
    assertEquals(1, metaReplicaZnodes.size());
  }
}
