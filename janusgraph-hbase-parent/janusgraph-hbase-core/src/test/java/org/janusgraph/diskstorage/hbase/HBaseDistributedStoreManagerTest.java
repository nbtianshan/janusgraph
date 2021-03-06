// Copyright 2017 JanusGraph Authors
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.janusgraph.diskstorage.hbase;

import java.io.IOException;

import org.janusgraph.diskstorage.BackendException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.janusgraph.HBaseStorageSetup;
import org.janusgraph.diskstorage.DistributedStoreManagerTest;


public class HBaseDistributedStoreManagerTest extends DistributedStoreManagerTest<HBaseStoreManager> {

    @BeforeAll
    public static void startHBase() throws IOException {
        HBaseStorageSetup.startHBase();
    }

    @BeforeEach
    public void setUp() throws BackendException {
        manager = new HBaseStoreManager(HBaseStorageSetup.getHBaseConfiguration());
        store = manager.openDatabase("distributedStoreTest");
    }

    @AfterEach
    public void tearDown() throws BackendException {
        store.close();
        manager.close();
    }
}
