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
package com.effektif.workflow.impl.script;

import java.util.Map;

import com.effektif.workflow.impl.data.DataType;
import com.effektif.workflow.impl.workflowinstance.ScopeInstanceImpl;


/**
 * @author Tom Baeyens
 */
public class ScriptImpl implements CompiledScript, CompiledCondition {

  public AbstractScriptService scriptService;
  public Object compiledScript;
  /** maps script variable names to workflow variable ids */ 
  public Map<String, String> mappings;
  public DataType expectedResultType;
  public boolean readOnly;
  
  public ScriptResult evaluate(ScopeInstanceImpl scopeInstance) {
    return scriptService.evaluate(scopeInstance, this);
  }
}
