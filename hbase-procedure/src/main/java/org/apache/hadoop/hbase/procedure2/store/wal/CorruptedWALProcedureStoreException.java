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
package org.apache.hadoop.hbase.procedure2.store.wal;

import org.apache.hadoop.hbase.HBaseIOException;
import org.apache.yetus.audience.InterfaceAudience;

/**
 * Thrown when a procedure WAL is corrupted
 * @deprecated Since 2.3.0, will be removed in 4.0.0. Keep here only for rolling upgrading, now we
 *             use the new region based procedure store.
 */
@Deprecated
@InterfaceAudience.Private
public class CorruptedWALProcedureStoreException extends HBaseIOException {

  private static final long serialVersionUID = -3407300445435898074L;

  /** default constructor */
  public CorruptedWALProcedureStoreException() {
    super();
  }

  /**
   * Constructor
   * @param s message
   */
  public CorruptedWALProcedureStoreException(String s) {
    super(s);
  }
}
