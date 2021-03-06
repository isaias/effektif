/*
 * Copyright 2014 Effektif GmbH.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.effektif.workflow.test.serialization;

import org.junit.Test;
import org.junit.runners.model.InitializationError;

import com.effektif.workflow.test.TestSuiteHelper;
import com.effektif.workflow.test.api.EmailTriggerTest;

/**
 * @author Tom Baeyens
 */
public class SerializationTest {
  
  @Test
  public void testSerialization() throws InitializationError {
    TestSuiteHelper.run(new SerializingWorkflowEngineConfiguration()
      // use the next line if you only want to run 1 test
      // , EmailTriggerTest.class, "testEmailTrigger"
      );
  }
}
